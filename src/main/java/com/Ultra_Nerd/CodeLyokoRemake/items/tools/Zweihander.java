package com.Ultra_Nerd.CodeLyokoRemake.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake.Base;
import com.Ultra_Nerd.CodeLyokoRemake.Util.IHasModel;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class Zweihander extends ItemSword implements IHasModel{
	
	public Zweihander(String name, ToolMaterial material)
	{
		super(material);
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



