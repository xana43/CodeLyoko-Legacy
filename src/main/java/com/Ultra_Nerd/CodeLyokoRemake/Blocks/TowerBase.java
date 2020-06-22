package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class TowerBase extends Block 
{

	
		public TowerBase(String name, Material material)
		{
			super(material);
			
			setSoundType(SoundType.GLASS);
			setHardness(20);
			setResistance(20);
			setHarvestLevel("spade", 20);
			setLightLevel(0);
			setUnlocalizedName(name);
			setRegistryName(name);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
			Modblocks.BLOCKS.add(this);
			ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
			
		}
}
