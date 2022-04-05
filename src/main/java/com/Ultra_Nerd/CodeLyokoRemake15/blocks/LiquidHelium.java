package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class LiquidHelium extends LiquidBlock {

    public LiquidHelium(Supplier<? extends FlowingFluid> supplier) {
        super(supplier, BlockBehaviour.Properties.copy(Blocks.WATER)


        );

    }


    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        if (entityIn instanceof LivingEntity livingEntity) {
            livingEntity.hurt(new DamageSource(this.getName().toString()), RANDOM.nextInt(2));
            livingEntity.moveDist = 0;
            livingEntity.isInPowderSnow = true;

        }
    }



    @Override
    public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter level, BlockPos pos, FluidState fluidState) {
        return true;
    }



    @Override
    public void onPlace(@Nonnull BlockState state, Level worldIn, BlockPos pos, @Nonnull BlockState oldState, boolean isMoving) {
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
}
