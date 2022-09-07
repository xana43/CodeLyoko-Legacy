package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.world.World;

public final class ComputerControlPanelScreenHandler extends ScreenHandler/*extends Container*/ {


    PropertyDelegate propertyDelegate;
    private final ScreenHandlerContext context;

    public ComputerControlPanelScreenHandler(final int syncId) {
        this(syncId, new ArrayPropertyDelegate(1), ScreenHandlerContext.EMPTY);

    }

    public ComputerControlPanelScreenHandler(final int syncId, PropertyDelegate propertyDelegate, ScreenHandlerContext context) {
        super(ModScreenHandlers.CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE, syncId);
        this.propertyDelegate = propertyDelegate;
        this.addProperties(propertyDelegate);
        this.context = context;


    }

    public boolean getIsActive() {
        return propertyDelegate.get(0) == 1;
    }

    public void setIsActive(boolean isActive) {
        propertyDelegate.set(0, isActive ? 1 : 0);
        this.sendContentUpdates();
        this.context.run(World::markDirty);
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
