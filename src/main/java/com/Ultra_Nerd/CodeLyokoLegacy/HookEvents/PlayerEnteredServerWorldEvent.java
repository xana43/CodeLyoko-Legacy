package com.Ultra_Nerd.CodeLyokoLegacy.HookEvents;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModStats;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public record PlayerEnteredServerWorldEvent() {
    public static void consume(final ServerWorld world) {
        if(!MethodUtil.DimensionCheck.worldIsVanilla(world)) {
            for(final ServerPlayerEntity player : world.getPlayers()) {
                player.incrementStat(ModStats.TIME_SPENT_IN_LYOKO_IDENTIFIER);
            }

        }
    }
}
