package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record LootTableOverride() {
    private static final Identifier SUS_SAND_DESERT_ID = new Identifier("minecraft","archaeology/desert_pyramid");
    private static final Identifier JUNGLE_TEMPLE_ID = new Identifier("minecraft","chests/jungle_temple");
    public static void modifyLootTables()
    {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(JUNGLE_TEMPLE_ID.equals(id))
            {
                final LootPool.Builder poolBuilder = LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1))
                        .with(ItemEntry.builder(ModItems.STORY_BOOK2))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1,1)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if(SUS_SAND_DESERT_ID.equals(id))
            {
                final List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                entries.add(ItemEntry.builder(ModItems.STORY_BOOK).build());
                final LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }
            return null;
        });
    }
}
