package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public final class ElectroplatingRodImplements extends Block {
    public ElectroplatingRodImplements(final Settings settings) {
        super(settings);
    }

    private static final VoxelShape Rod = Stream.of(
            Block.createCuboidShape(10, 14, 6, 11, 15, 10),
            Block.createCuboidShape(6, 0, 6, 10, 14, 10),
            Block.createCuboidShape(6, 14, 6, 10, 15, 10),
            Block.createCuboidShape(7, 0, 5, 9, 14, 6),
            Block.createCuboidShape(6, 14, 5, 10, 15, 6),
            Block.createCuboidShape(7, 0, 10, 9, 14, 11),
            Block.createCuboidShape(6, 14, 10, 10, 15, 11),
            Block.createCuboidShape(5, 0, 7, 6, 14, 9),
            Block.createCuboidShape(5, 14, 6, 6, 15, 10),
            Block.createCuboidShape(10, 0, 7, 11, 14, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return Rod;
    }
}
