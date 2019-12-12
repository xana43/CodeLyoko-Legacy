package com.Ultra_Nerd.CodeLyokoRemake.items;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class ItemBase extends Item 
{

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.Items.add(this);
	}
	
	
	 

}
