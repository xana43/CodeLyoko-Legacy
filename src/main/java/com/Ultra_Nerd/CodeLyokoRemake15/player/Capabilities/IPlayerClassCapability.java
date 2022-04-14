package com.Ultra_Nerd.CodeLyokoRemake15.player.Capabilities;

import com.Ultra_Nerd.CodeLyokoRemake15.player.PlayerClassType;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;
import org.jetbrains.annotations.NotNull;

public  sealed interface IPlayerClassCapability extends INBTSerializable<CompoundTag> permits PlayerClassCapabilityHandler {

    //void setPlayer(Player player);
    void setClass(PlayerClassType tag);
    @NotNull
    PlayerClassType getClassType();


}
