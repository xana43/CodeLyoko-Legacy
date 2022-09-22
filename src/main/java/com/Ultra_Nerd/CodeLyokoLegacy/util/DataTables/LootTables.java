package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public final class LootTables extends FabricBlockLootTableProvider {
    public LootTables(final FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables() {
        ModBlocks.BLOCK_MAP.values().forEach(block -> {
            if (block != ModBlocks.SILICA_SAND) {
                addDrop(block);
                //addDropWithSilkTouch(block);

            } else if (block == ModBlocks.SILICA_SAND) {
                addDrop(block, dropsWithSilkTouch(block, applyExplosionDecay(block, ItemEntry.builder(ModItems.RAW_SILICADUST).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 5.0F))).apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE)))));
            }
        });
    }










/*
    @Override
    protected void addTables() {
        dataMap.put(ModBlocks.BORNITE_ORE.get(), createBlockTabe("bornite_ore",ModBlocks.BORNITE_ORE.get()));

    }

 */
}
