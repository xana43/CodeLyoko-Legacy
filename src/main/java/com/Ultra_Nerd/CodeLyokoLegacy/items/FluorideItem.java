package com.Ultra_Nerd.CodeLyokoLegacy.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FluorideItem extends Item {
    public FluorideItem(@NotNull Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 1000;
    }


}
