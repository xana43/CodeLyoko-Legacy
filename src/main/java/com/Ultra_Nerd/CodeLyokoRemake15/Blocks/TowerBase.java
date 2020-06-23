package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class TowerBase extends Block 
{

	
		public TowerBase()
		{
			super(Block.Properties.create(Material.IRON)
					
					.hardnessAndResistance(20, 20)
					.sound(SoundType.GLASS)
					.lightValue(0)
					.harvestLevel(20)
					.harvestTool(ToolType.SHOVEL)
						
						
						
						
				);
			
			
			
		}
}
