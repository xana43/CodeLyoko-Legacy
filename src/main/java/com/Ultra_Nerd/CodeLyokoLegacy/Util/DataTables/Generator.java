package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBiomes;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFeature;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModRecipes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public record Generator() implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(final FabricDataGenerator fabricDataGenerator) {
        final FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        CodeLyokoMain.registerFuels();
        ModRecipes.RecipeTypes.init();
        ModRecipes.RecipeSerializers.init();
        pack.addProvider(LootTables::new);
        pack.addProvider(CustomRecipeProvider::new);
        pack.addProvider(CustomBlockTags::new);
        pack.addProvider(CustomItemTags::new);
        pack.addProvider(WorldProvider::new);
        pack.addProvider(CustomFluidTags::new);
        pack.addProvider(CustomEntityTags::new);
        pack.addProvider(LanguageGenerators.EnglishProvider::new);
        pack.addProvider(LanguageGenerators.FrenchProvider::new);
        pack.addProvider(ModelGenerator::new);
        pack.addProvider(CustomAdvancements::new);
        pack.addProvider(LootTables.EntityLootTable::new);
        pack.addProvider(CustomBiomeTagProvider::new);
    }

    @Override
    public void buildRegistry(final RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootStrap);
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModFeature::bootStrap);
    }
}
