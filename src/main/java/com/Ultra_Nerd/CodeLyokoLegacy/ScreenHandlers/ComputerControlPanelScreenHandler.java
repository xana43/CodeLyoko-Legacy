package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.math.BlockPos;

public final class ComputerControlPanelScreenHandler extends ScreenHandler {


    private BlockPos pos;
    private boolean isActive;

    public ComputerControlPanelScreenHandler(final int syncId, final PacketByteBuf buf) {
        this(syncId);
        pos = buf.readBlockPos();
        isActive = buf.readBoolean();
    }

    public ComputerControlPanelScreenHandler(final int syncId) {
        //super(ModScreenHandlers.CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE, syncId);
        super(ScreenHandlerType.ANVIL,syncId);
        pos = BlockPos.ORIGIN;


    }

    public BlockPos getPos() {
        return pos;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public ItemStack quickMove(final PlayerEntity player, final int index) {
        return null;
    }

    @Override
    public boolean canUse(final PlayerEntity player) {

        return true;
    }


}
