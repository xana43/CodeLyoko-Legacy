package com.Ultra_Nerd.CodeLyokoLegacy.Compat;

import com.Ultra_Nerd.CodeLyokoLegacy.Compat.LithographyMachineDisplay.CodeLyokoLithographyCategory;
import com.Ultra_Nerd.CodeLyokoLegacy.Compat.LithographyMachineDisplay.CodeLyokoLithographyDisplay;
import com.Ultra_Nerd.CodeLyokoLegacy.Compat.ReactorDisplay.CodeLyokoReactorCategory;
import com.Ultra_Nerd.CodeLyokoLegacy.Compat.ReactorDisplay.CodeLyokoReactorDisplay;
import com.Ultra_Nerd.CodeLyokoLegacy.Recipies.LithographyRecipe;
import com.Ultra_Nerd.CodeLyokoLegacy.Recipies.ReactorRecipe;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModRecipes;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.LithographyGUI;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ReactorGUI;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public record CodeLyokoREIClientPlugin() implements REIClientPlugin {


    @Override
    public void registerCategories(final CategoryRegistry registry) {
    registry.add(new CodeLyokoReactorCategory());
    registry.addWorkstations(CodeLyokoReactorCategory.REACTOR_DISPLAY_CATEGORY_IDENTIFIER, EntryStacks.of(ModBlocks.URANIUM_REACTOR));
    registry.add(new CodeLyokoLithographyCategory());
    registry.addWorkstations(CodeLyokoLithographyCategory.LITHOGRAPHY_DISPLAY_CATEGORY_IDENTIFIER, EntryStacks.of(ModBlocks.LITHOGRAPHY_MACHINE));
    }

    @Override
    public void registerDisplays(final DisplayRegistry registry) {
        registry.registerRecipeFiller(ReactorRecipe.class, ModRecipes.RecipeTypes.REACTOR_RECIPE_TYPE, CodeLyokoReactorDisplay::new);
        registry.registerRecipeFiller(LithographyRecipe.class,ModRecipes.RecipeTypes.LITHOGRAPHY_RECIPE_RECIPE_TYPE, CodeLyokoLithographyDisplay::new);
    }

    @Override
    public void registerScreens(final ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75,30,20,30), ReactorGUI.class,CodeLyokoReactorCategory.REACTOR_DISPLAY_CATEGORY_IDENTIFIER);
        registry.registerClickArea(screen -> new Rectangle(75,30,20,30), LithographyGUI.class,CodeLyokoLithographyCategory.LITHOGRAPHY_DISPLAY_CATEGORY_IDENTIFIER);
    }
}
