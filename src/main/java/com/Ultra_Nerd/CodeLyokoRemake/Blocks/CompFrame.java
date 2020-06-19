package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import javax.swing.Icon;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.world.IBlockAccess;

public class CompFrame extends Block 
{

	
		public CompFrame(String name, Material material)
		{
			super(material);
			
			setSoundType(SoundType.METAL);
			setHardness(1.0f);
			setResistance(20);
			setHarvestLevel("pickaxe", 0);
			setLightLevel(0.0f);
			setUnlocalizedName(name);
			setRegistryName(name);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
			Modblocks.BLOCKS.add(this);
			ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
			
		}
		
		
		public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side)
		{
			return this.getBlockTexture(world, x, y, z, side);
			
		}
		
}
