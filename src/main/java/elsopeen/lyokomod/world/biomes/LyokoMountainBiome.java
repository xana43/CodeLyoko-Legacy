package elsopeen.lyokomod.world.biomes;

import elsopeen.lyokomod.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class LyokoMountainBiome extends Biome {

    public LyokoMountainBiome(Builder biomeBuilder) {
        super(biomeBuilder.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.MOUNTAIN_ROCK.get().getDefaultState(),
                ModBlocks.MOUNTAIN_ROCK.get().getDefaultState(),
                ModBlocks.MOUNTAIN_ROCK.get().getDefaultState()))
                .category(Category.EXTREME_HILLS)
                .depth(0.0f)
                .precipitation(RainType.NONE)
                .scale(1.5f)
                .temperature(1.f)
                .downfall(0.5f)
                .waterColor(16724639)
                .waterFogColor(16762304)
                .parent(null));
    }
}
