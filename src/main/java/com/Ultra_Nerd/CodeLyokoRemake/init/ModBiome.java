package com.Ultra_Nerd.CodeLyokoRemake.init;

import com.Ultra_Nerd.CodeLyokoRemake.world.biome.LyokoFS;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
public class ModBiome {
	
	public static final Biome LYOKO_FS = new LyokoFS();
	
	public static void registerBiomes()
	{
		initBiome(LYOKO_FS, "Lyoko_FS", BiomeType.WARM, Type.FOREST);
	}
	

	private static Biome initBiome(Biome biome, String name, BiomeType biometype, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		
		//BiomeManager.addSpawnBiome(biome);		
		
		return biome;
	}
	
	
	
}
