package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Dsand extends Block {
	
	public Dsand()
	{
super(Block.Properties.create(Material.SAND)
				
				.hardnessAndResistance(20, 10)
				.sound(SoundType.SAND)
				.lightValue(0)
				.harvestLevel(20)
				.harvestTool(ToolType.SHOVEL)
				.tickRandomly()
					
					
					
					
			);

		
	}
	
	
	
	
	
}
