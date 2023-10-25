package com.Ultra_Nerd.CodeLyokoLegacy.init;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Recipies.ReactorRecipe;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;

@SuppressWarnings("EmptyMethod")
public record ModRecipes() {


    private static final String REACTOR_RECIPE_ID = createStringId("reactor_recipe");
    private static String createStringId(final String id)
    {
       return CodeLyokoMain.codeLyokoPrefix(id).toString();
    }
    public record RecipeTypes()
    {

        public static final RecipeType<ReactorRecipe> REACTOR_RECIPE_TYPE;
        static {
           REACTOR_RECIPE_TYPE = RecipeType.register(REACTOR_RECIPE_ID);
        }
        public static void init()
        {}
    }
    public record RecipeSerializers()
    {
        public static final RecipeSerializer<ReactorRecipe> REACTOR_RECIPE_SERIALIZER;
        static {

            REACTOR_RECIPE_SERIALIZER =
                    RecipeSerializer.register(REACTOR_RECIPE_ID,
                            new CookingRecipeSerializer<>(ReactorRecipe::new,
                                    MethodUtil.TickConversion.secondsToTicks(120)));

        }
        public static void init()
        {}
    }



}
