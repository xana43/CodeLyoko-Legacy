package com.Ultra_Nerd.CodeLyokoRemake15.Util.MultiBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public interface PremiereBlockLogic {
    private @NotNull BlockEntity self()
    {
        return (BlockEntity) this;
    }
    default @NotNull BlockState getPremiereBlock()
    {
        return self().getBlockState();
    }

    default @NotNull BlockPos getPremierePosition()
    {
        return self().getBlockPos();
    }

    void updateOnChange(PartLogic partLogic,BlockPos pos,BlockState state);
}
