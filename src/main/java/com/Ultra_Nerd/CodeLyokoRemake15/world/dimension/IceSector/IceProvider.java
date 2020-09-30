package com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBiome;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import javax.annotation.Nonnull;
import java.util.Set;

public class IceProvider extends BiomeProvider {
    protected IceProvider() {
        super(List);

    }
    private static final Set<Biome> List = ImmutableSet.of(ModBiome.ICE.get());

    @Nonnull
    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return ModBiome.ICE.get();
    }
}
