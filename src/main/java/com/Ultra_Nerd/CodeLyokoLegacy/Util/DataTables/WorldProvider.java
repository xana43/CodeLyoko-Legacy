package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBiomes;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFeature;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.ObjectObjectImmutablePair;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
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
            final RegistryKey<PlacedFeature> placedFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.PLACED_FEATURE, CodeLyokoMain.codeLyokoPrefix(stringObjectObjectImmutablePairEntry.getKey()));
            entries.add(placedFeatureRegistryKey,stringObjectObjectImmutablePairEntry.getValue().right());
        });

        registerStandardFeature(ModFeature.ORE_IMMUTABLE_MAP,entries);
        registerStandardFeature(ModFeature.MISC_IMMUTABLE_MAP,entries);

    }
    private static <K extends Object2ObjectMap<String, ObjectObjectImmutablePair<ConfiguredFeature<?,?>,PlacedFeature>>> void registerStandardFeature(final K map, final Entries entries) {
        Object2ObjectMaps.fastForEach(map,stringObjectObjectImmutablePairEntry -> {
            final Identifier registeredKeyIdentifier = CodeLyokoMain.codeLyokoPrefix(stringObjectObjectImmutablePairEntry.getKey());
            final RegistryKey<ConfiguredFeature<?,?>> configuredFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,registeredKeyIdentifier);
            entries.add(configuredFeatureRegistryKey,stringObjectObjectImmutablePairEntry.getValue().left());
            final RegistryKey<PlacedFeature> placedFeatureRegistryKey =
                    RegistryKey.of(RegistryKeys.PLACED_FEATURE,registeredKeyIdentifier);
            entries.add(placedFeatureRegistryKey,stringObjectObjectImmutablePairEntry.getValue().right());
        });
    }
    @Override
    public String getName() {
        return "world provider";
    }
}
