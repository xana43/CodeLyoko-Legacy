package com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public abstract class EnergyStorageBlockEntityInventory extends SidedInventoryTickingBlockEntity {
    private static final String energyKey = "general_energy_storage";
    protected final SimpleEnergyStorage energyStorage;


    public EnergyStorageBlockEntityInventory(final BlockEntityType<?> type, final BlockPos pos, final BlockState state,
            final int inventorySize, final long capacity, @Nullable Long maxInsert, @Nullable Long maxExtract) {
        super(type, pos, state, inventorySize);
        maxExtract = Optional.ofNullable(maxExtract).orElse(0L);
        maxInsert = Optional.ofNullable(maxInsert).orElse(0L);
        energyStorage = new SimpleEnergyStorage(capacity, maxInsert, maxExtract){
            @Override
            protected void onFinalCommit() {
                super.onFinalCommit();
                markDirty();
            }
        };
    }

    public final EnergyStorage getEnergyStorage() {
        return energyStorage;
    }

    @Override
    public void readNbt(final NbtCompound nbt) {

        super.readNbt(nbt);
        energyStorage.amount = nbt.getLong(energyKey);
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong(energyKey, energyStorage.amount);
    }
}
