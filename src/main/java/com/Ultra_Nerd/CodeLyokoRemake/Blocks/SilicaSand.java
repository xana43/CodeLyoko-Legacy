package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class SilicaSand extends Block {
	
	public SilicaSand(String name, Material material)
	{
		super(material);
		setSoundType(SoundType.SAND);
		setHardness(6.0f);
		setResistance(10);
		setHarvestLevel("spade", 1);
		setLightLevel(0.2f);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return ModItems.RAW_SILICADUST; 
			   
		
	}
	
	@Override
	public int quantityDropped(Random rand)
	{
		int max = 9;
		int min = 4;
		return rand.nextInt(max) + min;
	}
}
