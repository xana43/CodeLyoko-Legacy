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

public final class ElectroplatingRodParts extends Block {
    public ElectroplatingRodParts(final Settings settings) {
        super(settings);
    }

    private static final VoxelShape RodPart = Stream.of(
            Block.createCuboidShape(6, 0, 6, 10, 16, 10),
            Block.createCuboidShape(7, 0, 5, 9, 16, 6),
            Block.createCuboidShape(7, 0, 10, 9, 16, 11),
            Block.createCuboidShape(5, 0, 7, 6, 16, 9),
            Block.createCuboidShape(10, 0, 7, 11, 16, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();



    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return RodPart;
    }




}
