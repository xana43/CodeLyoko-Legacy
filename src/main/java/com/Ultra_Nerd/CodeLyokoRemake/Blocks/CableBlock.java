package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class CableBlock extends blockBase {
	
	public static final AxisAlignedBB CABLEAABB = new AxisAlignedBB(0.3125D, 0, 0.3125D, 0.8125D, 1.25D, 0.8125D);
	
	public CableBlock(String name)
	{
		super(name, Material.CIRCUITS);
		setSoundType(SoundType.STONE);
		setHardness(-1);
		setResistance(10);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.0f);
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
