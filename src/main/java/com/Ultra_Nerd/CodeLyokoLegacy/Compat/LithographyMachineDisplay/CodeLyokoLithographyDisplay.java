package com.Ultra_Nerd.CodeLyokoLegacy.Compat.LithographyMachineDisplay;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;

import java.util.List;

public final class CodeLyokoLithographyDisplay extends BasicDisplay {
    public CodeLyokoLithographyDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return null;
    }
    /*
    public CodeLyokoLithographyDisplay(final RecipeEntry<LithographyRecipe> recipeEntry)
    {
        super(getInputList(recipeEntry.value()),getOutputList(recipeEntry.value()));
    }
    private static List<EntryIngredient> getInputList(final LithographyRecipe recipe) {
        if(recipe == null) {
            return ObjectLists.emptyList();
        }
        final ObjectList<EntryIngredient> list = new ObjectArrayList<>();
        for(final Ingredient ingredient : recipe.getIngredients())
        {
            list.add(EntryIngredients.ofIngredient(ingredient));
        }
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
    }*/
}
