package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;

public final class LiquidHelium extends FluidBlock {
    public LiquidHelium(final FlowableFluid fluid, final Settings settings) {
        super(fluid, settings);
    }

  /*

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        if (entityIn instanceof final LivingEntity livingEntity) {
            livingEntity.hurt(DamageSource.FREEZE, RANDOM.nextInt(3));
            livingEntity.moveDist = 0;
            livingEntity.isInPowderSnow = true;

        }
    }



    @Override
    public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter level, BlockPos pos, FluidState fluidState) {
        return true;
    }



    @Override
    public void onPlace(@Nonnull BlockState state, @NotNull Level worldIn, @NotNull BlockPos pos, @Nonnull BlockState oldState, boolean isMoving) {
        //water
        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) == Blocks.WATER.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())) == Blocks.WATER.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getFluidState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) == Fluids.FLOWING_WATER.defaultFluidState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) == Blocks.LAVA.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.DIAMOND_BLOCK.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())) == Blocks.LAVA.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.DIAMOND_BLOCK.defaultBlockState());
        }
        if (worldIn.getFluidState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) == Fluids.FLOWING_LAVA.defaultFluidState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.OBSIDIAN.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)) == Blocks.WATER.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1)) == Blocks.WATER.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)) == Blocks.WATER.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())) == Blocks.WATER.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())) == Blocks.WATER.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)) == Blocks.WATER.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)) == Blocks.LAVA.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1)) == Blocks.LAVA.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)) == Blocks.LAVA.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())) == Blocks.LAVA.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())) == Blocks.LAVA.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)) == Blocks.LAVA.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getFluidState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)) == Fluids.FLOWING_WATER.defaultFluidState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getFluidState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1)) == Fluids.FLOWING_WATER.defaultFluidState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getFluidState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)) == Fluids.FLOWING_WATER.defaultFluidState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getFluidState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())) == Fluids.FLOWING_WATER.defaultFluidState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getFluidState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())) == Fluids.FLOWING_WATER.defaultFluidState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.BLUE_ICE.defaultBlockState());
        }
        if (worldIn.getFluidState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)) == Fluids.FLOWING_WATER.defaultFluidState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.BLUE_ICE.defaultBlockState());
        }
        //snow
        if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1)) == Blocks.AIR.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1), Blocks.SNOW.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1)) == Blocks.AIR.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1), Blocks.SNOW.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)) == Blocks.AIR.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.SNOW.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())) == Blocks.AIR.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.SNOW.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())) == Blocks.AIR.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.SNOW.defaultBlockState());
        }
        if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)) == Blocks.AIR.defaultBlockState()) {
            worldIn.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.SNOW.defaultBlockState());
        }

        super.onPlace(state, worldIn, pos, oldState, isMoving);
    }

   */
}
