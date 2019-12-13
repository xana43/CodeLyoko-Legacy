package com.Ultra_Nerd.CodeLyokoRemake.items.cust;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LaserArrow extends Item{

	public LaserArrow(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		ModItems.Items.add(this);
	}
	
}
