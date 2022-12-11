package com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public abstract class DigitalLAVA extends LyokoFluid {
    @Override
    public Fluid getStill() {
        return ModFluids.STILL_DIGITAL_LAVA;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_DIGITAL_LAVA;
    }

    @Override
    public Item getBucketItem() {
        return null;
    }

    @Override
    protected BlockState toBlockState(final FluidState state) {
        return ModBlocks.DIGITAL_LAVA_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }


    public static class Flowing extends DigitalLAVA {
        @Override
        protected void appendProperties(final StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder.add(LEVEL));
        }

        @Override
        protected boolean isInfinite() {
            return true;
        }

        @Override
        public int getLevel(final FluidState state) {
            return state.get(LEVEL);
        }

        @Override
        public boolean isStill(final FluidState state) {
            return false;
        }
    }

    public static class Still extends DigitalLAVA {
        @Override
        protected boolean isInfinite() {
            return true;
        }

        @Override
        public int getLevel(final FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(final FluidState state) {
            return true;
        }
    }
}
