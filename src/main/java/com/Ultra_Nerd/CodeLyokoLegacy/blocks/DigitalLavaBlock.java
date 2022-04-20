package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

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
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Supplier;

public final class DigitalLavaBlock extends LiquidBlock {


    public DigitalLavaBlock(@NotNull Supplier<? extends FlowingFluid> supplier) {
        super(supplier, BlockBehaviour.Properties.copy(Blocks.LAVA).friction(0));
    }




    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        super.entityInside(state, worldIn, pos, entityIn);
        entityIn.setRemainingFireTicks(100);
        entityIn.hurt(new DamageSource(Objects.requireNonNull(this.getRegistryName()).toString()).bypassArmor().setIsFire(),Float.MAX_VALUE);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        return Blocks.LAVA.getLightEmission(state,world,pos);
    }


}
