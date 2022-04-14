package com.Ultra_Nerd.CodeLyokoRemake15.Util.client;

import com.Ultra_Nerd.CodeLyokoRemake15.player.PlayerClassType;

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
