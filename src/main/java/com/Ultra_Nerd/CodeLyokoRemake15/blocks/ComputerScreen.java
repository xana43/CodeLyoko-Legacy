package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ComputerScreen extends Block
{

	
		public ComputerScreen()
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
