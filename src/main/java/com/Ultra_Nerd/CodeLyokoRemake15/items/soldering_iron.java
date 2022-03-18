package com.Ultra_Nerd.CodeLyokoRemake15.items;

import net.minecraft.item.Item;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class soldering_iron extends Item {
    public soldering_iron(Properties properties) {
        super(properties);
    }



    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }
}
