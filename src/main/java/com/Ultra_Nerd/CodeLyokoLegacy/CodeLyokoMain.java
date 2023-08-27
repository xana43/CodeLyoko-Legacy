package com.Ultra_Nerd.CodeLyokoLegacy;


import com.Ultra_Nerd.CodeLyokoLegacy.Entity.MegaTankEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandlerCommon;
import com.Ultra_Nerd.CodeLyokoLegacy.init.*;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.MultiBlockController;
import com.Ultra_Nerd.CodeLyokoLegacy.util.event.PlaceBlockEvent;
import com.Ultra_Nerd.CodeLyokoLegacy.util.handlers.XanaHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage.CarthageGenerator;
import com.mojang.serialization.Lifecycle;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.DamageUtil;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.gen.GenerationStep;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;
import team.reborn.energy.api.EnergyStorage;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public record CodeLyokoMain() implements ModInitializer {


    public static final String MOD_ID = "codelyoko";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    public static final ItemGroup LYOKO_ITEM = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.BIT))
            .displayName(Text.translatable("itemGroup.lyoko_items"))
            .build();
    public static final ItemGroup LYOKO_BLOCKS = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.lyoko_blocks"))
            .icon(() -> new ItemStack(ModBlocks.TOWER_INTERFACE)).build();
    public static final ItemGroup LYOKO_ARMOR = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.lyoko_armor"))
            .icon(() -> new ItemStack(ModItems.WILLIAM_CHESTPLATE)).build();
    public static final ItemGroup LYOKO_WEAPONS = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.lyoko_weapons"))
            .icon(() -> new ItemStack(ModItems.LASER_ARROWSHOOTER)).build();
    private static final TrackedData<NbtCompound> peristent = DataTracker.registerData(ServerPlayerEntity.class,
            TrackedDataHandlerRegistry.NBT_COMPOUND);

    @Contract("_ -> new")
    public static @NotNull Identifier codeLyokoPrefix(String name) {
        return new Identifier(MOD_ID, name);
    }

    private static void registerEnergyStorageBE() {
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.getEnergyImplementation(),
                ModBlockEntities.UNIVERSAL_ENERGY_STORAGE);
    }

    private static void checkWorld() {
        PlaceBlockEvent.EVENT.register(((entity, world, pos) -> {
            for (int x = -32; x < 32; ++x) {
                for (int y = -32; y < 32; ++y) {
                    for (int z = -32; z < 32; ++z) {
                        final BlockPos checkedPos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                        if (world.getBlockEntity(
                                checkedPos) instanceof final MultiBlockController multiBlockController && world.isChunkLoaded(
                                ChunkSectionPos.getSectionCoord(checkedPos.getX()),
                                ChunkSectionPos.getSectionCoord(checkedPos.getZ())) && !world.isClient()) {
                            if (!multiBlockController.getCheckSuccessful()) {
                                multiBlockController.check();

                            }
                        }
                    }
                }
            }


            return ActionResult.PASS;
        }));


        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            for (int x = -32; x < 32; ++x) {
                for (int y = -32; y < 32; ++y) {
                    for (int z = -32; z < 32; ++z) {
                        final BlockPos checkedPos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);

                        if (world.getBlockEntity(
                                checkedPos) instanceof final MultiBlockController multiBlockController && world.isChunkLoaded(
                                ChunkSectionPos.getSectionCoord(checkedPos.getX()),
                                ChunkSectionPos.getSectionCoord(checkedPos.getZ()))) {
                            if (multiBlockController.getCheckSuccessful()) {
                                multiBlockController.check();
                            }
                        }
                    }
                }
            }
        });
    }

    private static void generalRegistration() {
        Registry.register(Registries.ITEM_GROUP,CodeLyokoMain.codeLyokoPrefix("lyoko_blocks"),LYOKO_BLOCKS);
        Registry.register(Registries.ITEM_GROUP,CodeLyokoMain.codeLyokoPrefix("lyoko_item"),LYOKO_ITEM);
        Registry.register(Registries.ITEM_GROUP,CodeLyokoMain.codeLyokoPrefix("lyoko_armor"),LYOKO_ARMOR);
        Registry.register(Registries.ITEM_GROUP,CodeLyokoMain.codeLyokoPrefix("lyoko_weapons"),LYOKO_WEAPONS);
        ModBlocks.BLOCK_MAP.forEach((s, block) -> {

            Registry.register(Registries.BLOCK, new Identifier(MOD_ID, s), block);
            if (block != ModBlocks.LYOKO_CORE && block != ModBlocks.DIGITAL_OCEAN_BLOCK && block != ModBlocks.DIGITAL_LAVA_BLOCK) {
                final BlockItem blockItem = new BlockItem(block, new FabricItemSettings());
                Registry.register(Registries.ITEM, new Identifier(MOD_ID, s), blockItem);

                final RegistryKey<ItemGroup> registryKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                        CodeLyokoMain.codeLyokoPrefix("lyoko_blocks"));
                ItemGroupEvents.modifyEntriesEvent(registryKey).register(entries -> entries.add(blockItem));
            }
        });

        ModItems.ITEM_MAP.forEach((s, item) -> {
            Registry.register(Registries.ITEM, new Identifier(MOD_ID, s), item);

            final RegistryKey<ItemGroup> registryKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                    CodeLyokoMain.codeLyokoPrefix("lyoko_item"));
            ItemGroupEvents.modifyEntriesEvent(registryKey).register(entries -> entries.add(item));
        });
        ModItems.ARMOR_MAP.forEach((s, item) -> {
            Registry.register(Registries.ITEM, new Identifier(MOD_ID, s), item);

            final RegistryKey<ItemGroup> registryKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                    CodeLyokoMain.codeLyokoPrefix("lyoko_armor"));
            ItemGroupEvents.modifyEntriesEvent(registryKey).register(entries -> entries.add(item));
        });
        ModItems.WEAPON_MAP.forEach((s, item) -> {
            Registry.register(Registries.ITEM, new Identifier(MOD_ID, s), item);

            final RegistryKey<ItemGroup> registryKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                    CodeLyokoMain.codeLyokoPrefix("lyoko_weapons"));
            ItemGroupEvents.modifyEntriesEvent(registryKey).register(entries -> entries.add(item));
        });
        ModBlockEntities.BLOCKENTITY_MAP.forEach(
                (s, blockEntityType) -> Registry.register(Registries.BLOCK_ENTITY_TYPE, codeLyokoPrefix(s),
                        blockEntityType));
        for (int i = 0; i < ModSounds.SOUNDS.length; i++) {

            Registry.register(Registries.SOUND_EVENT, ModSounds.SOUNDS[i].getId(), ModSounds.SOUNDS[i]);
        }
        ModEntities.ENTITY_TYPE_HASH_MAP.forEach(
                (s, entityType) -> Registry.register(Registries.ENTITY_TYPE, codeLyokoPrefix(s), entityType));
        ModFluids.FLUID_IMMUTABLE_MAP.forEach(
                (s, fluid) -> Registry.register(Registries.FLUID, codeLyokoPrefix(s), fluid));

        ModParticles.PARTICLE_TYPE_IMMUTABLE_MAP.forEach(
                (s, defaultParticleType) -> Registry.register(Registries.PARTICLE_TYPE, codeLyokoPrefix(s),
                        defaultParticleType));
        Registry.register(Registries.CHUNK_GENERATOR, codeLyokoPrefix("carthage_chunkgen"),
                CarthageGenerator.CARTHAGE_GENERATOR_CODEC);
        ModScreenHandlers.screenHandlerMap.forEach(
                (s, screenHandlerType) -> Registry.register(Registries.SCREEN_HANDLER, codeLyokoPrefix(s),
                        screenHandlerType));
        CodeLyokoMain.LOG.info(
                String.valueOf(RegistryEntry.of(ModScreenHandlers.COMPUTER_INTERFACE_SCREEN_SCREEN_HANDLER_TYPE)));
        ModStructures.registerNewStructures();


        ModStats.registerStats();

        BiomeFeatureInject();
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.getEnergyStorage(),
                ModBlockEntities.COMPUTER_REACTOR_TILE_ENTITY);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.getEnergyStorage(),
                ModBlockEntities.COMPUTER_CORE_TILE_ENTITY_BLOCK_ENTITY_TYPE);


    }


    private static void BiomeFeatureInject() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, codeLyokoPrefix("coffinite_ore_overworld")));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        RegistryKey.of(RegistryKeys.BIOME, ModBiome.RegisteredBiomes.FOREST_SECTOR.getIdentifier())),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, codeLyokoPrefix("lyoko_forest_tree")));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        RegistryKey.of(RegistryKeys.BIOME, ModBiome.RegisteredBiomes.VOLCANO.getIdentifier())),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModFeature.PlacedFeatures.LAVA_LAKE_VOLCANO_KEY);
    }

    private static void registerDefaultAttributes() {
        //FabricDefaultAttributeRegistry.register(ModEntities.BLOK, EntityBlok.createMonsterAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.MEGATANK, MegaTankEntity.registerAttributes());

    }

    private static void SetupFunctions() {


        //sets the properties for the xana handler to calcualate on
        ServerWorldEvents.LOAD.register((server, world) -> XanaHandler.setProperties(world.getLevelProperties()));
        //saves and loads the inventory for both respawn and joining
        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
            if (MethodUtil.DimensionCheck.playerInVanilla(newPlayer)) {
                CardinalData.LyokoInventorySave.loadPlayerInventory(
                        newPlayer.server.getSaveProperties().getMainWorldProperties(), newPlayer);
            }

        });

        ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register((player, origin, destination) -> {

            if (player != null) {
                if (MethodUtil.DimensionCheck.worldIsNotVanilla(destination)) {
                    CardinalData.LyokoInventorySave.savePlayerInventory(
                            player.server.getSaveProperties().getMainWorldProperties(), player);

                    player.incrementStat(ModStats.ENTERED_LYOKO_IDENTIFIER);
                    CardinalData.PlayerSavedProfile.getPlayerProfile(
                            player.getServer().getSaveProperties().getMainWorldProperties(), player).incrementEntered();
                } else if (MethodUtil.DimensionCheck.worldIsNotVanilla(origin)) {
                    CardinalData.LyokoInventorySave.loadPlayerInventory(
                            player.server.getSaveProperties().getMainWorldProperties(), player);
                    player.resetStat(Stats.CUSTOM.getOrCreateStat(ModStats.ENTERED_LYOKO_IDENTIFIER));
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
                handler.player.getInventory()
                        .setStack(handler.player.getInventory().getEmptySlot(), new ItemStack(ModItems.STORY_BOOK));

            } else {

                t.set(handler.player.getDataTracker().get(peristent));
            }


        });

        //xana
        final AtomicInteger tick = new AtomicInteger();
        ServerTickEvents.START_WORLD_TICK.register(world -> world.getPlayers().forEach(serverPlayerEntity -> {

            //tick the xana attack handler and heal player stress
            tick.getAndIncrement();
            if ((tick.get() >> 3) % 5 == 0) {
                if (!serverPlayerEntity.getEquippedStack(EquipmentSlot.HEAD).isOf(ModItems.MIND_HELMET)) {
                    CardinalData.MindHelmStress.decreaseStress(serverPlayerEntity);
                }
                CardinalData.CellularDamage.regenerateHealth(serverPlayerEntity);

                if (serverPlayerEntity.getStatHandler().getStat(Stats.CUSTOM, ModStats.ENTERED_LYOKO_IDENTIFIER) > 0) {
                    if (XanaHandler.calculateAttackProbability()) {
                        final int notifyPlayerRandom = new Random().nextInt(world.getPlayers().size());

                        world.getPlayers().get(notifyPlayerRandom).sendMessage(Text.translatable("xana.attack.start")
                                .getWithStyle(ConstantUtil.Styles.GUNSHIP.getThisStyle().withColor(Formatting.RED))
                                .get(0), true);


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
                if (MethodUtil.DimensionCheck.worldIsNotVanilla(world) && !itemEntity.getStack()
                        .isIn(ModTags.ItemTags.LYOKO_ITEM)) {
                    itemEntity.kill();
                }
            }


        });

        //prevents the player from losing EXP
        ServerPlayerEvents.COPY_FROM.register((oldPlayer, newPlayer, alive) -> {

            if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(oldPlayer)) {
                newPlayer.experienceLevel = oldPlayer.experienceLevel;
                CardinalData.CellularDamage.getCellComponentKey().get(newPlayer)
                        .copyFrom(CardinalData.CellularDamage.getCellComponentKey().get(oldPlayer));
            }
        });
        //regenerates the player's digital energy
        ServerTickEvents.END_SERVER_TICK.register(world -> {
            for (final ServerPlayerEntity player : world.getPlayerManager().getPlayerList()) {
                if((world.getTicks() >> 3) % 5 == 0 && !CardinalData.DigitalEnergyComponent.isUsingenergy(player)) {
                    CardinalData.DigitalEnergyComponent.regenerateEnergy(player);
                }
            }

        });
    }

    @Override
    public void onInitialize() {
        //GlobalOBJModels.loadModels();
        GeckoLib.initialize();
        PacketHandlerCommon.commonChannelRegistry();
        generalRegistration();
        SetupFunctions();
        registerDefaultAttributes();
        registerEnergyStorageBE();
        checkWorld();
        //CodeLyokoMain.LOG.info(String.valueOf(GlobalOBJModels.LYOKO_CORE.isInitialized()));
    }


}
