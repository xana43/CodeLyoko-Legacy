package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetLootTableLootFunction;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public final class LootTables extends FabricBlockLootTableProvider  {
    public LootTables(final FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables() {
        ModBlocks.BLOCK_MAP.values().forEach(block -> {
            if(block != ModBlocks.SILICA_SAND) {
                addDrop(block);
                //addDropWithSilkTouch(block);

            }
            else if(block == ModBlocks.SILICA_SAND)
            {
               addDrop(block,dropsWithSilkTouch(block, applyExplosionDecay(block, ItemEntry.builder(ModItems.RAW_SILICADUST).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 5.0F))).apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE)))));
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
