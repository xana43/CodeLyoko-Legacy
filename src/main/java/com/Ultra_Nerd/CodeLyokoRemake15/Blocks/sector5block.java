package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class sector5block extends Block {
	
	public sector5block(String name, Material material)
	{
		super(material);
		setSoundType(SoundType.GLASS);
		setLightLevel(4);
		setUnlocalizedName(name);
		setRegistryName(name);
		setBlockUnbreakable();
		
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	
	
	
	
}
