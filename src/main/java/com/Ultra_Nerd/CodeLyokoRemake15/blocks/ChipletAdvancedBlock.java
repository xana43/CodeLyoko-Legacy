package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class ChipletAdvancedBlock extends Block {
    private static final VoxelShape shape = Stream.of(
            Block.box(1, 0, 1, 15, 16, 15),
            Block.box(0, 2, 1, 1, 3, 15),
            Block.box(0, 0, 1, 1, 1, 15),
            Block.box(15, 2, 1, 16, 3, 15),
            Block.box(15, 0, 1, 16, 1, 15),
            Block.box(0, 2, 0, 16, 3, 1),
            Block.box(0, 0, 0, 16, 1, 1),
            Block.box(0, 2, 15, 16, 3, 16),
            Block.box(0, 0, 15, 16, 1, 16),
            Block.box(0, 4, 1, 1, 5, 15),
            Block.box(15, 4, 1, 16, 5, 15),
            Block.box(0, 4, 0, 16, 5, 1),
            Block.box(0, 4, 15, 16, 5, 16),
            Block.box(0, 6, 1, 1, 7, 15),
            Block.box(15, 6, 1, 16, 7, 15),
            Block.box(0, 6, 0, 16, 7, 1),
            Block.box(0, 6, 15, 16, 7, 16),
            Block.box(0, 8, 1, 1, 9, 15),
            Block.box(15, 8, 1, 16, 9, 15),
            Block.box(0, 8, 0, 16, 9, 1),
            Block.box(0, 8, 15, 16, 9, 16),
            Block.box(0, 10, 1, 1, 11, 15),
            Block.box(15, 10, 1, 16, 11, 15),
            Block.box(0, 10, 0, 16, 11, 1),
            Block.box(0, 10, 15, 16, 11, 16),
            Block.box(0, 12, 1, 1, 13, 15),
            Block.box(15, 12, 1, 16, 13, 15),
            Block.box(0, 12, 0, 16, 13, 1),
            Block.box(0, 12, 15, 16, 13, 16),
            Block.box(0, 14, 1, 1, 15, 15),
            Block.box(15, 14, 1, 16, 15, 15),
            Block.box(0, 14, 0, 16, 15, 1),
            Block.box(0, 14, 15, 16, 15, 16)
    ).reduce((v1, v2) -> {
        return Shapes.join(v1, v2, BooleanOp.OR);
    }).get();

    public ChipletAdvancedBlock(Properties properties) {
        super(properties);
    }



    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return shape;
    }
}
