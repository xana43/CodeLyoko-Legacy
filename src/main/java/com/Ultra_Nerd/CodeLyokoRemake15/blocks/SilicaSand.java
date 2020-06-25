package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SilicaSand extends Block {
	
	public SilicaSand()
	{
super(Block.Properties.create(Material.SAND)
				
				.hardnessAndResistance(6, 10)
				.sound(SoundType.SAND)
				.lightValue(1)
				.harvestLevel(1)
				.harvestTool(ToolType.SHOVEL)
				
					
					
					
					
			);
		
	}
	
	
}
