package com.Ultra_Nerd.CodeLyokoLegacy.items;

import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;

public final class soldering_iron extends Item {
    public soldering_iron(@NotNull Settings properties) {
        super(properties);
    }


    @Override
    public boolean isDamageable() {
        return true;
    }
}
