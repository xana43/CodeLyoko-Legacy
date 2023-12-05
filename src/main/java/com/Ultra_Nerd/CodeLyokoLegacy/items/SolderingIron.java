package com.Ultra_Nerd.CodeLyokoLegacy.items;

import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;

public final class SolderingIron extends Item {
    public SolderingIron(@NotNull Settings properties) {
        super(properties);
    }


    @Override
    public boolean isDamageable() {
        return true;
    }
}
