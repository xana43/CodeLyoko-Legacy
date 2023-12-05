package com.Ultra_Nerd.CodeLyokoLegacy.Init.common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.MusicSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

import java.util.concurrent.atomic.AtomicReference;

public record ModBiomes() {


    private static final SpawnSettings.Builder biomesSpawns = new SpawnSettings.Builder().spawn(SpawnGroup.MONSTER,
            new SpawnSettings.SpawnEntry(ModEntities.BLOK, 10, 2, 4));
    public static void bootStrap(final Registerable<Biome> biomeRegisterable)
    {
        Object2ObjectMaps.fastForEach(BIOMES_MAP,stringBiomeEntry -> {
            final RegistryKey<Biome> biomeRegistryKey = RegistryKey.of(RegistryKeys.BIOME,
                    CodeLyokoMain.codeLyokoPrefix(stringBiomeEntry.getKey()));
            biomeRegisterable.register(biomeRegistryKey,stringBiomeEntry.getValue());
        });
    }
    /*Forest Sector*/
    // private static final SurfaceBuilder FOREST_CARVER = new SurfaceBuilder(null,ModBlocks.BORNITE_ORE.getDefaultState(), 0,0,null);
    private static final Biome FOREST_SECTOR = buildForest();
    //Desert Sector
    private static final Biome DESERT_SECTOR = buildDesert();
    private static final Biome ICE_SECTOR = buildIce();
    private static final Biome DIGITAL_OCEAN = buildOcean();
    private static final Biome MOUNTAIN_SECTOR = buildMountain();
    private static final Biome FRONTEIR = new Biome.Builder()

            .downfall(0)
            .temperature(-243)
            .temperatureModifier(Biome.TemperatureModifier.FROZEN)
            .effects(new BiomeEffects.Builder().skyColor(16777215).waterColor(16777215).waterFogColor(16777215)
                    .fogColor(16777215).build())
            .spawnSettings(new SpawnSettings.Builder().build())
            .precipitation(false)
            .generationSettings(new GenerationSettings.Builder().build())
            .build();
    private static final Biome VOLCANO = buildVolcano();
    private static final Biome SECTOR_5 = buildSector5();
     public static final Object2ObjectMap<String,Biome> BIOMES_MAP = Object2ObjectMaps.unmodifiable(new Object2ObjectOpenHashMap<>() {{
             put("sector5", SECTOR_5);
             put("forest_sector", FOREST_SECTOR);
             put("desert_sector", DESERT_SECTOR);
             put("ice_sector", ICE_SECTOR);
             put("digital_ocean", DIGITAL_OCEAN);
             put("mountain_sector", MOUNTAIN_SECTOR);
             put("void_frontier", FRONTEIR);
             put("volcano_replika", VOLCANO);
     }});

         private static Biome buildForest() {

             final GenerationSettings.Builder forestGensettings = new GenerationSettings.Builder();
             // CodeLyokoMain.LOG.info(String.valueOf(ModFeature.FOREST_ENTRY_PLACED));
             // forestGensettings.feature(GenerationStep.Feature.VEGETAL_DECORATION,
             //       RegistryEntry.of(ModFeature.PlacedFeatures.FOREST_TREE_PLACED));
             return (new Biome.Builder()).precipitation(false)
                     .downfall(0)
                     .effects(new BiomeEffects.Builder().waterColor(2387).fogColor(2387).waterFogColor(2387)
                             .skyColor(2387).music(new MusicSound(ModSounds.FOREST, 0, 0, true)).build())
                     .spawnSettings(biomesSpawns.build())
                     .generationSettings(forestGensettings.build())
                     .temperature(3)
                     .build();
         }

         private static Biome buildDesert() {

             GenerationSettings.Builder desertGen = new GenerationSettings.Builder();

             return (new Biome.Builder())

                     .precipitation(false)
                     .downfall(0)
                     .effects(new BiomeEffects.Builder().music(new MusicSound(ModSounds.DESERT, 0, 0, true)).waterFogColor(12759680).fogColor(12759680).waterColor(12759680)
                             .skyColor(12759680).build())
                     .spawnSettings(biomesSpawns.build())
                     .generationSettings(desertGen.build())
                     .temperature(38)
                     .temperatureModifier(Biome.TemperatureModifier.NONE)
                     .build();
         }

         private static Biome buildIce() {

             GenerationSettings.Builder iceGenBuilder = new GenerationSettings.Builder();
             //iceGenBuilder.feature(GenerationStep.Feature.SURFACE_STRUCTURES,
             //      (RegistryEntry<PlacedFeature>) MiscPlacedFeatures.BLUE_ICE);

             return (new Biome.Builder())

                     .precipitation(true)
                     .downfall(0)
                     .effects(new BiomeEffects.Builder().music(new MusicSound(ModSounds.ICE, 0, 0, true)).skyColor(2387)
                             .waterColor(2387).waterFogColor(2387).fogColor(2387).build())
                     .spawnSettings(biomesSpawns.build())
                     .generationSettings(iceGenBuilder.build())
                     .temperatureModifier(Biome.TemperatureModifier.FROZEN)
                     .temperature(-3)
                     .build();
         }

