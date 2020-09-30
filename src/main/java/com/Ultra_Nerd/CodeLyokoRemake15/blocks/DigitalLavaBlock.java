package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class DigitalLavaBlock extends FlowingFluidBlock {


    public DigitalLavaBlock(Supplier<? extends FlowingFluid> supplier) {
        super(supplier, Block.Properties.from(Blocks.LAVA));
    }

    @Override
    public void onEntityCollision(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        super.onEntityCollision(state, worldIn, pos, entityIn);
        entityIn.setFireTimer(100);
        entityIn.attackEntityFrom(new DamageSource(this.getTranslationKey()),Integer.MAX_VALUE);
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return 90;
    }


}
