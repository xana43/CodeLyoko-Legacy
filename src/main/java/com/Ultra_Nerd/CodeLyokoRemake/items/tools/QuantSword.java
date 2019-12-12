package com.Ultra_Nerd.CodeLyokoRemake.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class QuantSword extends ItemSword {
	
	public QuantSword(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		
		ModItems.Items.add(this);
	}
	

}



