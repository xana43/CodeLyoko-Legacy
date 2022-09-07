package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;

public final class TowerInterfaceScreenHandler extends ScreenHandler {

    public TowerInterfaceScreenHandler(final int syncId) {
        super(ModScreenHandlers.TOWER_INTERFACE_SCREEN_HANDLER, syncId);

    }

    @Override
    public ItemStack transferSlot(final PlayerEntity player, final int index) {
        return null;
    }

    @Override
    public boolean canUse(final PlayerEntity player) {
        return true;
    }


}

