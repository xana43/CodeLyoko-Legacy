package com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage;

import com.mojang.serialization.Codec;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

import java.util.stream.Stream;

public final class CarthageBiomeProvider extends BiomeSource {
    protected CarthageBiomeProvider(final Stream<RegistryEntry<Biome>> biomeStream) {
        super(biomeStream);
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return null;
    }

    @Override
    public BiomeSource withSeed(final long seed) {
        return null;
    }

    @Override
    public RegistryEntry<Biome> getBiome(final int x, final int y, final int z, final MultiNoiseUtil.MultiNoiseSampler noise) {
        return null;
    }


/*
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

 */
}
