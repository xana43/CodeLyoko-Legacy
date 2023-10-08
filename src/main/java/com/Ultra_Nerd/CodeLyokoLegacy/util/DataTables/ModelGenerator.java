package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.item.Item;

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
    }
    private static final Item[] defaultBuckets = {ModItems.LIQUID_HELIUM_BUCKET};

    @Override
    public void generateItemModels(final ItemModelGenerator itemModelGenerator) {
        for(final Item item : defaultBuckets)
        {
            ModelMethods.registerDefaultBucketItem(itemModelGenerator,item);
        }

    }
}
