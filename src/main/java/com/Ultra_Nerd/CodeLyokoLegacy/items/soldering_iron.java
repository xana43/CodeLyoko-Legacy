package com.Ultra_Nerd.CodeLyokoLegacy.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class soldering_iron extends Item {
    public soldering_iron(@NotNull Properties properties) {
        super(properties);
    }



    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }
}
