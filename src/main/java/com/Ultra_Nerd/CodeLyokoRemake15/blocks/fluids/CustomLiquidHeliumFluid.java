package com.Ultra_Nerd.CodeLyokoRemake15.blocks.fluids;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.IFluidState;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nonnull;

public class CustomLiquidHeliumFluid extends ForgeFlowingFluid {


    public CustomLiquidHeliumFluid(Properties properties) {
        super(properties);


    }

    @Override
    public boolean isSource(@Nonnull IFluidState state) {
        return true;
    }

    @Override
    protected void flowInto(@Nonnull IWorld worldIn, @Nonnull BlockPos pos, @Nonnull BlockState blockStateIn, @Nonnull Direction direction, @Nonnull IFluidState fluidStateIn) {
        if (direction == Direction.DOWN) {
            IFluidState ifluidstate = worldIn.getFluidState(pos);
            if (this.isIn(FluidTags.WATER) && ifluidstate.isTagged(FluidTags.WATER)) {
                if (blockStateIn.getBlock() instanceof FlowingFluidBlock) {
                    worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, Blocks.BLUE_ICE.getDefaultState()), 3);
                }


                return;
            }
            if (this.isIn(FluidTags.WATER) && ifluidstate.isTagged(FluidTags.LAVA)) {
                if (blockStateIn.getBlock() instanceof FlowingFluidBlock) {
                    worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, Blocks.DIAMOND_BLOCK.getDefaultState()), 3);
                }


                return;
            }
        }
        super.flowInto(worldIn, pos, blockStateIn, direction, fluidStateIn);
    }


    @Override
    protected boolean canSourcesMultiply() {
        return false;
    }

    @Override
    public int getLevel(@Nonnull IFluidState p_207192_1_) {
        return 8;
    }


}
