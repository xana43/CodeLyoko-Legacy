package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class UraniumBlock extends Block {

	public UraniumBlock(String name,Material materialIn) {
		super(materialIn);
		
		setSoundType(SoundType.METAL);
		setHardness(6.0f);
		setResistance(10);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.2f);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	 

}
