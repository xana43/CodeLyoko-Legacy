package com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class LyokoFluid extends FlowableFluid
{
    @Override
    public boolean matchesType(final Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    protected void beforeBreakingBlock(final WorldAccess world, final BlockPos pos, final BlockState state) {

    }

    @Override
    protected boolean canBeReplacedWith(final FluidState state, final BlockView world, final BlockPos pos, final Fluid fluid, final Direction direction) {
        return false;
    }

    @Override
    protected int getFlowSpeed(final WorldView world) {
        return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(final WorldView world) {
        return 1;
    }

    @Override
    public int getTickRate(final WorldView world) {
        return 5;
    }

    @Override
    protected float getBlastResistance() {
        return 100;
    }
}