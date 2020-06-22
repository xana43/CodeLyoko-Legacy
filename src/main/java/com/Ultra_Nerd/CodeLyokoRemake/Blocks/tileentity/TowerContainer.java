package com.Ultra_Nerd.CodeLyokoRemake.Blocks.tileentity;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

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