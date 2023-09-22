package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Recipies.ReactorRecipe;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeatures;

public record ModRecipes() {
    public record RecipeTypes()
    {

        public static final RecipeType<ReactorRecipe> REACTOR_RECIPE_TYPE;
        static {
           REACTOR_RECIPE_TYPE = RecipeType.register(CodeLyokoMain.codeLyokoPrefix("reactor_recipe").toString());
        }
        public static void init()
        {}
    }
    public record RecipeSerializers()
    {
        public static final RecipeSerializer<ReactorRecipe> REACTOR_RECIPE_SERIALIZER;

        static {

            REACTOR_RECIPE_SERIALIZER =
                    RecipeSerializer.register(CodeLyokoMain.codeLyokoPrefix("reactor_recipe").toString(),
                            new CookingRecipeSerializer<>(ReactorRecipe::new,
                                    MethodUtil.TickConversion.secondsToTicks(120)));

        }
        public static void init()
        {}
    }



}
