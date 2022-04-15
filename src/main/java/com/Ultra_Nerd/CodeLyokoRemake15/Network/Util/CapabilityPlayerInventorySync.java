package com.Ultra_Nerd.CodeLyokoRemake15.Network.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.player.Capabilities.CapabilityRegistration;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public record CapabilityPlayerInventorySync(ListTag playerInventory) {
    public static void Sync(ListTag playerInventory)
    {
        PacketHandler.INSTANCE.sendToServer(new CapabilityPlayerInventorySync(playerInventory));
    }

    public static @NotNull CapabilityPlayerInventorySync make(final @NotNull FriendlyByteBuf byteBuf)
    {


        return new CapabilityPlayerInventorySync(byteBuf.readCollection(value ->
        {
            ListTag tag = new ListTag();
            for(int i = 0; i < value; i++)
            {
                tag.set(i, NbtOps.INSTANCE.empty());
            }
            return tag;



        }, FriendlyByteBuf::readAnySizeNbt));

    }

    public static void encapsulate(CapabilityPlayerInventorySync caps, FriendlyByteBuf buf)
    {
        for(int i =0; i < caps.playerInventory().size(); i++)
        {
            buf.writeNbt(caps.playerInventory().getCompound(i));
        }

    }

    public static final class Handler
    {
        public static void handle(final CapabilityPlayerInventorySync pky, final Supplier<NetworkEvent.Context> ctx)
        {

            ctx.get().enqueueWork(() -> {
                final ServerPlayer player = ctx.get().getSender();

                assert player != null;
                ServerSaveHandler.send(false);
                player.getCapability(CapabilityRegistration.INVENTORY_CAPABILITY).ifPresent(cap -> {
                    cap.savePlayerInventory(player);
               });


            });
            ctx.get().setPacketHandled(true);
        }
    }
}
