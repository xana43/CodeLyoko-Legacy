package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFluids;
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

public abstract class UraniumWasteFluid extends LyokoFluid {
    @Override
    public Fluid getStill() {
        return ModFluids.STILL_URANIUM;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_URANIUM;
    }

    @Override
    public Item getBucketItem() {
        return null;
    }

    @Override
    protected void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        super.randomDisplayTick(world, pos, state, random);
        if(random.nextInt(100) == 0)
        {
            double d = (double)pos.getX() + random.nextDouble();
            double e = (double)pos.getY() + 1.0;
            double f = (double)pos.getZ() + random.nextDouble();
            world.addParticle(ParticleTypes.SOUL, d, e, f, 0.0, 0.0, 0.0);
            world.playSound(d, e, f, SoundEvents.PARTICLE_SOUL_ESCAPE.value(), SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            d = (double)pos.getX() + random.nextDouble();
            e = (double)pos.getY() + 1.0;
            f = (double)pos.getZ() + random.nextDouble();
            world.addParticle(ParticleTypes.LAVA, d, e, f, 0.0, 0.0, 0.0);
            world.playSound(d, e, f, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            d = (double)pos.getX() + random.nextDouble();
            e = (double)pos.getY() + 1.0;
            f = (double)pos.getZ() + random.nextDouble();
            world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, d, e, f, 0.0, 0.0, 0.0);
            world.playSound(d, e, f, SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS.value(), SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
        }
    }

    @Override
    protected BlockState toBlockState(final FluidState state) {
        return ModBlocks.URANIUM_WASTE_BLOCK.getDefaultState().with(Properties.LEVEL_15, Integer.valueOf(getBlockStateLevel(state)));
    }


    public static class Flowing extends UraniumWasteFluid {
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

    public static class Still extends UraniumWasteFluid {
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
