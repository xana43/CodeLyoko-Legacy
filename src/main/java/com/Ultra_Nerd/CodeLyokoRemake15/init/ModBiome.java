package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class ModBiome {





    //Registry keys
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, CodeLyokoMain.MOD_ID);



    public static final ResourceKey<Biome> FOREST_SECTOR = ForestResourceKey(new BiomeSpecialEffects.Builder()
                    .skyColor(2387)
                    .waterColor(2387)
                    .backgroundMusic(ModSounds.LAZY_FOREST.get())
                    .fogColor(2387)
                    .waterFogColor(2387)
                    .waterColor(2387).build()
    );

    @NotNull
    private static ResourceKey<Biome> makeResourceKey(String name, Biome.BiomeCategory biomeCategory, int temp, Biome.TemperatureModifier temperatureModifier,BiomeSpecialEffects biomeSpecialEffects,MobSpawnSettings mobSpawnSettings)
    {
        BIOMES.register(name,() -> new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .biomeCategory(biomeCategory)
                .temperature(temp)
                .temperatureAdjustment(temperatureModifier)
                .downfall(0)
                .specialEffects(biomeSpecialEffects)
                .mobSpawnSettings(mobSpawnSettings)
                .generationSettings(BiomeGenerationSettings.EMPTY)
                .build());
        return ResourceKey.create(Registry.BIOME_REGISTRY, CodeLyokoMain.CodeLyokoPrefix(name));
    }

    @NotNull
    private static ResourceKey<Biome> ForestResourceKey(BiomeSpecialEffects biomeSpecialEffects)
    {


            BIOMES.register("forest_sector", () -> new Biome.BiomeBuilder()
                    .precipitation(Biome.Precipitation.NONE)
                    .biomeCategory(Biome.BiomeCategory.JUNGLE)
                    .temperature(10)
                    .temperatureAdjustment(Biome.TemperatureModifier.NONE)
                    .downfall(0)
                    .specialEffects(biomeSpecialEffects)
                    .mobSpawnSettings(MobSpawnSettings.EMPTY)
                    .generationSettings(new BiomeGenerationSettings.Builder().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                            ModFeature.DIGITAL_FOREST_PLACED).build())
                    .build());

        return ResourceKey.create(Registry.BIOME_REGISTRY, CodeLyokoMain.CodeLyokoPrefix("forest_sector"));
    }



    public static final ResourceKey<Biome> SECTOR_5 = makeResourceKey("sector5", Biome.BiomeCategory.THEEND,10, Biome.TemperatureModifier.NONE,new BiomeSpecialEffects.Builder()
            .skyColor(2387)
            .waterColor(2387)
            .backgroundMusic(ModSounds.LAZY_SECTOR5.get())
            .fogColor(2387)
            .waterFogColor(2387)
            .waterColor(2387).build()
            ,MobSpawnSettings.EMPTY);



    @NotNull
    private static ResourceKey<Biome> MountainResourceKey(BiomeSpecialEffects biomeSpecialEffects)
    {


        BIOMES.register("mountain_sector", () -> new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .biomeCategory(Biome.BiomeCategory.MOUNTAIN)
                .temperature(6)
                .temperatureAdjustment(Biome.TemperatureModifier.NONE)
                .downfall(0)
                .specialEffects(biomeSpecialEffects)
                .mobSpawnSettings(MobSpawnSettings.EMPTY)
                .generationSettings(new BiomeGenerationSettings.Builder().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                        ModFeature.DIGITAL_MOUNTAIN_PLACED).build())
                .build());

        return ResourceKey.create(Registry.BIOME_REGISTRY, CodeLyokoMain.CodeLyokoPrefix("forest_sector"));
    }



    public static final ResourceKey<Biome> ICE_SECTOR = makeResourceKey("ice_sector",Biome.BiomeCategory.ICY,-3, Biome.TemperatureModifier.FROZEN,new BiomeSpecialEffects.Builder()
            .skyColor(2387)
            .backgroundMusic(ModSounds.LAZY_ICE.get())
            .fogColor(2387)
            .waterFogColor(2387)
            .waterColor(2387)
            .build(),MobSpawnSettings.EMPTY);
    public static final ResourceKey<Biome> DESERT_SECTOR = makeResourceKey("desert_sector", Biome.BiomeCategory.DESERT,38, Biome.TemperatureModifier.NONE,new BiomeSpecialEffects.Builder()
            .skyColor(12759680)
            .backgroundMusic(ModSounds.LAZY_DESERT.get())
            .fogColor(12759680)
            .waterFogColor(12759680)
            .waterColor(12759680)
            .build(),MobSpawnSettings.EMPTY);
    public static final ResourceKey<Biome> MOUNTAIN_SECTOR = MountainResourceKey(new BiomeSpecialEffects.Builder()
            .skyColor(306)
            .backgroundMusic(ModSounds.LAZY_MOUNTAIN.get())
            .fogColor(306)
            .waterFogColor(306)
            .waterColor(306)
            .build());
    public static final ResourceKey<Biome> VOLCANO_SECTOR = makeResourceKey("volcano_replika", Biome.BiomeCategory.NETHER,40, Biome.TemperatureModifier.NONE,new BiomeSpecialEffects.Builder()
            .skyColor(7579)
            .backgroundMusic(ModSounds.LAZY_VOLCANO.get())
            .fogColor(7579)
            .waterFogColor(7579)
            .waterColor(7579)
            .build(),MobSpawnSettings.EMPTY);
    public static final ResourceKey<Biome> DIGITAL_OCEAN = makeResourceKey("digital_ocean", Biome.BiomeCategory.OCEAN,15, Biome.TemperatureModifier.NONE,new BiomeSpecialEffects.Builder()
            .skyColor(2382)
            .backgroundMusic(ModSounds.LAZY_OCEAN.get())
            .fogColor(2382)
            .waterFogColor(2382)
            .waterColor(2382)
            .build(),MobSpawnSettings.EMPTY);
    public static final BiomeDictionary.Type LYOKO = BiomeDictionary.Type.getType("Lyoko");



    public static void addBiomeTypes()
    {

        BiomeDictionary.addTypes(SECTOR_5,LYOKO,BiomeDictionary.Type.VOID,BiomeDictionary.Type.SPOOKY);
        BiomeDictionary.addTypes(FOREST_SECTOR,LYOKO,BiomeDictionary.Type.FOREST,BiomeDictionary.Type.LUSH,BiomeDictionary.Type.JUNGLE);
        BiomeDictionary.addTypes(DESERT_SECTOR,LYOKO, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY);
        BiomeDictionary.addTypes(ICE_SECTOR,LYOKO, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MODIFIED, BiomeDictionary.Type.SNOWY,BiomeDictionary.Type.DEAD);
        BiomeDictionary.addTypes(MOUNTAIN_SECTOR,LYOKO, BiomeDictionary.Type.MOUNTAIN,BiomeDictionary.Type.SPARSE);
        BiomeDictionary.addTypes(VOLCANO_SECTOR,LYOKO, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HOT, BiomeDictionary.Type.NETHER, BiomeDictionary.Type.SPOOKY);
        BiomeDictionary.addTypes(DIGITAL_OCEAN,LYOKO, BiomeDictionary.Type.WATER, BiomeDictionary.Type.WET);



    }


