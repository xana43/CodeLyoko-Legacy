package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Recipies.ICustomRecipes;
import com.Ultra_Nerd.CodeLyokoRemake15.Recipies.RecipeSerializers;
import com.Ultra_Nerd.CodeLyokoRemake15.Recipies.TestRecipe;
import net.minecraft.core.Registry;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {

    public static final RecipeSerializer<TestRecipe> TEST_RECIPE_I_RECIPE_SERIALIZER = new RecipeSerializer();
    public static final RecipeType<ICustomRecipes> TYPE = registerType(ICustomRecipes.RECIPE_TYPE);


    private static class RegistryType<T extends Recipe<?>> implements RecipeType<T> {
        @Override
        public String toString() {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    }

    private static <T extends RecipeType> T registerType(ResourceLocation recipeType) {
        return (T) Registry.register(Registry.RECIPE_TYPE, recipeType, new RegistryType<>());
    }

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Base.MOD_ID);
    public static final RegistryObject<RecipeSerializer<?>> TEST_RECEPIE = RECIPE_SERIALIZER_DEFERRED_REGISTER.register("recipes", () -> TEST_RECIPE_I_RECIPE_SERIALIZER);
}
