package com.Ultra_Nerd.CodeLyokoRemake15.Recipies;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;


public interface ICustomRecipes extends IRecipe<RecipeWrapper> {

    ResourceLocation RECIPE_TYPE = new ResourceLocation(Base.MOD_ID, "recipetypes");

    @Nonnull
    @Override
    default IRecipeType<?> getType()
    {
        return Registry.RECIPE_TYPE.getValue(RECIPE_TYPE).get();
    }

    @Override
    default boolean canFit(int width, int height)
    {
        return false;
    }

    Ingredient getInput();
}
