package com.Ultra_Nerd.CodeLyokoRemake15.Network.Util;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.function.Supplier;

public record ServerSaveHandler(boolean saveall) {
    public static void send(final boolean save)
    {
        PacketHandler.INSTANCE.send(PacketDistributor.SERVER.with(() -> null),new ServerSaveHandler(save));
    }

    public static ServerSaveHandler make(final FriendlyByteBuf byteBuf)
    {
        return new ServerSaveHandler(byteBuf.readBoolean());
    }

    public static void encapsulate(final ServerSaveHandler pkt,final  FriendlyByteBuf buf)
    {
        buf.writeBoolean(pkt.saveall);
    }
    public static final class SaveHandleer{
        public static void saveServer(final ServerSaveHandler pku, final Supplier<NetworkEvent.Context> ctx)
        {
            ctx.get().enqueueWork(() ->{
                final ServerPlayer serverPlayer = ctx.get().getSender();
                if(serverPlayer == null)
                {
                    return;
                }
                if(!serverPlayer.server.isSingleplayer())
                {

                    if(pku.saveall)
                    {
                        serverPlayer.server.saveEverything(false,true,false);
                    }
                    else
                    {


                        serverPlayer.server.getPlayerList().saveAll();

                    }
                }

            });
            ctx.get().setPacketHandled(true);
        }
    }
}
