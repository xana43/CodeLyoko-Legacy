package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride.slots;

import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class SlotFuel extends Slot {

	public SlotFuel(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		
	}
	/*
	@Override
	public boolean isItemValid(ItemStack stack) {
		// TODO Auto-generated method stub
		return InfusingChamberTileEntity.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		// TODO Auto-generated method stub
		return super.getItemStackLimit(stack);
	}

	 */

}