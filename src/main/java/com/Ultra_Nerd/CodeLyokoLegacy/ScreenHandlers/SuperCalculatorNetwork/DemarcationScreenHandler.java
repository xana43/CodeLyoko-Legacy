package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.SuperCalculatorNetwork;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public final class DemarcationScreenHandler extends ScreenHandler {
    private BlockPos pos;
    private final PropertyDelegate delegate;

    public DemarcationScreenHandler(final int syncId, final PacketByteBuf buf) {
        this(syncId,new ArrayPropertyDelegate(1));
        pos = buf.readBlockPos();

    }
    public DemarcationScreenHandler(final int syncId, final PropertyDelegate propertyDelegate)
    {
        super(ModScreenHandlers.DEMARCATION_SCREEN_HANDLER_TYPE,syncId);
        pos = BlockPos.ORIGIN;
        this.delegate = propertyDelegate;
        this.addProperties(delegate);
    }

    public BlockPos getPos() {
        return pos;
    }

    public int getId() {
        return delegate.get(0);
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
