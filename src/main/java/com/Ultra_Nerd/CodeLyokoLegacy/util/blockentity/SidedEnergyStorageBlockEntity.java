package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public abstract class SidedEnergyStorageBlockEntity extends EnergyStorageBlockEntity {
    public SidedEnergyStorageBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state,
            final long capacity,final long maxinsert,final long maxextract) {
        super(type, pos, state, capacity,maxinsert,maxextract);
    }
}
