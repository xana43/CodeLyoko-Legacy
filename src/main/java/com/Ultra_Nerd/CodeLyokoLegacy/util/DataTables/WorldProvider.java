package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBiomes;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModFeature;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
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
        Object2ObjectMaps.fastForEach(ModBiomes.BIOMES_MAP,stringBiomeEntry -> {
            final RegistryKey<Biome> biomeRegistryKey = RegistryKey.of(RegistryKeys.BIOME,
                    CodeLyokoMain.codeLyokoPrefix(stringBiomeEntry.getKey()));
            entries.add(biomeRegistryKey,biomeRegistry.getOrThrow(biomeRegistryKey).value());
        });
        Object2ObjectMaps.fastForEach(ModFeature.CONFIGURED_TREE_IMMUTABLE_MAP,stringObjectObjectImmutablePairEntry -> {
            final RegistryKey<ConfiguredFeature<?,?>> configuredFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, CodeLyokoMain.codeLyokoPrefix(stringObjectObjectImmutablePairEntry.getKey()));
            entries.add(configuredFeatureRegistryKey, new ConfiguredFeature<>(Feature.TREE,stringObjectObjectImmutablePairEntry.getValue().left()
                    .build()));
        });
        Object2ObjectMaps.fastForEach(ModFeature.CONFIGURED_TREE_IMMUTABLE_MAP,stringObjectObjectImmutablePairEntry -> {
            final RegistryKey<PlacedFeature> placedFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.PLACED_FEATURE, CodeLyokoMain.codeLyokoPrefix(stringObjectObjectImmutablePairEntry.getKey()));
            entries.add(placedFeatureRegistryKey,stringObjectObjectImmutablePairEntry.getValue().right());
        });
        //ore Features
        Object2ObjectMaps.fastForEach(ModFeature.ORE_IMMUTABLE_MAP,stringObjectObjectImmutablePairEntry -> {
            final RegistryKey<ConfiguredFeature<?,?>> configuredFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, CodeLyokoMain.codeLyokoPrefix(stringObjectObjectImmutablePairEntry.getKey()));
            entries.add(configuredFeatureRegistryKey, stringObjectObjectImmutablePairEntry.getValue().left());
        });
        Object2ObjectMaps.fastForEach(ModFeature.ORE_IMMUTABLE_MAP,stringObjectObjectImmutablePairEntry -> {
            final RegistryKey<PlacedFeature> configuredFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.PLACED_FEATURE, CodeLyokoMain.codeLyokoPrefix(stringObjectObjectImmutablePairEntry.getKey()));
            entries.add(configuredFeatureRegistryKey, stringObjectObjectImmutablePairEntry.getValue().right());
        });
        //misc features
        Object2ObjectMaps.fastForEach(ModFeature.MISC_IMMUTABLE_MAP,stringObjectObjectImmutablePairEntry -> {
            final RegistryKey<ConfiguredFeature<?,?>> configuredFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,CodeLyokoMain.codeLyokoPrefix(stringObjectObjectImmutablePairEntry.getKey()));
            entries.add(configuredFeatureRegistryKey,stringObjectObjectImmutablePairEntry.getValue().left());
        });
        Object2ObjectMaps.fastForEach(ModFeature.MISC_IMMUTABLE_MAP,stringObjectObjectImmutablePairEntry -> {
            final RegistryKey<PlacedFeature> configuredFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.PLACED_FEATURE,CodeLyokoMain.codeLyokoPrefix(stringObjectObjectImmutablePairEntry.getKey()));
            entries.add(configuredFeatureRegistryKey,stringObjectObjectImmutablePairEntry.getValue().right());
        });
    }

    @Override
    public String getName() {
        return "world provider";
    }
}
