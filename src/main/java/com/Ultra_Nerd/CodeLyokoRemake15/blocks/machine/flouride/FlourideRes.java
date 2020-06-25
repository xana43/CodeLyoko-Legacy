package com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.flouride;

import java.util.Map;
import java.util.Map.Entry;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import net.minecraft.item.ItemStack;

public class FlourideRes 
{	
	private static final FlourideRes INSTANCE = new FlourideRes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static FlourideRes getInstance()
	{
		return INSTANCE;
	}
	
	private FlourideRes() 
	{
		addRefiningRecipe(new ItemStack(ModItems.URANIUM_DIOXIDE), new ItemStack(ModItems.FLOURIDE), new ItemStack(ModItems.URANIUM_ISOTOPE238), 5.0F);
		addRefiningRecipe(new ItemStack(ModItems.URANIUM_MELT), new ItemStack(Modblocks.FLOURITE_BLOCK), new ItemStack(ModItems.URANIUM_ISOTOPE238), 1f);
	}

	
	public void addRefiningRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) 
	{
		if(getInfusingResult(input1, input2) != ItemStack.EMPTY) return;
		if(getInfusingResult(input2, input1) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, result);
		this.smeltingList.put(input2, input1, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getInfusingResult(ItemStack input1, ItemStack input2) 
	{
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) 
		{
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) 
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	public float getSinteringExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}