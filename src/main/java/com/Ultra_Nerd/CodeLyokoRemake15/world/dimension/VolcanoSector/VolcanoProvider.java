package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.VolcanoSector;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBiome;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.Set;

public class VolcanoProvider extends BiomeProvider {

    private Random rand;
    protected VolcanoProvider() {
        super(List);
        rand = new Random();
    }
    private static final Set<Biome> List = ImmutableSet.of(ModBiome.VOLCANO.get());

    @Nonnull
    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return ModBiome.VOLCANO.get();
    }
}
