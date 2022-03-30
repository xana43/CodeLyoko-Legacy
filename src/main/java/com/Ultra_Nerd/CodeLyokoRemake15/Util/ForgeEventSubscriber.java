package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBiome;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModEntities;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {

    @SubscribeEvent
    public static void explosions(final ExplosionEvent world) {
        if (world.getWorld().dimension() == ModDimensions.FOREST || world.getWorld().dimension() == ModDimensions.SECTOR5 ||
                world.getWorld().dimension() == ModDimensions.VOLCANO || world.getWorld().dimension() == ModDimensions.DESERT ||
                world.getWorld().dimension() == ModDimensions.ICE ||
                world.getWorld().dimension() == ModDimensions.DIGITAL_OCEAN || world.getWorld().dimension() == ModDimensions.MOUNTAIN) {

            world.getExplosion().clearToBlow();

        }
    }
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void biomeOperations(final BiomeLoadingEvent event)
    {
        if(Objects.equals(event.getName(), ModBiome.FOREST_SECTOR.location()) && event.getName() != null) {

            event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.BLOK.get(), 20, 10, 22));
        }

    }






}
