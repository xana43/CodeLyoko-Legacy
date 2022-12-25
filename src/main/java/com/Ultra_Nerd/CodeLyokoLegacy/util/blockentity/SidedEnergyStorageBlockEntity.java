package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public abstract class SidedEnergyStorageBlockEntity extends EnergyStorageBlockEntity {
    public SidedEnergyStorageBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state, @Nullable final SimpleEnergyStorage storage) {
        super(type, pos, state, storage);
    }
}
