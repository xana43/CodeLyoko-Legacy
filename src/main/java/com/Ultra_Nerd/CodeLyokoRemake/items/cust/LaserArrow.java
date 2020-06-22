package com.Ultra_Nerd.CodeLyokoRemake.items.cust;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;

public class LaserArrow extends ItemArrow{

	public LaserArrow(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		ModItems.Items.add(this);
	}
	
	@Override
	public boolean isInfinite(ItemStack stack, ItemStack bow, EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
	}
}
