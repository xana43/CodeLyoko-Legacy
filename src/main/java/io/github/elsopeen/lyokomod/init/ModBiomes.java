package io.github.elsopeen.lyokomod.init;

import io.github.elsopeen.lyokomod.LyokoMod;
import io.github.elsopeen.lyokomod.world.biomes.LyokoBanquiseBiome;
import io.github.elsopeen.lyokomod.world.biomes.LyokoDesertBiome;
import io.github.elsopeen.lyokomod.world.biomes.LyokoForestBiome;
import io.github.elsopeen.lyokomod.world.biomes.LyokoMountainBiome;
import io.github.elsopeen.lyokomod.world.biomes.LyokoSector5;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, LyokoMod.MOD_ID);

    public static final RegistryObject<Biome> FOREST = BIOMES.register("forest_biome", ()-> new LyokoForestBiome(new Biome.Builder()));
    public static final RegistryObject<Biome> MOUNTAIN = BIOMES.register("mountain_biome", ()-> new LyokoMountainBiome(new Biome.Builder()));
    public static final RegistryObject<Biome> DESERT = BIOMES.register("desert_biome", ()-> new LyokoDesertBiome(new Biome.Builder()));
    public static final RegistryObject<Biome> BANQUISE = BIOMES.register("banquise_biome", ()-> new LyokoBanquiseBiome(new Biome.Builder()));
    public static final RegistryObject<Biome> SECTOR5 = BIOMES.register("sector5", () -> new LyokoSector5(new Biome.Builder()));
}
