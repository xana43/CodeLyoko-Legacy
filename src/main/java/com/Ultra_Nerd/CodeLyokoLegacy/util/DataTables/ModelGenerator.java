package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;

import java.util.Optional;



public final class ModelGenerator extends FabricModelProvider {

    protected record ModelMethods()
    {
        public static Model item(final String parent)
        {
            return new Model(Optional.of(CodeLyokoMain.codeLyokoPrefix("item/"+parent)),Optional.empty());
        }
    }
    public ModelGenerator(final FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(final BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(final ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LIQUID_HELIUM_BUCKET, ModelMethods.item("template_bucket.json"));
    }
}
