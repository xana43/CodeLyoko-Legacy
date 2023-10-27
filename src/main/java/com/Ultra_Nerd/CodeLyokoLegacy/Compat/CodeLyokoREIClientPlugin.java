package com.Ultra_Nerd.CodeLyokoLegacy.Compat;

import com.Ultra_Nerd.CodeLyokoLegacy.Recipies.ReactorRecipe;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModRecipes;
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
    }

    @Override
    public void registerDisplays(final DisplayRegistry registry) {
        registry.registerRecipeFiller(ReactorRecipe.class, ModRecipes.RecipeTypes.REACTOR_RECIPE_TYPE,CodeLyokoReactorDisplay::new);
    }

    @Override
    public void registerScreens(final ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75,30,20,30), ReactorGUI.class,CodeLyokoReactorCategory.REACTOR_DISPLAY_CATEGORY_IDENTIFIER);
    }
}
