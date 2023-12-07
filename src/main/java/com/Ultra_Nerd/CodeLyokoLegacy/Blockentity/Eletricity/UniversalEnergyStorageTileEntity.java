package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Eletricity;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.base.SimpleEnergyStorage;
import team.reborn.energy.api.base.SimpleSidedEnergyContainer;


public final class UniversalEnergyStorageTileEntity extends BlockEntity {

    private static final String NBT_KEY = "universal_energy_key";
    private final SimpleEnergyStorage energyStorageImplementation = new SimpleEnergyStorage(900, 10, 10);
    private final SimpleSidedEnergyContainer sidedEnergyContainer = new SimpleSidedEnergyContainer() {
        @Override
        public long getCapacity() {
            return energyStorageImplementation.capacity;
        }

        @Override
        public long getMaxInsert(@Nullable final Direction side) {
            assert side != null;
            return switch (side) {
                case DOWN, UP, NORTH, SOUTH, WEST, EAST -> energyStorageImplementation.maxInsert;
            };
        }

        @Override
        public long getMaxExtract(@Nullable final Direction side) {
            assert side != null;
            return switch (side) {
                case DOWN, UP, NORTH, SOUTH, WEST, EAST -> energyStorageImplementation.maxExtract;
            };
        }

        @Override
        protected void onFinalCommit() {
            super.onFinalCommit();
            markDirty();
        }

        @Override
        public EnergyStorage getSideStorage(@Nullable final Direction side) {
            assert side != null;
            return switch (side) {
                case DOWN, NORTH, SOUTH, WEST, EAST, UP -> energyStorageImplementation;
            };
        }
    };

    public UniversalEnergyStorageTileEntity(final BlockPos pos, final BlockState state) {
        super(ModBlockEntities.UNIVERSAL_ENERGY_STORAGE, pos, state);
    }

    public EnergyStorage getEnergyImplementation() {
        return energyStorageImplementation;
    }

    public void setEnergyAmount(final long amount) {
        energyStorageImplementation.amount = amount;
    }

    public EnergyStorage getSideImplementation(final Direction side) {
        return sidedEnergyContainer.getSideStorage(side);
    }

    public long getMaxSidedExtract(final Direction side) {
        return sidedEnergyContainer.getMaxExtract(side);
    }

    public long getMaxSidedInsert(final Direction side) {
        return sidedEnergyContainer.getMaxInsert(side);
    }

    public long getCapacity() {
        return energyStorageImplementation.capacity;
    }

    public long getCurrentAmount() {
        return energyStorageImplementation.amount;
    }

    @Override
    public void readNbt(final NbtCompound nbt) {
        super.readNbt(nbt);
        energyStorageImplementation.amount = nbt.getLong(NBT_KEY);
    }

    @Override
    protected void writeNbt(final NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putLong(NBT_KEY, energyStorageImplementation.amount);
    }
}
