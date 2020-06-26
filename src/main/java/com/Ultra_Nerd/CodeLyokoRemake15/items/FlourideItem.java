package com.Ultra_Nerd.CodeLyokoRemake15.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FlourideItem extends Item {
    public FlourideItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 1000;
    }
}
