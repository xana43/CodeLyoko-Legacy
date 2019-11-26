package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class QuantumBlock extends blockBase 
{

	
		public QuantumBlock(String name, Material material)
		{
			super(name, material);
			
			setSoundType(SoundType.GLASS);
			setHardness(6.0f);
			setResistance(20);
			setHarvestLevel("pickaxe", 2);
			setLightLevel(0.5f);
			
			
		}
}
