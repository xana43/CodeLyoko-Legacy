package com.Ultra_Nerd.CodeLyokoLegacy;


import com.Ultra_Nerd.CodeLyokoLegacy.Entity.MegaTankEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandlerCommon;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.handlers.XanaHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.*;
import com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage.CarthageBiomeProvider;
import com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage.CarthageGenerator;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;
import team.reborn.energy.api.EnergyStorage;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public record CodeLyokoMain() implements ModInitializer {


    public static final String MOD_ID = "cm";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    public static final ItemGroup LYOKO_ITEM = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "lyoko_items"), () -> new ItemStack(ModItems.BIT));
    public static final ItemGroup LYOKO_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "lyoko_blocks"), () -> new ItemStack(ModBlocks.TOWER_INTERFACE));
    public static final ItemGroup LYOKO_ARMOR = FabricItemGroupBuilder.build(CodeLyokoPrefix("lyoko_armor"), () -> new ItemStack(ModItems.WILLIAM_CHESTPLATE));
    public static final ItemGroup LYOKO_WEAPONS = FabricItemGroupBuilder.build(CodeLyokoPrefix("lyoko_weapons"), () -> new ItemStack(ModItems.LASER_ARROWSHOOTER));


    @Contract("_ -> new")
    public static @NotNull Identifier CodeLyokoPrefix(String name) {
        return new Identifier(MOD_ID, name);
    }

    private static void registerEnergyStorageBE() {
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.simpleEnergyStorage, ModTileEntities.UNIVERSAL_ENERGY_STORAGE);
    }

    @Override
    public void onInitialize() {
        GeckoLib.initialize();
        PacketHandlerCommon.CommonChannelRegistry();
        generalRegistration();
        SetupFunctions();
        registerDefaultAttributes();
        registerEnergyStorageBE();

    }


    private static void generalRegistration() {

        ModBlocks.BLOCK_MAP.forEach((s, block) -> {

            Registry.register(Registry.BLOCK, new Identifier(MOD_ID, s), block);
            //LOG.info(String.valueOf(blocks));
            if (block != ModBlocks.LYOKO_CORE && block != ModBlocks.DIGITAL_OCEAN_BLOCK && block != ModBlocks.DIGITAL_LAVA_BLOCK) {
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, s), new BlockItem(block, new FabricItemSettings().group(LYOKO_BLOCKS)));
            }
        });
        ModItems.ITEM_MAP.forEach((s, item) -> Registry.register(Registry.ITEM, new Identifier(MOD_ID, s), item));
        ModTileEntities.BLOCKENTITY_MAP.forEach((s, blockEntityType) -> Registry.register(Registry.BLOCK_ENTITY_TYPE, CodeLyokoPrefix(s), blockEntityType));
        //ModSounds.SOUNDS.forEach(soundEvent -> Registry.register(Registry.SOUND_EVENT,soundEvent.getId(),soundEvent));
        final int size = ModSounds.SOUNDS.length;
        for (int i = 0; i < size; i++) {

            Registry.register(Registry.SOUND_EVENT, ModSounds.SOUNDS[i].getId(), ModSounds.SOUNDS[i]);
        }
        ModBiome.BIOME_MAP.forEach((s, biome) -> Registry.register(BuiltinRegistries.BIOME, CodeLyokoPrefix(s), biome));
        ModEntities.ENTITY_TYPE_HASH_MAP.forEach((s, entityType) -> Registry.register(Registry.ENTITY_TYPE, CodeLyokoPrefix(s), entityType));
        ModFluids.FLUID_IMMUTABLE_MAP.forEach((s, fluid) ->
                Registry.register(Registry.FLUID, CodeLyokoPrefix(s), fluid));

        ModParticles.PARTICLE_TYPE_IMMUTABLE_MAP.forEach((s, defaultParticleType) -> Registry.register(Registry.PARTICLE_TYPE, CodeLyokoPrefix(s), defaultParticleType));
        Registry.register(Registry.CHUNK_GENERATOR, CodeLyokoPrefix("carthage_chunkgen"), CarthageGenerator.CARTHAGE_GENERATOR_CODEC);
        Registry.register(Registry.BIOME_SOURCE, CodeLyokoPrefix("carthage_biome"), CarthageBiomeProvider.CARTHAGE_BIOME_PROVIDER_CODEC);
        ModScreenHandlers.screenHandlerMap.forEach((s, screenHandlerType) -> Registry.register(Registry.SCREEN_HANDLER, CodeLyokoPrefix(s), screenHandlerType));

        ModStructures.registerNewStructures();
        ModFeature.CONFIGURED_TREE_IMMUTABLE_MAP.forEach((s, feature) -> {

            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, CodeLyokoPrefix(s), feature.getLeft());
            Registry.register(BuiltinRegistries.PLACED_FEATURE, CodeLyokoPrefix(s), feature.getRight());


        });
        ModStats.RegisterStats();


        BiomeFeatureInject();
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, ModTileEntities.COMPUTER_REACTOR_TILE_ENTITY);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) ->


                {
                    return switch (stack.getTranslationKey()) {
                        case "item.cm.story_book" -> 0x00008B;
                        case "item.cm.story_book2" -> ColorHelper.Argb.getArgb(255, 255, 0, 0);
                        default -> 1;
                    };

                    //return 0x00008B;
                }

                , ModItems.STORY_BOOK, ModItems.STORY_BOOK2);

    }


    private static void BiomeFeatureInject() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, CodeLyokoPrefix("coffinite_ore_overworld")));
    }

    private static void registerDefaultAttributes() {
        //FabricDefaultAttributeRegistry.register(ModEntities.BLOK, EntityBlok.createMonsterAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.MEGATANK, MegaTankEntity.registerAttributes());

    }

    private static final TrackedData<NbtCompound> peristent = DataTracker.registerData(ServerPlayerEntity.class, TrackedDataHandlerRegistry.NBT_COMPOUND);

    private static void SetupFunctions() {

        //sets the properties for the xana handler to calcualate on
        ServerWorldEvents.LOAD.register((server, world) -> XanaHandler.setProperties(world.getLevelProperties()));
        //saves and loats the inventoryfor both respawn and joining
        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
            if (MethodUtil.DimensionCheck.playerInVanilla(newPlayer)) {
                CardinalData.LyokoInventorySave.loadPlayerInventory(newPlayer.server.getSaveProperties().getMainWorldProperties(), newPlayer);
            }

        });

        ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register((player, origin, destination) -> {

            if (player != null) {
                if (MethodUtil.DimensionCheck.worldIsNotVanilla(destination)) {
                    CardinalData.LyokoInventorySave.savePlayerInventory(player.server.getSaveProperties().getMainWorldProperties(), player);

                } else if (MethodUtil.DimensionCheck.worldIsNotVanilla(origin)) {
                    CardinalData.LyokoInventorySave.loadPlayerInventory(player.server.getSaveProperties().getMainWorldProperties(), player);

                }
            }
        });

        XanaHandler.setTicksToNextCalculation(1);
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {

            if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(player) && !player.isCreative()) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;

        });
        //gives the player the first entry into the story
        final String nbtdat = "first_join";
        final AtomicReference<NbtCompound> t = new AtomicReference<>(new NbtCompound());
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            handler.player.getDataTracker().startTracking(peristent, t.getAcquire());
            if (!handler.player.getDataTracker().get(peristent).contains(nbtdat)) {
                handler.player.getDataTracker().get(peristent).putBoolean(nbtdat, true);
                handler.player.getInventory().setStack(handler.player.getInventory().getEmptySlot(), new ItemStack(ModItems.STORY_BOOK));

            } else {

                t.set(handler.player.getDataTracker().get(peristent));
            }


        });

        //xana
        final AtomicInteger tick = new AtomicInteger();
        ServerTickEvents.START_WORLD_TICK.register(world -> world.getPlayers().forEach(serverPlayerEntity -> {
            //tick the xana attack handler
            tick.getAndIncrement();
            if ((tick.get() >> 3) % 5 == 0) {
                if (serverPlayerEntity.getStatHandler().getStat(Stats.CUSTOM, ModStats.ENTERED_LYOKO_IDENTIFIER) > 0) {
                    if (XanaHandler.calculateAttackProbability()) {
                        final int notifyPlayerRandom = new Random().nextInt(world.getPlayers().size());

                        world.getPlayers().get(notifyPlayerRandom).sendMessage(Text.translatable("xana.attack.start").getWithStyle(ConstantUtil.Styles.GUNSHIP.getThisStyle().withColor(Formatting.RED)).get(0), true);


                    }
                }
            }
            //carry out continuous operations dependant on the dimension
            if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(serverPlayerEntity)) {
                serverPlayerEntity.getHungerManager().setExhaustion(0);
                serverPlayerEntity.getHungerManager().setSaturationLevel(5);
                serverPlayerEntity.getAbilities().allowModifyWorld = serverPlayerEntity.isCreative();

                //CodeLyokoMain.LYOKO_LOCK.lock(serverPlayerEntity, DefaultInventoryNodes.MAIN_INVENTORY);
            } else/*&& CodeLyokoMain.LYOKO_LOCK.isLocking(serverPlayerEntity,DefaultInventoryNodes.MAIN_INVENTORY)*/ {

                serverPlayerEntity.getAbilities().allowModifyWorld = true;
                //CodeLyokoMain.LYOKO_LOCK.unlock(serverPlayerEntity,DefaultInventoryNodes.MAIN_INVENTORY);
            }


        }));
        //stop items from being able to drop in lyoko
        ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            if (entity instanceof final ItemEntity itemEntity) {
                if (MethodUtil.DimensionCheck.worldIsNotVanilla(world)) {
                    itemEntity.kill();
                }
            }


        });

        //prevents the player from losing EXP
        ServerPlayerEvents.COPY_FROM.register((oldPlayer, newPlayer, alive) -> {

            if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(oldPlayer)) {
                newPlayer.experienceLevel = oldPlayer.experienceLevel;
            }

        });
    }


}
