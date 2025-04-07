package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity;

import net.minecraft.util.math.BlockPos;

/**
 * @author Ultra_Nerd
 * @desc <br/>
 * @since 2025-03-19
 */
public interface CableNetworkConnectedBlockEntity
{
    boolean isConnected();
    BlockPos getConnectedPos();
    void tryConnect();
    void tryDisconnect();
    default boolean canConnect(){
        return true;
    }
}
