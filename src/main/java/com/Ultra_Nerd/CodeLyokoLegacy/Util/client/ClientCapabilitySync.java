package com.Ultra_Nerd.CodeLyokoLegacy.Util.client;

import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerClassType;

public final class ClientCapabilitySync {
    private static PlayerClassType playerClassType;

    public static void setServerData(PlayerClassType playerTypeIn)
    {

        playerClassType = playerTypeIn;

    }

    public static PlayerClassType getPlayerClassType()
    {

        return playerClassType;

    }


}
