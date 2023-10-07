package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClient;

import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ServerToClientPacket;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public record FluidS2CPacket() implements ServerToClientPacket {
    public static final FluidS2CPacket INSTANCE = new FluidS2CPacket();
    @Override
    public void receive(final MinecraftClient client, final ClientPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender responseSender) {
//        final FluidVariant variant = FluidVariant.fromPacket(buf);
        final long fluidLevel = buf.readLong();
        //final BlockPos pos = buf.readBlockPos();
    }
}
