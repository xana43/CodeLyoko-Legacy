package com.Ultra_Nerd.CodeLyokoLegacy.Util.client;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public final class DimensionCheck {

    public static boolean playerNotInVanillaWorld(@NotNull Player player) {
        return player.level.dimension() == ModDimensions.FOREST || player.level.dimension() == ModDimensions.SECTOR5 || player.level.dimension() == ModDimensions.DESERT || player.level.dimension() == ModDimensions.ICE

                || player.level.dimension() == ModDimensions.MOUNTAIN || player.level.dimension() == ModDimensions.VOLCANO || player.level.dimension() == ModDimensions.DIGITAL_OCEAN || player.level.dimension() == ModDimensions.FRONTIER;





    }

    public static boolean EntityNotInVanillaWorld(@NotNull Entity entity) {
        return entity.level.dimension() == ModDimensions.FOREST || entity.level.dimension() == ModDimensions.SECTOR5 || entity.level.dimension() == ModDimensions.DESERT || entity.level.dimension() == ModDimensions.ICE

                || entity.level.dimension() == ModDimensions.MOUNTAIN || entity.level.dimension() == ModDimensions.VOLCANO || entity.level.dimension() == ModDimensions.DIGITAL_OCEAN || entity.level.dimension() == ModDimensions.FRONTIER;





    }

    public static boolean worldIsNotVanilla(@NotNull Level level) {
        return level.dimension() == ModDimensions.FOREST || level.dimension() == ModDimensions.SECTOR5 || level.dimension() == ModDimensions.DESERT || level.dimension() == ModDimensions.ICE

                || level.dimension() == ModDimensions.MOUNTAIN || level.dimension() == ModDimensions.VOLCANO || level.dimension() == ModDimensions.DIGITAL_OCEAN || level.dimension() == ModDimensions.FRONTIER;





    }
    public static boolean playerInVanilla(Entity player)
    {
        return player.level.dimension() == Level.OVERWORLD || player.level.dimension() == Level.NETHER || player.level.dimension() == Level.END;
    }

    public static boolean worldIsVanilla(Level level)
    {
        return level.dimension() == Level.END  || level.dimension() == Level.OVERWORLD || level.dimension() == Level.NETHER;
    }
    public static boolean worldIsVanilla(ResourceKey<Level> level)
    {
        return level == Level.END  || level == Level.OVERWORLD || level == Level.NETHER;
    }




}
