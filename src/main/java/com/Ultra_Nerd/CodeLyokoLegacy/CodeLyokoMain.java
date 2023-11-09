package com.Ultra_Nerd.CodeLyokoLegacy;


import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.SuperCalculatorEntities.ComputerCoreTileEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.MegaTankEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass.ServerTriplicateCloneEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.EntitySkid;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.init.*;
import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerProfile;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.LootTableOverride;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ThreadUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.MultiBlockController;
import com.Ultra_Nerd.CodeLyokoLegacy.util.event.server.PlaceBlockEvent;
import com.Ultra_Nerd.CodeLyokoLegacy.util.handlers.XanaHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage.CarthageGenerator;
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
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
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
        return new Identifier(MOD_ID, name);
    }

    private static void registerEnergyStorageBE() {
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.getEnergyImplementation(),
                ModBlockEntities.UNIVERSAL_ENERGY_STORAGE);
    }


    private static void checkWorld() {
        PlaceBlockEvent.EVENT.register(((entity, world, pos) -> {

                ThreadUtil.SMALL_TASK_THREAD_EXECUTOR.execute(() -> {
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
                });

            return ActionResult.PASS;
        }));


        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            ThreadUtil.SMALL_TASK_THREAD_EXECUTOR.execute(() -> {
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

        });
        PlaceBlockEvent.EVENT.register((entity, world, pos) -> {
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
        Registry.register(Registries.CHUNK_GENERATOR, codeLyokoPrefix("carthage_chunkgen"),
                CarthageGenerator.CARTHAGE_GENERATOR_CODEC);
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
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                RegistryKey.of(RegistryKeys.BIOME, ModBiomes.RegisteredBiomes.FOREST_SECTOR.getIdentifier())),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, codeLyokoPrefix("lyoko_forest_tree")));
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        RegistryKey.of(RegistryKeys.BIOME, ModBiomes.RegisteredBiomes.VOLCANO.getIdentifier())),
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
            if(originalEntity instanceof EntitySkid && newEntity instanceof EntitySkid)
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
        ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register((player, origin, destination) -> {
            if (player != null) {
                if (MethodUtil.DimensionCheck.worldIsNotVanilla(destination)) {
                    CardinalData.LyokoInventorySave.savePlayerInventory(
                            player.server.getSaveProperties().getMainWorldProperties(), player);

                    player.incrementStat(ModStats.ENTERED_LYOKO_IDENTIFIER);
                    if(CardinalData.PlayerSavedProfile.getPlayerProfile(player.getServer().getSaveProperties().getMainWorldProperties(), player) != null) {
                        CardinalData.PlayerSavedProfile.getPlayerProfile(
                                        player.getServer().getSaveProperties().getMainWorldProperties(), player)
                                .incrementEntered();
                    }
                    ModCustomTrackedCriteria.ENTERED_LYOKO.trigger(player,destination);
                } else if (MethodUtil.DimensionCheck.worldIsNotVanilla(origin)) {
                    CardinalData.LyokoInventorySave.loadPlayerInventory(
                            player.server.getSaveProperties().getMainWorldProperties(), player);
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
        ServerEntityEvents.ENTITY_LOAD.register((entity,world) -> {
            if(entity instanceof final ServerPlayerEntity player)
            {
            CardinalData.PlayerSavedProfile.saveProfile(world.getServer().getSaveProperties().getMainWorldProperties(),player);
            final PlayerProfile updatedProfile =
                    CardinalData.PlayerSavedProfile.getPlayerProfile(world.getServer().getSaveProperties().getMainWorldProperties(), player);
            if(!updatedProfile.getFirstJoin()) {
                //CodeLyokoMain.LOG.info("updating first join");
                final PlayerInventory tmpInventory = player.getInventory();
                if(tmpInventory.getEmptySlot() != -1) {
                    tmpInventory.setStack(tmpInventory.getEmptySlot(), new ItemStack(ModItems.STORY_BOOK));
                }
                updatedProfile.setFirstJoin(true);
                //CodeLyokoMain.LOG.info(String.valueOf(updatedProfile.getFirstJoin()));
                CardinalData.PlayerSavedProfile.updateProfile(world.getServer().getSaveProperties().getMainWorldProperties(), updatedProfile);
                }
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


            } else {

                serverPlayerEntity.getAbilities().allowModifyWorld = true;

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
                if((world.getTicks() >> 3) % 5 == 0 && !CardinalData.DigitalEnergyComponent.isUsingEnergy(player)) {
                    CardinalData.DigitalEnergyComponent.regenerateEnergy(player);
                }
            }

        });
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
            if(entity instanceof final ServerTriplicateCloneEntity triplicateClone)
            {
                CardinalData.LyokoClass.ExtraClassData.SamuraiData.removeClone(triplicateClone.getOwner());
                triplicateClone.getOwner().sendMessage(Text.translatable("triplicate.clone.died"));
            }
        });
    }

    public static void registerFuels()
    {
        ModFuels.FUEL_MAP.forEach(FuelRegistry.INSTANCE::add);
    }
    @Override
    public void onInitialize() {
        ConstantUtil.StoryEntry.init();
        GeckoLib.initialize();
        PacketHandler.commonChannelRegistry();
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
