package com.Ultra_Nerd.CodeLyokoLegacy.Recipies;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.util.Identifier;

public class ReactorRecipe extends AbstractCookingRecipe {
    public ReactorRecipe(final Identifier id, final String group, final CookingRecipeCategory category, final Ingredient input, final ItemStack output, final float experience, final int cookTime) {
        super(ModRecipes.RecipeTypes.REACTOR_RECIPE_TYPE, id, group, category, input, output, experience, cookTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.RecipeSerializers.REACTOR_RECIPE_SERIALIZER;
    }
}
