package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CompScreen extends Block 
{

	
		public CompScreen()
		{
			super(Block.Properties.create(Material.GLASS)
					
					.hardnessAndResistance(1, 20)
					.sound(SoundType.GLASS)
					.lightValue(1)
					.harvestLevel(2)
					.harvestTool(ToolType.PICKAXE)
					
						
						
						
						
				);
			
			
			
		}
}
