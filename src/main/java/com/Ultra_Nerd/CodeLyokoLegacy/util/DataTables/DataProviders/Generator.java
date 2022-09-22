package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.DataProviders;

import com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.BlockStateSimple;
import com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.CustomBlockTags;
import com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.CustomItemTags;
import com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.LootTables;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;


public record Generator() implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(final FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(LootTables::new);
        fabricDataGenerator.addProvider(CustomBlockTags::new);
        fabricDataGenerator.addProvider(CustomRecipeProvider::new);
        fabricDataGenerator.addProvider(CustomItemTags::new);
        fabricDataGenerator.addProvider(BlockStateSimple::new);
    }


}
