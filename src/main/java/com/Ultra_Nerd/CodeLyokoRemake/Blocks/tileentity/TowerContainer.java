package com.Ultra_Nerd.CodeLyokoRemake.Blocks.tileentity;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class TowerContainer extends Container
{
	private final Interface tileentity;
	
	
	
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return this.tileentity.isUsableByPlayer(playerIn);
	}
	public TowerContainer(InventoryPlayer player, Interface tileentity) 
	{
		this.tileentity = new Interface();
		
		
	}
	
}