package com.Ultra_Nerd.CodeLyokoLegacy.Recipies;

public class RecipeSerializers /*extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<TestRecipe>*/ {


/*
    @Nonnull
    @Override
    public TestRecipe fromJson(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
        ItemStack output = CraftingHelper.getItemStack(GetJSongetJsonObject(json, "output"), true);
        Ingredient Input = Ingredient.fromJson(JSONUtils.getJsonObject(json, "input"));
        return new TestRecipe(recipeId, Input, output);
    }

    @Override
    public @Nullable TestRecipe fromJson(ResourceLocation p_44103_, JsonObject p_44104_) {
        return null;
    }

    @Override
    public TestRecipe fromNetwork(@Nonnull ResourceLocation recipeId, @NotNull FriendlyByteBuf buffer) {
        ItemStack output = buffer.readItem();
        Ingredient input = Ingredient.fromNetwork(buffer);
        return new TestRecipe(recipeId, input, output);
    }



    @Override
    public void toNetwork(@Nonnull FriendlyByteBuf buffer, @NotNull TestRecipe recipe) {
        Ingredient input = recipe.getIngredients().get(0);
        input.toNetwork(buffer);
        buffer.writeItemStack(recipe.getResultItem(), false);
    }

 */
}
