package com.Ultra_Nerd.CodeLyokoRemake15;


import com.Ultra_Nerd.CodeLyokoRemake15.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers.ModConfiguration;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.LiquidHelium;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.LyokoCore;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.SeaPylon;
import com.Ultra_Nerd.CodeLyokoRemake15.init.*;
import com.Ultra_Nerd.CodeLyokoRemake15.items.CustomMobEggs;
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
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import vazkii.patchouli.api.IMultiblock;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Mod("cm")
@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Bus.MOD)
public class Base {

    public static final Logger Log = LogManager.getLogger();
    public static final String MOD_ID = "cm";
    public static final Map<ResourceLocation, IMultiBlock> MULTIBLOCK_MAP = new ConcurrentHashMap<>();

    public static final CreativeModeTab LYOKO_BLOCKS = new CreativeModeTab("lyoko_blocks") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModBlocks.TOWER_INTERFACE.get());
        }


    };

    public static final CreativeModeTab LYOKO_ARMOR = new CreativeModeTab("lyoko_armor") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.WILLIAM_CHESTPLATE.get());
        }
    };

    public static final CreativeModeTab LYOKO_WEAPONS = new CreativeModeTab("lyoko_weapons") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.LASER_ARROWSHOOTER.get());
        }
    };

    public static final CreativeModeTab LYOKO_ITEMS = new CreativeModeTab("lyoko_items") {
        @Override
        public @NotNull ItemStack makeIcon() {
            // TODO Auto-generated method stub
            return new ItemStack(ModItems.BIT.get());
        }
    };

    private static final String nbt = "first_join";
    public static boolean XANA = false;
    public static Base instance;
    public static int random = 1000;

    public Base() {
        final IEventBus ModBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBus.addListener(this::commonSetup);
        ModBus.addListener(this::clientSetup);
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
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfiguration.COMMON_SPEC, "code_lyoko_legacy.toml");
    }

    public static IMultiblock registerMultiBlocks(ResourceLocation resourceLocation, IMultiblock multiblock) {
        IMultiblock MultiBlocks = MULTIBLOCK_MAP.put(resourceLocation, multiblock);
        if (MultiBlocks != null) {
            throw new IllegalArgumentException("Multiblock " + resourceLocation + " already registered");
        } else {
            Base.Log.info(resourceLocation);
            return multiblock.setId(resourceLocation);
        }
    }

    @SubscribeEvent
    public static void onItemInit(final RegistryEvent.Register<Item> Items) {
        final IForgeRegistry<Item> registry = Items.getRegistry();

        ModBlocks.BLOCKS.getEntries().stream().filter(block -> !(block.get() instanceof FlowingFluid) &&
                !(block.get() instanceof LiquidHelium) && !(block.get() instanceof SeaPylon) && !(block.get() instanceof LyokoCore)).map(RegistryObject::get).forEach(block ->
        {
            final Item.Properties itemsettings = new Item.Properties().tab(LYOKO_BLOCKS);
            final BlockItem Itemblocks = new BlockItem(block, itemsettings);
            Itemblocks.setRegistryName(block.getRegistryName());
            registry.register(Itemblocks);
        });
        Log.debug("Inventory blocks registered");
    }

    @SubscribeEvent
    public static void onRegisterBiome(final RegistryEvent.Register<Biome> event) {
        ModBiome.regbio();
    }

    @SubscribeEvent
    public void onRegisterEnties(final RegistryEvent.Register<EntityType<?>> event) {
        CustomMobEggs.initEgg();
    }

    @SubscribeEvent
    public void tickPast(final TickEvent event) {
        if ((event.phase == TickEvent.Phase.START || event.phase == TickEvent.Phase.END) && Minecraft.getInstance().world != null) {
            random--;
            //Base.Log.debug(random);
            if (random == 0 && !XANA) {
                random = new Random().nextInt(40000);
                assert Minecraft.getInstance().player != null;
                Minecraft.getInstance().player.sendMessage(new TextComponent("xana is attacking"));
                XANA = true;
            }
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(ModOreGen::genOre);
        DeferredWorkQueue.runLater(StructGen::genStruct);
        PacketHandler.init();
    }

    @SubscribeEvent
    public void PlayerSetup(final EntityJoinWorldEvent event) {
        random = 1000;
        if (event.getEntity() instanceof PlayerEntity) {
            CompoundTag tag = event.getEntity().getPersistentData();
            CompoundTag existing;
            Player player = (Player) event.getEntity();
            if (!tag.contains(Player.PERSISTED_NBT_TAG)) {
                tag.put(Player.PERSISTED_NBT_TAG, (existing = new CompoundTag()));
            } else {
                existing = tag.getCompound(Player.PERSISTED_NBT_TAG);
            }

            if (!existing.contains(nbt)) {
                existing.putBoolean(nbt, true);
                player.getInventory().add(0, new ItemStack(ModItems.STORY_BOOK.get(), 1));
            }
        }
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }


}