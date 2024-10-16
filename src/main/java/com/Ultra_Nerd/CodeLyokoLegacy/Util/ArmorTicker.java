package com.Ultra_Nerd.CodeLyokoLegacy.Util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public interface ArmorTicker {
    @SuppressWarnings("UnnecessaryReturnStatement")
    default void onArmorTick(final PlayerEntity player, final World world, final Item armorItem, final int slot)
    {

        if(!MethodUtil.ArmorMethods.isArmorSlot(slot))
        {
            return;
        }
    }
}
