package com.Ultra_Nerd.CodeLyokoRemake15.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ComputerCoreTileEntity extends TileEntity
{
	public ComputerCoreTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	/*
	private EG storage = new EG(1000000000, 1000000000);
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityEnergy.ENERGY) return(T)this.storage;
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability == CapabilityEnergy.ENERGY) return true;
		return super.hasCapability(capability, facing);
	}
	
	
	@Override
	public void update()
	{
		
		this.storage.receiveEnergy(1000000000, false);
		this.storage.extractEnergy(2000000000, false);
		
	}
*/
}
