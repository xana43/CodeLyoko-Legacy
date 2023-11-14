package com.Ultra_Nerd.CodeLyokoLegacy.HookEvents;

import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public record RegeneratePlayerEnergyServerEvent() {


    public static void consume(final MinecraftServer server) {
        for (final ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            if((server.getTicks() >> 3) % 5 == 0 && !CardinalData.DigitalEnergyComponent.isUsingEnergy(player)) {
                CardinalData.DigitalEnergyComponent.regenerateEnergy(player);
            }
        }
    }
}
