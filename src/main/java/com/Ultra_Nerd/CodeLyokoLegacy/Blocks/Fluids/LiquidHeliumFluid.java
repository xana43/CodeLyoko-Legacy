package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFluids;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
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
    protected void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        super.randomDisplayTick(world, pos, state, random);
        if (!state.isStill() && !(Boolean)state.get(FALLING)) {
            if (random.nextInt(64) == 0) {
                world.playSound((double)pos.getX() + (double)0.5F, (double)pos.getY() + (double)0.5F, (double)pos.getZ() + (double)0.5F, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
            }
            if(random.nextInt(1000) == 0)
            {
                world.playSound((double)pos.getX() + (double)0.5F, (double)pos.getY() + (double)0.5F, (double)pos.getZ() + (double)0.5F, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, 1.9F + random.nextFloat() * 0.7F, false);
            }
            if(random.nextInt(100) == 0)
            {
                double x = (double)pos.getX() + random.nextDouble();
                double y = (double)pos.getY() + 1.0;
                double z = (double)pos.getZ() + random.nextDouble();
                world.addParticle(ParticleTypes.SNOWFLAKE, x, y, z, 0.0D, 0.0D, 0.0D);
            }
        } else if (random.nextInt(10) == 0) {
            world.addParticle(ParticleTypes.UNDERWATER, (double)pos.getX() + random.nextDouble(), (double)pos.getY() + random.nextDouble(), (double)pos.getZ() + random.nextDouble(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected BlockState toBlockState(final FluidState state) {
        return ModBlocks.LIQUID_HELIUM_BLOCK.getDefaultState().with(Properties.LEVEL_15, Integer.valueOf(getBlockStateLevel(state)));
    }


    public static final class Flowing extends LiquidHeliumFluid {
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

    public static final class Still extends LiquidHeliumFluid {
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
