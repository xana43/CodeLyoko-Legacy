package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class SilicaSand extends blockBase {
	
	public SilicaSand(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.SAND);
		setHardness(6.0f);
		setResistance(10);
		setHarvestLevel("spade", 1);
		setLightLevel(0.2f);
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
