package com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.ClientToServer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blocks.SuperCalculator.ControlPanel;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.payloads.ControlPanelPayload;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public record AuxiliaryControlPanelActivationC2SPacket() {

    public static void receive(final ControlPanelPayload controlPanelPayload, final ServerPlayNetworking.Context context) {
        final BlockPos pos = controlPanelPayload.pos();
        final boolean active = controlPanelPayload.active();
        final ServerPlayerEntity player = context.player();
        player.getWorld().setBlockState(pos, player.getWorld().getBlockState(pos).with(ControlPanel.ScreenOn, active));
    }
}
