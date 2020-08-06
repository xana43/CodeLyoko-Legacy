package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class ChipletAdvancedBlock extends Block {
    private static final VoxelShape shape = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 16, 15),
            Block.makeCuboidShape(0, 2, 1, 1, 3, 15),
            Block.makeCuboidShape(0, 0, 1, 1, 1, 15),
            Block.makeCuboidShape(15, 2, 1, 16, 3, 15),
            Block.makeCuboidShape(15, 0, 1, 16, 1, 15),
            Block.makeCuboidShape(0, 2, 0, 16, 3, 1),
            Block.makeCuboidShape(0, 0, 0, 16, 1, 1),
            Block.makeCuboidShape(0, 2, 15, 16, 3, 16),
            Block.makeCuboidShape(0, 0, 15, 16, 1, 16),
            Block.makeCuboidShape(0, 4, 1, 1, 5, 15),
            Block.makeCuboidShape(15, 4, 1, 16, 5, 15),
            Block.makeCuboidShape(0, 4, 0, 16, 5, 1),
            Block.makeCuboidShape(0, 4, 15, 16, 5, 16),
            Block.makeCuboidShape(0, 6, 1, 1, 7, 15),
            Block.makeCuboidShape(15, 6, 1, 16, 7, 15),
            Block.makeCuboidShape(0, 6, 0, 16, 7, 1),
            Block.makeCuboidShape(0, 6, 15, 16, 7, 16),
            Block.makeCuboidShape(0, 8, 1, 1, 9, 15),
            Block.makeCuboidShape(15, 8, 1, 16, 9, 15),
            Block.makeCuboidShape(0, 8, 0, 16, 9, 1),
            Block.makeCuboidShape(0, 8, 15, 16, 9, 16),
            Block.makeCuboidShape(0, 10, 1, 1, 11, 15),
            Block.makeCuboidShape(15, 10, 1, 16, 11, 15),
            Block.makeCuboidShape(0, 10, 0, 16, 11, 1),
            Block.makeCuboidShape(0, 10, 15, 16, 11, 16),
            Block.makeCuboidShape(0, 12, 1, 1, 13, 15),
            Block.makeCuboidShape(15, 12, 1, 16, 13, 15),
            Block.makeCuboidShape(0, 12, 0, 16, 13, 1),
            Block.makeCuboidShape(0, 12, 15, 16, 13, 16),
            Block.makeCuboidShape(0, 14, 1, 1, 15, 15),
            Block.makeCuboidShape(15, 14, 1, 16, 15, 15),
            Block.makeCuboidShape(0, 14, 0, 16, 15, 1),
            Block.makeCuboidShape(0, 14, 15, 16, 15, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    public ChipletAdvancedBlock(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        return shape;
    }
}
