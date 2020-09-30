package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.MountainSector;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBiome;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.Set;

public class MountainProvider extends BiomeProvider {

    private Random rand;

    protected MountainProvider() {
        super(List);
        rand = new Random();
    }

    private static final Set<Biome> List = ImmutableSet.of(ModBiome.MOUNTAIN.get());

    @Nonnull
    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return ModBiome.MOUNTAIN.get();
    }
}
