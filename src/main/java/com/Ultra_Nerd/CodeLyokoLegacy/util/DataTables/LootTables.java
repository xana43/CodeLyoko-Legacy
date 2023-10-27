package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import java.util.function.BiConsumer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.EnchantWithLevelsLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

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
    public static final class EntityLootTable extends SimpleFabricLootTableProvider
    {

        public EntityLootTable(final FabricDataOutput output) {
            super(output, LootContextTypes.ENTITY);
        }

        @Override
        public void accept(final BiConsumer<Identifier, LootTable.Builder> exporter) {
            exporter.accept(ModEntities.BLOK.getLootTableId(), LootTable.builder()
                            .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(1,3))
                                    .with(ItemEntry.builder(ModItems.BIT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1,4)))))
                    .apply(EnchantWithLevelsLootFunction.builder(UniformLootNumberProvider.create(20.0f,39.0f))));
        }
    }
}
