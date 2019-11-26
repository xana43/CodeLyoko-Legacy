package com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.flouride.slots;

import com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.flouride.TileEntityInfusingChamber;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class slotfuel extends Slot{

	public slotfuel(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		// TODO Auto-generated method stub
		return TileEntityInfusingChamber.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		// TODO Auto-generated method stub
		return super.getItemStackLimit(stack);
	}

}
