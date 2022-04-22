package com.Ultra_Nerd.CodeLyokoLegacy;


import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityBlok;
import com.Ultra_Nerd.CodeLyokoLegacy.init.*;
import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;


public record CodeLyokoMain() implements ModInitializer {
    private static final Logger LOG = LogUtils.getLogger();
    public static final String MOD_ID = "cm";
    public static final ItemGroup LYOKO_ITEM = FabricItemGroupBuilder.build(new Identifier(MOD_ID,"lyoko_items"),() -> new ItemStack(ModItems.BIT));
    public static final ItemGroup LYOKO_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID,"lyoko_blocks"), () -> new ItemStack(ModBlocks.TOWER_INTERFACE));
    public static final ItemGroup LYOKO_ARMOR = FabricItemGroupBuilder.build(CodeLyokoPrefix("lyoko_armor"), ()->new ItemStack(ModItems.WILLIAM_CHESTPLATE));

    public static Identifier CodeLyokoPrefix(String name)
    {
        return new Identifier(MOD_ID,name);
    }

    public CodeLyokoMain
    {


        ModTileEntities.registerBlockEntities();
        ModSounds.createSounds();
        ModBiome.loadBiomes();

    }
    @Override
    public void onInitialize() {
        GeckoLib.initialize();
        ModBlocks.BLOCK_MAP.forEach((s, block) -> {
            LOG.info(String.valueOf(block));
            Registry.register(Registry.BLOCK,new Identifier(MOD_ID,s),block);
            if(block != ModBlocks.LYOKO_CORE) {
                Registry.register(Registry.ITEM, new Identifier(MOD_ID, s), new BlockItem(block, new FabricItemSettings().group(LYOKO_BLOCKS)));
            }
        });
        ModItems.ITEM_MAP.forEach((s, item) -> Registry.register(Registry.ITEM,new Identifier(MOD_ID,s),item));
        ModTileEntities.BLOCKENTITY_MAP.forEach((s, blockEntityType) -> Registry.register(Registry.BLOCK_ENTITY_TYPE,CodeLyokoPrefix(s),blockEntityType));
        ModSounds.SOUNDS.forEach(soundEvent -> Registry.register(Registry.SOUND_EVENT,soundEvent.getId(),soundEvent));
        ModBiome.BIOME_MAP.forEach((s, biome) -> Registry.register(BuiltinRegistries.BIOME,CodeLyokoPrefix(s),biome));
        ModEntities.ENTITY_TYPE_HASH_MAP.forEach((s, entityType) -> Registry.register(Registry.ENTITY_TYPE,CodeLyokoPrefix(s),entityType));
        RegisterAttributes();
    }

    private static void RegisterAttributes()
    {
        FabricDefaultAttributeRegistry.register(ModEntities.BLOK, EntityBlok.createMonsterAttributes());
    }



}
