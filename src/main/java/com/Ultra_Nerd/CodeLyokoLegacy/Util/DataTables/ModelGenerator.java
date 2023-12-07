package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Optional;

public final class ModelGenerator extends FabricModelProvider {

    protected record ModelMethods()
    {
        private static final StringBuilder loopBuilder = new StringBuilder();
        public static Model item(final String parent)
        {
            loopBuilder.setLength(0);
            loopBuilder.append("item/").append(parent);
            return new Model(Optional.of(CodeLyokoMain.codeLyokoPrefix(loopBuilder.toString())),Optional.empty());
        }
        
        public static Model block(final String parent)
        {
            loopBuilder.setLength(0);
            loopBuilder.append("item/").append(parent);
            return new Model(Optional.of(CodeLyokoMain.codeLyokoPrefix(loopBuilder.toString())),Optional.empty());
        }
        public static void registerDefaultBucketItem(final ItemModelGenerator generator, final Item item)
        {
            generator.register(item,item("template_bucket.json"));
        }
        public static void registerBucketItemModel(final ItemModelGenerator generator,final Item item, final String model)
        {

            if(model.contains(".json"))
            {
                generator.register(item,item(model));
            }
            else {
                loopBuilder.setLength(0);
                loopBuilder.append(model).append(".json");
                generator.register(item,item(loopBuilder.toString()));
            }
        }
    }
    public ModelGenerator(final FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(final BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerParentedItemModel(ModBlocks.RACK_CHARGER_BLOCK, CodeLyokoMain.codeLyokoPrefix("block/rack_charger"));
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CABLE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SECTOR_ENTRANCE_DESERT);
        generateFenceLikeModels(blockStateModelGenerator,ModBlocks.IRON_RAILING,"block/railing_post","block/railing_side");
        generateFenceLikeModels(blockStateModelGenerator,ModBlocks.ERODED_IRON_RAILING,"block/eroded_railing_post","block/eroded_railing_side");
        generateFenceLikeModels(blockStateModelGenerator,ModBlocks.TARNISHED_IRON_RAILING,"block/tarnished_railing_post","block/tarnished_railing_side");
        generateFenceLikeModels(blockStateModelGenerator,ModBlocks.RUSTED_IRON_RAILING,"block/rusted_railing_post","block/rusted_railing_side");
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIGITAL_WOOD_FOREST);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIGITAL_WOOD_MOUNTAIN);

    }

private static void generateFenceLikeModels(final BlockStateModelGenerator generator, final Block blockToGenerate,final String postModel, final String sideModel)
{
    final Identifier postIdentifier = CodeLyokoMain.codeLyokoPrefix(postModel);
    final Identifier sideIdentifier = CodeLyokoMain.codeLyokoPrefix(sideModel);
    generator.blockStateCollector.accept(MultipartBlockStateSupplier.create(blockToGenerate)
            .with(BlockStateVariant.create().put(VariantSettings.MODEL,postIdentifier))
            .with(When.create().set(Properties.NORTH,true),BlockStateVariant.create().put(VariantSettings.UVLOCK,true).put(VariantSettings.MODEL,sideIdentifier))
            .with(When.create().set(Properties.EAST,true),BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK,true).put(VariantSettings.MODEL,sideIdentifier))
            .with(When.create().set(Properties.SOUTH,true),BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK,true).put(VariantSettings.MODEL,sideIdentifier))
            .with(When.create().set(Properties.WEST,true),BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK,true).put(VariantSettings.MODEL,sideIdentifier)));
}
    private static void generateDefaultBuckets(final ItemModelGenerator itemModelGenerator)
    {
        final Item[] defaultBuckets = {ModItems.LIQUID_HELIUM_BUCKET};
        for(final Item item : defaultBuckets)
        {
            ModelMethods.registerDefaultBucketItem(itemModelGenerator,item);
        }
    }
    private static void generateItems(final ItemModelGenerator itemModelGenerator)
    {
        final Item[] ModelsGeneratedItems = {
                ModItems.LYOKO_THEME_INSTRUMENTAL
        };
        for (final Item item : ModelsGeneratedItems)
        {
            itemModelGenerator.register(item,Models.GENERATED);
        }
    }
    @Override
    public void generateItemModels(final ItemModelGenerator itemModelGenerator) {
       generateDefaultBuckets(itemModelGenerator);
       generateItems(itemModelGenerator);

    }
}
