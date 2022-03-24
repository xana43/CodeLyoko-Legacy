package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Recipies.ICustomRecipes;
import com.Ultra_Nerd.CodeLyokoRemake15.Recipies.TestRecipe;
import com.google.gson.JsonObject;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class ModRecipes {

    public static final RecipeSerializer<TestRecipe> TEST_RECIPE_I_RECIPE_SERIALIZER = new RecipeSerializer<TestRecipe>() {
        @Override
        public TestRecipe fromJson(ResourceLocation p_44103_, JsonObject p_44104_) {
            return null;
        }

        @Nullable
        @Override
        public TestRecipe fromNetwork(ResourceLocation p_44105_, FriendlyByteBuf p_44106_) {
            return null;
        }

        @Override
        public void toNetwork(FriendlyByteBuf p_44101_, TestRecipe p_44102_) {

        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return null;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return null;
        }
    };
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

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CodeLyokoMain.MOD_ID);
    public static final RegistryObject<RecipeSerializer<?>> TEST_RECEPIE = RECIPE_SERIALIZER_DEFERRED_REGISTER.register("recipes", () -> TEST_RECIPE_I_RECIPE_SERIALIZER);
}
