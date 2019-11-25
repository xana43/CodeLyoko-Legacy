package com.Ultra_Nerd.CodeLyokoRemake.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class Client extends Common{
	
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(),id));
	}
	
	
}
