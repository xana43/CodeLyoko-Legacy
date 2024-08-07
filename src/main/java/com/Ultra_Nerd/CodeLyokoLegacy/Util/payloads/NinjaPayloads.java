package com.Ultra_Nerd.CodeLyokoLegacy.Util.payloads;

import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.hit.BlockHitResult;

public record NinjaPayloads() {
    public record NinjaPayloadBlock(BlockHitResult blockHitResult) implements CustomPayload {
        public static final CustomPayload.Id<NinjaPayloadBlock> ID = new Id<>(PacketHandler.RAY_CAST);

        public static final PacketCodec<RegistryByteBuf,NinjaPayloadBlock> CODEC = PacketCodec.tuple(ConstantUtil.HIT_RESULT_PACKET_CODEC,NinjaPayloadBlock::blockHitResult,NinjaPayloadBlock::new);

        @Override
        public Id<? extends CustomPayload> getId() {
            return ID;
        }
    }
}
