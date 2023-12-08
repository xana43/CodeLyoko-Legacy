package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.World;

public abstract class DigitalOcean extends LyokoFluid {
    @Override
    public Fluid getStill() {
        return ModFluids.STILL_DIGITAL_OCEAN;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_DIGITAL_OCEAN;
    }

    @Override
    public Item getBucketItem() {
        return null;
    }

    @Override
    protected BlockState toBlockState(final FluidState state) {
        return ModBlocks.DIGITAL_OCEAN_BLOCK.getDefaultState().with(Properties.LEVEL_15, Integer.valueOf(getBlockStateLevel(state)));
    }


    public static class Flowing extends DigitalOcean {
        @Override
        protected void appendProperties(final StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder.add(LEVEL));
        }

        @Override
        protected boolean isInfinite(final World world) {
            return true;
        }

        @Override
        public int getLevel(final FluidState state) {
            return state.<Integer>get(LEVEL);
        }

        @Override
        public boolean isStill(final FluidState state) {
            return false;
        }
    }

    public static class Still extends DigitalOcean {
        @Override
        protected boolean isInfinite(final World world) {
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
