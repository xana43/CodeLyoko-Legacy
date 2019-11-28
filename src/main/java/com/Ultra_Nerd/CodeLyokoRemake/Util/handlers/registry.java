package com.Ultra_Nerd.CodeLyokoRemake.Util.handlers;


import com.Ultra_Nerd.CodeLyokoRemake.Util.IHasModel;
import com.Ultra_Nerd.CodeLyokoRemake.commands.ComTel;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		
		
		
		for(Block block : Modblocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
}


