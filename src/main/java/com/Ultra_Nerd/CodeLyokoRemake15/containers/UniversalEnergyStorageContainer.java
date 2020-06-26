package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import net.minecraft.block.ContainerBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class UniversalEnergyStorageContainer extends ContainerBlock {
	protected UniversalEnergyStorageContainer(Properties builder) {
		super(builder);
	}

	@Nullable
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return null;
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
