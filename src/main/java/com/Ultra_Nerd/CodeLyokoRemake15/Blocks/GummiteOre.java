package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class GummiteOre extends Block {
	
	public GummiteOre()
	{
super(Block.Properties.create(Material.ROCK)
				
				.hardnessAndResistance(3, 10)
				.sound(SoundType.STONE)
				.lightValue(1)
				.harvestLevel(3)
				.harvestTool(ToolType.PICKAXE)
		
					
					
					
					
			);
		
	}
	
	
}
