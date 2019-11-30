package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class GummiteOre extends blockBase {
	
	public GummiteOre(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(3.0f);
		setResistance(10);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(0.2f);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return ModItems.URANIUM_SILACATE; 
			   
		
	}
	
	@Override
	public int quantityDropped(Random rand)
	{
		int max = 6;
		int min = 4;
		return rand.nextInt(max) + min;
	}
}
