package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.DataProviders;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBiome;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFeature;
import com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.impl.datagen.FabricDataGenHelper;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import org.spongepowered.asm.mixin.Final;


public record Generator() implements DataGeneratorEntrypoint {
    private static FabricDataGenerator.Pack pack;
    @Override
    public void onInitializeDataGenerator(final FabricDataGenerator fabricDataGenerator) {
        //fabricDataGenerator..(LootTables::new);
        //fabricDataGenerator.addProvider(CustomBlockTags::new);
        //fabricDataGenerator.addProvider(CustomRecipeProvider::new);
        //fabricDataGenerator.addProvider(CustomItemTags::new);
        //fabricDataGenerator.addProvider(BlockStateSimple::new);
        pack = fabricDataGenerator.createPack();
        pack.addProvider(LootTables::new);
        pack.addProvider(CustomRecipeProvider::new);
        pack.addProvider(CustomBlockTags::new);
        pack.addProvider(CustomItemTags::new);
        pack.addProvider(WorldProvider::new);
        //pack.addProvider(BlockStateSimple::new);
    }

    @Override
    public void buildRegistry(final RegistryBuilder registryBuilder) {
        CodeLyokoMain.LOG.info("registering Biomes");
        registryBuilder.addRegistry(RegistryKeys.BIOME,ModBiome::bootStrap);
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModFeature::bootStrap);
    }
}
