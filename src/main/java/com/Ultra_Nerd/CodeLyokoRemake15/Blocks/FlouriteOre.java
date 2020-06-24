package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.ToolType;

public class FlouriteOre extends Block {
	
	public FlouriteOre()
	{
		super(Block.Properties.create(Material.ROCK)
				
				.hardnessAndResistance(6, 10)
				.sound(SoundType.STONE)
				.lightValue(1))
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				
					
					
					
					
			);
		
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return ModItems.FLOURIDE; 
			   
		
	}
	
	@Override
	public int quantityDropped(Random rand)
	{
		int max = 3;
		int min = 0;
		return rand.nextInt(max) + min;
	}
}
