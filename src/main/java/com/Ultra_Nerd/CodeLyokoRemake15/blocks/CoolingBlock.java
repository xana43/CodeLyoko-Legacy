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

public class CoolingBlock extends Block {
    private static final VoxelShape shape = Stream.of(

            Block.box(9, 0, 7, 13, 32, 9),
            Block.box(9, 0, 23, 13, 32, 25),
            Block.box(25, 0, 23, 29, 32, 25),
            Block.box(25, 0, 7, 29, 32, 9),
            Block.box(25, 0, -9, 29, 32, -7),
            Block.box(9, 0, -9, 13, 32, -7),
            Block.box(-7, 0, -9, -3, 32, -7),
            Block.box(-7, 0, 7, -3, 32, 9),
            Block.box(-7, 0, 23, -3, 32, 25),
            Block.box(0, 0, 0, 16, 1, 7),
            Block.box(0, 0, 16, 16, 1, 23),
            Block.box(16, 0, 16, 32, 1, 23),
            Block.box(16, 0, 0, 32, 1, 7),
            Block.box(16, 0, -16, 32, 1, -9),
            Block.box(0, 0, -16, 16, 1, -9),
            Block.box(-16, 0, -16, 0, 1, -9),
            Block.box(-16, 0, 0, 0, 1, 7),
            Block.box(-16, 0, 16, 0, 1, 23),
            Block.box(0, 2, 0, 16, 3, 7),
            Block.box(0, 2, 16, 16, 3, 23),
            Block.box(16, 2, 16, 32, 3, 23),
            Block.box(16, 2, 0, 32, 3, 7),
            Block.box(16, 2, -16, 32, 3, -9),
            Block.box(0, 2, -16, 16, 3, -9),
            Block.box(-16, 2, -16, 0, 3, -9),
            Block.box(-16, 2, 0, 0, 3, 7),
            Block.box(-16, 2, 16, 0, 3, 23),
            Block.box(0, 4, 0, 16, 5, 7),
            Block.box(0, 4, 16, 16, 5, 23),
            Block.box(16, 4, 16, 32, 5, 23),
            Block.box(16, 4, 0, 32, 5, 7),
            Block.box(16, 4, -16, 32, 5, -9),
            Block.box(0, 4, -16, 16, 5, -9),
            Block.box(-16, 4, -16, 0, 5, -9),
            Block.box(-16, 4, 0, 0, 5, 7),
            Block.box(-16, 4, 16, 0, 5, 23),
            Block.box(0, 6, 0, 16, 7, 7),
            Block.box(0, 6, 16, 16, 7, 23),
            Block.box(16, 6, 16, 32, 7, 23),
            Block.box(16, 6, 0, 32, 7, 7),
            Block.box(16, 6, -16, 32, 7, -9),
            Block.box(0, 6, -16, 16, 7, -9),
            Block.box(-16, 6, -16, 0, 7, -9),
            Block.box(-16, 6, 0, 0, 7, 7),
            Block.box(-16, 6, 16, 0, 7, 23),
            Block.box(0, 8, 0, 16, 9, 7),
            Block.box(0, 8, 16, 16, 9, 23),
            Block.box(16, 8, 16, 32, 9, 23),
            Block.box(16, 8, 0, 32, 9, 7),
            Block.box(16, 8, -16, 32, 9, -9),
            Block.box(0, 8, -16, 16, 9, -9),
            Block.box(-16, 8, -16, 0, 9, -9),
            Block.box(-16, 8, 0, 0, 9, 7),
            Block.box(-16, 8, 16, 0, 9, 23),
            Block.box(0, 10, 0, 16, 11, 7),
            Block.box(0, 10, 16, 16, 11, 23),
            Block.box(16, 10, 16, 32, 11, 23),
            Block.box(16, 10, 0, 32, 11, 7),
            Block.box(16, 10, -16, 32, 11, -9),
            Block.box(0, 10, -16, 16, 11, -9),
            Block.box(-16, 10, -16, 0, 11, -9),
            Block.box(-16, 10, 0, 0, 11, 7),
            Block.box(-16, 10, 16, 0, 11, 23),
            Block.box(0, 12, 0, 16, 13, 7),
            Block.box(0, 12, 16, 16, 13, 23),
            Block.box(16, 12, 16, 32, 13, 23),
            Block.box(16, 12, 0, 32, 13, 7),
            Block.box(16, 12, -16, 32, 13, -9),
            Block.box(0, 12, -16, 16, 13, -9),
            Block.box(-16, 12, -16, 0, 13, -9),
            Block.box(-16, 12, 0, 0, 13, 7),
            Block.box(-16, 12, 16, 0, 13, 23),
            Block.box(0, 14, 0, 16, 15, 7),
            Block.box(0, 14, 16, 16, 15, 23),
            Block.box(16, 14, 16, 32, 15, 23),
            Block.box(16, 14, 0, 32, 15, 7),
            Block.box(16, 14, -16, 32, 15, -9),
            Block.box(0, 14, -16, 16, 15, -9),
            Block.box(-16, 14, -16, 0, 15, -9),
            Block.box(-16, 14, 0, 0, 15, 7),
            Block.box(-16, 14, 16, 0, 15, 23),
            Block.box(0, 16, 0, 16, 17, 7),
            Block.box(0, 18, 0, 16, 19, 7),
            Block.box(0, 20, 0, 16, 21, 7),
            Block.box(0, 22, 0, 16, 23, 7),
            Block.box(0, 24, 0, 16, 25, 7),
            Block.box(0, 26, 0, 16, 27, 7),
            Block.box(0, 28, 0, 16, 29, 7),
            Block.box(0, 30, 0, 16, 31, 7),
            Block.box(0, 16, 16, 16, 17, 23),
            Block.box(0, 18, 16, 16, 19, 23),
            Block.box(0, 20, 16, 16, 21, 23),
            Block.box(0, 22, 16, 16, 23, 23),
            Block.box(0, 24, 16, 16, 25, 23),
            Block.box(0, 26, 16, 16, 27, 23),
            Block.box(0, 28, 16, 16, 29, 23),
            Block.box(0, 30, 16, 16, 31, 23),
            Block.box(16, 16, 16, 32, 17, 23),
            Block.box(16, 18, 16, 32, 19, 23),
            Block.box(16, 20, 16, 32, 21, 23),
            Block.box(16, 22, 16, 32, 23, 23),
            Block.box(16, 24, 16, 32, 25, 23),
            Block.box(16, 26, 16, 32, 27, 23),
            Block.box(16, 28, 16, 32, 29, 23),
            Block.box(16, 30, 16, 32, 31, 23),
            Block.box(16, 16, 0, 32, 17, 7),
            Block.box(16, 18, 0, 32, 19, 7),
            Block.box(16, 20, 0, 32, 21, 7),
            Block.box(16, 22, 0, 32, 23, 7),
            Block.box(16, 24, 0, 32, 25, 7),
            Block.box(16, 26, 0, 32, 27, 7),
            Block.box(16, 28, 0, 32, 29, 7),
            Block.box(16, 30, 0, 32, 31, 7),
            Block.box(16, 16, -16, 32, 17, -9),
            Block.box(16, 18, -16, 32, 19, -9),
            Block.box(16, 20, -16, 32, 21, -9),
            Block.box(16, 22, -16, 32, 23, -9),
            Block.box(16, 24, -16, 32, 25, -9),
            Block.box(16, 26, -16, 32, 27, -9),
            Block.box(16, 28, -16, 32, 29, -9),
            Block.box(16, 30, -16, 32, 31, -9),
            Block.box(0, 16, -16, 16, 17, -9),
            Block.box(0, 18, -16, 16, 19, -9),
            Block.box(0, 20, -16, 16, 21, -9),
            Block.box(0, 22, -16, 16, 23, -9),
            Block.box(0, 24, -16, 16, 25, -9),
            Block.box(0, 26, -16, 16, 27, -9),
            Block.box(0, 28, -16, 16, 29, -9),
            Block.box(0, 30, -16, 16, 31, -9),
            Block.box(-16, 16, -16, 0, 17, -9),
            Block.box(-16, 18, -16, 0, 19, -9),
            Block.box(-16, 20, -16, 0, 21, -9),
            Block.box(-16, 22, -16, 0, 23, -9),
            Block.box(-16, 24, -16, 0, 25, -9),
            Block.box(-16, 26, -16, 0, 27, -9),
            Block.box(-16, 28, -16, 0, 29, -9),
            Block.box(-16, 30, -16, 0, 31, -9),
            Block.box(-16, 16, 0, 0, 17, 7),
            Block.box(-16, 18, 0, 0, 19, 7),
            Block.box(-16, 20, 0, 0, 21, 7),
            Block.box(-16, 22, 0, 0, 23, 7),
            Block.box(-16, 24, 0, 0, 25, 7),
            Block.box(-16, 26, 0, 0, 27, 7),
            Block.box(-16, 28, 0, 0, 29, 7),
            Block.box(-16, 30, 0, 0, 31, 7),
            Block.box(-16, 16, 16, 0, 17, 23),
            Block.box(-16, 18, 16, 0, 19, 23),
            Block.box(-16, 20, 16, 0, 21, 23),
            Block.box(-16, 22, 16, 0, 23, 23),
            Block.box(-16, 24, 16, 0, 25, 23),
            Block.box(-16, 26, 16, 0, 27, 23),
            Block.box(-16, 28, 16, 0, 29, 23),
            Block.box(-16, 30, 16, 0, 31, 23),
            Block.box(0, 0, 9, 16, 1, 16),
            Block.box(0, 0, 25, 16, 1, 32),
            Block.box(16, 0, 25, 32, 1, 32),
            Block.box(16, 0, 9, 32, 1, 16),
            Block.box(16, 0, -7, 32, 1, 0),
            Block.box(0, 0, -7, 16, 1, 0),
            Block.box(-16, 0, -7, 0, 1, 0),
            Block.box(-16, 0, 9, 0, 1, 16),
            Block.box(-16, 0, 25, 0, 1, 32),
            Block.box(0, 2, 9, 16, 3, 16),
            Block.box(0, 2, 25, 16, 3, 32),
            Block.box(16, 2, 25, 32, 3, 32),
            Block.box(16, 2, 9, 32, 3, 16),
            Block.box(16, 2, -7, 32, 3, 0),
            Block.box(0, 2, -7, 16, 3, 0),
            Block.box(-16, 2, -7, 0, 3, 0),
            Block.box(-16, 2, 9, 0, 3, 16),
            Block.box(-16, 2, 25, 0, 3, 32),
            Block.box(0, 4, 9, 16, 5, 16),
            Block.box(0, 4, 25, 16, 5, 32),
            Block.box(16, 4, 25, 32, 5, 32),
            Block.box(16, 4, 9, 32, 5, 16),
            Block.box(16, 4, -7, 32, 5, 0),
            Block.box(0, 4, -7, 16, 5, 0),
            Block.box(-16, 4, -7, 0, 5, 0),
            Block.box(-16, 4, 9, 0, 5, 16),
            Block.box(-16, 4, 25, 0, 5, 32),
            Block.box(0, 6, 9, 16, 7, 16),
            Block.box(0, 6, 25, 16, 7, 32),
            Block.box(16, 6, 25, 32, 7, 32),
            Block.box(16, 6, 9, 32, 7, 16),
            Block.box(16, 6, -7, 32, 7, 0),
            Block.box(0, 6, -7, 16, 7, 0),
            Block.box(-16, 6, -7, 0, 7, 0),
            Block.box(-16, 6, 9, 0, 7, 16),
            Block.box(-16, 6, 25, 0, 7, 32),
            Block.box(0, 8, 9, 16, 9, 16),
            Block.box(0, 8, 25, 16, 9, 32),
            Block.box(16, 8, 25, 32, 9, 32),
            Block.box(16, 8, 9, 32, 9, 16),
            Block.box(16, 8, -7, 32, 9, 0),
            Block.box(0, 8, -7, 16, 9, 0),
            Block.box(-16, 8, -7, 0, 9, 0),
            Block.box(-16, 8, 9, 0, 9, 16),
            Block.box(-16, 8, 25, 0, 9, 32),
            Block.box(0, 10, 9, 16, 11, 16),
            Block.box(0, 10, 25, 16, 11, 32),
            Block.box(16, 10, 25, 32, 11, 32),
            Block.box(16, 10, 9, 32, 11, 16),
            Block.box(16, 10, -7, 32, 11, 0),
            Block.box(0, 10, -7, 16, 11, 0),
            Block.box(-16, 10, -7, 0, 11, 0),
            Block.box(-16, 10, 9, 0, 11, 16),
            Block.box(-16, 10, 25, 0, 11, 32),
            Block.box(0, 12, 9, 16, 13, 16),
            Block.box(0, 12, 25, 16, 13, 32),
            Block.box(16, 12, 25, 32, 13, 32),
            Block.box(16, 12, 9, 32, 13, 16),
            Block.box(16, 12, -7, 32, 13, 0),
            Block.box(0, 12, -7, 16, 13, 0),
            Block.box(-16, 12, -7, 0, 13, 0),
            Block.box(-16, 12, 9, 0, 13, 16),
            Block.box(-16, 12, 25, 0, 13, 32),
            Block.box(0, 14, 9, 16, 15, 16),
            Block.box(0, 14, 25, 16, 15, 32),
            Block.box(16, 14, 25, 32, 15, 32),
            Block.box(16, 14, 9, 32, 15, 16),
            Block.box(16, 14, -7, 32, 15, 0),
            Block.box(0, 14, -7, 16, 15, 0),
            Block.box(-16, 14, -7, 0, 15, 0),
            Block.box(-16, 14, 9, 0, 15, 16),
            Block.box(-16, 14, 25, 0, 15, 32),
            Block.box(0, 16, 9, 16, 17, 16),
            Block.box(0, 18, 9, 16, 19, 16),
            Block.box(0, 20, 9, 16, 21, 16),
            Block.box(0, 22, 9, 16, 23, 16),
            Block.box(0, 24, 9, 16, 25, 16),
            Block.box(0, 26, 9, 16, 27, 16),
            Block.box(0, 28, 9, 16, 29, 16),
            Block.box(0, 30, 9, 16, 31, 16),
            Block.box(0, 16, 25, 16, 17, 32),
            Block.box(0, 18, 25, 16, 19, 32),
            Block.box(0, 20, 25, 16, 21, 32),
            Block.box(0, 22, 25, 16, 23, 32),
            Block.box(0, 24, 25, 16, 25, 32),
            Block.box(0, 26, 25, 16, 27, 32),
            Block.box(0, 28, 25, 16, 29, 32),
            Block.box(0, 30, 25, 16, 31, 32),
            Block.box(16, 16, 25, 32, 17, 32),
            Block.box(16, 18, 25, 32, 19, 32),
            Block.box(16, 20, 25, 32, 21, 32),
            Block.box(16, 22, 25, 32, 23, 32),
            Block.box(16, 24, 25, 32, 25, 32),
            Block.box(16, 26, 25, 32, 27, 32),
            Block.box(16, 28, 25, 32, 29, 32),
            Block.box(16, 30, 25, 32, 31, 32),
            Block.box(16, 16, 9, 32, 17, 16),
            Block.box(16, 18, 9, 32, 19, 16),
            Block.box(16, 20, 9, 32, 21, 16),
            Block.box(16, 22, 9, 32, 23, 16),
            Block.box(16, 24, 9, 32, 25, 16),
            Block.box(16, 26, 9, 32, 27, 16),
            Block.box(16, 28, 9, 32, 29, 16),
            Block.box(16, 30, 9, 32, 31, 16),
            Block.box(16, 16, -7, 32, 17, 0),
            Block.box(16, 18, -7, 32, 19, 0),
            Block.box(16, 20, -7, 32, 21, 0),
            Block.box(16, 22, -7, 32, 23, 0),
            Block.box(16, 24, -7, 32, 25, 0),
            Block.box(16, 26, -7, 32, 27, 0),
            Block.box(16, 28, -7, 32, 29, 0),
            Block.box(16, 30, -7, 32, 31, 0),
            Block.box(0, 16, -7, 16, 17, 0),
            Block.box(0, 18, -7, 16, 19, 0),
            Block.box(0, 20, -7, 16, 21, 0),
            Block.box(0, 22, -7, 16, 23, 0),
            Block.box(0, 24, -7, 16, 25, 0),
            Block.box(0, 26, -7, 16, 27, 0),
            Block.box(0, 28, -7, 16, 29, 0),
            Block.box(0, 30, -7, 16, 31, 0),
            Block.box(-16, 16, -7, 0, 17, 0),
            Block.box(-16, 18, -7, 0, 19, 0),
            Block.box(-16, 20, -7, 0, 21, 0),
            Block.box(-16, 22, -7, 0, 23, 0),
            Block.box(-16, 24, -7, 0, 25, 0),
            Block.box(-16, 26, -7, 0, 27, 0),
            Block.box(-16, 28, -7, 0, 29, 0),
            Block.box(-16, 30, -7, 0, 31, 0),
            Block.box(-16, 16, 9, 0, 17, 16),
            Block.box(-16, 18, 9, 0, 19, 16),
            Block.box(-16, 20, 9, 0, 21, 16),
            Block.box(-16, 22, 9, 0, 23, 16),
            Block.box(-16, 24, 9, 0, 25, 16),
            Block.box(-16, 26, 9, 0, 27, 16),
            Block.box(-16, 28, 9, 0, 29, 16),
            Block.box(-16, 30, 9, 0, 31, 16),
            Block.box(-16, 16, 25, 0, 17, 32),
            Block.box(-16, 18, 25, 0, 19, 32),
            Block.box(-16, 20, 25, 0, 21, 32),
            Block.box(-16, 22, 25, 0, 23, 32),
            Block.box(-16, 24, 25, 0, 25, 32),
            Block.box(-16, 26, 25, 0, 27, 32),
            Block.box(-16, 28, 25, 0, 29, 32),
            Block.box(-16, 30, 25, 0, 31, 32),
            Block.box(0, 0, 7, 3, 1, 9),
            Block.box(0, 0, 23, 3, 1, 25),
            Block.box(16, 0, 23, 19, 1, 25),
            Block.box(16, 0, 7, 19, 1, 9),
            Block.box(16, 0, -9, 19, 1, -7),
            Block.box(0, 0, -9, 3, 1, -7),
            Block.box(-16, 0, -9, -13, 1, -7),
            Block.box(-16, 0, 7, -13, 1, 9),
            Block.box(-16, 0, 23, -13, 1, 25),
            Block.box(0, 2, 7, 3, 3, 9),
            Block.box(0, 2, 23, 3, 3, 25),
            Block.box(16, 2, 23, 19, 3, 25),
            Block.box(16, 2, 7, 19, 3, 9),
            Block.box(16, 2, -9, 19, 3, -7),
            Block.box(0, 2, -9, 3, 3, -7),
            Block.box(-16, 2, -9, -13, 3, -7),
            Block.box(-16, 2, 7, -13, 3, 9),
            Block.box(-16, 2, 23, -13, 3, 25),
            Block.box(0, 4, 7, 3, 5, 9),
            Block.box(0, 4, 23, 3, 5, 25),
            Block.box(16, 4, 23, 19, 5, 25),
            Block.box(16, 4, 7, 19, 5, 9),
            Block.box(16, 4, -9, 19, 5, -7),
            Block.box(0, 4, -9, 3, 5, -7),
            Block.box(-16, 4, -9, -13, 5, -7),
            Block.box(-16, 4, 7, -13, 5, 9),
            Block.box(-16, 4, 23, -13, 5, 25),
            Block.box(0, 6, 7, 3, 7, 9),
            Block.box(0, 6, 23, 3, 7, 25),
            Block.box(16, 6, 23, 19, 7, 25),
            Block.box(16, 6, 7, 19, 7, 9),
            Block.box(16, 6, -9, 19, 7, -7),
            Block.box(0, 6, -9, 3, 7, -7),
            Block.box(-16, 6, -9, -13, 7, -7),
            Block.box(-16, 6, 7, -13, 7, 9),
            Block.box(-16, 6, 23, -13, 7, 25),
            Block.box(0, 8, 7, 3, 9, 9),
            Block.box(0, 8, 23, 3, 9, 25),
            Block.box(16, 8, 23, 19, 9, 25),
            Block.box(16, 8, 7, 19, 9, 9),
            Block.box(16, 8, -9, 19, 9, -7),
            Block.box(0, 8, -9, 3, 9, -7),
            Block.box(-16, 8, -9, -13, 9, -7),
            Block.box(-16, 8, 7, -13, 9, 9),
            Block.box(-16, 8, 23, -13, 9, 25),
            Block.box(0, 10, 7, 3, 11, 9),
            Block.box(0, 10, 23, 3, 11, 25),
            Block.box(16, 10, 23, 19, 11, 25),
            Block.box(16, 10, 7, 19, 11, 9),
            Block.box(16, 10, -9, 19, 11, -7),
            Block.box(0, 10, -9, 3, 11, -7),
            Block.box(-16, 10, -9, -13, 11, -7),
            Block.box(-16, 10, 7, -13, 11, 9),
            Block.box(-16, 10, 23, -13, 11, 25),
            Block.box(0, 12, 7, 3, 13, 9),
            Block.box(0, 12, 23, 3, 13, 25),
            Block.box(16, 12, 23, 19, 13, 25),
            Block.box(16, 12, 7, 19, 13, 9),
            Block.box(16, 12, -9, 19, 13, -7),
            Block.box(0, 12, -9, 3, 13, -7),
            Block.box(-16, 12, -9, -13, 13, -7),
            Block.box(-16, 12, 7, -13, 13, 9),
            Block.box(-16, 12, 23, -13, 13, 25),
            Block.box(0, 14, 7, 3, 15, 9),
            Block.box(0, 14, 23, 3, 15, 25),
            Block.box(16, 14, 23, 19, 15, 25),
            Block.box(16, 14, 7, 19, 15, 9),
            Block.box(16, 14, -9, 19, 15, -7),
            Block.box(0, 14, -9, 3, 15, -7),
            Block.box(-16, 14, -9, -13, 15, -7),
            Block.box(-16, 14, 7, -13, 15, 9),
            Block.box(-16, 14, 23, -13, 15, 25),
            Block.box(0, 16, 7, 3, 17, 9),
            Block.box(0, 18, 7, 3, 19, 9),
            Block.box(0, 20, 7, 3, 21, 9),
            Block.box(0, 22, 7, 3, 23, 9),
            Block.box(0, 24, 7, 3, 25, 9),
            Block.box(0, 26, 7, 3, 27, 9),
            Block.box(0, 28, 7, 3, 29, 9),
            Block.box(0, 30, 7, 3, 31, 9),
            Block.box(0, 16, 23, 3, 17, 25),
            Block.box(0, 18, 23, 3, 19, 25),
            Block.box(0, 20, 23, 3, 21, 25),
            Block.box(0, 22, 23, 3, 23, 25),
            Block.box(0, 24, 23, 3, 25, 25),
            Block.box(0, 26, 23, 3, 27, 25),
            Block.box(0, 28, 23, 3, 29, 25),
            Block.box(0, 30, 23, 3, 31, 25),
            Block.box(16, 16, 23, 19, 17, 25),
            Block.box(16, 18, 23, 19, 19, 25),
            Block.box(16, 20, 23, 19, 21, 25),
            Block.box(16, 22, 23, 19, 23, 25),
            Block.box(16, 24, 23, 19, 25, 25),
            Block.box(16, 26, 23, 19, 27, 25),
            Block.box(16, 28, 23, 19, 29, 25),
            Block.box(16, 30, 23, 19, 31, 25),
            Block.box(16, 16, 7, 19, 17, 9),
            Block.box(16, 18, 7, 19, 19, 9),
            Block.box(16, 20, 7, 19, 21, 9),
            Block.box(16, 22, 7, 19, 23, 9),
            Block.box(16, 24, 7, 19, 25, 9),
            Block.box(16, 26, 7, 19, 27, 9),
            Block.box(16, 28, 7, 19, 29, 9),
            Block.box(16, 30, 7, 19, 31, 9),
            Block.box(16, 16, -9, 19, 17, -7),
            Block.box(16, 18, -9, 19, 19, -7),
            Block.box(16, 20, -9, 19, 21, -7),
            Block.box(16, 22, -9, 19, 23, -7),
            Block.box(16, 24, -9, 19, 25, -7),
            Block.box(16, 26, -9, 19, 27, -7),
            Block.box(16, 28, -9, 19, 29, -7),
            Block.box(16, 30, -9, 19, 31, -7),
            Block.box(0, 16, -9, 3, 17, -7),
            Block.box(0, 18, -9, 3, 19, -7),
            Block.box(0, 20, -9, 3, 21, -7),
            Block.box(0, 22, -9, 3, 23, -7),
            Block.box(0, 24, -9, 3, 25, -7),
            Block.box(0, 26, -9, 3, 27, -7),
            Block.box(0, 28, -9, 3, 29, -7),
            Block.box(0, 30, -9, 3, 31, -7),
            Block.box(-16, 16, -9, -13, 17, -7),
            Block.box(-16, 18, -9, -13, 19, -7),
            Block.box(-16, 20, -9, -13, 21, -7),
            Block.box(-16, 22, -9, -13, 23, -7),
            Block.box(-16, 24, -9, -13, 25, -7),
            Block.box(-16, 26, -9, -13, 27, -7),
            Block.box(-16, 28, -9, -13, 29, -7),
            Block.box(-16, 30, -9, -13, 31, -7),
            Block.box(-16, 16, 7, -13, 17, 9),
            Block.box(-16, 18, 7, -13, 19, 9),
            Block.box(-16, 20, 7, -13, 21, 9),
            Block.box(-16, 22, 7, -13, 23, 9),
            Block.box(-16, 24, 7, -13, 25, 9),
            Block.box(-16, 26, 7, -13, 27, 9),
            Block.box(-16, 28, 7, -13, 29, 9),
            Block.box(-16, 30, 7, -13, 31, 9),
            Block.box(-16, 16, 23, -13, 17, 25),
            Block.box(-16, 18, 23, -13, 19, 25),
            Block.box(-16, 20, 23, -13, 21, 25),
            Block.box(-16, 22, 23, -13, 23, 25),
            Block.box(-16, 24, 23, -13, 25, 25),
            Block.box(-16, 26, 23, -13, 27, 25),
            Block.box(-16, 28, 23, -13, 29, 25),
            Block.box(-16, 30, 23, -13, 31, 25),
            Block.box(13, 0, 7, 16, 1, 9),
            Block.box(13, 0, 23, 16, 1, 25),
            Block.box(29, 0, 23, 32, 1, 25),
            Block.box(29, 0, 7, 32, 1, 9),
            Block.box(29, 0, -9, 32, 1, -7),
            Block.box(13, 0, -9, 16, 1, -7),
            Block.box(-3, 0, -9, 0, 1, -7),
            Block.box(-3, 0, 7, 0, 1, 9),
            Block.box(-3, 0, 23, 0, 1, 25),
            Block.box(13, 2, 7, 16, 3, 9),
            Block.box(13, 2, 23, 16, 3, 25),
            Block.box(29, 2, 23, 32, 3, 25),
            Block.box(29, 2, 7, 32, 3, 9),
            Block.box(29, 2, -9, 32, 3, -7),
            Block.box(13, 2, -9, 16, 3, -7),
            Block.box(-3, 2, -9, 0, 3, -7),
            Block.box(-3, 2, 7, 0, 3, 9),
            Block.box(-3, 2, 23, 0, 3, 25),
            Block.box(13, 4, 7, 16, 5, 9),
            Block.box(13, 4, 23, 16, 5, 25),
            Block.box(29, 4, 23, 32, 5, 25),
            Block.box(29, 4, 7, 32, 5, 9),
            Block.box(29, 4, -9, 32, 5, -7),
            Block.box(13, 4, -9, 16, 5, -7),
            Block.box(-3, 4, -9, 0, 5, -7),
            Block.box(-3, 4, 7, 0, 5, 9),
            Block.box(-3, 4, 23, 0, 5, 25),
            Block.box(13, 6, 7, 16, 7, 9),
            Block.box(13, 6, 23, 16, 7, 25),
            Block.box(29, 6, 23, 32, 7, 25),
            Block.box(29, 6, 7, 32, 7, 9),
            Block.box(29, 6, -9, 32, 7, -7),
            Block.box(13, 6, -9, 16, 7, -7),
            Block.box(-3, 6, -9, 0, 7, -7),
            Block.box(-3, 6, 7, 0, 7, 9),
            Block.box(-3, 6, 23, 0, 7, 25),
            Block.box(13, 8, 7, 16, 9, 9),
            Block.box(13, 8, 23, 16, 9, 25),
            Block.box(29, 8, 23, 32, 9, 25),
            Block.box(29, 8, 7, 32, 9, 9),
            Block.box(29, 8, -9, 32, 9, -7),
            Block.box(13, 8, -9, 16, 9, -7),
            Block.box(-3, 8, -9, 0, 9, -7),
            Block.box(-3, 8, 7, 0, 9, 9),
            Block.box(-3, 8, 23, 0, 9, 25),
            Block.box(13, 10, 7, 16, 11, 9),
            Block.box(13, 10, 23, 16, 11, 25),
            Block.box(29, 10, 23, 32, 11, 25),
            Block.box(29, 10, 7, 32, 11, 9),
            Block.box(29, 10, -9, 32, 11, -7),
            Block.box(13, 10, -9, 16, 11, -7),
            Block.box(-3, 10, -9, 0, 11, -7),
            Block.box(-3, 10, 7, 0, 11, 9),
            Block.box(-3, 10, 23, 0, 11, 25),
            Block.box(13, 12, 7, 16, 13, 9),
            Block.box(13, 12, 23, 16, 13, 25),
            Block.box(29, 12, 23, 32, 13, 25),
            Block.box(29, 12, 7, 32, 13, 9),
            Block.box(29, 12, -9, 32, 13, -7),
            Block.box(13, 12, -9, 16, 13, -7),
            Block.box(-3, 12, -9, 0, 13, -7),
            Block.box(-3, 12, 7, 0, 13, 9),
            Block.box(-3, 12, 23, 0, 13, 25),
            Block.box(13, 14, 7, 16, 15, 9),
            Block.box(13, 14, 23, 16, 15, 25),
            Block.box(29, 14, 23, 32, 15, 25),
            Block.box(29, 14, 7, 32, 15, 9),
            Block.box(29, 14, -9, 32, 15, -7),
            Block.box(13, 14, -9, 16, 15, -7),
            Block.box(-3, 14, -9, 0, 15, -7),
            Block.box(-3, 14, 7, 0, 15, 9),
            Block.box(-3, 14, 23, 0, 15, 25),
            Block.box(13, 16, 7, 16, 17, 9),
            Block.box(13, 18, 7, 16, 19, 9),
            Block.box(13, 20, 7, 16, 21, 9),
            Block.box(13, 22, 7, 16, 23, 9),
            Block.box(13, 24, 7, 16, 25, 9),
            Block.box(13, 26, 7, 16, 27, 9),
            Block.box(13, 28, 7, 16, 29, 9),
            Block.box(13, 30, 7, 16, 31, 9),
            Block.box(13, 16, 23, 16, 17, 25),
            Block.box(13, 18, 23, 16, 19, 25),
            Block.box(13, 20, 23, 16, 21, 25),
            Block.box(13, 22, 23, 16, 23, 25),
            Block.box(13, 24, 23, 16, 25, 25),
            Block.box(13, 26, 23, 16, 27, 25),
            Block.box(13, 28, 23, 16, 29, 25),
            Block.box(13, 30, 23, 16, 31, 25),
            Block.box(29, 16, 23, 32, 17, 25),
            Block.box(29, 18, 23, 32, 19, 25),
            Block.box(29, 20, 23, 32, 21, 25),
            Block.box(29, 22, 23, 32, 23, 25),
            Block.box(29, 24, 23, 32, 25, 25),
            Block.box(29, 26, 23, 32, 27, 25),
            Block.box(29, 28, 23, 32, 29, 25),
            Block.box(29, 30, 23, 32, 31, 25),
            Block.box(29, 16, 7, 32, 17, 9),
            Block.box(29, 18, 7, 32, 19, 9),
            Block.box(29, 20, 7, 32, 21, 9),
            Block.box(29, 22, 7, 32, 23, 9),
            Block.box(29, 24, 7, 32, 25, 9),
            Block.box(29, 26, 7, 32, 27, 9),
            Block.box(29, 28, 7, 32, 29, 9),
            Block.box(29, 30, 7, 32, 31, 9),
            Block.box(29, 16, -9, 32, 17, -7),
            Block.box(29, 18, -9, 32, 19, -7),
            Block.box(29, 20, -9, 32, 21, -7),
            Block.box(29, 22, -9, 32, 23, -7),
            Block.box(29, 24, -9, 32, 25, -7),
            Block.box(29, 26, -9, 32, 27, -7),
            Block.box(29, 28, -9, 32, 29, -7),
            Block.box(29, 30, -9, 32, 31, -7),
            Block.box(13, 16, -9, 16, 17, -7),
            Block.box(13, 18, -9, 16, 19, -7),
            Block.box(13, 20, -9, 16, 21, -7),
            Block.box(13, 22, -9, 16, 23, -7),
            Block.box(13, 24, -9, 16, 25, -7),
            Block.box(13, 26, -9, 16, 27, -7),
            Block.box(13, 28, -9, 16, 29, -7),
            Block.box(13, 30, -9, 16, 31, -7),
            Block.box(-3, 16, -9, 0, 17, -7),
            Block.box(-3, 18, -9, 0, 19, -7),
            Block.box(-3, 20, -9, 0, 21, -7),
            Block.box(-3, 22, -9, 0, 23, -7),
            Block.box(-3, 24, -9, 0, 25, -7),
            Block.box(-3, 26, -9, 0, 27, -7),
            Block.box(-3, 28, -9, 0, 29, -7),
            Block.box(-3, 30, -9, 0, 31, -7),
            Block.box(-3, 16, 7, 0, 17, 9),
            Block.box(-3, 18, 7, 0, 19, 9),
            Block.box(-3, 20, 7, 0, 21, 9),
            Block.box(-3, 22, 7, 0, 23, 9),
            Block.box(-3, 24, 7, 0, 25, 9),
            Block.box(-3, 26, 7, 0, 27, 9),
            Block.box(-3, 28, 7, 0, 29, 9),
            Block.box(-3, 30, 7, 0, 31, 9),
            Block.box(-3, 16, 23, 0, 17, 25),
            Block.box(-3, 18, 23, 0, 19, 25),
            Block.box(-3, 20, 23, 0, 21, 25),
            Block.box(-3, 22, 23, 0, 23, 25),
            Block.box(-3, 24, 23, 0, 25, 25),
            Block.box(-3, 26, 23, 0, 27, 25),
            Block.box(-3, 28, 23, 0, 29, 25),
            Block.box(-3, 30, 23, 0, 31, 25),
            Block.box(7, 0, 7, 9, 1, 9),
            Block.box(7, 0, 23, 9, 1, 25),
            Block.box(23, 0, 23, 25, 1, 25),
            Block.box(23, 0, 7, 25, 1, 9),
            Block.box(23, 0, -9, 25, 1, -7),
            Block.box(7, 0, -9, 9, 1, -7),
            Block.box(-9, 0, -9, -7, 1, -7),
            Block.box(-9, 0, 7, -7, 1, 9),
            Block.box(-9, 0, 23, -7, 1, 25),
            Block.box(7, 2, 7, 9, 3, 9),
            Block.box(7, 2, 23, 9, 3, 25),
            Block.box(23, 2, 23, 25, 3, 25),
            Block.box(23, 2, 7, 25, 3, 9),
            Block.box(23, 2, -9, 25, 3, -7),
            Block.box(7, 2, -9, 9, 3, -7),
            Block.box(-9, 2, -9, -7, 3, -7),
            Block.box(-9, 2, 7, -7, 3, 9),
            Block.box(-9, 2, 23, -7, 3, 25),
            Block.box(7, 4, 7, 9, 5, 9),
            Block.box(7, 4, 23, 9, 5, 25),
            Block.box(23, 4, 23, 25, 5, 25),
            Block.box(23, 4, 7, 25, 5, 9),
            Block.box(23, 4, -9, 25, 5, -7),
            Block.box(7, 4, -9, 9, 5, -7),
            Block.box(-9, 4, -9, -7, 5, -7),
            Block.box(-9, 4, 7, -7, 5, 9),
            Block.box(-9, 4, 23, -7, 5, 25),
            Block.box(7, 6, 7, 9, 7, 9),
            Block.box(7, 6, 23, 9, 7, 25),
            Block.box(23, 6, 23, 25, 7, 25),
            Block.box(23, 6, 7, 25, 7, 9),
            Block.box(23, 6, -9, 25, 7, -7),
            Block.box(7, 6, -9, 9, 7, -7),
            Block.box(-9, 6, -9, -7, 7, -7),
            Block.box(-9, 6, 7, -7, 7, 9),
            Block.box(-9, 6, 23, -7, 7, 25),
            Block.box(7, 8, 7, 9, 9, 9),
            Block.box(7, 8, 23, 9, 9, 25),
            Block.box(23, 8, 23, 25, 9, 25),
            Block.box(23, 8, 7, 25, 9, 9),
            Block.box(23, 8, -9, 25, 9, -7),
            Block.box(7, 8, -9, 9, 9, -7),
            Block.box(-9, 8, -9, -7, 9, -7),
            Block.box(-9, 8, 7, -7, 9, 9),
            Block.box(-9, 8, 23, -7, 9, 25),
            Block.box(7, 10, 7, 9, 11, 9),
            Block.box(7, 10, 23, 9, 11, 25),
            Block.box(23, 10, 23, 25, 11, 25),
            Block.box(23, 10, 7, 25, 11, 9),
            Block.box(23, 10, -9, 25, 11, -7),
            Block.box(7, 10, -9, 9, 11, -7),
            Block.box(-9, 10, -9, -7, 11, -7),
            Block.box(-9, 10, 7, -7, 11, 9),
            Block.box(-9, 10, 23, -7, 11, 25),
            Block.box(7, 12, 7, 9, 13, 9),
            Block.box(7, 12, 23, 9, 13, 25),
            Block.box(23, 12, 23, 25, 13, 25),
            Block.box(23, 12, 7, 25, 13, 9),
            Block.box(23, 12, -9, 25, 13, -7),
            Block.box(7, 12, -9, 9, 13, -7),
            Block.box(-9, 12, -9, -7, 13, -7),
            Block.box(-9, 12, 7, -7, 13, 9),
            Block.box(-9, 12, 23, -7, 13, 25),
            Block.box(7, 14, 7, 9, 15, 9),
            Block.box(7, 14, 23, 9, 15, 25),
            Block.box(23, 14, 23, 25, 15, 25),
            Block.box(23, 14, 7, 25, 15, 9),
            Block.box(23, 14, -9, 25, 15, -7),
            Block.box(7, 14, -9, 9, 15, -7),
            Block.box(-9, 14, -9, -7, 15, -7),
            Block.box(-9, 14, 7, -7, 15, 9),
            Block.box(-9, 14, 23, -7, 15, 25),
            Block.box(7, 16, 7, 9, 17, 9),
            Block.box(7, 18, 7, 9, 19, 9),
            Block.box(7, 20, 7, 9, 21, 9),
            Block.box(7, 22, 7, 9, 23, 9),
            Block.box(7, 24, 7, 9, 25, 9),
            Block.box(7, 26, 7, 9, 27, 9),
            Block.box(7, 28, 7, 9, 29, 9),
            Block.box(7, 30, 7, 9, 31, 9),
            Block.box(7, 16, 23, 9, 17, 25),
            Block.box(7, 18, 23, 9, 19, 25),
            Block.box(7, 20, 23, 9, 21, 25),
            Block.box(7, 22, 23, 9, 23, 25),
            Block.box(7, 24, 23, 9, 25, 25),
            Block.box(7, 26, 23, 9, 27, 25),
            Block.box(7, 28, 23, 9, 29, 25),
            Block.box(7, 30, 23, 9, 31, 25),
            Block.box(23, 16, 23, 25, 17, 25),
            Block.box(23, 18, 23, 25, 19, 25),
            Block.box(23, 20, 23, 25, 21, 25),
            Block.box(23, 22, 23, 25, 23, 25),
            Block.box(23, 24, 23, 25, 25, 25),
            Block.box(23, 26, 23, 25, 27, 25),
            Block.box(23, 28, 23, 25, 29, 25),
            Block.box(23, 30, 23, 25, 31, 25),
            Block.box(23, 16, 7, 25, 17, 9),
            Block.box(23, 18, 7, 25, 19, 9),
            Block.box(23, 20, 7, 25, 21, 9),
            Block.box(23, 22, 7, 25, 23, 9),
            Block.box(23, 24, 7, 25, 25, 9),
            Block.box(23, 26, 7, 25, 27, 9),
            Block.box(23, 28, 7, 25, 29, 9),
            Block.box(23, 30, 7, 25, 31, 9),
            Block.box(23, 16, -9, 25, 17, -7),
            Block.box(23, 18, -9, 25, 19, -7),
            Block.box(23, 20, -9, 25, 21, -7),
            Block.box(23, 22, -9, 25, 23, -7),
            Block.box(23, 24, -9, 25, 25, -7),
            Block.box(23, 26, -9, 25, 27, -7),
            Block.box(23, 28, -9, 25, 29, -7),
            Block.box(23, 30, -9, 25, 31, -7),
            Block.box(7, 16, -9, 9, 17, -7),
            Block.box(7, 18, -9, 9, 19, -7),
            Block.box(7, 20, -9, 9, 21, -7),
            Block.box(7, 22, -9, 9, 23, -7),
            Block.box(7, 24, -9, 9, 25, -7),
            Block.box(7, 26, -9, 9, 27, -7),
            Block.box(7, 28, -9, 9, 29, -7),
            Block.box(7, 30, -9, 9, 31, -7),
            Block.box(-9, 16, -9, -7, 17, -7),
            Block.box(-9, 18, -9, -7, 19, -7),
            Block.box(-9, 20, -9, -7, 21, -7),
            Block.box(-9, 22, -9, -7, 23, -7),
            Block.box(-9, 24, -9, -7, 25, -7),
            Block.box(-9, 26, -9, -7, 27, -7),
            Block.box(-9, 28, -9, -7, 29, -7),
            Block.box(-9, 30, -9, -7, 31, -7),
            Block.box(-9, 16, 7, -7, 17, 9),
            Block.box(-9, 18, 7, -7, 19, 9),
            Block.box(-9, 20, 7, -7, 21, 9),
            Block.box(-9, 22, 7, -7, 23, 9),
            Block.box(-9, 24, 7, -7, 25, 9),
            Block.box(-9, 26, 7, -7, 27, 9),
            Block.box(-9, 28, 7, -7, 29, 9),
            Block.box(-9, 30, 7, -7, 31, 9),
            Block.box(-9, 16, 23, -7, 17, 25),
            Block.box(-9, 18, 23, -7, 19, 25),
            Block.box(-9, 20, 23, -7, 21, 25),
            Block.box(-9, 22, 23, -7, 23, 25),
            Block.box(-9, 24, 23, -7, 25, 25),
            Block.box(-9, 26, 23, -7, 27, 25),
            Block.box(-9, 28, 23, -7, 29, 25),
            Block.box(-9, 30, 23, -7, 31, 25),
            Block.box(3, 0, 7, 7, 32, 9),
            Block.box(3, 0, 23, 7, 32, 25),
            Block.box(19, 0, 23, 23, 32, 25),
            Block.box(19, 0, 7, 23, 32, 9),
            Block.box(19, 0, -9, 23, 32, -7),
            Block.box(3, 0, -9, 7, 32, -7),
            Block.box(-13, 0, -9, -9, 32, -7),
            Block.box(-13, 0, 7, -9, 32, 9),
            Block.box(-13, 0, 23, -9, 32, 25)
    ).reduce((v1, v2) -> {
        return Shapes.join(v1, v2, BooleanOp.OR);
    }).get();

    public CoolingBlock(Properties properties) {
        super(properties);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return shape;
    }
}
