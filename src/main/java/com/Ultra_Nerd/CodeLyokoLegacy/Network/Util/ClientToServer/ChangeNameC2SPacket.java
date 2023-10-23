package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.IdBlockEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.util.blockentity.RenameableBlockEntity;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public record ChangeNameC2SPacket() {


    public static final ChangeNameC2SPacket INSTANCE = new ChangeNameC2SPacket();


    public static void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
            final BlockPos pos = buf.readBlockPos();
            final String newName = buf.readString();
            final int id = buf.readInt();
            server.execute(() -> {

                final BlockEntity blockEntity = player.getWorld().getBlockEntity(pos);
                    if(blockEntity instanceof final RenameableBlockEntity renameable && blockEntity instanceof final IdBlockEntity idBlockEntity)
                    {
                        if(newName != null && !newName.isEmpty() && id > -1) {
                            CodeLyokoMain.LOG.warn("setting name and id");
                            renameable.rename(newName);
                            idBlockEntity.setId(id);
                        }
                        else if((newName == null || newName.isEmpty()) && id >-1) {
                            CodeLyokoMain.LOG.warn("setting id only");
                            idBlockEntity.setId(id);
                        }
                        else if(newName != null && !newName.isEmpty()) {
                            CodeLyokoMain.LOG.warn("setting name only");
                            renameable.rename(newName);
                        }

                    } else if (blockEntity instanceof final RenameableBlockEntity renameableBlockEntity) {
                        renameableBlockEntity.rename(newName);
                    } else if (blockEntity instanceof final IdBlockEntity idBlockEntity) {
                        if(id > -1) {
                            idBlockEntity.setId(id);
                        }
                        else {
                            CodeLyokoMain.LOG.warn("message sent is an id that is <= -1");
                        }
                    }
                //ServerPlayNetworking.send(player, PacketHandler.REFRESH, PacketByteBufs.empty());
            });
    }
}
