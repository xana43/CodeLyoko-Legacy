package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class SilicaSand extends Block {
	
	public SilicaSand(String name, Material material)
	{
super(Block.Properties.create(Material.SAND)
				
				.hardnessAndResistance(6, 10)
				.sound(SoundType.SAND)
				.lightValue(1)
				.harvestLevel(1)
				.harvestTool(ToolType.SHOVEL)
				
					
					
					
					
			);
		
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return ModItems.RAW_SILICADUST; 
			   
		
	}
	
	@Override
	public int quantityDropped(Random rand)
	{
		int max = 9;
		int min = 4;
		return rand.nextInt(max) + min;
	}
}
