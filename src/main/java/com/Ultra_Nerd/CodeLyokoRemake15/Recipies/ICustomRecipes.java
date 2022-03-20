package com.Ultra_Nerd.CodeLyokoRemake15.Recipies;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;


public interface ICustomRecipes extends Recipe<RecipeWrapper> {

    ResourceLocation RECIPE_TYPE = new ResourceLocation(Base.MOD_ID, "recipetypes");

    @Nonnull
    @Override
    default RecipeType<?> getType() {
        return Registry.RECIPE_TYPE.get(RECIPE_TYPE);
    }



    @Override
    default boolean canCraftInDimensions(int width, int height) {
        return false;
    }



    @Override
    default NonNullList<Ingredient> getIngredients() {
        return Recipe.super.getIngredients();
    }
}
