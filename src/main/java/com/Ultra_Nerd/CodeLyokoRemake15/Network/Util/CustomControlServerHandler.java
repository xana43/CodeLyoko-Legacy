package com.Ultra_Nerd.CodeLyokoRemake15.Network.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.vehicle.LyokoVehicleEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.function.Supplier;

public record CustomControlServerHandler(byte upPressed, byte downPressed) {

    public static void syncToServer(int upPressed, int downPressed)
    {
        PacketHandler.INSTANCE.send(PacketDistributor.SERVER.with(()->null),new CustomControlServerHandler((byte)upPressed,(byte) downPressed));
    }

    public static CustomControlServerHandler make(final FriendlyByteBuf byteBuf)
    {
        return new CustomControlServerHandler(byteBuf.readByte(), byteBuf.readByte());
    }

    public static void encapsulate(final CustomControlServerHandler pkt, final FriendlyByteBuf byteBuf)
    {
        byteBuf.writeByte(pkt.upPressed);
        byteBuf.writeByte(pkt.downPressed);
    }

    public static class Handler{
        public static void handle(final CustomControlServerHandler pkt, final Supplier<NetworkEvent.Context> netContext)
        {
            netContext.get().enqueueWork(() -> {

                ServerPlayer serverPlayer = netContext.get().getSender();
                if(serverPlayer == null)
                {
                    return;
                }
                if(serverPlayer.getVehicle() instanceof LyokoVehicleEntity lyokoVehicleEntity)
                {
                    if(pkt.upPressed() != 2)
                    {
                        lyokoVehicleEntity.movingUp = pkt.upPressed() == 1;
                    }
                    if(pkt.downPressed() != 2)
                    {
                        lyokoVehicleEntity.movingDown = pkt.downPressed() == 1;
                    }
                }


            });
            netContext.get().setPacketHandled(true);
        }
    }

}
