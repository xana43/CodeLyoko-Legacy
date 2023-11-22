package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;

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
        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(ModBlocks.IRON_RAILING)
                        .with(BlockStateVariant.create().put(VariantSettings.MODEL,CodeLyokoMain.codeLyokoPrefix("block/railing_post")))
                .with(When.create().set(Properties.NORTH,true),BlockStateVariant.create().put(VariantSettings.UVLOCK,true).put(VariantSettings.MODEL,CodeLyokoMain.codeLyokoPrefix("block/railing_side")))
                .with(When.create().set(Properties.EAST,true),BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK,true).put(VariantSettings.MODEL,CodeLyokoMain.codeLyokoPrefix("block/railing_side")))
                .with(When.create().set(Properties.SOUTH,true),BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK,true).put(VariantSettings.MODEL,CodeLyokoMain.codeLyokoPrefix("block/railing_side")))
                .with(When.create().set(Properties.WEST,true),BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK,true).put(VariantSettings.MODEL,CodeLyokoMain.codeLyokoPrefix("block/railing_side"))));
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
