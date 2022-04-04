package com.Ultra_Nerd.CodeLyokoRemake15;


import com.Ultra_Nerd.CodeLyokoRemake15.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.ClientModEventSubscriber;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.enums.LyokoArmorMaterial;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.LiquidHelium;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.LyokoCore;
import com.Ultra_Nerd.CodeLyokoRemake15.blocks.SeaPylon;
import com.Ultra_Nerd.CodeLyokoRemake15.init.*;
import com.Ultra_Nerd.CodeLyokoRemake15.player.PlayerClassType;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.List;
import java.util.Objects;

@Mod("cm")
public class CodeLyokoMain {

    public static ResourceLocation CodeLyokoPrefix(String name)
    {
        return new ResourceLocation(MOD_ID,name);
    }
    public static final Logger Log = LogUtils.getLogger();
    public static final String MOD_ID = "cm";
    public static final List<PlayerClassType> playerClassType = List.of(new PlayerClassType("Archer",34, LyokoArmorMaterial.ARCHER),
            new PlayerClassType("Felyne",62,LyokoArmorMaterial.FELNINE),new PlayerClassType("Guardian",90,LyokoArmorMaterial.GUARDIAN),
            new PlayerClassType("Samurai",118,LyokoArmorMaterial.SAMURAI),new PlayerClassType("Ninja",146,LyokoArmorMaterial.NINJA));
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
        instance = this;
        final IEventBus ModBus = FMLJavaModLoadingContext.get().getModEventBus();
        GeckoLib.initialize();

        //ModBus.addListener(this::PlayerSetup);
        //ModBus.addListener(ClientModEventSubscriber::onFMLClientSetupEvent);


        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientModEventSubscriber::ClientSetup);
        ModContainerTypes.CONTAINER_TYPES.register(ModBus);
        ModTileEntities.TILE_ENTITY_TYPES.register(ModBus);
        ModParticles.PARTICLES.register(ModBus);
        ModSounds.SOUNDS.register(ModBus);
        ModEntities.Entities.register(ModBus);
        ModSounds.populateMusicHashMap();
        ModBlocks.BLOCKS.register(ModBus);
        ModItems.ITEMS.register(ModBus);
        ModFluids.LIQUIDS.register(ModBus);
        ModBiome.BIOMES.register(ModBus);
        ModFeature.LYOKOFEATURES.register(ModBus);



        //ModRecipes.RECIPE_SERIALIZER_DEFERRED_REGISTER.register(ModBus);


        MinecraftForge.EVENT_BUS.register(this);
        //ModWorldFeatures.FEATURES.register(ModBus);

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






    @SubscribeEvent
    public void PlayerSetup(final EntityJoinWorldEvent event) {

        random = 1000;


        if (event.getEntity() instanceof Player player) {

            //makes it so that when the player re-enters the world default music doesn't play
            ModSounds.LAZY_HASH_MAP.forEach((levelResourceKey, musicLazy) -> {
                //Log.debug(levelResourceKey.toString(),musicLazy.toString());
                if(player.level.dimension() == levelResourceKey)
                {

                    Minecraft.getInstance().getMusicManager().startPlaying(musicLazy.get());



                }

            });



            CompoundTag tag = event.getEntity().getPersistentData();
            CompoundTag existing;
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


@Mod.EventBusSubscriber(modid = MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public static final class RegistryEventHandler{


    @SubscribeEvent
    public static void onRegisterBiome(final RegistryEvent.Register<Biome> event) {



        ModBiome.addBiomeTypes();

    }
    public static DamageSource DigitaloceanDamageSource;
    @SubscribeEvent
    public static void test(final RegistryEvent.Register<Block> registerBlcoks)
    {
        registerBlcoks.getRegistry().getEntries().stream().forEach(resourceKeyBlockEntry -> {

            if(resourceKeyBlockEntry.getValue().getRegistryName().equals(ModFluids.DIGITAL_SEA_BLOCK.get().getRegistryName()))
            {
                DigitaloceanDamageSource = new DamageSource(resourceKeyBlockEntry.getValue().getRegistryName().toString()).bypassArmor();
            }
        });
    }
    @SubscribeEvent
    public static void onItemInit(final RegistryEvent.Register<Item> Items) {
        ModFeature.setConfigurations();

        final IForgeRegistry<Item> registry = Items.getRegistry();
        ModBlocks.BLOCKS.getEntries().stream().filter(block -> !(block.get() instanceof LiquidBlock) &&
                !(block.get() instanceof LiquidHelium) && !(block.get() instanceof SeaPylon) && !(block.get() instanceof LyokoCore)
                && !(block.get() instanceof AirBlock)).map(RegistryObject::get).forEach(block ->
        {
            final Item.Properties itemsettings = new Item.Properties().tab(LYOKO_BLOCKS);
            final BlockItem Itemblocks = new BlockItem(block, itemsettings);
            Itemblocks.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
            registry.register(Itemblocks);
        });
    }


    /*
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

     */
    @SubscribeEvent
    public static void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() ->
                {

                    PacketHandler.init();

                    ModDimensions.init();


                }
        );

        //ModOreGen.genOre();
        //StructGen.genStruct();


    }







}







}