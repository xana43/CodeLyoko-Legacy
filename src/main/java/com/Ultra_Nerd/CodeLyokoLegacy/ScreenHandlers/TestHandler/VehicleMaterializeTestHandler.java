package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TestHandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public final class VehicleMaterializeTestHandler extends ScreenHandler {
    public VehicleMaterializeTestHandler(final int syncId) {
        //super(ModScreenHandlers.VEHICLE_MATERIALIZE_TEST_HANDLER_SCREEN_HANDLER_TYPE, syncId);
        super(ScreenHandlerType.ANVIL,syncId);
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
