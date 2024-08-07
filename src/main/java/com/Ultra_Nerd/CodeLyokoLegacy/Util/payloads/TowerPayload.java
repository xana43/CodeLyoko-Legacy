package com.Ultra_Nerd.CodeLyokoLegacy.Util.payloads;

import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.math.BlockPos;

public record TowerPayload(BlockPos pos, int state) implements CustomPayload {
    public static final CustomPayload.Id<TowerPayload> ID = new CustomPayload.Id<TowerPayload>(PacketHandler.TowerChannelID);
    public static final PacketCodec<RegistryByteBuf,TowerPayload> CODEC = PacketCodec.tuple(BlockPos.PACKET_CODEC,TowerPayload::pos, PacketCodecs.INTEGER,TowerPayload::state,TowerPayload::new);
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
