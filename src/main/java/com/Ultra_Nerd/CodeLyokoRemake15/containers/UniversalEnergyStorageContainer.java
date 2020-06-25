package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.UniversalEnergyStorageTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;

public class UniversalEnergyStorageContainer extends Container {

	private final UniversalEnergyStorageTileEntity TE;
	private int ener;
	public UniversalEnergyStorageContainer(InventoryPlayer player, UniversalEnergyStorageTileEntity store)
	{
		this.TE = store;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return this.TE.useable(playerIn);
	}
	
	
	@Override
	public void detectAndSendChanges() {
		// TODO Auto-generated method stub
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.listeners.size(); i++)
		{
			IContainerListener listener = (IContainerListener)this.listeners.get(i);
			if(this.ener != this.TE.getall(0)) listener.sendWindowProperty(this, 0, this.TE.getall(0));
		}
		
		this.ener = this.TE.getall(0);
	}

}
