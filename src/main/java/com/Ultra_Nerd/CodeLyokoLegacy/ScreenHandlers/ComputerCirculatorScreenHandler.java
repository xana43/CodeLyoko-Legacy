package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public final class ComputerCirculatorScreenHandler extends ScreenHandler {
    private final PlayerEntity player;
    private byte[] flowDirections;
    private BlockPos currentPosition;
    public ComputerCirculatorScreenHandler(final int syncId,final PlayerEntity player) {
        super(ModScreenHandlers.COMPUTER_CIRCULATOR_SCREEN_HANDLER, syncId);
        currentPosition = BlockPos.ORIGIN;
        flowDirections = new byte[]{};
        this.player = player;
    }
    public ComputerCirculatorScreenHandler(final int syncID,final PlayerEntity player,final PacketByteBuf buf)
    {
        this(syncID,player);
        currentPosition = buf.readBlockPos();
        flowDirections = buf.readByteArray();
    }

    public byte[] getFlowDirections()
    {
        return flowDirections;
    }
    public BlockPos getCurrentPosition()
    {
        return currentPosition;
    }
    public PlayerEntity getPlayer()
    {
        return player;
    }
    @Override
    public ItemStack quickMove(final PlayerEntity player, final int slot) {
        return null;
    }

    @Override
    public boolean canUse(final PlayerEntity player) {
        return true;
    }
}
