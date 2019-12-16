package com.Ultra_Nerd.CodeLyokoRemake.Util.handlers;


import com.Ultra_Nerd.CodeLyokoRemake.Base;
import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;
import com.Ultra_Nerd.CodeLyokoRemake.commands.ComTel;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class registry 
{
	public static void serverRegistries(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new ComTel());
	
	}
	
	
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.Items.toArray(new Item[0]));
		
		
	}
	 
	
	
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(Modblocks.BLOCKS.toArray(new Block[0]));
		
	
	}
	
	


	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		
		EntRend.registerEntityRenderers();
		
		for(Item item : ModItems.Items)
		{
			Base.proxy.registerItemRenderer(item,0,"inventory");
		}
		
		
		
		
		for(Block block : Modblocks.BLOCKS)
		{
			Base.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0 , "inventory");
		}
	}
}


