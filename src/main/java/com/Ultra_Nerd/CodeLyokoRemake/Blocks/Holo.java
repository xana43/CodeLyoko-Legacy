package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import java.util.Random;

import org.lwjgl.util.Color;

import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJLoader;

public class Holo extends blockBase  {
	
	public Holo(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setLightLevel(2);
		
	}

	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	@Override
	public boolean isFullCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		// TODO Auto-generated method stub
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	
	@Override
	public float getAmbientOcclusionLightValue(IBlockState state) {
		// TODO Auto-generated method stub
		return 5;
	}
	
	
	@Override
	public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return NULL_AABB;
	}


	
	
	
}
