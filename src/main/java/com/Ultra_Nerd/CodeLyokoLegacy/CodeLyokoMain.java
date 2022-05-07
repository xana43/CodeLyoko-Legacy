package com.Ultra_Nerd.CodeLyokoLegacy;


import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.DimensionCheck;
import com.Ultra_Nerd.CodeLyokoLegacy.init.*;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.Devirtualized;
import com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage.CarthageBiomeProvider;
import com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage.CarthageGenerator;
import io.github.ladysnake.locki.DefaultInventoryNodes;
import io.github.ladysnake.locki.InventoryLock;
import io.github.ladysnake.locki.Locki;
import io.github.ladysnake.locki.impl.mixin.PlayerScreenHandlerAccessor;
import io.github.ladysnake.locki.impl.mixin.client.HandledScreenMixin;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.advancement.criterion.ChangedDimensionCriterion;
import net.minecraft.advancement.criterion.OnKilledCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Attachment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.render.entity.feature.Deadmau5FeatureRenderer;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.brain.task.PlayDeadTask;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Difficulty;
import net.minecraft.world.PersistentState;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

import java.util.concurrent.atomic.AtomicReference;


public record CodeLyokoMain() implements ModInitializer {
    public static final InventoryLock LYOKO_LOCK = Locki.registerLock(CodeLyokoPrefix("lyoko_lock"));
    public static final String MOD_ID = "cm";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    public static final ItemGroup LYOKO_ITEM = FabricItemGroupBuilder.build(new Identifier(MOD_ID,"lyoko_items"),() -> new ItemStack(ModItems.BIT));
    public static final ItemGroup LYOKO_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID,"lyoko_blocks"), () -> new ItemStack(ModBlocks.TOWER_INTERFACE));
    public static final ItemGroup LYOKO_ARMOR = FabricItemGroupBuilder.build(CodeLyokoPrefix("lyoko_armor"), ()->new ItemStack(ModItems.WILLIAM_CHESTPLATE));
    public static final ItemGroup LYOKO_WEAPONS = FabricItemGroupBuilder.build(CodeLyokoPrefix("lyoko_weapons"),() -> new ItemStack(ModItems.LASER_ARROWSHOOTER));
    public static Identifier CodeLyokoPrefix(String name)
    {
        return new Identifier(MOD_ID,name);
    }


    @Override
    public void onInitialize() {
        GeckoLib.initialize();

        //Registration

        ModBlocks.BLOCK_MAP.forEach((s, block) -> {

            Registry.register(Registry.BLOCK,new Identifier(MOD_ID,s),block);
            //LOG.info(String.valueOf(block));
            if(block != ModBlocks.LYOKO_CORE && block != ModBlocks.DIGITAL_OCEAN_BLOCK && block != ModBlocks.DIGITAL_LAVA_BLOCK) {
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, s), new BlockItem(block, new FabricItemSettings().group(LYOKO_BLOCKS)));
            }
        });
        ModItems.ITEM_MAP.forEach((s, item) -> Registry.register(Registry.ITEM,new Identifier(MOD_ID,s),item));
        ModTileEntities.BLOCKENTITY_MAP.forEach((s, blockEntityType) -> Registry.register(Registry.BLOCK_ENTITY_TYPE,CodeLyokoPrefix(s),blockEntityType));
        //ModSounds.SOUNDS.forEach(soundEvent -> Registry.register(Registry.SOUND_EVENT,soundEvent.getId(),soundEvent));
        final int size = ModSounds.SOUNDS.size();
        for(int i =0; i < size; i++)
        {
            Registry.register(Registry.SOUND_EVENT, ModSounds.SOUNDS.get(i).getId(),ModSounds.SOUNDS.get(i));
        }
        ModBiome.BIOME_MAP.forEach((s, biome) -> Registry.register(BuiltinRegistries.BIOME,CodeLyokoPrefix(s),biome));
        ModEntities.ENTITY_TYPE_HASH_MAP.forEach((s, entityType) -> Registry.register(Registry.ENTITY_TYPE,CodeLyokoPrefix(s),entityType));
        ModFluids.FLUID_IMMUTABLE_MAP.forEach((s, fluid) ->
                Registry.register(Registry.FLUID,CodeLyokoPrefix(s),fluid));

        ModParticles.PARTICLE_TYPE_IMMUTABLE_MAP.forEach((s, defaultParticleType) -> Registry.register(Registry.PARTICLE_TYPE,CodeLyokoPrefix(s),defaultParticleType));
        //GeneratorTypeAccessor.getValues().add(carthage);
        //Attribute Registration
        FabricDefaultAttributeRegistry.register(ModEntities.BLOK, EntityBlok.createMonsterAttributes());
        //events
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {

            if(DimensionCheck.playerNotInVanillaWorld(player) && !player.isCreative())
            {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;

        });


        Registry.register(Registry.CHUNK_GENERATOR,CodeLyokoPrefix("carthage_chunkgen"), CarthageGenerator.CARTHAGE_GENERATOR_CODEC);
        Registry.register(Registry.BIOME_SOURCE,CodeLyokoPrefix("carthage_biome"), CarthageBiomeProvider.CARTHAGE_BIOME_PROVIDER_CODEC);
        SetupFunctions();
    }
    private static final TrackedData<NbtCompound> peristent = DataTracker.registerData(ServerPlayerEntity.class,TrackedDataHandlerRegistry.NBT_COMPOUND);

    private static void SetupFunctions(){

        final String nbtdat = "first_join";
        final AtomicReference<NbtCompound> t = new AtomicReference<>(new NbtCompound());
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            handler.player.getDataTracker().startTracking(peristent,t.getAcquire());
            if(!handler.player.getDataTracker().get(peristent).contains(nbtdat))
            {
                handler.player.getDataTracker().get(peristent).putBoolean(nbtdat,true);
                handler.player.getInventory().setStack(handler.player.getInventory().getEmptySlot(),new ItemStack(ModItems.STORY_BOOK));

            }
            else
            {

                t.set(handler.player.getDataTracker().get(peristent));
            }





        });
        ServerTickEvents.START_WORLD_TICK.register(world -> world.getPlayers().forEach(serverPlayerEntity -> {

            if(DimensionCheck.playerNotInVanillaWorld(serverPlayerEntity))
            {
                serverPlayerEntity.getHungerManager().setExhaustion(0);
                serverPlayerEntity.getHungerManager().setSaturationLevel(5);
                CodeLyokoMain.LYOKO_LOCK.lock(serverPlayerEntity, DefaultInventoryNodes.CRAFTING);
                //CodeLyokoMain.LYOKO_LOCK.lock(serverPlayerEntity, DefaultInventoryNodes.MAIN_INVENTORY);
            } else if (CodeLyokoMain.LYOKO_LOCK.isLocking(serverPlayerEntity,DefaultInventoryNodes.CRAFTING) /*&& CodeLyokoMain.LYOKO_LOCK.isLocking(serverPlayerEntity,DefaultInventoryNodes.MAIN_INVENTORY)*/) {
                CodeLyokoMain.LYOKO_LOCK.unlock(serverPlayerEntity,DefaultInventoryNodes.CRAFTING);
                //CodeLyokoMain.LYOKO_LOCK.unlock(serverPlayerEntity,DefaultInventoryNodes.MAIN_INVENTORY);
            }


        }));

        ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            if(entity instanceof ItemEntity itemEntity)
            {
                if(DimensionCheck.worldIsNotVanilla(world))
                {
                    itemEntity.kill();
                }
            }


        });

    }







}
