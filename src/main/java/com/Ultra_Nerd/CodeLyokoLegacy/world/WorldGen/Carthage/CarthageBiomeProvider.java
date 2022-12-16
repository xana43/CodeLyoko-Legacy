package com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBiome;
import com.mojang.serialization.Codec;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public final class CarthageBiomeProvider extends BiomeSource {
    private static final List<RegistryKey<Biome>> SPAWN = Collections.singletonList(
            RegistryKey.of(RegistryKeys.BIOME, ModBiome.RegisteredBiomes.SECTOR5.getIdentifier()));
    //public static final Codec<CarthageBiomeProvider> CARTHAGE_BIOME_PROVIDER_CODEC = RegistryOps.createRegistryCodec(
    //              BuiltinRegistries.BIOME.getKey())
    //    .xmap(CarthageBiomeProvider::new, CarthageBiomeProvider::getBiomeRegistry).codec();
    private final @NotNull Registry<Biome> thisRegistry;
    //private final @NotNull RegistryEntry<Biome> biomeHolder;


    public CarthageBiomeProvider(@NotNull Registry<Biome> registry) {
        super(getSpawnBiomes(registry));
        this.thisRegistry = registry;
        //this.biomeHolder = registry.getOrEmpty(
        //      RegistryKey.of(registry.getKey(), ModBiome.RegisteredBiomes.SECTOR5.getIdentifier()));
    }


    public static List<RegistryEntry<Biome>> getSpawnBiomes(@NotNull Registry<Biome> registry) {

        return null;//SPAWN.stream().map(registry::getOrCreateEntry).collect(Collectors.toList());
    }


    public @NotNull Registry<Biome> getBiomeRegistry() {
        return thisRegistry;
    }


    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return null;//CARTHAGE_BIOME_PROVIDER_CODEC;
    }


    @Override
    public RegistryEntry<Biome> getBiome(final int x, final int y, final int z, final MultiNoiseUtil.MultiNoiseSampler noise) {
        return null;//biomeHolder;
    }


}
