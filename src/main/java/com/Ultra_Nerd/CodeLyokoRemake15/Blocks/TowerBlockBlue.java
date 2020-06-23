package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class TowerBlockBlue extends Block {
	
	public TowerBlockBlue()
	{
		super(Block.Properties.create(Material.IRON)
				
				.hardnessAndResistance(20, 20)
				.sound(SoundType.GLASS)
				.lightValue(4)
				.harvestLevel(20)
				.harvestTool(ToolType.SHOVEL)
					
					
					
					
			);
		
	}
	
	
	
	
	
}
