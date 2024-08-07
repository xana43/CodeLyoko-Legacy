package com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public abstract class EnergyStorageBlockEntityInventory extends SidedInventoryTickingBlockEntity {
    private static final String energyKey = "general_energy_storage";
    protected final SimpleEnergyStorage energyStorage;


    public EnergyStorageBlockEntityInventory(final BlockEntityType<?> type, final BlockPos pos, final BlockState state,
            final int inventorySize, final long capacity,final long maxInsert, final long maxExtract) {
        super(type, pos, state, inventorySize);
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
    public void readNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {

        super.readNbt(nbt,registryLookup);
        energyStorage.amount = nbt.getLong(energyKey);
    }

    @Override
    protected void writeNbt(final NbtCompound nbt,final RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt,registryLookup);
        nbt.putLong(energyKey, energyStorage.amount);
    }
}
