package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public abstract class EnergyStorageBlockEntity extends SidedTickingBlockEntity {
    protected final SimpleEnergyStorage energyStorage;

    public EnergyStorageBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state,
            final int inventorySize, final long capacity, @Nullable Long maxInsert, @Nullable Long maxExtract) {
        super(type, pos, state, inventorySize);
        maxExtract = Optional.ofNullable(maxExtract).orElse(0L);
        maxInsert = Optional.ofNullable(maxInsert).orElse(0L);
        energyStorage = new SimpleEnergyStorage(capacity,maxInsert,maxExtract);
    }


    public EnergyStorage getEnergyStorage() {
        return energyStorage;
    }






}
