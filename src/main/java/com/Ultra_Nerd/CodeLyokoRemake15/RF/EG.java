package com.Ultra_Nerd.CodeLyokoRemake15.RF;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.energy.EnergyStorage;

public class EG extends EnergyStorage {


    public EG(int capacity) {
        super(capacity, capacity, capacity, 0);
    }

    public EG(int capacity, int maxTransfer) {
        super(capacity, maxTransfer, maxTransfer, 0);
    }

    public EG(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract, 0);
    }

    public EG(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        // TODO Auto-generated method stub
        return super.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        // TODO Auto-generated method stub
        return super.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored() {
        // TODO Auto-generated method stub
        return super.getEnergyStored();
    }

    @Override
    public boolean canExtract() {
        // TODO Auto-generated method stub
        return super.canExtract();
    }

    @Override
    public boolean canReceive() {
        // TODO Auto-generated method stub
        return super.canReceive();
    }

    public void RFNBT(CompoundTag compunt) {
        this.energy = compunt.getInt("Energy");
        this.capacity = compunt.getInt("Capacity");
        this.maxExtract = compunt.getInt("MaxExtract");
        this.maxReceive = compunt.getInt("MaxRecive");
    }

    public void WRTNBT(CompoundTag comd) {
        comd.putInt("Energy", this.energy);
        comd.putInt("Capacity", this.capacity);
        comd.putInt("MaxRecieve", this.maxReceive);
        comd.putInt("MaxExtract", this.maxExtract);
    }
}
