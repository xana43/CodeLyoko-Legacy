package com.Ultra_Nerd.CodeLyokoLegacy.Util.payloads;

import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;

/**
 * @author Leon Sun
 * @desc <br/>
 * @since 2024-06-12
 */
public record ClassScreenPayload(int classInt) implements CustomPayload {
    public static final CustomPayload.Id<ClassScreenPayload> ID = new CustomPayload.Id<>(PacketHandler.ClassScreenID);
    public static final PacketCodec<RegistryByteBuf,ClassScreenPayload> CODEC = PacketCodec.tuple(PacketCodecs.INTEGER,ClassScreenPayload::classInt,ClassScreenPayload::new);
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
