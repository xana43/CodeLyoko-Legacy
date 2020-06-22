package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class MTree extends Block 
{

	
		public MTree(String name, Material material)
		{
			super(material);
			
			setSoundType(SoundType.WOOD);
			setHardness(-1);
			setResistance(-1);
			setUnlocalizedName(name);
			setRegistryName(name);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
			Modblocks.BLOCKS.add(this);
			ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
			
			
			
		}
}
