package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.world.biome.LyokoCarthage;
import com.Ultra_Nerd.CodeLyokoRemake15.world.biome.LyokoDesert;
import com.Ultra_Nerd.CodeLyokoRemake15.world.biome.LyokoForest;
import com.Ultra_Nerd.CodeLyokoRemake15.world.biome.LyokoICE;
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
	
	/*public static final Biome LYOKO_FS = new LyokoForest();
	public static final Biome LYOKO_ICE = new LyokoICE();
    public static final Biome LYOKO_DESERT = new LyokoDesert();
    public static final Biome LYOKO_OCEAN = new LyokoOC();
    public static final Biome LYOKO_M = new LyokoMountain();
    public static final Biome SECTOR_5 = new LyokoCarthage();
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
	
	public static final RegistryObject<Biome> SECTOR5 = BIOMES.register("sector5", () -> new LyokoCarthage(new Biome.Builder()
			 .precipitation(RainType.NONE)
			 .waterColor(3099807)
			 .waterFogColor(3099807)
			 .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.SECTOR_5.get()
			 .getDefaultState(),Blocks.AIR.getDefaultState(),Blocks.AIR.getDefaultState()))
			.depth(70)
			.scale(4)
			.temperature(10)

			 .category(Category.NONE)
			 .downfall(0)
			 .parent(null)));
	public static final RegistryObject<Biome>FOREST = BIOMES.register("forest_sector",() -> new LyokoForest(new Biome.Builder()
			.precipitation(RainType.NONE)
			.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.DIGITAL_GRASS.get()
			.getDefaultState(),ModBlocks.DIGITAL_DIRT.get().getDefaultState(),ModBlocks.DIGITAL_DIRT.get().getDefaultState()))
			.category(Category.FOREST)
			.downfall(0)
			.waterColor(13827971)
			.waterFogColor(13827971)
			.depth(70)
			.scale(4)
			.temperature(10)
			.parent(null)

			));
	public static final RegistryObject<Biome>DESERT = BIOMES.register("desert_sector", () -> new LyokoDesert(new Biome.Builder()
		.precipitation(RainType.NONE)
			.surfaceBuilder(SurfaceBuilder.DEFAULT,new SurfaceBuilderConfig(ModBlocks.DIGITAL_SAND.get().getDefaultState(),
					ModBlocks.DIGITAL_SAND.get().getDefaultState(),ModBlocks.DIGITAL_SAND.get().getDefaultState()))
			.category(Category.DESERT)
			.downfall(0)
			.depth(70)
			.waterColor(3099807)
			.waterFogColor(3099807)
			.scale(4)
			.temperature(10)
			.parent(null)
	));

	public static final RegistryObject<Biome>ICE = BIOMES.register("ice_sector", () -> new LyokoICE(new Biome.Builder()
	.precipitation(RainType.NONE)
	.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.DIGITAL_ICE.get().getDefaultState(),
			ModBlocks.DIGITAL_ICE.get().getDefaultState(),ModBlocks.DIGITAL_ICE.get().getDefaultState()))
	.category(Category.TAIGA)
	.downfall(0)
	.depth(70)
	.parent(null)
	.scale(9)
	.depth(80)
	.temperature(-1)
	.waterColor(0)
	.waterFogColor(9)
	));
	public static void regbio()
	{
		initBiome(SECTOR5.get(),Type.DENSE,Type.END,Type.MODIFIED,Type.SPOOKY);
		initBiome(FOREST.get(),Type.LUSH,Type.FOREST);
		initBiome(DESERT.get(),Type.SPARSE,Type.SPARSE,Type.DRY,Type.SANDY);
		initBiome(ICE.get(),Type.DRY,Type.COLD,Type.DEAD,Type.SNOWY);
	}

	private static void initBiome(Biome biome,Type... types)
	{
		BiomeDictionary.addTypes(biome, types);
		net.minecraftforge.common.BiomeManager.addSpawnBiome(biome);
	}
	
	
	
}
