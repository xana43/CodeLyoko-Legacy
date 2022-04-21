package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables.DataProviders;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.LootTableProvider;

public abstract class LootProvider extends LootTableProvider {
    public LootProvider(final DataGenerator root) {
        super(root);
    }
    /*
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

     */
}
