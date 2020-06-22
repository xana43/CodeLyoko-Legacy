package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class CableBlock extends Block {
	
	public static final AxisAlignedBB CABLEAABB = new AxisAlignedBB(0.3125D, 0, 0.3125D, 0.8125D, 1.25D, 0.8125D);
	
	public CableBlock(String name,Material material)
	{
		super(material);
		setSoundType(SoundType.STONE);
		setHardness(-1);
		setResistance(10);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.0f);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		// TODO Auto-generated method stub
		return CABLEAABB;
	}
	
	
	
}
