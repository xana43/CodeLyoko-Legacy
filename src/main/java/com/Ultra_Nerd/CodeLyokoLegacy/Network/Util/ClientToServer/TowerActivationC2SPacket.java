package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.TowerInterfaceTileEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.payloads.TowerPayload;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.math.BlockPos;

import java.util.Optional;

public record TowerActivationC2SPacket() {
    public static void receive(final TowerPayload towerPayload, final ServerPlayNetworking.Context context) {
        final BlockPos pos = towerPayload.pos();
        final int activationState = towerPayload.state();
           final Optional<TowerInterfaceTileEntity> optionalBlockEntity = context.player().getWorld().getBlockEntity(pos, ModBlockEntities.TOWER_INTERFACE_TILE_ENTITY);
            optionalBlockEntity.ifPresent(towerInterfaceTileEntity -> towerInterfaceTileEntity.calculateTowerActivation(activationState));
    }
}
