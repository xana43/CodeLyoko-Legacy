package com.Ultra_Nerd.CodeLyokoRemake15;


import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelSkid;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.LiquidHelium;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.LyokoCore;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.SeaPylon;
import com.Ultra_Nerd.CodeLyokoRemake15.init.*;
import com.Ultra_Nerd.CodeLyokoRemake15.items.BlokItem;
import com.Ultra_Nerd.CodeLyokoRemake15.world.WorldGen.ModOreGen;
import com.Ultra_Nerd.CodeLyokoRemake15.world.WorldGen.StructGen;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod("cm")
@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Bus.MOD)
public class Base
{

	public static final Logger Log = LogManager.getLogger();
	public static boolean XANA = false;
	public static final String MOD_ID = "cm";
	public static Base instance;
	public static int random = 1000;
	public Base()
	{

		final IEventBus ModBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModBus.addListener(this::setup);
		ModBus.addListener(this::dostuff);
		ModParticles.PARTICLES.register(ModBus);
		ModSounds.SOUNDS.register(ModBus);
		ModItems.ITEMS.register(ModBus);
		ModFluids.LIQUIDS.register(ModBus);
		ModBlocks.BLOCKS.register(ModBus);
		ModEntities.Entities.register(ModBus);
		ModRecipes.RECIPE_SERIALIZER_DEFERRED_REGISTER.register(ModBus);
		ModBiome.BIOMES.register(ModBus);
		ModContainerTypes.CONTAINER_TYPES.register(ModBus);
		ModTileEntities.TILE_ENTITY_TYPES.register(ModBus);
		ModDimensions.MOD_DIMENSION_DEFERRED_REGISTER.register(ModBus);
		ModWorldFeatures.FEATURES.register(ModBus);
		ModBus.addListener(this::onbake);
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	@SubscribeEvent
	public void onRegisterEnties(final RegistryEvent.Register<EntityType<?>> event){
		BlokItem.initEgg();
	}

	@SubscribeEvent
	public void tickPast(final TickEvent event)
	{

		if((event.phase == TickEvent.Phase.START || event.phase == TickEvent.Phase.END) && Minecraft.getInstance().world != null)
		{
			random--;

			//Base.Log.debug(random);
			if(random == 0 && !XANA)
			{
				random = new Random().nextInt(1000);
				assert Minecraft.getInstance().player != null;
				Minecraft.getInstance().player.sendMessage(new StringTextComponent("xana is attacking"));
				XANA = true;
			}


		}
	}
	private void setup(final FMLCommonSetupEvent event)
	{
		DeferredWorkQueue.runLater(ModOreGen::genOre);
		DeferredWorkQueue.runLater(StructGen::genStruct);
	}
private static final String nbt = "firstjoin";
	@SubscribeEvent
	public void PlayerSetup(final EntityJoinWorldEvent event)
	{
		random = 1000;
		if(event.getEntity() instanceof PlayerEntity) {
CompoundNBT tag = event.getEntity().getPersistentData();
CompoundNBT existing;
			PlayerEntity player = (PlayerEntity)event.getEntity();
			if(!tag.contains(PlayerEntity.PERSISTED_NBT_TAG))
			{
				tag.put(PlayerEntity.PERSISTED_NBT_TAG,(existing = new CompoundNBT()));
			}
			else
			{
				existing = tag.getCompound(PlayerEntity.PERSISTED_NBT_TAG);
			}

			if(!existing.contains(nbt))
			{
				existing.putBoolean(nbt,true);
			player.inventory.add(0, new ItemStack(ModItems.STORY_BOOK.get(), 1));
			}
		}
	}








	private void dostuff(final FMLClientSetupEvent event)
	{
	}
	
	@SubscribeEvent
	public static void onItemInit(final RegistryEvent.Register<Item> Items)
	{
		final IForgeRegistry<Item> registry = Items.getRegistry();
		
		ModBlocks.BLOCKS.getEntries().stream().filter(block -> !(block.get() instanceof FlowingFluidBlock) &&
				!(block.get() instanceof LiquidHelium) && !(block.get() instanceof SeaPylon) && !(block.get() instanceof LyokoCore)).map(RegistryObject::get).forEach(block->
		{
			final Item.Properties itemsettings = new Item.Properties().group(LYOKO_BLOCKS);
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
	
	public static final ItemGroup LYOKO_BLOCKS = new ItemGroup("lyoko_blocks") {
		
		@Override
		public ItemStack createIcon() {
			// TODO Auto-generated method stub
			return new ItemStack(ModBlocks.TOWER_INTERFACE.get());
		}
	};


	public static final ItemGroup LYOKO_ARMOR = new ItemGroup("lyoko_armor") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.WILLIAM_CHESTPLATE.get());
		}
	};

	public static final ItemGroup LYOKO_WEAPONS = new ItemGroup("lyoko_weapons") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.LASER_ARROWSHOOTER.get());
		}
	};

	public static final ItemGroup LYOKO_ITEMS = new ItemGroup("lyoko_items") {

		@Override
		public ItemStack createIcon() {
			// TODO Auto-generated method stub
			return new ItemStack(ModItems.BIT.get());
		}
	};

	public void onbake(final ModelRegistryEvent event)
	{
		ModelLoaderRegistry.registerLoader(new ResourceLocation(Base.MOD_ID, "test"), new ModelSkid() {
		});
	}

	
}