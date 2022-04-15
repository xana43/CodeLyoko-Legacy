package com.Ultra_Nerd.CodeLyokoLegacy.Recipies;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;


public interface ICustomRecipes extends Recipe<RecipeWrapper> {

    ResourceLocation RECIPE_TYPE = new ResourceLocation(CodeLyokoMain.MOD_ID, "recipetypes");

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
    default @NotNull NonNullList<Ingredient> getIngredients() {
        return Recipe.super.getIngredients();
    }
}
