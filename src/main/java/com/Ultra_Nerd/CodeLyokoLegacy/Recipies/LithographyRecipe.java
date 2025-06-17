package com.Ultra_Nerd.CodeLyokoLegacy.Recipies;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModRecipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeBookCategory;

public final class LithographyRecipe extends AbstractCookingRecipe
{
    public LithographyRecipe(final String group, final CookingRecipeCategory category, final Ingredient ingredient, final ItemStack result, final float experience, final int cookingTime) {
        super(group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return ModRecipes.RecipeSerializers.LITHOGRAPHY_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends AbstractCookingRecipe> getType() {
        return ModRecipes.RecipeTypes.LITHOGRAPHY_RECIPE_RECIPE_TYPE;
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return null;
    }

    @Override
    protected Item getCookerItem() {
        return null;
    }
}
