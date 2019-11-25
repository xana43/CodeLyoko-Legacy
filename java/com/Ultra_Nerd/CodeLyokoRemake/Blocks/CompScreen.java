package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CompScreen extends blockBase 
{

	
		public CompScreen(String name, Material material)
		{
			super(name, material);
			
			setSoundType(SoundType.GLASS);
			setHardness(1.0f);
			setResistance(20);
			setHarvestLevel("pickaxe", 2);
			setLightLevel(1f);
			
			
		}
}
