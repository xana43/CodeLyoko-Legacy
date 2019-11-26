package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TowerBase extends blockBase 
{

	
		public TowerBase(String name, Material material)
		{
			super(name, material);
			
			setSoundType(SoundType.GLASS);
			setHardness(20);
			setResistance(20);
			setHarvestLevel("spade", 20);
			setLightLevel(0);
			
			
		}
}
