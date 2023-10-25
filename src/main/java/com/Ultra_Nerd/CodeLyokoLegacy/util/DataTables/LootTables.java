package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;

public final class LootTables extends FabricBlockLootTableProvider {


    public LootTables(final FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        Registries.BLOCK.forEach(block -> {
            if(Registries.BLOCK.getId(block).getNamespace().equals(CodeLyokoMain.MOD_ID))
            {
                if (block != ModBlocks.SILICA_SAND) {
                    addDrop(block);

                } else {
                    addDrop(block, dropsWithSilkTouch(block, applyExplosionDecay(block,
                            ItemEntry.builder(ModItems.RAW_SILICADUST)
                                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 5.0F)))
                                    .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE)))));
                }
            }
        });

    }

}
