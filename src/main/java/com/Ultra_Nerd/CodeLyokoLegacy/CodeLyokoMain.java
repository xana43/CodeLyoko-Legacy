package com.Ultra_Nerd.CodeLyokoLegacy;


import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.ComputerCoreTileEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.MegaTankEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass.ServerTriplicateCloneEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.SkidbladnirEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.HookEvents.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.*;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables.LootTableOverride;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.blockentity.MultiBlockController;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.event.server.ServerEvents;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.handlers.XanaHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.World.WorldGen.Carthage.CarthageGenerator;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.gen.GenerationStep;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import team.reborn.energy.api.EnergyStorage;

import java.util.Objects;

public record CodeLyokoMain() implements ModInitializer {


    public static final ItemGroup LYOKO_ARMOR = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.lyoko_armor"))
            .icon(() -> new ItemStack(ModItems.WILLIAM_CHESTPLATE)).build();
    public static final ItemGroup LYOKO_BLOCKS = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.lyoko_blocks"))
            .icon(() -> new ItemStack(ModBlocks.TOWER_INTERFACE)).build();
    public static final ItemGroup LYOKO_ITEM = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.BIT))
            .displayName(Text.translatable("itemGroup.lyoko_items"))
            .build();
    public static final ItemGroup LYOKO_WEAPONS = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.lyoko_weapons"))
            .icon(() -> new ItemStack(ModItems.LASER_ARROW_SHOOTER)).build();
    public static final String MOD_ID = "codelyoko";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    @Contract("_ -> new")
    public static @NotNull Identifier codeLyokoPrefix(final String name) {
        return Identifier.of(MOD_ID, name);
    }

    private static void registerEnergyStorageBE() {
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.getEnergyImplementation(),
                ModBlockEntities.UNIVERSAL_ENERGY_STORAGE);
    }


    private static void checkWorld() {
        ServerEvents.PLACE_BLOCK_EVENT.register(((entity, world, pos) -> {
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
        ServerEvents.PLACE_BLOCK_EVENT.register((entity, world, pos) -> {
            if(entity instanceof final ServerPlayerEntity playerEntity && !world.isClient() && world.getBlockEntity(pos) instanceof ComputerCoreTileEntity)
            {
                CardinalData.MiscellaneousDataCollection.XanaRaidData.calculateSuperCalculatorPositions(playerEntity,pos);
            }
            return ActionResult.PASS;
        });
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
                if(!world.isClient() && world.getBlockEntity(pos) instanceof ComputerCoreTileEntity)
                {
                    CardinalData.MiscellaneousDataCollection.XanaRaidData.removeFromCalculatorPositions((ServerPlayerEntity) player,pos);
                }
            return true;
        });
    }

    private static void generalRegistration() {
        Registry.register(Registries.ITEM_GROUP,CodeLyokoMain.codeLyokoPrefix("lyoko_blocks"),LYOKO_BLOCKS);
        Registry.register(Registries.ITEM_GROUP,CodeLyokoMain.codeLyokoPrefix("lyoko_item"),LYOKO_ITEM);
        Registry.register(Registries.ITEM_GROUP,CodeLyokoMain.codeLyokoPrefix("lyoko_armor"),LYOKO_ARMOR);
        Registry.register(Registries.ITEM_GROUP,CodeLyokoMain.codeLyokoPrefix("lyoko_weapons"),LYOKO_WEAPONS);

        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModBlockEntities.registerBlockEntities();
        ModSounds.registerSounds();
        ModEntities.registerEntities();
        ModFluids.registerModFluids();

        ModParticles.registerParticles();
        Registry.register(Registries.CHUNK_GENERATOR, codeLyokoPrefix("carthage_chunkgen"), CarthageGenerator.CARTHAGE_GENERATOR_CODEC);
        ModScreenHandlers.registerScreenHandlers();
        ModStructures.registerNewStructures();


        ModStats.registerStats();

        BiomesFeatureInject();
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.getEnergyStorage(),
                ModBlockEntities.COMPUTER_REACTOR_TILE_ENTITY);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.getEnergyStorage(),
                ModBlockEntities.COMPUTER_CORE_TILE_ENTITY_BLOCK_ENTITY_TYPE);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.getEnergyStorage(),
                ModBlockEntities.RACK_CHARGER_BLOCK_ENTITY);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) ->switch (direction){
                    case NORTH -> blockEntity.waterIntake;
                    default -> blockEntity.waterDistibution;
                },
                ModBlockEntities.COMPUTER_CIRCULATOR_BLOCK_ENTITY_TYPE);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) ->
                    switch (direction)
                    {
                        case NORTH -> blockEntity.getOutput();
                        default -> blockEntity.getInput();
                    }
                ,
                ModBlockEntities.CIRCULATOR_PIPE_BLOCK_ENTITY_TYPE);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> switch (direction){
            case DOWN -> blockEntity.input;
            default -> blockEntity.output;

        },ModBlockEntities.COMPUTER_FLUID_INTAKE_BLOCK_ENTITY);

        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> switch (direction){
            case UP, EAST, SOUTH -> blockEntity.chilled_intake;
            case DOWN, WEST, NORTH -> blockEntity.hot_outlet;
        },ModBlockEntities.COMPUTER_CORE_TILE_ENTITY_BLOCK_ENTITY_TYPE);

    }


    private static void BiomesFeatureInject() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, codeLyokoPrefix("coffinite_ore_overworld")));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.RegisteredBiomes.FOREST_SECTOR.getBiomesRegistryKey()),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, codeLyokoPrefix("lyoko_forest_tree")));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.RegisteredBiomes.VOLCANO.getBiomesRegistryKey()),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModFeature.PlacedFeatures.LAVA_LAKE_VOLCANO_KEY);
    }

    private static void registerDefaultAttributes() {
        //FabricDefaultAttributeRegistry.register(ModEntities.BLOK, EntityBlok.createMonsterAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.MEGATANK, MegaTankEntity.registerAttributes());

    }

    private static void SetupFunctions() {


        //sets the properties for the xana handler to calculate on
        ServerWorldEvents.LOAD.register((server, world) -> XanaHandler.setProperties(server,world.getLevelProperties()));
        //saves and loads the inventory for both respawn and joining
        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
            if (MethodUtil.DimensionCheck.playerInVanilla(newPlayer)) {
                CardinalData.LyokoInventorySave.loadPlayerInventory(
                        newPlayer.server.getSaveProperties().getMainWorldProperties(), newPlayer);
            }
        });
        ServerEntityWorldChangeEvents.AFTER_ENTITY_CHANGE_WORLD.register((originalEntity, newEntity, origin, destination) -> {
            if(originalEntity instanceof SkidbladnirEntity && newEntity instanceof SkidbladnirEntity)
            {
                if(destination.getRegistryKey().equals(ModDimensions.digitalOceanWorld))
                {
                    final BlockPos retrievedLyokoPosition = CardinalData.SkidBladnirNavData.getLyokoPosition(newEntity);
                    if(retrievedLyokoPosition == null || retrievedLyokoPosition == BlockPos.ORIGIN) {
                        CardinalData.SkidBladnirNavData.setLyokoPosition(newEntity, newEntity.getBlockPos());
                    }
                }
            }
        });
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
            for (final ServerWorld world : server.getWorlds())
            {
              for(final ServerTriplicateCloneEntity entity : world.getEntitiesByType(ModEntities.TRIPLICATE_ENTITY_TYPE, ServerTriplicateCloneEntity::hasOwner))
              {
                  if(handler.getPlayer().equals(entity.getOwner()))
                  {
                      entity.remove(Entity.RemovalReason.DISCARDED);
                  }
              }
            }

        });
        ServerLivingEntityEvents.AFTER_DEATH.register(PlayerAfterDeathEvent::consume);
        ServerTickEvents.END_WORLD_TICK.register(PlayerEnteredServerWorldEvent::consume);
        ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register((player, origin, destination) -> {
            if (player != null) {
                if (MethodUtil.DimensionCheck.isWorldLyoko(destination)) {
                    CardinalData.LyokoInventorySave.savePlayerInventory(
                            player.server.getSaveProperties().getMainWorldProperties(), player);

                    player.incrementStat(ModStats.ENTERED_LYOKO_IDENTIFIER);
                    if(CardinalData.PlayerSavedProfile.getPlayerProfile(Objects.requireNonNull(player.getServer()).getSaveProperties().getMainWorldProperties(), player) != null) {
                        CardinalData.PlayerSavedProfile.getPlayerProfile(
                                        player.getServer().getSaveProperties().getMainWorldProperties(), player)
                                .incrementEntered();
                    }
                    //ModCustomTrackedCriteria.ENTERED_LYOKO.trigger(player,destination);
                } else if (MethodUtil.DimensionCheck.isWorldLyoko(origin)) {
                    CardinalData.LyokoInventorySave.loadPlayerInventory(
                            player.server.getSaveProperties().getMainWorldProperties(), player);
                }

            }

        });
        XanaHandler.setTicksToNextCalculation(1);
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {

            if (MethodUtil.DimensionCheck.isPlayerInLyoko(player) && !player.isCreative()) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;

        });
        //gives the player the first entry into the story
        ServerEntityEvents.ENTITY_LOAD.register(EntityLoadServerEvent::consume);


        //xana

        ServerTickEvents.START_WORLD_TICK.register(StartWorldTickServerWorldEvent::consume);


        //prevents the player from losing EXP
        ServerPlayerEvents.COPY_FROM.register((oldPlayer, newPlayer, alive) -> {

            if (MethodUtil.DimensionCheck.isPlayerInLyoko(oldPlayer)) {
                newPlayer.experienceLevel = oldPlayer.experienceLevel;
                //CardinalData.CellularDamage.getCellComponentKey().get(newPlayer).copyFrom(CardinalData.CellularDamage.getCellComponentKey().get(oldPlayer));
            }
        });
        //regenerates the player's digital energy
        ServerTickEvents.END_SERVER_TICK.register(RegeneratePlayerEnergyServerEvent::consume);
    }

    public static void registerFuels() {
        Object2ObjectMaps.fastForEach(ModFuels.FUEL_MAP,itemConvertibleIntegerEntry -> FuelRegistry.INSTANCE.add(itemConvertibleIntegerEntry.getKey(),itemConvertibleIntegerEntry.getValue()));
    }
    @Override
    public void onInitialize() {

        PacketHandler.commonPayloadRegistry();
        generalRegistration();
        registerFuels();
        ModRecipes.RecipeTypes.init();
        ModRecipes.RecipeSerializers.init();
        ModCustomTrackedCriteria.init();
        SetupFunctions();
        registerDefaultAttributes();
        registerEnergyStorageBE();
        checkWorld();
        LootTableOverride.modifyLootTables();
    }


}
