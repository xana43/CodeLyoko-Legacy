package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerClassType;
import net.minecraft.nbt.NbtCompound;

public record CapabilityPlayerClassSync(NbtCompound playerClassTag, PlayerClassType playerClassType) {
/*
    public static void Sync(PlayerClassType classType)
    {
      PacketHandler.INSTANCE.send(PacketDistributor.SERVER.with(() -> null),new CapabilityPlayerClassSync(classType.getClassTag(),classType));
    }


    public static @NotNull CapabilityPlayerClassSync make(final @NotNull FriendlyByteBuf byteBuf)
    {
        return new CapabilityPlayerClassSync(byteBuf.readNbt(),byteBuf.readEnum(PlayerClassType.class));

    }

    public static void encapsulate(CapabilityPlayerClassSync caps, FriendlyByteBuf buf)
    {
        buf.writeNbt(caps.playerClassTag);
        buf.writeEnum(caps.playerClassType);
    }

    public static final class Handler
    {
        public static void handle(final CapabilityPlayerClassSync pky, final Supplier<NetworkEvent.Context> ctx)
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

 */

}
