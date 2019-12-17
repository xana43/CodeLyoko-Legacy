package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class QuantSteel extends blockBase 
{

	
		public QuantSteel(String name, Material material)
		{
			super(name, material);
			
			setSoundType(SoundType.GLASS);
			setHardness(6.0f);
			setResistance(20);
			setHarvestLevel("pickaxe", 3);
			setLightLevel(0);
			
			
		}
}
