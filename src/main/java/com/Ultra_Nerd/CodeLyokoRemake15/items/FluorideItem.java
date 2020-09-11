package com.Ultra_Nerd.CodeLyokoRemake15.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FluorideItem extends Item {
    public FluorideItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 1000;
    }
}
