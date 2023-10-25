package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public record ClassEffectC2SPacket(){

    private record ClassEffects()
    {
        record SamuraiClassEffects()
        {
            public static final StatusEffectInstance SUPER_SPRINT = new StatusEffectInstance(StatusEffects.SPEED,
                    -1, 128, false, false, false);
            public static void addClone(final ServerPlayerEntity player)
            {
                CardinalData.LyokoClass.ExtraClassData.SamuraiData.addClone(player);
            }
        }
    }
    public static void receiveSecondary(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender)
    {
       server.execute(() -> {
           //if ((server.getTicks() >> 2) % 5 == 0) {
           if (CardinalData.DigitalEnergyComponent.tryUseEnergy(player, 1)) {
               switch (CardinalData.LyokoClass.getLyokoClass(player)) {
                   case 0 -> {
                   }
                   case 1 -> ClassEffects.SamuraiClassEffects.addClone(player);
               }
           }
           //}
       });
    }

    public static void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender)
    {

        server.execute(() -> {
            //if ((server.getTicks() >> 2) % 5 == 0) {
            if (CardinalData.DigitalEnergyComponent.tryUseEnergy(player, 1)) {
                switch (CardinalData.LyokoClass.getLyokoClass(player)) {
                    case 0 -> {
                    }
                    case 1 -> player.addStatusEffect(ClassEffects.SamuraiClassEffects.SUPER_SPRINT);
                }
            }
            //}
        });


    }
}
