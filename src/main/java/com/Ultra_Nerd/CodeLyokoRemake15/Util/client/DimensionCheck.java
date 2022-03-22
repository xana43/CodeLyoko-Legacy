package com.Ultra_Nerd.CodeLyokoRemake15.Util.client;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class DimensionCheck {

    public static boolean playerNotInVanillaWorld(Player player) {
        return player.level.dimension() != Level.END && player.level.dimension() != Level.NETHER && player.level.dimension() != Level.OVERWORLD;
    }




}
