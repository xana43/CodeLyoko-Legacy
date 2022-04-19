package com.Ultra_Nerd.CodeLyokoLegacy.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public final class ComputerCoreTileEntity extends InventoryBE {
    public ComputerCoreTileEntity(@NotNull BlockEntityType<?> type, @NotNull BlockPos pos, @NotNull BlockState state, int size) {
        super(type, pos, state, size);
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
