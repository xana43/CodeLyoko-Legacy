package com.Ultra_Nerd.CodeLyokoRemake15.containers;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class UniversalEnergyStorageContainer extends AbstractContainerMenu implements Container {
    protected UniversalEnergyStorageContainer(@Nullable MenuType<?> type, int id) {
        super(type, id);
    }

    @Override
    public int getContainerSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public @org.jetbrains.annotations.Nullable ItemStack getItem(int p_18941_) {
        return null;
    }

    @Override
    public @NotNull ItemStack removeItem(int p_18942_, int p_18943_) {
        return null;
    }

    @Override
    public @org.jetbrains.annotations.Nullable ItemStack removeItemNoUpdate(int p_18951_) {
        return null;
    }

    @Override
    public void setItem(int p_18944_, ItemStack p_18945_) {

    }

    @Override
    public void setChanged() {

    }

    @Override
    public boolean stillValid(@Nonnull Player playerIn) {
        return false;
    }

    @Override
    public void clearContent() {

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
