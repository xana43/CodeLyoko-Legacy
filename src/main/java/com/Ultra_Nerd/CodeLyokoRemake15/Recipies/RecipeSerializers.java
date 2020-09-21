package com.Ultra_Nerd.CodeLyokoRemake15.Recipies;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nonnull;

public class RecipeSerializers extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<TestRecipe> {
    @Nonnull
    @Override
    public TestRecipe read(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
        ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json,"output"),true);
        Ingredient Input = Ingredient.deserialize(JSONUtils.getJsonObject(json,"input"));
        return new TestRecipe(recipeId,Input,output);
    }


    @Override
    public TestRecipe read(@Nonnull ResourceLocation recipeId, PacketBuffer buffer) {
       ItemStack output = buffer.readItemStack();
       Ingredient input = Ingredient.read(buffer);
        return new TestRecipe(recipeId,input,output);
    }

    @Override
    public void write(@Nonnull PacketBuffer buffer, TestRecipe recipe) {
Ingredient input = recipe.getIngredients().get(0);
input.write(buffer);
buffer.writeItemStack(recipe.getRecipeOutput(),false);
    }
}
