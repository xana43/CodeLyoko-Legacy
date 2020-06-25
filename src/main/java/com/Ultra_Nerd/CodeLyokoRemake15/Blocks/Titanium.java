package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Titanium extends Block {
	
	public Titanium()
	{
super(Block.Properties.create(Material.IRON)
				
				.hardnessAndResistance(6, 10)
				.sound(SoundType.METAL)
				.lightValue(1)
				.harvestLevel(3)
				.harvestTool(ToolType.PICKAXE)
				
					
					
					
					
			);
		
	}
	
	
	
	
}
