package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public final class ModelGenerator extends FabricModelProvider {


    public ModelGenerator(final FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(final BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(final ItemModelGenerator itemModelGenerator) {

    }
}
