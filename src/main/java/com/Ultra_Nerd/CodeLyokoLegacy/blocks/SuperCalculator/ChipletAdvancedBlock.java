package com.Ultra_Nerd.CodeLyokoLegacy.blocks.SuperCalculator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public final class ChipletAdvancedBlock extends Block {
    private static final VoxelShape shape = Stream.of(
            Block.createCuboidShape(1, 0, 1, 15, 16, 15),
            Block.createCuboidShape(0, 2, 1, 1, 3, 15),
            Block.createCuboidShape(0, 0, 1, 1, 1, 15),
            Block.createCuboidShape(15, 2, 1, 16, 3, 15),
            Block.createCuboidShape(15, 0, 1, 16, 1, 15),
            Block.createCuboidShape(0, 2, 0, 16, 3, 1),
            Block.createCuboidShape(0, 0, 0, 16, 1, 1),
            Block.createCuboidShape(0, 2, 15, 16, 3, 16),
            Block.createCuboidShape(0, 0, 15, 16, 1, 16),
            Block.createCuboidShape(0, 4, 1, 1, 5, 15),
            Block.createCuboidShape(15, 4, 1, 16, 5, 15),
            Block.createCuboidShape(0, 4, 0, 16, 5, 1),
            Block.createCuboidShape(0, 4, 15, 16, 5, 16),
            Block.createCuboidShape(0, 6, 1, 1, 7, 15),
            Block.createCuboidShape(15, 6, 1, 16, 7, 15),
            Block.createCuboidShape(0, 6, 0, 16, 7, 1),
            Block.createCuboidShape(0, 6, 15, 16, 7, 16),
            Block.createCuboidShape(0, 8, 1, 1, 9, 15),
            Block.createCuboidShape(15, 8, 1, 16, 9, 15),
            Block.createCuboidShape(0, 8, 0, 16, 9, 1),
            Block.createCuboidShape(0, 8, 15, 16, 9, 16),
            Block.createCuboidShape(0, 10, 1, 1, 11, 15),
            Block.createCuboidShape(15, 10, 1, 16, 11, 15),
            Block.createCuboidShape(0, 10, 0, 16, 11, 1),
            Block.createCuboidShape(0, 10, 15, 16, 11, 16),
            Block.createCuboidShape(0, 12, 1, 1, 13, 15),
            Block.createCuboidShape(15, 12, 1, 16, 13, 15),
            Block.createCuboidShape(0, 12, 0, 16, 13, 1),
            Block.createCuboidShape(0, 12, 15, 16, 13, 16),
            Block.createCuboidShape(0, 14, 1, 1, 15, 15),
            Block.createCuboidShape(15, 14, 1, 16, 15, 15),
            Block.createCuboidShape(0, 14, 0, 16, 15, 1),
            Block.createCuboidShape(0, 14, 15, 16, 15, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public ChipletAdvancedBlock(final Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return shape;
    }

}
