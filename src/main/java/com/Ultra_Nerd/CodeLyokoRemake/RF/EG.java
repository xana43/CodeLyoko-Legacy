package com.Ultra_Nerd.CodeLyokoRemake.RF;

import javax.swing.border.CompoundBorder;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.energy.EnergyStorage;

public class EG extends EnergyStorage{

	
	public EG(int capacity)
    {
        super(capacity, capacity, capacity, 0);
    }

    public EG(int capacity, int maxTransfer)
    {
        super(capacity, maxTransfer, maxTransfer, 0);
    }

    public EG(int capacity, int maxReceive, int maxExtract)
    {
        super(capacity, maxReceive, maxExtract, 0);
    }

    public EG(int capacity, int maxReceive, int maxExtract, int energy)
    {
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
    public void RFNBT(NBTTagCompound compunt)
    {
    	this.energy = compunt.getInteger("Energy");
    	this.capacity = compunt.getInteger("Capacity");
    	this.maxExtract = compunt.getInteger("MaxExtract");
    	this.maxReceive = compunt.getInteger("MaxRecive");
    }
    public void WRTNBT(NBTTagCompound comd)
    {
    	comd.setInteger("Energy", this.energy);
    	comd.setInteger("Capacity", this.capacity);
    	comd.setInteger("MaxRecieve", this.maxReceive);
    	comd.setInteger("MaxExtract", this.maxExtract);
    }
}
