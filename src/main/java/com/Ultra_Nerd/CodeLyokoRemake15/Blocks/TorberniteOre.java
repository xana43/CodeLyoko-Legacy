package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class TorberniteOre extends Block {
	
	public TorberniteOre(String name, Material material)
	{
super(Block.Properties.create(Material.ROCK)
				
				.hardnessAndResistance(6, 10)
				.sound(SoundType.STONE)
				.lightValue(1)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				
					
					
					
					
			);
		
		
	}
	
	
}
