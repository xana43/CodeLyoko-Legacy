package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public final class ComputerCoreTileEntity extends InventoryBE {
    public ComputerCoreTileEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state) {
        super(type, pos, state);
    }

    //public ComputerCoreTileEntity(BlockEntityType<?> tileEntityTypeIn) {
   //     super(tileEntityTypeIn);
    //}
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
