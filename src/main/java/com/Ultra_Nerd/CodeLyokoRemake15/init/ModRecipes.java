package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Recipies.ICustomRecipes;
import com.Ultra_Nerd.CodeLyokoRemake15.Recipies.RecipeSerializers;
import com.Ultra_Nerd.CodeLyokoRemake15.Recipies.TestRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipes {

    public static final IRecipeSerializer<TestRecipe> TEST_RECIPE_I_RECIPE_SERIALIZER = new RecipeSerializers();
    public static final IRecipeType<ICustomRecipes> TYPE = registerType(ICustomRecipes.RECIPE_TYPE);


    private static class RegistryType<T extends IRecipe<?>> implements IRecipeType<T> {
        @Override
        public String toString() {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    }

    private static <T extends IRecipeType> T registerType(ResourceLocation recipeType) {
        return (T) Registry.register(Registry.RECIPE_TYPE, recipeType, new RegistryType<>());
    }

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Base.MOD_ID);
    public static final RegistryObject<IRecipeSerializer<?>> TEST_RECEPIE = RECIPE_SERIALIZER_DEFERRED_REGISTER.register("recipes", () -> TEST_RECIPE_I_RECIPE_SERIALIZER);
}
