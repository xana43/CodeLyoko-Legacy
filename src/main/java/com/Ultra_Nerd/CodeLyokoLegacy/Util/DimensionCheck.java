package com.Ultra_Nerd.CodeLyokoLegacy.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public record DimensionCheck() {

    public static boolean playerNotInVanillaWorld(@NotNull PlayerEntity player) {
        return player.world.getRegistryKey() == ModDimensions.forestSectorWorld || player.world.getRegistryKey() == ModDimensions.carthage || player.world.getRegistryKey() == ModDimensions.desertSectorWorld || player.world.getRegistryKey() == ModDimensions.iceSectorWorld

                || player.world.getRegistryKey() == ModDimensions.mountainSectorWorld || player.world.getRegistryKey() == ModDimensions.volcanoWorld || player.world.getRegistryKey() == ModDimensions.digitalOceanWorld || player.world.getRegistryKey() == ModDimensions.frontierWorld;





    }

    public static boolean EntityNotInVanillaWorld(@NotNull Entity entity) {
        return entity.world.getRegistryKey() == ModDimensions.forestSectorWorld || entity.world.getRegistryKey() == ModDimensions.carthage || entity.world.getRegistryKey() == ModDimensions.desertSectorWorld || entity.world.getRegistryKey() == ModDimensions.iceSectorWorld

                || entity.world.getRegistryKey() == ModDimensions.mountainSectorWorld || entity.world.getRegistryKey() == ModDimensions.volcanoWorld || entity.world.getRegistryKey() == ModDimensions.digitalOceanWorld || entity.world.getRegistryKey() == ModDimensions.frontierWorld;





    }

    public static boolean worldIsNotVanilla(@NotNull World level) {
        return level.getRegistryKey() == ModDimensions.forestSectorWorld || level.getRegistryKey() == ModDimensions.carthage || level.getRegistryKey() == ModDimensions.desertSectorWorld || level.getRegistryKey() == ModDimensions.iceSectorWorld
                || level.getRegistryKey() == ModDimensions.mountainSectorWorld || level.getRegistryKey() == ModDimensions.volcanoWorld || level.getRegistryKey() == ModDimensions.digitalOceanWorld || level.getRegistryKey() == ModDimensions.frontierWorld;





    }
    public static boolean playerInVanilla(PlayerEntity player)
    {
        return player.world.getRegistryKey() == World.OVERWORLD || player.world.getRegistryKey() == World.NETHER || player.world.getRegistryKey() == World.END;
    }

    public static boolean worldIsVanilla(World level)
    {
        return level.getRegistryKey() == World.END  || level.getRegistryKey() == World.OVERWORLD || level.getRegistryKey() == World.NETHER;
    }
    public static boolean worldIsVanilla(RegistryKey<World> level)
    {
        return level == World.END  || level == World.OVERWORLD || level == World.NETHER;
    }






}
