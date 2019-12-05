package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DigitalRock extends blockBase 
{

	
		public DigitalRock(String name, Material material)
		{
			super(name, material);
			
			setSoundType(SoundType.GROUND);
			setHardness(4.0f);
			setResistance(20);
			setHarvestLevel("pickaxe", 20);
			
			
			
		}
}
