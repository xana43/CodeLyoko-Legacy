package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class Dsand extends Block {
	
	public Dsand(String name, final Properties prop)
	{
		super(prop);

		setRegistryName(name);
		
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	
	
	
	
}
