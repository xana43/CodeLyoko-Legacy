package com.Ultra_Nerd.CodeLyokoRemake15.Util.client;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import net.minecraft.world.entity.player.Player;

public class DimensionCheck {

    public static boolean playerNotInVanillaWorld(Player player) {
        return player.level.dimension() == ModDimensions.FOREST || player.level.dimension() == ModDimensions.SECTOR5 || player.level.dimension() == ModDimensions.DESERT || player.level.dimension() == ModDimensions.ICE

                || player.level.dimension() == ModDimensions.MOUNTAIN || player.level.dimension() == ModDimensions.VOLCANO;





    }




}
