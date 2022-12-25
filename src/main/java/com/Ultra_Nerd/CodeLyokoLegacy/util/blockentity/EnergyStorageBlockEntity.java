package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public abstract class EnergyStorageBlockEntity extends TickingBlockEntity {
    protected static final String ENERGY_AMOUNT_KEY = "nbt_energyAmount";
    private SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(0, 0, 0);

    public EnergyStorageBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state,
            @Nullable SimpleEnergyStorage storage) {
        super(type, pos, state);
        if (storage != null) {
            energyStorage = storage;
        }

    }

    public SimpleEnergyStorage getEnergyStorage() {
        return energyStorage;
    }

    public long getCapacity() {
        return energyStorage.capacity;
    }

    public long getStoredEnergy() {
        return energyStorage.amount;
    }

    public void setEnergyAmount(final long newAmount) {
        energyStorage.amount = newAmount;
        markDirty();
    }

    public void incrementEnergyAmount(final long increment) {
        energyStorage.amount += increment;
        markDirty();
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong(ENERGY_AMOUNT_KEY, energyStorage.amount);
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        energyStorage.amount = nbt.getLong(ENERGY_AMOUNT_KEY);
    }
}
