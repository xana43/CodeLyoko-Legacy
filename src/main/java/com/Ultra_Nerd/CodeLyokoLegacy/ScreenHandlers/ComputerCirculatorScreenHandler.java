package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public final class ComputerCirculatorScreenHandler extends ScreenHandler {
    private final PlayerEntity player;
    private BlockPos currentPosition;
    public ComputerCirculatorScreenHandler(final int syncId,final PlayerEntity player) {
        super(ModScreenHandlers.COMPUTER_CIRCULATOR_SCREEN_HANDLER, syncId);
        currentPosition = BlockPos.ORIGIN;
        this.player = player;
    }
    public ComputerCirculatorScreenHandler(final int syncid,final PlayerEntity player,final PacketByteBuf buf)
    {
        this(syncid,player);
        currentPosition = buf.readBlockPos();
    }
    @Override
    public ItemStack quickMove(final PlayerEntity player, final int slot) {
        return null;
    }

    @Override
    public boolean canUse(final PlayerEntity player) {
        return false;
    }
}
