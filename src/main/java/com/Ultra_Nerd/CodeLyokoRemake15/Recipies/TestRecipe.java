package com.Ultra_Nerd.CodeLyokoRemake15.Recipies;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class TestRecipe implements ICustomRecipes {

private final ResourceLocation id;
private Ingredient input;
private final ItemStack output;

    public TestRecipe(ResourceLocation id,Ingredient Input, ItemStack output)
    {
this.id = id;
this.input = Input;
this.output = output;
    }



    @Override
    public Ingredient getInput() {
        return this.input;
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        return this.input.test(inv.getStackInSlot(0));
    }

    @Override
    public ItemStack getCraftingResult(RecipeWrapper inv) {
        return this.output;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this
                .output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.TEST_RECEPIE.get();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.from(null,this.input);
    }
}
