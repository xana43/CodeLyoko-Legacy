package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Map.Entry;

public class FlourideInfusionResult {

    private static final FlourideInfusionResult INSTANCE = new FlourideInfusionResult();
    private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static @NotNull FlourideInfusionResult getInstance() {
        return INSTANCE;
    }

    private FlourideInfusionResult() {
        addRefiningRecipe(new ItemStack(ModItems.URANIUM_DIOXIDE.get()), new ItemStack(ModItems.FLUORIDE.get()),
                new ItemStack(ModItems.URANIUM_ISOTOPE238.get()), 5.0F);
        addRefiningRecipe(new ItemStack(ModItems.URANIUM_MELT.get()), new ItemStack(ModBlocks.FLUORITE_BLOCK.get()),
                new ItemStack(ModItems.URANIUM_ISOTOPE238.get()), 1f);
    }


    public void addRefiningRecipe(@NotNull ItemStack input1, @NotNull ItemStack input2, ItemStack result, float experience) {
        if (getInfusingResult(input1, input2) != ItemStack.EMPTY) return;
        if (getInfusingResult(input2, input1) != ItemStack.EMPTY) return;
        this.smeltingList.put(input1, input2, result);
        this.smeltingList.put(input2, input1, result);
        this.experienceList.put(result, experience);
    }

    public ItemStack getInfusingResult(@NotNull ItemStack input1, @NotNull ItemStack input2) {
        for (Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) {
            if (this.compareItemStacks(input1, entry.getKey())) {
                for (Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
                    if (this.compareItemStacks(input2, ent.getKey())) {
                        return ent.getValue();
                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(@NotNull ItemStack stack1, @NotNull ItemStack stack2) {
        //return stack2.equals(stack1, false);
        return stack2.getItem() == stack1.getItem(); //&& (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public @NotNull Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() {
        return this.smeltingList;
    }

    public float getSinteringExperience(@NotNull ItemStack stack) {
        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }
        return 0.0F;
    }
}