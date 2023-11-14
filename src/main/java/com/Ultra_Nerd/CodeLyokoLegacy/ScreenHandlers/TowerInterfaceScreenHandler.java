package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public final class TowerInterfaceScreenHandler extends ScreenHandler {

    private final PlayerEntity player;
    private BlockPos currentPosition;
    public TowerInterfaceScreenHandler(final int syncId,final PlayerEntity player,final PacketByteBuf buf) {
        this(syncId,player);
        currentPosition = buf.readBlockPos();
    }
    public TowerInterfaceScreenHandler(final int syncId,final PlayerEntity player) {
        super(ModScreenHandlers.TOWER_INTERFACE_SCREEN_HANDLER, syncId);
        currentPosition = BlockPos.ORIGIN;
        this.player = player;

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
    public ItemStack quickMove(final PlayerEntity player, final int index) {
        return null;
    }

    @Override
    public boolean canUse(final PlayerEntity player) {
        return true;
    }


}

