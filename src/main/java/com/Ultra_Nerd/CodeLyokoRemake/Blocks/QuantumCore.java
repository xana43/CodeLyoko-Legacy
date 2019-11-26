package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class QuantumCore extends blockBase 
{

	
		public QuantumCore(String name, Material material)
		{
			super(name, material);
			
			setSoundType(SoundType.GLASS);
			setHardness(1.0f);
			setResistance(20);
			setHarvestLevel("pickaxe", 0);
			setLightLevel(0.5f);
			
			
		}
}
