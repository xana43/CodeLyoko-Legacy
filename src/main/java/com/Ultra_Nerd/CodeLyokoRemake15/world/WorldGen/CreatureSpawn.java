package com.Ultra_Nerd.CodeLyokoRemake15.world.WorldGen;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBiome;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreatureSpawn {


    @SubscribeEvent
    public static void SpawnInWorld(FMLLoadCompleteEvent loaded) {
        for (Biome biomes : ForgeRegistries.BIOMES) {
            if (biomes == ModBiome.DESERT.get()) {
                biomes.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ModEntities.BLOK.get(),
                        8, 1, 3));
                biomes.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ModEntities.MEGATANK.get(),
                        4, 1, 2));
            } else if (biomes == ModBiome.FOREST.get()) {
                biomes.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ModEntities.BLOK.get(),
                        8, 2, 2));
                biomes.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ModEntities.MEGATANK.get(),
                        4, 1, 2));
            } else if (biomes == ModBiome.ICE.get()) {
                biomes.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ModEntities.BLOK.get(),
                        8, 2, 2));
                biomes.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ModEntities.MEGATANK.get(),
                        4, 1, 2));
            } else if (biomes == ModBiome.MOUNTAIN.get()) {
                biomes.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ModEntities.BLOK.get(),
                        8, 2, 2));
                biomes.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ModEntities.MEGATANK.get(),
                        4, 1, 2));
            }

        }
    }

}
