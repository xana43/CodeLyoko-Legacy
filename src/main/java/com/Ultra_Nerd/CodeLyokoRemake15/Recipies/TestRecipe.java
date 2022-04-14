package com.Ultra_Nerd.CodeLyokoRemake15.Recipies;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModRecipes;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class TestRecipe implements ICustomRecipes {

    private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient input;

    public TestRecipe(ResourceLocation id, Ingredient Input, ItemStack output) {
        this.id = id;
        this.input = Input;
        this.output = output;
    }


   // @Override
   // public Ingredient getInput() {
   //     return this.input;
    //}

    @Override
    public boolean matches(@NotNull RecipeWrapper inv, @Nonnull Level worldIn) {
        return this.input.test(inv.getItem(0));
    }

    @Override
    public @Nullable ItemStack assemble(RecipeWrapper p_44001_) {
        return null;
    }

    @Override
    public @Nullable ItemStack getResultItem() {
        return null;
    }

    //@Nonnull
    //@Override
    //public ItemStack getCraftingResult(@Nonnull RecipeWrapper inv) {
      //  return this.output;
    //}

    //@Nonnull
    //@Override
    //public ItemStack getRecipeOutput() {
     //   return this
      //          .output;
    //}

    @Nonnull
    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Nonnull
    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.TEST_RECEPIE.get();
    }

    @Nonnull
    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(null, this.input);
    }
}
