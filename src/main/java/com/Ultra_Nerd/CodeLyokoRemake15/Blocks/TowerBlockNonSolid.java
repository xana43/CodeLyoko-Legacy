package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import javax.annotation.Nullable;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TowerBlockNonSolid extends Block {
	
	
	
	public TowerBlockNonSolid(String name, Material material)
	{
		super(material);
		setSoundType(SoundType.GLASS);
		setHardness(20);
		setResistance(20);
		setHarvestLevel("spade", 20);
		setLightLevel(4);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}
	
	@Nullable
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i,int j, int k) {
		return null;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
	
	
	public AxisAlignedBB GetCollisionBoxesEvent()
	{
		return null;
		
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
