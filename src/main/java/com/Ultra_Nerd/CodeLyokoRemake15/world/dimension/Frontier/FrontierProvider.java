package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Frontier;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBiome;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;

import javax.annotation.Nonnull;
import java.util.Set;

public class FrontierProvider extends BiomeSource {

    protected FrontierProvider() {
        super(List);
    }

    private static final Set<Biome> List = ImmutableSet.of(ModBiome.FRONTIER.get());

    @Nonnull
    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return ModBiome.FRONTIER.get();
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return null;
    }

    @Override
    public BiomeSource withSeed(long p_47916_) {
        return null;
    }

    @Override
    public Holder<Biome> getNoiseBiome(int p_204238_, int p_204239_, int p_204240_, Climate.Sampler p_204241_) {
        return null;
    }
}
