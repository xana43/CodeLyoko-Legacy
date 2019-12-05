package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class tree extends blockBase 
{

	
		public tree(String name, Material material)
		{
			super(name, material);
			
			setSoundType(SoundType.WOOD);
			setHardness(4.0f);
			setResistance(20);
			setHarvestLevel("axe", 20);
			
			
			
		}
}
