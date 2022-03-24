package com.Ultra_Nerd.CodeLyokoRemake15;


import com.Ultra_Nerd.CodeLyokoRemake15.blocks.LiquidHelium;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.LyokoCore;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.SeaPylon;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.GeckoLib;

import java.util.Random;

@Mod("cm")
@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Bus.MOD)
public class CodeLyokoMain {
    public static ResourceLocation CodeLyokoPrefix(String name)
    {
        return new ResourceLocation("cm",name);
    }
    public static final Logger Log = LogManager.getLogger();
    public static final String MOD_ID = "cm";
    //public static final Map<ResourceLocation, IMultiBlock> MULTIBLOCK_MAP = new ConcurrentHashMap<>();

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
    public static CodeLyokoMain instance;
    public static int random = 1000;
   /*
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event)
    {
        //event.registerEntityRenderer(ModEntities.BLOK.get(), RendBlok::new);
    }*/

public CodeLyokoMain() {

        final IEventBus ModBus = FMLJavaModLoadingContext.get().getModEventBus();
        GeckoLib.initialize();

        ModBus.addListener(this::commonSetup);
        ModBus.addListener(this::clientSetup);
        //ModParticles.PARTICLES.register(ModBus);
        ModSounds.SOUNDS.register(ModBus);
        ModItems.ITEMS.register(ModBus);
        ModFluids.LIQUIDS.register(ModBus);
        ModBlocks.BLOCKS.register(ModBus);
        //ModEntities.Entities.register(ModBus);
        //ModRecipes.RECIPE_SERIALIZER_DEFERRED_REGISTER.register(ModBus);
        //ModBiome.BIOMES.register(ModBus);
        //ModContainerTypes.CONTAINER_TYPES.register(ModBus);
        //ModTileEntities.TILE_ENTITY_TYPES.register(ModBus);
       // ModDimensions.MOD_DIMENSION_DEFERRED_REGISTER.register(ModBus);
        //ModWorldFeatures.FEATURES.register(ModBus);
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfiguration.COMMON_SPEC, "code_lyoko_legacy.toml");
    }

    /*public static IMultiblock registerMultiBlocks(ResourceLocation resourceLocation, IMultiblock multiblock) {
        IMultiblock MultiBlocks = MULTIBLOCK_MAP.put(resourceLocation, multiblock);
        if (MultiBlocks != null) {
            throw new IllegalArgumentException("Multiblock " + resourceLocation + " already registered");
        } else {
            CodeLyokoMain.Log.info(resourceLocation);
            return multiblock.setId(resourceLocation);
        }
    }
*/

    public static VoxelShape calculateShapes(Direction to, VoxelShape shape) {
        final VoxelShape[] buffer = { shape, Shapes.empty() };

        final int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.or(buffer[1],
                    Shapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = Shapes.empty();
        }

        return buffer[0];
    }

    @SubscribeEvent
    public static void onItemInit(final RegistryEvent.Register<Item> Items) {
        final IForgeRegistry<Item> registry = Items.getRegistry();

        ModBlocks.BLOCKS.getEntries().stream().filter(block -> !(block.get() instanceof LiquidBlock) &&
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
       // ModBiome.regbio();
    }

    @SubscribeEvent
    public void onRegisterEnties(final RegistryEvent.Register<EntityType<?>> event) {
   //     CustomMobEggs.initEgg();
    }

    @SubscribeEvent
    public void tickPast(final TickEvent event) {
        if ((event.phase == TickEvent.Phase.START || event.phase == TickEvent.Phase.END) && Minecraft.getInstance().level != null) {
            random--;
            //CodeLyokoMain.Log.debug(random);
            if (random == 0 && !XANA) {
                random = new Random().nextInt(40000);
                assert Minecraft.getInstance().player != null;
                Minecraft.getInstance().player.sendMessage(new TextComponent("xana is attacking"),Minecraft.getInstance().player.getUUID());
                XANA = true;
            }
        }
    }
    @SubscribeEvent
    public  void commonSetup(final FMLCommonSetupEvent event) {

        //ModOreGen.genOre();
        //StructGen.genStruct();
        //PacketHandler.init();

    }

    @SubscribeEvent
    public void PlayerSetup(final EntityJoinWorldEvent event) {
        random = 1000;
        if (event.getEntity() instanceof Player) {
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