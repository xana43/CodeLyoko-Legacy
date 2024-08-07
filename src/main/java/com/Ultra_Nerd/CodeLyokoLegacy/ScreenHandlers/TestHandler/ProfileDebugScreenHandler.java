package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TestHandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.world.WorldProperties;

public final class ProfileDebugScreenHandler extends ScreenHandler {
    private final WorldProperties worldProperties;
    private final PlayerEntity player;
    public ProfileDebugScreenHandler(final int syncId,
            final PlayerEntity player,final WorldProperties worldProperties) {
        //super(ModScreenHandlers.PROFILE_DEBUG_SCREEN_HANDLER_SCREEN_HANDLER_TYPE, syncId);
        super(ScreenHandlerType.ANVIL,syncId);
        this.player = player;
        this.worldProperties = worldProperties;
    }

    public WorldProperties getWorldProperties() {
        return worldProperties;
    }

    public PlayerEntity getPlayer() {
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
