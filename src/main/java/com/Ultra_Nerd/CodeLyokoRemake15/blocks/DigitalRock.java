package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DigitalRock extends Block 
{

	
		public DigitalRock()
		{
			super(Block.Properties.create(Material.ROCK)
					
					.hardnessAndResistance(4, 20)
					.sound(SoundType.STONE)
					.lightValue(0)
					.harvestLevel(20)
					.harvestTool(ToolType.PICKAXE)
					
						
						
						
						
				);
			
			
			
		}
}
