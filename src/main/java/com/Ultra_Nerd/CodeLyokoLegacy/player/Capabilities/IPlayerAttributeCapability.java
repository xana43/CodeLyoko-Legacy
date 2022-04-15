package com.Ultra_Nerd.CodeLyokoLegacy.player.Capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;

public interface IPlayerAttributeCapability extends INBTSerializable<CompoundTag>
{
    void getPlayer(Player player);
    void update();
    void attribute(CompoundTag attribute);

}
