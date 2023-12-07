package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public final class CustomItemTags extends FabricTagProvider.ItemTagProvider {


    public CustomItemTags(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup arg) {

        final Block[] commonUraniumOres = {
                ModBlocks.AUTUNITE_ORE,
                ModBlocks.BORNITE_ORE,
                ModBlocks.CARNOTITE_ORE,
                ModBlocks.CHALCOCITE_ORE,
                ModBlocks.CHALCOPYRITE_ORE,
                ModBlocks.COFFINITE_ORE,
                ModBlocks.COVELLITE_ORE,
                ModBlocks.GUMMITE_ORE,
                ModBlocks.METAAUTUNITE_ORE,
                ModBlocks.METATORBERNITE_ORE,
                ModBlocks.METATYUYAMUNITE_ORE,
                ModBlocks.SALEEITE_ORE,
                ModBlocks.SKLODOWSKITE_ORE,
                ModBlocks.TORBERNITE_ORE,
                ModBlocks.TYUYAMUNITE_ORE,
                ModBlocks.URANINITE_ORE,
                ModBlocks.URANOPHANE_ORE,
        };
        for (final Block block: commonUraniumOres)
        {
            getOrCreateTagBuilder(ModTags.ItemTags.URANIUM_ORE_TAG).add(block.asItem());
            getOrCreateTagBuilder(ModTags.ItemTags.URANIUM_ORES_TAG).add(block.asItem());
            getOrCreateTagBuilder(ModTags.ItemTags.COMMON_ORES).add(block.asItem());
        }

        final Block[] commonLeaves = {
                ModBlocks.DIGITAL_LEAF_MOUNTAIN
        };
        for (final Block block : commonLeaves)
        {
            getOrCreateTagBuilder(ItemTags.LEAVES).add(block.asItem());
            getOrCreateTagBuilder(ModTags.ItemTags.COMMON_LEAVES).add(block.asItem());
        }
        getOrCreateTagBuilder(ItemTags.CHERRY_LOGS).add(ModBlocks.DIGITAL_WOOD_MOUNTAIN.asItem());
        getOrCreateTagBuilder(ItemTags.JUNGLE_LOGS).add(ModBlocks.DIGITAL_WOOD_FOREST.asItem());
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS).add(ModItems.LYOKO_THEME,ModItems.LYOKO_THEME_INSTRUMENTAL);
        getOrCreateTagBuilder(ItemTags.SAND).add(ModBlocks.SILICA_SAND.asItem());
        getOrCreateTagBuilder(ModTags.ItemTags.LYOKO_ITEM).add(ModItems.HOVERBOARD_SPAWN_ITEM,ModItems.OVERBOARD_SPAWN_ITEM);
        getOrCreateTagBuilder(ModTags.ItemTags.URANIUM_BATTERIES).add(ModItems.URANIUM_BATTERY_STARTER,
                ModItems.URANIUM_BATTERY_NOVICE,ModItems.URANIUM_BATTERY_FINAL);
        getOrCreateTagBuilder(ModTags.ItemTags.URANIUM_235_INGOTS).add(ModItems.URANIUM_ISOTOPE235);
        getOrCreateTagBuilder(ModTags.ItemTags.URANIUM_238_INGOTS).add(ModItems.URANIUM_ISOTOPE238);
        getOrCreateTagBuilder(ModTags.ItemTags.COMMON_SILICON_PLATES).add(ModItems.SILICON_WAFER);

    }

}
