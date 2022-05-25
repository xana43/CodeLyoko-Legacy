package com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModScreenHandlers;
import net.minecraft.client.gui.screen.ingame.BeaconScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.*;

public final class ComputerControlPanelScreenHandler extends ScreenHandler/*extends Container*/  {

private boolean isActive;


    public ComputerControlPanelScreenHandler(final int syncId, final PacketByteBuf buf)
    {this(syncId);
     isActive = buf.readBoolean();
    }
    public ComputerControlPanelScreenHandler(final int syncId) {
        super(ModScreenHandlers.CONTROL_PANEL_SCREEN_HANDLER_SCREEN_HANDLER_TYPE, syncId);




    }


public boolean isActive()
{
    return isActive;
}






    @Override
    public boolean canUse(final PlayerEntity player) {

        return true;
    }

    @Override
    public boolean onButtonClick(final PlayerEntity player, final int id) {
        CodeLyokoMain.LOG.info("test click");
        return super.onButtonClick(player, id);
    }
}
