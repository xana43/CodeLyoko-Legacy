package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProperties;

public final class ComputerInterfaceScreenHandler extends ScreenHandler {
    private BlockPos pos;
    private final PlayerEntity player;
    private WorldProperties worldProperties;
    public ComputerInterfaceScreenHandler(final int syncId,final PlayerEntity player,
            final WorldProperties worldProperties,final PacketByteBuf buf) {
        this(syncId,player);
        pos = buf.readBlockPos();
        this.worldProperties = worldProperties;
    }
    public ComputerInterfaceScreenHandler(final int syncId,final PlayerEntity player) {
        super(ModScreenHandlers.COMPUTER_INTERFACE_SCREEN_SCREEN_HANDLER_TYPE, syncId);
        pos = BlockPos.ORIGIN;
        this.player = player;
    }

    public WorldProperties getWorldProperties() {
        return worldProperties;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public BlockPos getPos() {
        return pos;
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
