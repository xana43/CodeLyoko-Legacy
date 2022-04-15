package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.LyokoVehicleEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public final record CustomControlServerHandler(byte upPressed, byte downPressed) {

    public static void syncToServer(final int upPressed, final int downPressed)
    {
        PacketHandler.INSTANCE.send(PacketDistributor.SERVER.with(()->null),new CustomControlServerHandler((byte)upPressed,(byte) downPressed));
    }

    public static @NotNull CustomControlServerHandler make(final @NotNull FriendlyByteBuf byteBuf)
    {
        return new CustomControlServerHandler(byteBuf.readByte(), byteBuf.readByte());
    }

    public static void encapsulate(final @NotNull CustomControlServerHandler pkt, final @NotNull FriendlyByteBuf byteBuf)
    {
        byteBuf.writeByte(pkt.upPressed);
        byteBuf.writeByte(pkt.downPressed);

        /*
        byteBuf.writeByte(pkt.upHeld);
        byteBuf.writeByte(pkt.downHeld);

         */
    }

    public static final class Handler{
        public static void handle(final @NotNull CustomControlServerHandler pkt, final @NotNull Supplier<NetworkEvent.Context> netContext)
        {
            netContext.get().enqueueWork(() -> {

                final ServerPlayer serverPlayer = netContext.get().getSender();
                if(serverPlayer == null)
                {
                    return;
                }
                if(serverPlayer.getVehicle() instanceof LyokoVehicleEntity lyokoVehicleEntity)
                {
                    if(pkt.upPressed() != 0)
                    {

                        lyokoVehicleEntity.movingUp = pkt.upPressed() == 1 || pkt.upPressed() == 2;
                    }
                    else {
                        lyokoVehicleEntity.movingUp = false;
                    }


                    if(pkt.downPressed() != 0)
                    {

                        lyokoVehicleEntity.movingDown = pkt.downPressed() == 1 || pkt.downPressed() == 2;
                    }
                    else
                    {
                        lyokoVehicleEntity.movingDown = false;

                    }
                }



            });
            netContext.get().setPacketHandled(true);
        }
    }

}
