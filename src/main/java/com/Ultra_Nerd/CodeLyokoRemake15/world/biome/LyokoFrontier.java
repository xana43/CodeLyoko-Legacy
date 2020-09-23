package com.Ultra_Nerd.CodeLyokoRemake15.world.biome;

import net.minecraft.world.biome.Biome;

public class LyokoFrontier extends Biome {
    public LyokoFrontier(Builder biomeBuilder) {
        super(biomeBuilder);
    }

    @Override
    public int getSkyColor() {
        return 0xFFF700;
    }

}
