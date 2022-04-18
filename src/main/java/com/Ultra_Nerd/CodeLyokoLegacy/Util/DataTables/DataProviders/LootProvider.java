package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables.DataProviders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public abstract class LootProvider extends LootTableProvider {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson JSONDATA = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    protected final HashMap<Block, LootTable.Builder>  dataMap = new HashMap<>();
    private final DataGenerator dataGenerator;
    public LootProvider(final DataGenerator pGenerator) {
        super(pGenerator);
        this.dataGenerator = pGenerator;
    }


    protected abstract void addTables();
    protected LootTable.Builder createOriginalLootTable(String name, Block block, BlockEntityType<?> entityType)
    {
       final LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(block)
                        .apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY))
                        .apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY)
                                .copy("Info","BlockEntityTag.Info", CopyNbtFunction.MergeStrategy.REPLACE)
                                .copy("Inventory", "BlockEntityTag.Inventory", CopyNbtFunction.MergeStrategy.REPLACE)
                                .copy("Energy","BlockEntityTag.Energy", CopyNbtFunction.MergeStrategy.REPLACE)

                        ).apply(SetContainerContents.setContents(entityType)
                                .withEntry(DynamicLoot.dynamicEntry(new ResourceLocation("minecraft","contents")))));
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder silkTable(String name, Block block, Item droppedItem, float min, float max)
    {
       final LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantValue.exactly(1))
                .add(AlternativesEntry.alternatives(
                        LootItem.lootTableItem(block)
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                        .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))),
                        LootItem.lootTableItem(droppedItem)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min,max)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE,1))
                                .apply(ApplyExplosionDecay.explosionDecay())
                ));
        return LootTable.lootTable().withPool(builder);
    }

    @Override
    public void run(final HashCache pCache) {
        addTables();
        final HashMap<ResourceLocation,LootTable> tables = new HashMap<>();
        for(Map.Entry<Block,LootTable.Builder> entry : dataMap.entrySet())
        {
            tables.put(entry.getKey().getLootTable(),entry.getValue().setParamSet(LootContextParamSets.BLOCK).build());
        }

        writeToTable(pCache,tables);

    }
    protected LootTable.Builder createBlockTabe(String name, Block block)
    {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(block));
        return LootTable.lootTable().withPool(builder);
    }
    private void writeToTable(HashCache cache,HashMap<ResourceLocation,LootTable> tables)
    {
        Path outputFolder = this.dataGenerator.getOutputFolder();
        tables.forEach((resourceLocation, lootTable) -> {
            Path path = outputFolder.resolve("data/" + resourceLocation.getNamespace() + "/loot_tables/" + resourceLocation.getPath() + ".json");
            try
            {
                DataProvider.save(JSONDATA,cache, LootTables.serialize(lootTable),path);
            }
            catch (IOException e)
            {
                LOGGER.error("Couldn't create loot table {}", path,e);
            }
        });
    }

    @Override
    public String getName() {
        return "Codelyoko LootTables";
    }
}
