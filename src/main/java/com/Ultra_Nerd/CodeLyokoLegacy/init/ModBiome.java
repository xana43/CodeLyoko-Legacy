package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sound.MusicSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.MiscConfiguredFeatures;
import net.minecraft.world.gen.feature.MiscPlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.concurrent.atomic.AtomicReference;

public record ModBiome() {


    private static final SpawnSettings.Builder biomeSpawns = new SpawnSettings.Builder().spawn(SpawnGroup.MONSTER,
            new SpawnSettings.SpawnEntry(ModEntities.BLOK, 10, 2, 4));
    public static void bootStrap(final Registerable<Biome> biomeRegisterable)
    {
        BIOME_MAP.forEach((s, biome) -> {
            final RegistryKey<Biome> biomeRegistryKey = RegistryKey.of(RegistryKeys.BIOME,
                    CodeLyokoMain.codeLyokoPrefix(s));
            biomeRegisterable.register(biomeRegistryKey,biome);
            CodeLyokoMain.LOG.info("Registering " + s);
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
            .precipitation(Biome.Precipitation.NONE)
            .generationSettings(new GenerationSettings.Builder().build())
            .build();
    private static final Biome VOLCANO = buildVolcano();
    private static final Biome SECTOR_5 = buildSector5();
    public static final ImmutableMap<String, Biome> BIOME_MAP = ImmutableMap.<String, Biome>builder()
            .put("sector5", SECTOR_5)
            .put("forest_sector", FOREST_SECTOR)
            .put("desert_sector", DESERT_SECTOR)
            .put("ice_sector", ICE_SECTOR)
            .put("digital_ocean", DIGITAL_OCEAN)
            .put("mountain_sector", MOUNTAIN_SECTOR)
            .put("void_frontier", FRONTEIR)
            .put("volcano_replika", VOLCANO)

            .build();

    private static Biome buildForest() {

        final GenerationSettings.Builder forestGensettings = new GenerationSettings.Builder();
        // CodeLyokoMain.LOG.info(String.valueOf(ModFeature.FOREST_ENTRY_PLACED));
       // forestGensettings.feature(GenerationStep.Feature.VEGETAL_DECORATION,
         //       RegistryEntry.of(ModFeature.PlacedFeatures.FOREST_TREE_PLACED));
        return (new Biome.Builder()).precipitation(Biome.Precipitation.NONE)
                .downfall(0)
                .effects(new BiomeEffects.Builder().waterColor(2387).fogColor(2387).waterFogColor(2387)
                        .skyColor(2387).music(new MusicSound(RegistryEntry.of(ModSounds.FOREST),0,0,true)).build())
                .spawnSettings(biomeSpawns.build())
                .generationSettings(forestGensettings.build())
                .temperature(3)
                .build();
    }

    private static Biome buildDesert() {

        GenerationSettings.Builder desertGen = new GenerationSettings.Builder();

        return (new Biome.Builder())

                .precipitation(Biome.Precipitation.NONE)
                .downfall(0)
                .effects(new BiomeEffects.Builder().waterFogColor(12759680).fogColor(12759680).waterColor(12759680)
                        .skyColor(12759680).build())
                .spawnSettings(biomeSpawns.build())
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

                .precipitation(Biome.Precipitation.SNOW)
                .downfall(0)
                .effects(new BiomeEffects.Builder().music(new MusicSound(RegistryEntry.of(ModSounds.ICE), 0, 0, true)).skyColor(2387)
                        .waterColor(2387).waterFogColor(2387).fogColor(2387).build())
                .spawnSettings(biomeSpawns.build())
                .generationSettings(iceGenBuilder.build())
                .temperatureModifier(Biome.TemperatureModifier.FROZEN)
                .temperature(-3)
                .build();
    }

    private static Biome buildOcean() {
        SpawnSettings.Builder oceanSpawns = new SpawnSettings.Builder();
        GenerationSettings.Builder ocenGen = new GenerationSettings.Builder();
        return (new Biome.Builder())

                .precipitation(Biome.Precipitation.NONE)
                .downfall(0)
                .temperature(13)
                .temperatureModifier(Biome.TemperatureModifier.NONE)
                .effects(new BiomeEffects.Builder().music(new MusicSound(RegistryEntry.of(ModSounds.OCEAN), 0, 0, true)).skyColor(2382)
                        .waterColor(2382).waterFogColor(2382).fogColor(2382).build())
                .generationSettings(ocenGen.build())
                .spawnSettings(oceanSpawns.build())
                .build();
    }

    private static Biome buildMountain() {

        final GenerationSettings.Builder mountainGen = new GenerationSettings.Builder();

        return (new Biome.Builder())

                .precipitation(Biome.Precipitation.NONE)
                .temperature(2)
                .downfall(0)
                .temperatureModifier(Biome.TemperatureModifier.NONE)
                .effects(new BiomeEffects.Builder().music(new MusicSound(RegistryEntry.of(ModSounds.MOUNTAIN), 0, 0, true))
                        .waterFogColor(1).waterColor(1).fogColor(1).skyColor(1).build())
                .generationSettings(mountainGen.build())
                .spawnSettings(biomeSpawns.build())
                .build();
    }

    private static Biome buildVolcano() {
        SpawnSettings.Builder volcanoSpawn = new SpawnSettings.Builder().spawnCost(ModEntities.BLOK, 1, 0);
        GenerationSettings.Builder volcanoGen = new GenerationSettings.Builder();
       // volcanoGen.feature(GenerationStep.Feature.FLUID_SPRINGS,
         //       (RegistryEntry<PlacedFeature>) MiscPlacedFeatures.SPRING_LAVA);
        return (new Biome.Builder())

                .downfall(0)
                .precipitation(Biome.Precipitation.NONE)
                .temperature(46)
                .effects(new BiomeEffects.Builder().fogColor(7579).music(new MusicSound(RegistryEntry.of(ModSounds.VOLCANO),
                                0, 0, true))
                        .waterFogColor(7579).skyColor(7579).waterColor(7579).build())
                .spawnSettings(volcanoSpawn.build())
                .generationSettings(volcanoGen.build())
                .build();
    }

    private static Biome buildSector5() {
        SpawnSettings.Builder sector5Spawn = new SpawnSettings.Builder().spawnCost(ModEntities.BLOK, 1, 0);
        GenerationSettings.Builder sector5Gen = new GenerationSettings.Builder();
        return (new Biome.Builder())

                .downfall(0)
                .precipitation(Biome.Precipitation.NONE)
                .temperature(13)
                .effects(new BiomeEffects.Builder().music(new MusicSound(RegistryEntry.of(ModSounds.SECTOR5),
                                0, 0,
                                true)).fogColor(2387)
                        .waterColor(2387).waterFogColor(2387).skyColor(2387).build())
                .spawnSettings(sector5Spawn.build())
                .generationSettings(sector5Gen.build())
                .build();
    }


    public enum RegisteredBiomes {


        SECTOR5(ModBiome.SECTOR_5),
        FOREST_SECTOR(ModBiome.FOREST_SECTOR),
        DESERT_SECTOR(ModBiome.DESERT_SECTOR),
        ICE_SECTOR(ModBiome.ICE_SECTOR),
        DIGITAL_OCEAN(ModBiome.DIGITAL_OCEAN),
        MOUNTAIN_SECTOR(ModBiome.MOUNTAIN_SECTOR),
        FRONTIER(ModBiome.FRONTEIR),
        VOLCANO(ModBiome.VOLCANO);

        private final Identifier BiomeLocation;
        private final RegistryEntry<Biome> biomeRegistryKey;
        private final Biome biomeValue;
        RegisteredBiomes(Biome biomeToIdentify) {
            this.BiomeLocation = identiferOfBiome(biomeToIdentify);
            this.biomeRegistryKey = getBiomeKey(biomeToIdentify);
            this.biomeValue = biomeToIdentify;
        }

        private static RegistryEntry<Biome> getBiomeKey(Biome biome) {
            return RegistryEntry.of(biome);
        }

        private static Identifier identiferOfBiome(final Biome biome) {
            final AtomicReference<Identifier> output = new AtomicReference<Identifier>();
            BIOME_MAP.forEach((s, biome1) -> {

                if (biome == biome1) {
                    output.set(CodeLyokoMain.codeLyokoPrefix(s));
                }
            });

            return output.get();

        }
        public final Biome getBiomeValue()
        {
            return biomeValue;
        }
        public final RegistryEntry<Biome> getBiomeRegistryKey() {
            return this.biomeRegistryKey;
        }

        public final Identifier getIdentifier() {
            return BiomeLocation;
        }

    }
}
