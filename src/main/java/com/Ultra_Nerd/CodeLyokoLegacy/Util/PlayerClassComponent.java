package com.Ultra_Nerd.CodeLyokoLegacy.Util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoCardinalData;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public final class PlayerClassComponent implements AutoSyncedComponent {
   private Map<UUID,Integer> playerMap = new HashMap<>();
   private final PlayerEntity player;
   public PlayerClassComponent(PlayerEntity player/*, Map<UUID,Integer> playerMap*/)
   {

       this.player = player;
   }



    @Override
    public void writeSyncPacket(final PacketByteBuf buf, final ServerPlayerEntity recipient) {
        buf.writeMap(this.playerMap, PacketByteBuf::writeUuid, PacketByteBuf::writeVarInt);

    }

    @Override
    public void applySyncPacket(final PacketByteBuf buf) {
        this.playerMap = buf.readMap(PacketByteBuf::readUuid,PacketByteBuf::readInt);
    }

    public void setPlayerMap(Integer classID)
    {
        playerMap.put(this.player.getUuid(),classID);
        CodeLyokoCardinalData.pclass.sync(this.player);

    }

    @Override
    public boolean shouldSyncWith(final ServerPlayerEntity player) {
        return player == this.player;
    }

    @Override
    public void readFromNbt(final @NotNull NbtCompound tag) {
       final String uuid = player.getUuidAsString();


            this.playerMap.put(player.getUuid(), tag.getInt(uuid));
    }

    @Override
    public void writeToNbt(final @NotNull NbtCompound tag) {
        this.playerMap.forEach((uuid, integer) -> tag.putInt(uuid.toString(),integer));
    }
}