         private static Biome buildOcean() {
             final SpawnSettings.Builder oceanSpawns = new SpawnSettings.Builder();
             final GenerationSettings.Builder oceanGen = new GenerationSettings.Builder();
             return (new Biome.Builder())

                     .precipitation(false)
                     .downfall(0)
                     .temperature(13)
                     .temperatureModifier(Biome.TemperatureModifier.NONE)
                     .effects(new BiomeEffects.Builder().music(new MusicSound(ModSounds.OCEAN, 0, 0, true)).skyColor(2382)
                             .waterColor(2382).waterFogColor(2382).fogColor(2382).build())
                     .generationSettings(oceanGen.build())
                     .spawnSettings(oceanSpawns.build())
                     .build();
         }

         private static Biome buildMountain() {

             final GenerationSettings.Builder mountainGen = new GenerationSettings.Builder();

             return (new Biome.Builder())

                     .precipitation(false)
                     .temperature(2)
                     .downfall(0)
                     .temperatureModifier(Biome.TemperatureModifier.NONE)
                     .effects(new BiomeEffects.Builder().music(new MusicSound(ModSounds.MOUNTAIN, 0, 0, true))
                             .waterFogColor(1).waterColor(1).fogColor(1).skyColor(1).build())
                     .generationSettings(mountainGen.build())
                     .spawnSettings(biomesSpawns.build())
                     .build();
         }

         private static Biome buildVolcano() {
             final SpawnSettings.Builder volcanoSpawn = new SpawnSettings.Builder().spawnCost(ModEntities.BLOK, 1, 0);
             final GenerationSettings.Builder volcanoGen = new GenerationSettings.Builder();
             // volcanoGen.feature(GenerationStep.Feature.FLUID_SPRINGS,
             //       (RegistryEntry<PlacedFeature>) MiscPlacedFeatures.SPRING_LAVA);
             return (new Biome.Builder())

                     .downfall(0)
                     .precipitation(false)
                     .temperature(46)
                     .effects(new BiomeEffects.Builder().fogColor(7579).music(new MusicSound(ModSounds.VOLCANO,
                                     0, 0, true))
                             .waterFogColor(7579).skyColor(7579).waterColor(7579).build())
                     .spawnSettings(volcanoSpawn.build())
                     .generationSettings(volcanoGen.build())
                     .build();
         }

         private static Biome buildSector5() {
             final SpawnSettings.Builder sector5Spawn = new SpawnSettings.Builder().spawnCost(ModEntities.BLOK, 1, 0);
             final GenerationSettings.Builder sector5Gen = new GenerationSettings.Builder();
             return (new Biome.Builder())

                     .downfall(0)
                     .precipitation(false)
                     .temperature(13)
                     .effects(new BiomeEffects.Builder().music(new MusicSound(ModSounds.SECTOR5,
                                     0, 0,
                                     true)).fogColor(2387)
                             .waterColor(2387).waterFogColor(2387).skyColor(2387).build())
                     .spawnSettings(sector5Spawn.build())
                     .generationSettings(sector5Gen.build())
                     .build();
         }


         public enum RegisteredBiomes {


             SECTOR5(ModBiomes.SECTOR_5),
             FOREST_SECTOR(ModBiomes.FOREST_SECTOR),
             DESERT_SECTOR(ModBiomes.DESERT_SECTOR),
             ICE_SECTOR(ModBiomes.ICE_SECTOR),
             DIGITAL_OCEAN(ModBiomes.DIGITAL_OCEAN),
             MOUNTAIN_SECTOR(ModBiomes.MOUNTAIN_SECTOR),
             FRONTIER(ModBiomes.FRONTEIR),
             VOLCANO(ModBiomes.VOLCANO);

             private final Identifier biomesLocation;
             private final RegistryKey<Biome> biomesRegistryKey;
             private final Biome biomesValue;

             RegisteredBiomes(Biome biomesToIdentify) {
                 this.biomesLocation = identifierBiomes(biomesToIdentify);
                 this.biomesRegistryKey = getBiomesKey(biomesLocation);
                 this.biomesValue = biomesToIdentify;
             }

             private static RegistryKey<Biome> getBiomesKey(final Identifier location) {
                 return RegistryKey.of(RegistryKeys.BIOME, location);
             }

             private static Identifier identifierBiomes(final Biome biome) {
                 final AtomicReference<Identifier> output = new AtomicReference<>();

                 Object2ObjectMaps.fastForEach(BIOMES_MAP,stringBiomeEntry -> {
                     if(biome == stringBiomeEntry.getValue()) {
                         output.set(CodeLyokoMain.codeLyokoPrefix(stringBiomeEntry.getKey()));
                     }
                 });
                 return output.get();
             }

             public final Biome getBiomesValue() {
                 return biomesValue;
             }

             public final RegistryKey<Biome> getBiomesRegistryKey() {
                 return this.biomesRegistryKey;
             }

             public final Identifier getIdentifier() {
                 return biomesLocation;
             }

         }
     }
