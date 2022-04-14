package com.Ultra_Nerd.CodeLyokoRemake15.FE;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.energy.EnergyStorage;

public class EG extends EnergyStorage {

    private final BlockEntity BE;
    public EG(BlockEntity be,int capacity) {
        super(capacity);
        this.BE = be;
    }

    public EG(BlockEntity be,int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
        this.BE = be;
    }

    public EG(BlockEntity be,int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
        this.BE = be;
    }

    public EG(BlockEntity be,int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
        this.BE = be;
    }

    public void setThisEnergy(int energy)
    {
        this.energy = Math.max(0,Math.min(energy,this.capacity));
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        this.BE.setChanged();
        return super.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        this.BE.setChanged();
        return super.receiveEnergy(maxReceive, simulate);
    }
}
