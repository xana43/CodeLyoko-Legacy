package com.Ultra_Nerd.CodeLyokoRemake.Blocks.tileentity;

import com.Ultra_Nerd.CodeLyokoRemake.RF.EG;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

public class ComputerCoreTileEntity extends TileEntity implements ITickable 
{
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

}
