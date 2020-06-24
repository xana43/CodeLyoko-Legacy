package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CompFrame extends Block 
{

	
		public CompFrame()
		{
			super(Block.Properties.create(Material.IRON)
					
					.hardnessAndResistance(1, 20)
					.sound(SoundType.METAL)
					.lightValue(0)
					.harvestLevel(2)
					.harvestTool(ToolType.PICKAXE)
									
						
						
						
				);
			
			
		}
		
		
		
}
