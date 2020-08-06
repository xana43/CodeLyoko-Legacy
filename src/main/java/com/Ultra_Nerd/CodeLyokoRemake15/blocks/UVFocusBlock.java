package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

public class UVFocusBlock extends Block {
    public UVFocusBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isTransparent(@Nonnull BlockState state) {
        return true;
    }

    @Override
    public boolean isNormalCube(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return false;
    }
}
