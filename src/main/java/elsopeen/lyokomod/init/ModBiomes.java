package elsopeen.lyokomod.init;

import elsopeen.lyokomod.LyokoMod;
import elsopeen.lyokomod.world.biomes.LyokoBanquiseBiome;
import elsopeen.lyokomod.world.biomes.LyokoDesertBiome;
import elsopeen.lyokomod.world.biomes.LyokoForestBiome;
import elsopeen.lyokomod.world.biomes.LyokoMountainBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, LyokoMod.MOD_ID);

    public static final RegistryObject<Biome> FOREST = BIOMES.register("forest", ()-> new LyokoForestBiome(new Biome.Builder()));
    public static final RegistryObject<Biome> MOUNTAIN = BIOMES.register("mountain", ()-> new LyokoMountainBiome(new Biome.Builder()));
    public static final RegistryObject<Biome> DESERT = BIOMES.register("desert", ()-> new LyokoDesertBiome(new Biome.Builder()));
    public static final RegistryObject<Biome> BANQUISE = BIOMES.register("banquise", ()-> new LyokoBanquiseBiome(new Biome.Builder()));
}
