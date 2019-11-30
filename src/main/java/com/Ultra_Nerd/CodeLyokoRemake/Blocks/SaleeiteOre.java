package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class SaleeiteOre extends blockBase {
	
	public SaleeiteOre(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(6.0f);
		setResistance(10);
		setHarvestLevel("pickaxe", 2);
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
		
		return 3;
	}
}
