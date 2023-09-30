package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public abstract class EnergyStorageBlockEntity extends SyncedBlockEntity implements TickingBlockEntity{
    protected static final String ENERGY_AMOUNT_KEY = "nbt_energyAmount";
    protected final SimpleEnergyStorage energyStorage;

    public EnergyStorageBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state,
            final long capacity,final long maxinsert, final long maxextract) {
        super(type, pos, state);

        energyStorage = new SimpleEnergyStorage(capacity,maxinsert,maxextract);


    }


    public final SimpleEnergyStorage getEnergyStorage() {
        return energyStorage;
    }

    public final long getCapacity() {
        return energyStorage.capacity;
    }

    public final long getStoredEnergy() {
        return energyStorage.amount;
    }

    public void setEnergyAmount(final long newAmount) {
        energyStorage.amount = newAmount;
        markDirty();
    }
    public void useEnergy(final long usageAmount)
    {
        if(energyStorage.amount > usageAmount) {
            energyStorage.amount -= usageAmount;
            markDirty();
        }
    }
    public void incrementEnergyAmount(final long increment) {
        if(energyStorage.amount < energyStorage.capacity) {
            energyStorage.amount += increment;
            markDirty();
        }
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        if(energyStorage != null) {
            nbt.putLong(ENERGY_AMOUNT_KEY, energyStorage.amount);
        }
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        if(energyStorage != null) {
            energyStorage.amount = nbt.getLong(ENERGY_AMOUNT_KEY);
        }
    }
}
