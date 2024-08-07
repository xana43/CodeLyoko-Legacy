package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables.CustomRecipeBuilderProviders;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFuels;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;

public final class CustomCookingRecipeJsonBuilder implements CraftingRecipeJsonBuilder {
    private final RecipeCategory category;
    private final CookingRecipeCategory cookingRecipeCategory;
    private final Ingredient input;
    private final Item output;
    private final float experience;
    private final int cookingTime;
  private final Map<String, AdvancementCriterion<?>> criteria = new Object2ObjectLinkedOpenHashMap<>();
    private String group;
    private final RecipeSerializer<? extends AbstractCookingRecipe> serializer;

    private CustomCookingRecipeJsonBuilder(final RecipeCategory category, final CookingRecipeCategory cookingRecipeCategory, final ItemConvertible output, final Ingredient input, final float experience, final int cookingTime, final RecipeSerializer<? extends AbstractCookingRecipe> serializer) {
        this.category = category;
        this.cookingRecipeCategory = cookingRecipeCategory;
        this.output = output.asItem();
        this.input = input;
        this.experience = experience;
        this.cookingTime = cookingTime;
        this.serializer = serializer;
    }

    @Override
    public CraftingRecipeJsonBuilder criterion(final String name, final AdvancementCriterion<?> conditions) {
        this.criteria.put(name, conditions);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable final String group) {
        this.group = group;
        return this;
    }

    private static int getModFuelTime(final Ingredient ingredient) {
        for (final ItemStack stack : ingredient.getMatchingStacks()) {
            if (ModFuels.FUEL_MAP.containsKey(stack.getItem())) {
                return ModFuels.FUEL_MAP.get(stack.getItem());
            }
        }
        CodeLyokoMain.LOG.warn("no fuel time found falling back");
        return 200;
    }

    public static CustomCookingRecipeJsonBuilder create(final Ingredient input, final RecipeCategory category, final ItemConvertible output, final float experience, final RecipeSerializer<? extends AbstractCookingRecipe> serializer) {
        return new CustomCookingRecipeJsonBuilder(category, CookingRecipeCategory.MISC, output, input, experience, getModFuelTime(input), serializer);
    }

    @Override
    public Item getOutputItem() {
        return this.output;
    }

    private void validate(final Identifier recipeId) {
        if (this.criteria.isEmpty()) {
            throw new IllegalArgumentException("No way of obtaining recipe " + recipeId);
        }
    }

    @Override
    public void offerTo(final RecipeExporter exporter, final Identifier recipeId) {
        this.validate(recipeId);
        final Advancement.Builder builder = exporter.getAdvancementBuilder().criterion("has_the_recipe",RecipeUnlockedCriterion.create(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        Objects.requireNonNull(builder);
        this.criteria.forEach(builder::criterion);
        //exporter.accept(new CustomCookingRecipeJsonProvider(recipeId, this.group == null ? "" : this.group, this.cookingRecipeCategory, input, output, experience, cookingTime, builder.build(recipeId.withPrefixedPath("recipes/" + this.category.getName() + "/")), serializer));
    }

  /*  private record CustomCookingRecipeJsonProvider(Identifier recipeId, String group
            , CookingRecipeCategory cookingRecipeCategory, Ingredient input, Item result,
                                                   float experience, int cookingTime,
                                                   AdvancementEntry advancementEntry
            ,
                                                   RecipeSerializer<? extends AbstractCookingRecipe> serializer) implements RecipeJsonProvider {

        @Override
        public void serialize(final JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }
            json.addProperty("category", this.cookingRecipeCategory.asString());
            json.add("ingredient", this.input.toJson(false));
            json.addProperty("result", Registries.ITEM.getId(this.result).toString());
            json.addProperty("experience", this.experience);
            json.addProperty("cookingtime", this.cookingTime);
        }

        @Override
        public Identifier id() {
            return recipeId;
        }

        @Override
        public AdvancementEntry advancementEntry() {
            return advancementEntry;
        }



        @Override
        public RecipeSerializer<? extends AbstractCookingRecipe> serializer() {
            return serializer;
        }
        public String getGroup()
        {
            return group;
        }
       public CookingRecipeCategory getCategory()
       {
           return cookingRecipeCategory;
       }
       public float getExperience()
       {
           return experience;
       }
       public int getCookingTime()
       {
           return cookingTime;
       }

       public Ingredient getInput()
       {
           return input;
       }

       public Item getResult()
       {
           return result;
       }

    }*/
}
