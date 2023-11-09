package com.Ultra_Nerd.CodeLyokoLegacy.Compat.LithographyMachineDisplay;

import com.Ultra_Nerd.CodeLyokoLegacy.Recipies.LithographyRecipe;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.util.List;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.recipe.RecipeEntry;

public final class CodeLyokoLithographyDisplay extends BasicDisplay {
    public CodeLyokoLithographyDisplay(final RecipeEntry<LithographyRecipe> recipeEntry)
    {
        super(getInputList(recipeEntry.value()),getOutputList(recipeEntry.value()));
    }
    private static List<EntryIngredient> getInputList(final LithographyRecipe recipe) {
        if(recipe == null) {
            return ObjectLists.emptyList();
        }
        final List<EntryIngredient> list = new ObjectArrayList<>();
        list.add(EntryIngredients.ofIngredient(recipe.getIngredients().get(0)));
        return list;
    }
    private static List<EntryIngredient> getOutputList(final LithographyRecipe recipe) {
        if(recipe == null){ 
            return ObjectLists.emptyList();
        }
        final List<EntryIngredient> list = new ObjectArrayList<>();
        list.add(EntryIngredients.of(recipe.getResult(null)));
        return list;
    }
    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return CodeLyokoLithographyCategory.LITHOGRAPHY_DISPLAY_CATEGORY_IDENTIFIER;
    }
}