package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFluids;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import com.google.common.collect.ImmutableMap;
import dev.felnull.specialmodelloader.api.data.SpecialModelDataGenHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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
        ModBlocks.BlockStateProvider.generateBlockStateModels(blockStateModelGenerator);
        ModFluids.BlockStateProvider.generateBlockStateModels(blockStateModelGenerator);

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
