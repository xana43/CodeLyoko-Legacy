package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class DigitalRock extends Block 
{

	
		public DigitalRock(String name, Material material)
		{
			super(material);
			
			setSoundType(SoundType.GROUND);
			setHardness(4.0f);
			setResistance(20);
			setHarvestLevel("pickaxe", 20);
			setUnlocalizedName(name);
			setRegistryName(name);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
			Modblocks.BLOCKS.add(this);
			ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
			
			
		}
}
