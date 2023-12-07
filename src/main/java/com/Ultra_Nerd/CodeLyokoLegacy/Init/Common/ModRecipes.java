package com.Ultra_Nerd.CodeLyokoLegacy.Init.Common;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Recipies.LithographyRecipe;
import com.Ultra_Nerd.CodeLyokoLegacy.Recipies.ReactorRecipe;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;

@SuppressWarnings("EmptyMethod")
public record ModRecipes() {


    private static final String REACTOR_RECIPE_ID = createStringId("reactor_recipe");
    private static final String LITHOGRAPHY_RECIPE_ID = createStringId("lithography_recipe");
    private static String createStringId(final String id)
    {
       return CodeLyokoMain.codeLyokoPrefix(id).toString();
    }
    public record RecipeTypes()
    {

        public static final RecipeType<ReactorRecipe> REACTOR_RECIPE_TYPE;
        public static final RecipeType<LithographyRecipe> LITHOGRAPHY_RECIPE_RECIPE_TYPE;
        static {
           REACTOR_RECIPE_TYPE = RecipeType.register(REACTOR_RECIPE_ID);
           LITHOGRAPHY_RECIPE_RECIPE_TYPE = RecipeType.register(LITHOGRAPHY_RECIPE_ID);
        }
        public static void init()
        {}
    }
    public record RecipeSerializers()
    {
        public static final RecipeSerializer<ReactorRecipe> REACTOR_RECIPE_SERIALIZER;
        public static final RecipeSerializer<LithographyRecipe> LITHOGRAPHY_RECIPE_SERIALIZER;
        static {

            REACTOR_RECIPE_SERIALIZER =
                    RecipeSerializer.register(REACTOR_RECIPE_ID,
                            new CookingRecipeSerializer<>(ReactorRecipe::new,
                                    MethodUtil.TickConversion.secondsToTicks(120)));
            LITHOGRAPHY_RECIPE_SERIALIZER = RecipeSerializer.register(LITHOGRAPHY_RECIPE_ID,new CookingRecipeSerializer<>(LithographyRecipe::new,MethodUtil.TickConversion.secondsToTicks(60)));

        }
        public static void init()
        {}
    }



}
