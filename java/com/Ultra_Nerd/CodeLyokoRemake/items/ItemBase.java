package com.Ultra_Nerd.CodeLyokoRemake.items;

import com.Ultra_Nerd.CodeLyokoRemake.Base;
import com.Ultra_Nerd.CodeLyokoRemake.Util.IHasModel;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class ItemBase extends Item implements IHasModel
{

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.Items.add(this);
	}
	@Override
	public void registerModels() {
		
		Base.proxy.registerItemRenderer(this,0,"inventory");
		
	}
	
	 

}
