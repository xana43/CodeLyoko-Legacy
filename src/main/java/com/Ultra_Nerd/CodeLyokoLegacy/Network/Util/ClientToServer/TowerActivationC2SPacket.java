package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.TowerInterfaceTileEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModBlockEntities;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

import java.util.Optional;

public record TowerActivationC2SPacket() {
    public static void receive(final MinecraftServer server, final ServerPlayerEntity player, final ServerPlayNetworkHandler handler, final PacketByteBuf buf, final PacketSender packetSender) {
        final BlockPos pos = buf.readBlockPos();
        final int activationState = buf.readInt();
        server.execute(() -> {
           final Optional<TowerInterfaceTileEntity> optionalBlockEntity = player.getWorld().getBlockEntity(pos, ModBlockEntities.TOWER_INTERFACE_TILE_ENTITY);
            optionalBlockEntity.ifPresent(towerInterfaceTileEntity -> towerInterfaceTileEntity.calculateTowerActivation(activationState));
        });
    }
}
