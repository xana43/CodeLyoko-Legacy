package com.Ultra_Nerd.CodeLyokoLegacy.Util.payloads;

import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.math.BlockPos;

public record ControlPanelPayload(BlockPos pos,boolean active) implements CustomPayload {
    public static final CustomPayload.Id<ControlPanelPayload> ID = new CustomPayload.Id<>(PacketHandler.ChannelID);
    public static final PacketCodec<RegistryByteBuf,ControlPanelPayload> CODEC = PacketCodec.tuple(BlockPos.PACKET_CODEC,ControlPanelPayload::pos,PacketCodecs.BOOL,ControlPanelPayload::active,ControlPanelPayload::new);
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
