package com.Ultra_Nerd.CodeLyokoRemake15.Util.client;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class DimensionCheck {

    public static boolean playerNotInVanillaWorld(Player player) {
        return player.level.dimension() == ModDimensions.FOREST || player.level.dimension() == ModDimensions.SECTOR5 || player.level.dimension() == ModDimensions.DESERT || player.level.dimension() == ModDimensions.ICE

                || player.level.dimension() == ModDimensions.MOUNTAIN || player.level.dimension() == ModDimensions.VOLCANO;





    }

    public static boolean EntityNotInVanillaWorld(Entity entity) {
        return entity.level.dimension() == ModDimensions.FOREST || entity.level.dimension() == ModDimensions.SECTOR5 || entity.level.dimension() == ModDimensions.DESERT || entity.level.dimension() == ModDimensions.ICE

                || entity.level.dimension() == ModDimensions.MOUNTAIN || entity.level.dimension() == ModDimensions.VOLCANO;





    }



}
