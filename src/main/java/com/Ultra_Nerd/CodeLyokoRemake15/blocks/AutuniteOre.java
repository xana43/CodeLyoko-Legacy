package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AutuniteOre extends Block {
	
	public AutuniteOre()
	{
		super(Block.Properties.create(Material.ROCK)
				
				.hardnessAndResistance(3, 2)
				.sound(SoundType.STONE)
				.lightValue(0)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
					
					
					
					
			);
	}
	
	
}
