package com.Ultra_Nerd.CodeLyokoLegacy.Recipies;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;

public final class LithographyRecipe extends AbstractCookingRecipe
{
    public LithographyRecipe(final String group, final CookingRecipeCategory category, final Ingredient ingredient, final ItemStack result, final float experience, final int cookingTime) {
        super(ModRecipes.RecipeTypes.LITHOGRAPHY_RECIPE_RECIPE_TYPE, group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.RecipeSerializers.LITHOGRAPHY_RECIPE_SERIALIZER;
    }
}
