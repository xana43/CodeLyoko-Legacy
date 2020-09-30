package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class UniversalEnergyStorageContainer extends Container {
    protected UniversalEnergyStorageContainer(@Nullable ContainerType<?> type, int id) {
        super(type, id);
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return false;
    }

   /*
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
*/
}
