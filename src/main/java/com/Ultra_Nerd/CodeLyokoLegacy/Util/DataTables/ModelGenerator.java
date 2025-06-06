package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import com.google.common.collect.ImmutableMap;
import dev.felnull.specialmodelloader.api.data.SpecialModelDataGenHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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
            return item(parent);
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
        public static void registerCustomItemModel(final ItemModelGenerator generator, final Item item,final String model)
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
        blockStateModelGenerator.registerParentedItemModel(ModBlocks.CABLE_BLOCK, CodeLyokoMain.codeLyokoPrefix("block/cable_block"));
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SECTOR_ENTRANCE_DESERT);
        generateObjBlockStateModels(blockStateModelGenerator,ModBlocks.SUPERCOMPUTER_INTERFACE,"models/block/interface_sc");
        generateCustomBlockModels(blockStateModelGenerator);
        generateFenceLikeModels(blockStateModelGenerator,ModBlocks.IRON_RAILING,"block/railing_post","block/railing_side");
        generateFenceLikeModels(blockStateModelGenerator,ModBlocks.ERODED_IRON_RAILING,"block/eroded_railing_post","block/eroded_railing_side");
        generateFenceLikeModels(blockStateModelGenerator,ModBlocks.TARNISHED_IRON_RAILING,"block/tarnished_railing_post","block/tarnished_railing_side");
        generateFenceLikeModels(blockStateModelGenerator,ModBlocks.RUSTED_IRON_RAILING,"block/rusted_railing_post","block/rusted_railing_side");
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIGITAL_WOOD_FOREST);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIGITAL_WOOD_MOUNTAIN);
        registerFluidStateModels(blockStateModelGenerator, ModBlocks.DIGITAL_OCEAN_BLOCK);
        registerFluidStateModels(blockStateModelGenerator, ModBlocks.DIGITAL_LAVA_BLOCK);
    }

    private static void registerFluidStateModels(final BlockStateModelGenerator generator, final Block fluidBlock)
    {
        final Identifier modelId = ModelIds.getBlockModelId(fluidBlock);
        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(fluidBlock).coordinate(
                        BlockStateVariantMap.create(Properties.LEVEL_15)
                                .register(level -> BlockStateVariant.create().put(VariantSettings.MODEL,modelId))

                )
        );
    }
    private static void generateObjBlockStateModels(final BlockStateModelGenerator blockStateModelGenerator, final Block block, final String model){
        Identifier parsedModel;
        if(model.contains(".obj"))
        {
            parsedModel = CodeLyokoMain.codeLyokoPrefix(model);
        }
        else{
            parsedModel = CodeLyokoMain.codeLyokoPrefix(model+".obj");
        }
        SpecialModelDataGenHelper.generateObjModel(
                block,
                parsedModel,
                false,
                true,
                null,
                ImmutableMap.of(),
                null,
                blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(
            BlockStateModelGenerator.createSingletonBlockState(block, ModelIds.getBlockModelId(block))
        );
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
    private static void generateCustomItemModels(final ItemModelGenerator itemModelGenerator)
    {
        
    }
    private static void generateCustomBlockModels(final BlockStateModelGenerator blockStateModelGenerator){

    }
    private static void generateObjItemModel(final ItemModelGenerator itemModelGenerator,final Item item, final String model)
    {
        if(Items.AIR.equals(item))
        {
            return;
        }
        Identifier parsedModel;
        if(model.contains(".obj"))
        {
            parsedModel = CodeLyokoMain.codeLyokoPrefix(model);
        }
        else{
            parsedModel = CodeLyokoMain.codeLyokoPrefix(model+".obj");
        }
        SpecialModelDataGenHelper.generateObjModel(item,
                parsedModel,
                false,
                true,
                null,
                ImmutableMap.of(),
                null,
                itemModelGenerator.writer
                );
    }
    @Override
    public void generateItemModels(final ItemModelGenerator itemModelGenerator) {
       generateDefaultBuckets(itemModelGenerator);
       generateCustomItemModels(itemModelGenerator);
       generateObjItemModel(itemModelGenerator,ModBlocks.SUPERCOMPUTER_INTERFACE.asItem(),"models/block/interface_sc");
    }
}
