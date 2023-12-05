package com.Ultra_Nerd.CodeLyokoLegacy.Recipies;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;

public class ReactorRecipe extends AbstractCookingRecipe {


    public ReactorRecipe(final String group, final CookingRecipeCategory category, final Ingredient ingredient, final ItemStack result, final float experience, final int cookingTime) {
        super(ModRecipes.RecipeTypes.REACTOR_RECIPE_TYPE, group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.RecipeSerializers.REACTOR_RECIPE_SERIALIZER;
    }
}
