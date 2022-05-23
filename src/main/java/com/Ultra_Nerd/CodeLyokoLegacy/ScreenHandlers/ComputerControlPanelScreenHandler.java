package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModScreenHandlers;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerSyncHandler;

public final class ComputerControlPanelScreenHandler extends ScreenHandler/*extends Container*/  {
        PropertyDelegate propertyDelegate;

    public ComputerControlPanelScreenHandler(final int id)
    {
        this(id,new ArrayPropertyDelegate(1));
    }

    public ComputerControlPanelScreenHandler(final int syncId, final PropertyDelegate propertyDelegate) {
        super(ModScreenHandlers.CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE, syncId);
        this.propertyDelegate = propertyDelegate;
        this.addProperties(propertyDelegate);



    }





    public int getPropertyVal()
    {
        return propertyDelegate.get(0);
    }

    @Override
    public void setProperty(final int id, final int value) {

        super.setProperty(id, value);


    }

    @Override
    public boolean canUse(final PlayerEntity player) {

        return true;
    }




}
