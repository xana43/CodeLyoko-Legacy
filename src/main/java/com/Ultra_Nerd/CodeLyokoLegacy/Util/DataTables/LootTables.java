package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetLootTableLootFunction;

public final class LootTables extends FabricBlockLootTableProvider  {
    public LootTables(final FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables() {
        ModBlocks.BLOCK_MAP.values().forEach(block -> {

            addDrop(block);
            addDropWithSilkTouch(block);

        });
    }










/*
    @Override
    protected void addTables() {
        dataMap.put(ModBlocks.BORNITE_ORE.get(), createBlockTabe("bornite_ore",ModBlocks.BORNITE_ORE.get()));

    }

 */
}
