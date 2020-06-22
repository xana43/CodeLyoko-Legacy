package com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.flouride.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotOut extends Slot {

	private final EntityPlayer player;
	private int rc;
	public SlotOut(EntityPlayer player, IInventory inventory, int index, int x, int y)
	{
		super(inventory, index, x, y);
		this.player = player;
	}
	
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
		// TODO Auto-generated method stub
		this.onCrafting(stack);
		super.onTake(thePlayer, stack);
		return stack;
	}
	
	@Override
	public ItemStack decrStackSize(int amount) {
		// TODO Auto-generated method stub
		if(this.getHasStack()) this.rc += Math.min(amount, this.getStack().getCount());
		return super.decrStackSize(amount);
	}
}
