package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers.registry;
import com.Ultra_Nerd.CodeLyokoRemake15.world.biome.Lyoko5;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
public class ModBiome {
	
	/*public static final Biome LYOKO_FS = new LyokoFS();
	public static final Biome LYOKO_ICE = new LyokoICE();
    public static final Biome LYOKO_DESERT = new LyokoDES();
    public static final Biome LYOKO_OCEAN = new LyokoOC();
    public static final Biome LYOKO_M = new LyokoM();
    public static final Biome SECTOR_5 = new Lyoko5();
	public static void registerBiomes()
	{
        initBiome(LYOKO_M, "Lyoko_M", BiomeType.WARM, Type.MOUNTAIN);
		initBiome(LYOKO_FS, "Lyoko_FS", BiomeType.WARM, Type.FOREST);
		initBiome(LYOKO_OCEAN, "Lyoko_OCEAN", BiomeType.COOL, Type.OCEAN);
        initBiome(LYOKO_ICE, "Lyoko_ICE", BiomeType.ICY, Type.COLD);
        initBiome(LYOKO_DESERT, "Lyoko_DESERT", BiomeType.DESERT, Type.HOT);
        initBiome(SECTOR_5,"sector5",BiomeType.ICY,Type.DEAD);
       
	}*/
	
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Base.MOD_ID);
	
	public static final RegistryObject<Biome> SECTOR5 = BIOMES.register("sector5", () -> new Lyoko5(new Biome.Builder()
			 .precipitation(RainType.NONE)
			 .waterColor(3099807)
			 .waterFogColor(3099807)
			 .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(registry.SECTOR_5.get()
			 .getDefaultState(),Blocks.AIR.getDefaultState(),Blocks.AIR.getDefaultState()))
			 .category(Category.TAIGA)
			 .downfall(0)
			 .parent(null)));
	
	public static void regbio()
	{
		initBiome(SECTOR5.get(),Type.DENSE,Type.END);
	}

	private static void initBiome(Biome biome,Type... types)
	{
		BiomeDictionary.addTypes(biome, types);
		net.minecraftforge.common.BiomeManager.addSpawnBiome(biome);
	}
	
	
	
}
