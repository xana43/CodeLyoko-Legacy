package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class DigitalLavaBlock extends LiquidBlock {


    public DigitalLavaBlock(Supplier<? extends FlowingFluid> supplier) {
        super(supplier, BlockBehaviour.Properties.copy(Blocks.LAVA));
    }




    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        super.entityInside(state, worldIn, pos, entityIn);
        entityIn.setRemainingFireTicks(100);
        entityIn.hurt(new DamageSource(this.getRegistryName().toString()),Integer.MAX_VALUE);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        return 90;
    }


}
