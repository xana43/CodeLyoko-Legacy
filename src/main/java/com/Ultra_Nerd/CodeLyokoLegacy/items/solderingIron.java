package com.Ultra_Nerd.CodeLyokoLegacy.items;

import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;

public final class solderingIron extends Item {
    public solderingIron(@NotNull Settings properties) {
        super(properties);
    }


    @Override
    public boolean isDamageable() {
        return true;
    }
}
