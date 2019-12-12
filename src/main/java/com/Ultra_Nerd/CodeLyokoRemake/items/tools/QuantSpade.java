package com.Ultra_Nerd.CodeLyokoRemake.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;


public class QuantSpade extends ItemSpade {
	
	public QuantSpade(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.Items.add(this);
	}
	

}



