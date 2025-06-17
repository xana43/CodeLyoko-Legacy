package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Sector.SectorEntrance;
import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantWithLevelsLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public final class LootTables extends FabricBlockLootTableProvider {


    public LootTables(final FabricDataOutput dataOutput,final CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput,registryLookup);
    }

    @Override
    public void generate() {
        Registries.BLOCK.forEach(block -> {
            if(Registries.BLOCK.getId(block).getNamespace().equals(CodeLyokoMain.MOD_ID))
            {
                if(!(block instanceof SectorEntrance)) {
                    CodeLyokoMain.LOG.info("attempting to generate loot table for {}",block.getName());
                    if (block != ModBlocks.SILICA_SAND && block.getLootTableKey().isPresent() && block.asItem() != Items.AIR) {
                        addDrop(block);

                    } else if (block == ModBlocks.LAPTOP_BLOCK) {

                        addDrop(block,drops(ModItems.JEREMY_LAPTOP));
                    } else if (block == ModBlocks.SILICA_SAND) {
                        addDrop(block, dropsWithSilkTouch(block, applyExplosionDecay(block,
                                ItemEntry.builder(ModItems.RAW_SILICADUST)
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 5.0F))))));
                                        //.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE)))));
                    }
                }
            }
        });

    }
    public static final class EntityLootTable extends SimpleFabricLootTableProvider
    {

        public EntityLootTable(final FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(output,registryLookup, LootContextTypes.ENTITY);
        }



        @Override
        public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
            lootTableBiConsumer.accept(ModEntities.BLOK.getLootTableKey().orElseThrow(), LootTable.builder()
                    .pool(LootPool.builder().rolls(UniformLootNumberProvider.create(1,3))
                            .with(ItemEntry.builder(ModItems.BIT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1,4)))))
                    .apply(new EnchantWithLevelsLootFunction.Builder(UniformLootNumberProvider.create(20.0f,39.0f))));
        }
    }
}
