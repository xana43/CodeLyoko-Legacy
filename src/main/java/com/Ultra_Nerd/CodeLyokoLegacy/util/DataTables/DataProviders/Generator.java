package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.DataProviders;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBiome;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFeature;
import com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.CustomBlockTags;
import com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.CustomItemTags;
import com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.LootTables;
import com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.WorldProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;


public record Generator() implements DataGeneratorEntrypoint {
    private static FabricDataGenerator.Pack pack;
    @Override
    public void onInitializeDataGenerator(final FabricDataGenerator fabricDataGenerator) {
        pack = fabricDataGenerator.createPack();
        pack.addProvider(LootTables::new);
        pack.addProvider(CustomRecipeProvider::new);
        pack.addProvider(CustomBlockTags::new);
        pack.addProvider(CustomItemTags::new);
        pack.addProvider(WorldProvider::new);

    }

    @Override
    public void buildRegistry(final RegistryBuilder registryBuilder) {
        //CodeLyokoMain.LOG.info("registering Biomes");
        registryBuilder.addRegistry(RegistryKeys.BIOME,ModBiome::bootStrap);
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModFeature::bootStrap);
    }
}
