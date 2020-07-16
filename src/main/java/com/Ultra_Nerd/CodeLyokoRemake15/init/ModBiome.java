package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.world.biome.*;
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

	public static final RegistryObject<Biome>MOUNTAIN = BIOMES.register("mountain_sector",() -> new LyokoMountain(
			new Biome.Builder().precipitation(RainType.NONE)
			.surfaceBuilder(SurfaceBuilder.DEFAULT,new SurfaceBuilderConfig(ModBlocks.DIGITAL_ROCK.get().getDefaultState(),
					ModBlocks.DIGITAL_ROCK.get().getDefaultState(),ModBlocks.DIGITAL_ROCK.get().getDefaultState()))
			.waterFogColor(1)
			.waterColor(1)
			.temperature(2)
			.parent("Mounatain")
			.scale(9)
			.depth(80)
			.category(Category.EXTREME_HILLS)
			.downfall(0)
	));

	public static final RegistryObject<Biome>OCEAN = BIOMES.register("digital_ocean",() -> new LyokoOcean(
			new Biome.Builder().precipitation(RainType.RAIN)
			.downfall(90)
			.surfaceBuilder(SurfaceBuilder.DEFAULT,new SurfaceBuilderConfig(ModFluids.DIO.get().getDefaultState(),
					ModFluids.DIO.get().getDefaultState(),ModFluids.DIO.get().getDefaultState()))
			.parent(null)
			.waterColor(126)
			.waterFogColor(182)
			.scale(20)
			.depth(20)
			.category(Category.OCEAN)
			.temperature(1)

	));

	public static void regbio()
	{
		initBiome(OCEAN.get(),Type.MODIFIED,Type.OCEAN,Type.WATER);
		initBiome(SECTOR5.get(),Type.DENSE,Type.END,Type.MODIFIED,Type.SPOOKY);
		initBiome(FOREST.get(),Type.LUSH,Type.FOREST);
		initBiome(DESERT.get(),Type.SPARSE,Type.SPARSE,Type.DRY,Type.SANDY);
		initBiome(ICE.get(),Type.DRY,Type.COLD,Type.DEAD,Type.SNOWY);
		initBiome(MOUNTAIN.get(),Type.HILLS,Type.MODIFIED,Type.MOUNTAIN);
	}

	private static void initBiome(Biome biome,Type... types)
	{
		BiomeDictionary.addTypes(biome, types);
		net.minecraftforge.common.BiomeManager.addSpawnBiome(biome);
	}
	
	
	
}
