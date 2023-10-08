package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServerPacket;
import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public record ClassEffectC2SPacket() implements ClientToServerPacket {
    public static final ClassEffectC2SPacket INSTANCE = new ClassEffectC2SPacket();
    private record ClassEffects()
    {
        record Samurai()
        {
            public static final StatusEffectInstance SUPER_SPRINT = new StatusEffectInstance(StatusEffects.SPEED,
                    -1, 128, false, false, false);
        }
    }
    @Override
    public void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender)
    {

        server.execute(() -> {
            //if ((server.getTicks() >> 2) % 5 == 0) {
            if (CardinalData.DigitalEnergyComponent.tryUseEnergy(player, 1)) {
                switch (CardinalData.LyokoClass.getLyokoClass(player)) {
                    case 0 -> {
                    }
                    case 1 -> {
                        player.addStatusEffect(ClassEffects.Samurai.SUPER_SPRINT);
                        if(player.isOnGround()) {
                            player.handleFallDamage(player.fallDistance, 0.3f,
                                    player.getWorld().getDamageSources().fall());
                        }
                    }
                }
            }
            //}
        });


    }
}
