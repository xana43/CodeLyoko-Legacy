package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class UraniniteOre extends blockBase {
	
	public UraniniteOre(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(6.0f);
		setResistance(10);
		setHarvestLevel("pickaxe", 1);
		setLightLevel(0.01f);
		
	}
	
	
	
	

}
