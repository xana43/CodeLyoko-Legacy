package io.github.elsopeen.lyokomod.world.dimension.util;

import com.google.common.collect.ImmutableSet;
import io.github.elsopeen.lyokomod.init.ModBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import javax.annotation.Nonnull;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LyokoBanquiseBiomeProvider extends BiomeProvider {

    private static final Set<Biome> biomeList = ImmutableSet.of(ModBiomes.BANQUISE.get());
    private Random rand;
    private final double biomeSize = 16.0D;
    private VoronoiGenerator biomeNoise;

    public LyokoBanquiseBiomeProvider(LyokoBiomeProviderSettings settings) {
        super(biomeList);
        rand = new Random();
        this.biomeNoise = new VoronoiGenerator();
        this.biomeNoise.setSeed((int) settings.getSeed());
    }

    public Biome getBiome(List<Biome> biomeList, double noiseVal) {
        for (int i = biomeList.size(); i >= 0; i--) {
            if (noiseVal > (2.0f / biomeList.size()) * i - 1)
                return biomeList.get(i);
        }
        return biomeList.get(biomeList.size() - 1);
    }

    @Nonnull
    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return getBiome(new LinkedList<>(biomeList),
                biomeNoise.getValue((double) x / biomeSize, (double) y / biomeSize, (double) z / biomeSize));
    }
}
