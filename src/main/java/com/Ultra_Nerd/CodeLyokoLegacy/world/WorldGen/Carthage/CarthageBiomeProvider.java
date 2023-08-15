package com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBiome;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CarthageBiomeProvider extends BiomeSource implements BiomeAccess.Storage {
    public static final Codec<CarthageBiomeProvider> CARTHAGE_BIOME_PROVIDER_CODEC = Biome.REGISTRY_CODEC.fieldOf(
            "biome").xmap(CarthageBiomeProvider::new,
            (biomeSource) -> biomeSource.biomeHolder).stable().codec();
    private static final List<RegistryKey<Biome>> SPAWN = Collections.singletonList(
            RegistryKey.of(RegistryKeys.BIOME, ModBiome.RegisteredBiomes.SECTOR5.getIdentifier()));


    private final RegistryEntry<Biome> biomeHolder;

    public CarthageBiomeProvider(@NotNull RegistryEntry<Biome> registry) {
        super();
        this.biomeHolder = registry;
    }


    public static List<RegistryEntry<Biome>> getSpawnBiomes(@NotNull Registry<Biome> registry) {

        return SPAWN.stream().map(registry::entryOf).collect(Collectors.toList());
    }





    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return CARTHAGE_BIOME_PROVIDER_CODEC;
    }

    @Override
    protected Stream<RegistryEntry<Biome>> biomeStream() {
        return Stream.of(biomeHolder);
    }


    @Override
    public RegistryEntry<Biome> getBiome(final int x, final int y, final int z, final MultiNoiseUtil.MultiNoiseSampler noise) {
        return biomeHolder;
    }


    @Override
    public RegistryEntry<Biome> getBiomeForNoiseGen(final int biomeX, final int biomeY, final int biomeZ) {
        return biomeHolder;
    }
}
