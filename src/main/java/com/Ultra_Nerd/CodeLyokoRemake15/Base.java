package com.Ultra_Nerd.CodeLyokoRemake15;
 
import com.Ultra_Nerd.CodeLyokoRemake15.init.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend.RendBlok;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers.registry;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("cm")
@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Bus.MOD)
public class Base
{
	private static final Logger Log = LogManager.getLogger();
	
	public static final String MOD_ID = "cm";
	public static Base instance;
	public Base()
	{
		final IEventBus ModBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModBus.addListener(this::setup);
		ModBus.addListener(this::dostuff);
		registry.init();
		ModSounds.SOUNDS.register(ModBus);
		ModItems.ITEMS.register(ModBus);
		ModFluids.LIQUIDS.register(ModBus);
		ModBlocks.BLOCKS.register(ModBus);
		ModEntities.Entities.register(ModBus);
		ModBiome.BIOMES.register(ModBus);
		ModContainerTypes.CONTAINER_TYPES.register(ModBus);
		ModTileEntities.TILE_ENTITY_TYPES.register(ModBus);
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		
	}
	
	private void dostuff(final FMLClientSetupEvent event)
	{
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.BLOK.get(), RendBlok::new);
	}
	
	@SubscribeEvent
	private void OnItemInit(final RegistryEvent.Register<Item> Items)
	{
		final IForgeRegistry<Item> registry = Items.getRegistry();
		
		ModBlocks.BLOCKS.getEntries().stream().filter(block -> !(block.get() instanceof FlowingFluidBlock))
		.map(RegistryObject::get).forEach(block->
		{
			final Item.Properties itemsettings = new Item.Properties().group(Lyoko);
			final BlockItem Itemblocks = new BlockItem(block,itemsettings);
			Itemblocks.setRegistryName(block.getRegistryName());
			registry.register(Itemblocks);
		});
		Log.debug("Inventory blocks registered");
	}
	
	@SubscribeEvent
	public static void onRegisterBiome(final RegistryEvent.Register<Biome> event)
	{
		ModBiome.regbio();
	}
	
	public static final ItemGroup Lyoko = new ItemGroup("Lyoko") {
		
		@Override
		public ItemStack createIcon() {
			// TODO Auto-generated method stub
			return new ItemStack(registry.BIT.get());
		}
	};
	
}