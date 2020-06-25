package io.github.elsopeen.lyokomod.world.dimension.util;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class LyokoBiomeProviderSettings implements IBiomeProviderSettings {
    private final long seed;
    private final WorldType worldType;
    private LyokoGenSettings generatorSettings = new LyokoGenSettings();

    public LyokoBiomeProviderSettings(WorldInfo info) {
        this.seed = info.getSeed();
        this.worldType = info.getGenerator();
    }

    public LyokoBiomeProviderSettings setGeneratorSettings(LyokoGenSettings settings) {
        this.generatorSettings = settings;
        return this;
    }

    public long getSeed() {
        return this.seed;
    }

    public WorldType getWorldType() {
        return this.worldType;
    }

    public LyokoGenSettings getGeneratorSettings() {
        return this.generatorSettings;
    }
}