/*
    public static final RegistryObject<Biome> SECTOR5 = BIOMES.register("seector5",() ->
            new Biome.BiomeBuilder()
                    .biomeCategory(Biome.BiomeCategory.NONE)
                    .downfall(0)
                    .temperatureAdjustment(Biome.TemperatureModifier.NONE)
                    .specialEffects(new BiomeSpecialEffects.Builder()
                            .backgroundMusic(new Music(ModSounds.FOREST.get(),1,1,true))
                            .waterColor(13827971)
                            .fogColor(13827971)
                            .build())
                    .mobSpawnSettings(new MobSpawnSettings.Builder()
                            .build())
                    .build());





    public static final RegistryObject<Biome> SECTOR5 = BIOMES.register("sector5", () -> new Biome.BiomeBuilder()
            .biomeCategory(Biome.BiomeCategory.NONE)
            .downfall(0)
            .precipitation(Biome.Precipitation.NONE)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .generationSettings(new BiomeGenerationSettingsBuilder(BiomeGenerationSettings.EMPTY))
            .build());
    public static final RegistryObject<Biome> FOREST = BIOMES.register("forest_sector", () -> new LyokoForest(new Biome.BiomeBuilder()
            .precipitation(RainType.NONE)
            .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.DIGITAL_GRASS.get()
                    .getDefaultState(), ModBlocks.DIGITAL_DIRT.get().getDefaultState(), ModBlocks.DIGITAL_DIRT.get().getDefaultState()))
            .category(Category.FOREST)
            .downfall(0)
            .waterColor(13827971)
            .waterFogColor(13827971)
            .depth(70)
            .scale(4)
            .temperature(10)
            .parent(null)
    ));
    public static final RegistryObject<Biome> DESERT = BIOMES.register("desert_sector", () -> new LyokoDesert(new Biome.Builder()
            .precipitation(RainType.NONE)
            .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.DIGITAL_SAND.get().getDefaultState(),
                    ModBlocks.DIGITAL_SAND.get().getDefaultState(), ModBlocks.DIGITAL_SAND.get().getDefaultState()))
            .category(Category.DESERT)
            .downfall(0)
            .depth(70)
            .waterColor(3099807)
            .waterFogColor(3099807)
            .scale(4)
            .temperature(10)
            .parent(null)
    ));

    public static final RegistryObject<Biome> ICE = BIOMES.register("ice_sector", () -> new LyokoICE(new Biome.Builder()
            .precipitation(RainType.NONE)
            .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.DIGITAL_ICE.get().getDefaultState(),
                    ModBlocks.DIGITAL_ICE.get().getDefaultState(), ModBlocks.DIGITAL_ICE.get().getDefaultState()))
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

    public static final RegistryObject<Biome> MOUNTAIN = BIOMES.register("mountain_sector", () -> new LyokoMountain(
            new Biome.Builder().precipitation(RainType.NONE)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.DIGITAL_ROCK.get().getDefaultState(),
                            ModBlocks.DIGITAL_ROCK.get().getDefaultState(), ModBlocks.DIGITAL_ROCK.get().getDefaultState()))
                    .waterFogColor(1)
                    .waterColor(1)
                    .temperature(2)
                    .parent("Mounatain")
                    .scale(9)
                    .depth(80)
                    .category(Category.EXTREME_HILLS)
                    .downfall(0)
    ));

    public static final RegistryObject<Biome> OCEAN = BIOMES.register("digital_ocean", () -> new LyokoOcean(
            new Biome.Builder().precipitation(RainType.RAIN)
                    .downfall(90)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModFluids.DIGITAL_SEA_BLOCK.get().getDefaultState(),
                            ModFluids.DIGITAL_SEA_BLOCK.get().getDefaultState(), ModFluids.DIGITAL_SEA_BLOCK.get().getDefaultState()))
                    .parent(null)
                    .waterColor(126)
                    .waterFogColor(182)
                    .scale(20)
                    .depth(20)
                    .category(Category.OCEAN)
                    .temperature(1)

    ));
    public static final RegistryObject<Biome> FRONTIER = BIOMES.register("digital_frontier", () -> new LyokoFrontier(
            new Biome.Builder()
                    .precipitation(RainType.NONE)
                    .downfall(0)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.FRONTIER_BLOCK.get().getDefaultState(),
                            ModBlocks.FRONTIER_BLOCK.get().getDefaultState(), ModBlocks.FRONTIER_BLOCK.get().getDefaultState()))
                    .parent(null)
                    .waterColor(0xFFF700)
                    .waterFogColor(0xFFF700)
                    .scale(20)
                    .depth(20)
                    .category(Category.NONE)
                    .temperature(0)

    ));
    public static final RegistryObject<Biome> VOLCANO = BIOMES.register("volcano", () -> new LyokoVolcano(new Biome.Builder()
            .precipitation(RainType.NONE)
            .temperature(Integer.MAX_VALUE)
            .category(Category.NETHER)
            .waterFogColor(90)
            .waterColor(90)
            .parent(null)
            .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.VOLCANO_GROUND.get().getDefaultState(),
                    ModBlocks.VOLCANO_GROUND.get().getDefaultState(), ModBlocks.VOLCANO_GROUND.get().getDefaultState()))
            .downfall(0)
            .scale(200)
            .depth(200)
    ));








    public static void regbio() {

        initBiome(OCEAN, Type.MODIFIED, Type.OCEAN, Type.WATER);
        initBiome(SECTOR5, Type.DENSE, Type.END, Type.MODIFIED, Type.SPOOKY);
        initBiome(FOREST, Type.LUSH, Type.FOREST);
        initBiome(DESERT, Type.SPARSE, Type.SPARSE, Type.DRY, Type.SANDY);
        initBiome(ICE, Type.DRY, Type.COLD, Type.DEAD, Type.SNOWY);
        initBiome(MOUNTAIN, Type.HILLS, Type.MODIFIED, Type.MOUNTAIN);
        initBiome(FRONTIER, Type.END, Type.DEAD, Type.RARE, Type.MAGICAL, Type.SPOOKY, Type.VOID);
        initBiome(VOLCANO, Type.SPOOKY, Type.DEAD, Type.HOT, Type.MODIFIED, Type.NETHER);
    }

    private static void initBiome(RegistryObject<Biome> biome, Type... types) {
        BiomeDictionary.addTypes(biome.get(), types);

    }

*/
}
