package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFluids;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public abstract class LiquidHeliumFluid extends LyokoFluid {
    @Override
    public Fluid getStill() {
        return ModFluids.STILL_LIQUID_HELIUM;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_LIQUID_HELIUM;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.LIQUID_HELIUM_BUCKET;

    }

    @Override
    protected BlockState toBlockState(final FluidState state) {
        return ModBlocks.LIQUID_HELIUM_BLOCK.getDefaultState().with(Properties.LEVEL_15, Integer.valueOf(getBlockStateLevel(state)));
    }


    public static class Flowing extends LiquidHeliumFluid {
        @Override
        protected void appendProperties(final StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder.add(LEVEL));
        }

        @Override
        protected boolean isInfinite(final World world) {
            return false;
        }

        @Override
        protected int getMaxFlowDistance(WorldView world) {
            return 0;
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

    public static class Still extends LiquidHeliumFluid {
        @Override
        protected boolean isInfinite(final World world) {
            return true;
        }

        @Override
        protected int getMaxFlowDistance(WorldView world) {
            return 0;
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
