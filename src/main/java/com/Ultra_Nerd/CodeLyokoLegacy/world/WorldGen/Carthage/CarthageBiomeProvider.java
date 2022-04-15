package com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBiome;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class CarthageBiomeProvider extends BiomeSource {



    private final @NotNull Registry<Biome> thisRegistry;
    private final @NotNull Holder<Biome> biomeHolder;
    public static final Codec<CarthageBiomeProvider> CARTHAGE_BIOME_PROVIDER_CODEC = RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY)
            .xmap(CarthageBiomeProvider::new,CarthageBiomeProvider::getBiomeRegistry).codec();
    private static final List<ResourceKey<Biome>> SPAWN = Collections.singletonList(ModBiome.SECTOR_5);
    public CarthageBiomeProvider(@NotNull Registry<Biome> registry)
    {
        super(getSpawnBiomes(registry));
        this.thisRegistry = registry;
        biomeHolder = registry.getHolderOrThrow(ModBiome.SECTOR_5);
    }


    public static List<Holder<Biome>> getSpawnBiomes(@NotNull Registry<Biome> registry)
    {
        return SPAWN.stream().map(b -> registry
                .getHolderOrThrow(ResourceKey.create(BuiltinRegistries.BIOME.key(), b.location()))).collect(Collectors.toList());
    }

    public @NotNull Registry<Biome> getBiomeRegistry()
    {
        return thisRegistry;
    }


    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CARTHAGE_BIOME_PROVIDER_CODEC;
    }

    @Override
    public @NotNull BiomeSource withSeed(long p_47916_) {
        return this;
    }

    @Override
    public @NotNull Holder<Biome> getNoiseBiome(int p_204238_, int p_204239_, int p_204240_, Climate.Sampler p_204241_) {
        return biomeHolder;
    }
}
