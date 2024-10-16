package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public record LootTableOverride() {
    private static final Identifier SUS_SAND_DESERT_ID = Identifier.of("minecraft","archaeology/desert_pyramid");
    private static final Identifier JUNGLE_TEMPLE_ID = Identifier.of("minecraft","chests/jungle_temple");
    public static void modifyLootTables()
    {
       LootTableEvents.MODIFY.register((key,tableBuilder,source) -> {
            if(JUNGLE_TEMPLE_ID.equals(key.getValue()))
            {
                final LootPool.Builder poolBuilder = LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1))
                        .with(ItemEntry.builder(ModItems.STORY_BOOK2))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1,1)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
       /*LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if(SUS_SAND_DESERT_ID.equals(id))
            {
                final List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pool[0].entries));
                entries.add(ItemEntry.builder(ModItems.STORY_BOOK).build());
                final LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }
            return null;
        });*/
    }
}
