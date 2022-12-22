package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBiome;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFeature;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.concurrent.CompletableFuture;

public final class WorldProvider extends FabricDynamicRegistryProvider {
    public WorldProvider(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup registries, final Entries entries) {
        final RegistryWrapper.Impl<Biome> biomeRegistry = registries.getWrapperOrThrow(RegistryKeys.BIOME);
        ModBiome.BIOME_MAP.forEach((s, biome) -> {
            final RegistryKey<Biome> biomeRegistryKey = RegistryKey.of(RegistryKeys.BIOME,
                    CodeLyokoMain.codeLyokoPrefix(s));
            entries.add(biomeRegistryKey,biomeRegistry.getOrThrow(biomeRegistryKey).value());



        });
        //final RegistryWrapper.Impl<ConfiguredFeature<?,?>> configuredFeatureRegistry =
          //      registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE);
        //tree features
        ModFeature.CONFIGURED_TREE_IMMUTABLE_MAP.forEach((s, builderPlacedFeaturePair) -> {
            final RegistryKey<ConfiguredFeature<?,?>> configuredFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, CodeLyokoMain.codeLyokoPrefix(s));
            entries.add(configuredFeatureRegistryKey, new ConfiguredFeature<>(Feature.TREE,builderPlacedFeaturePair.getLeft()
                    .build()));
        });
        ModFeature.CONFIGURED_TREE_IMMUTABLE_MAP.forEach((s, builderPlacedFeaturePair) -> {
            final RegistryKey<PlacedFeature> placedFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.PLACED_FEATURE, CodeLyokoMain.codeLyokoPrefix(s));
            entries.add(placedFeatureRegistryKey,builderPlacedFeaturePair.getRight());
        });
        //ore Features
        ModFeature.ORE_IMMUTABLE_MAP.forEach((s, builderPlacedFeaturePair) -> {
            final RegistryKey<ConfiguredFeature<?,?>> configuredFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, CodeLyokoMain.codeLyokoPrefix(s));
            entries.add(configuredFeatureRegistryKey, builderPlacedFeaturePair.getLeft());
        });
        ModFeature.ORE_IMMUTABLE_MAP.forEach((s, builderPlacedFeaturePair) -> {
            final RegistryKey<PlacedFeature> configuredFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.PLACED_FEATURE, CodeLyokoMain.codeLyokoPrefix(s));
            entries.add(configuredFeatureRegistryKey, builderPlacedFeaturePair.getRight());
        });
        //misc features
        ModFeature.MISC_IMMUTABLE_MAP.forEach((s, configuredFeaturePlacedFeaturePair) -> {
            final RegistryKey<ConfiguredFeature<?,?>> configuredFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,CodeLyokoMain.codeLyokoPrefix(s));
            entries.add(configuredFeatureRegistryKey,configuredFeaturePlacedFeaturePair.getLeft());
        });
        ModFeature.MISC_IMMUTABLE_MAP.forEach((s, configuredFeaturePlacedFeaturePair) -> {
            final RegistryKey<PlacedFeature> configuredFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.PLACED_FEATURE,CodeLyokoMain.codeLyokoPrefix(s));
            entries.add(configuredFeatureRegistryKey,configuredFeaturePlacedFeaturePair.getRight());
        });
    }

    @Override
    public String getName() {
        return null;
    }
}
