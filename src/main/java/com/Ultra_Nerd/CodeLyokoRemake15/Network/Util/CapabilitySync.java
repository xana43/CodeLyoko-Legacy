package com.Ultra_Nerd.CodeLyokoRemake15.Network.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.player.Capabilities.CapabilityRegistration;
import com.Ultra_Nerd.CodeLyokoRemake15.player.PlayerClassType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public record CapabilitySync(CompoundTag playerClassTag, PlayerClassType playerClassType) {

    public static void Sync(PlayerClassType classType)
    {
      PacketHandler.INSTANCE.sendToServer(new CapabilitySync(classType.getClassTag(),classType));
    }


    public static @NotNull CapabilitySync make(final @NotNull FriendlyByteBuf byteBuf)
    {
        return new CapabilitySync(byteBuf.readNbt(),byteBuf.readEnum(PlayerClassType.class));
    }

    public static void encapsulate(CapabilitySync caps,FriendlyByteBuf buf)
    {
        buf.writeNbt(caps.playerClassTag);
        buf.writeEnum(caps.playerClassType);
    }

    public static final class Handler
    {
        public static void handle(final CapabilitySync pky, final Supplier<NetworkEvent.Context> ctx)
        {

            ctx.get().enqueueWork(() -> {
                final ServerPlayer player = ctx.get().getSender();

                assert player != null;

                player.getCapability(CapabilityRegistration.CLASS_CAPABILITY).ifPresent(cap -> {
                    //cap.setPlayer(player);
                    cap.setClass(pky.playerClassType);

                    //cap.deserializeNBT(pky.playerClassTag);





                });


            });
            ctx.get().setPacketHandled(true);
        }
    }

}
