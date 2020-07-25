package com.Ultra_Nerd.CodeLyokoRemake15;


import com.Ultra_Nerd.CodeLyokoRemake15.blocks.HologramBlock;
import com.Ultra_Nerd.CodeLyokoRemake15.events.DimensionEnterEvent;
import com.Ultra_Nerd.CodeLyokoRemake15.init.*;
import com.Ultra_Nerd.CodeLyokoRemake15.items.armor.AelitaArmorElytra;
import com.Ultra_Nerd.CodeLyokoRemake15.world.ModOreGen;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

@Mod("cm")
@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Bus.MOD)
public class Base
{
	public static final Logger Log = LogManager.getLogger();

	public static final String MOD_ID = "cm";
	public static Base instance;
	public Base()
	{
		final IEventBus ModBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModBus.addListener(this::setup);
		ModBus.addListener(this::dostuff);
		ModBus.addListener(this::RightClick);
		ModBus.addListener(this::OreGen);
		ModBus.addListener(this::PlayerSetup);
		ModSounds.SOUNDS.register(ModBus);
		ModItems.ITEMS.register(ModBus);
		ModBus.addListener(DimensionEnterEvent::EnterDimension);
		ModFluids.LIQUIDS.register(ModBus);
		ModBlocks.BLOCKS.register(ModBus);
		ModEntities.Entities.register(ModBus);
		ModBiome.BIOMES.register(ModBus);
		ModContainerTypes.CONTAINER_TYPES.register(ModBus);
		ModTileEntities.TILE_ENTITY_TYPES.register(ModBus);
		ModDimensions.MOD_DIMENSION_DEFERRED_REGISTER.register(ModBus);
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{

	}
private static final String nbt = "firstjoin";
	@SubscribeEvent
	public void PlayerSetup(final EntityJoinWorldEvent event)
	{
		if(event.getEntity() instanceof PlayerEntity) {
CompoundNBT tag =event.getEntity().getPersistentData();
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
			player.inventory.add(0, new ItemStack(Items.WRITABLE_BOOK, 1));
			}
		}
	}
	public void OreGen(final FMLLoadCompleteEvent event)
	{

		ModOreGen.genOre();
	}




	public void RightClick(final InputEvent.MouseInputEvent event)
	{
		if(event.getButton() == GLFW.GLFW_MOUSE_BUTTON_RIGHT)
		{
			assert Minecraft.getInstance().player != null;
			AelitaArmorElytra.EnergyBall(Minecraft.getInstance().player,Minecraft.getInstance().world);
		}
	}


	private void dostuff(final FMLClientSetupEvent event)
	{


	}
	
	@SubscribeEvent
	public static void onItemInit(final RegistryEvent.Register<Item> Items)
	{
		final IForgeRegistry<Item> registry = Items.getRegistry();
		
		ModBlocks.BLOCKS.getEntries().stream().filter(block -> !(block.get() instanceof FlowingFluidBlock) && !(block.get() instanceof HologramBlock)).map(RegistryObject::get).forEach(block->
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
	
}