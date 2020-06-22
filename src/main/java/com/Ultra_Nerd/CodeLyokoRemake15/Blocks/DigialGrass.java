package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DigialGrass extends Block {
	
	public DigialGrass()
	{
		super(Block.Properties.create(Material.EARTH)
				
			.hardnessAndResistance(40, 10)
			.sound(SoundType.GROUND)
			.lightValue(0)
			.harvestLevel(3)
			.harvestTool(ToolType.SHOVEL)
				
				
				
				
		);

	}
	
	
	
	
	
}
