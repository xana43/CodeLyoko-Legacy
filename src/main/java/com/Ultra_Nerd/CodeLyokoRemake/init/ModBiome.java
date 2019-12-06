package com.Ultra_Nerd.CodeLyokoRemake.init;

import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Conf;
import com.Ultra_Nerd.CodeLyokoRemake.world.biome.*;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
public class ModBiome {
	
	public static final Biome LYOKO_FS = new LyokoFS();
	public static final Biome LYOKO_ICE = new LyokoICE();
    public static final Biome LYOKO_DESERT = new LyokoDES();
    public static final Biome LYOKO_OCEAN = new LyokoOC();
	public static void registerBiomes()
	{
		initBiome(LYOKO_FS, "Lyoko_FS", BiomeType.WARM, Type.FOREST);
		initBiome(LYOKO_OCEAN, "Lyoko_OCEAN", BiomeType.OCEAN, Type.WET)
        initBiome(LYOKO_ICE, "Lyoko_ICE", BiomeType.ICY, Type.COLD);
        initBiome(LYOKO_DESERT, "Lyoko_DESERT", BiomeType.DESERT, Type.HOT);
	}
	

	private static Biome initBiome(Biome biome, String name, BiomeType biometype, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biometype, new BiomeEntry(biome, 10));
				
		if(Conf.spawnLyokoOverWorld)
		{
			BiomeManager.addSpawnBiome(biome);
		}
		return biome;
	}
	
	
	
}
