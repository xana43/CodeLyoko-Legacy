package com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBiome;
import com.mojang.serialization.Codec;
import net.minecraft.util.dynamic.RegistryOps;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CarthageBiomeProvider extends BiomeSource {
    private final @NotNull Registry<Biome> thisRegistry;
    private final @NotNull RegistryEntry<Biome> biomeHolder;
    public static final Codec<CarthageBiomeProvider> CARTHAGE_BIOME_PROVIDER_CODEC = RegistryOps.createRegistryCodec(Registry.BIOME_KEY)
            .xmap(CarthageBiomeProvider::new,CarthageBiomeProvider::getBiomeRegistry).codec();
    private static final List<RegistryKey<Biome>> SPAWN = Collections.singletonList(RegistryKey.of(Registry.BIOME_KEY,RegistryEntry.of(ModBiome.SECTOR_5).getKey().orElseThrow().getValue()));


    public CarthageBiomeProvider(@NotNull Registry<Biome> registry)
    {
        super((Stream<RegistryEntry<Biome>>) getSpawnBiomes(registry));
        this.thisRegistry = registry;
        this.biomeHolder = registry.getEntry(RegistryKey.of(Registry.BIOME_KEY,RegistryEntry.of(ModBiome.SECTOR_5).getKey().orElseThrow().getValue())).get();
    }


    public static List<Optional<RegistryEntry<Biome>>> getSpawnBiomes(@NotNull Registry<Biome> registry)
    {
        return SPAWN.stream().map(b -> registry
                .getEntry(RegistryKey.of(BuiltinRegistries.BIOME.getKey(), b.getValue()))).collect(Collectors.toList());
    }

    public @NotNull Registry<Biome> getBiomeRegistry()
    {
        return thisRegistry;
    }




    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return CARTHAGE_BIOME_PROVIDER_CODEC;
    }

    @Override
    public @NotNull BiomeSource withSeed(long p_47916_) {
        return this;
    }

    @Override
    public RegistryEntry<Biome> getBiome(final int x, final int y, final int z, final MultiNoiseUtil.MultiNoiseSampler noise) {
        return biomeHolder;
    }



}
