package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Trans extends Block  {
	
	public Trans(String name, Material material)
	{
		super(material);
		setSoundType(SoundType.STONE);
		setLightLevel(2);
		setUnlocalizedName(name);
		setRegistryName(name);
		setLightOpacity(0);
		setCreativeTab(null);
		setBlockUnbreakable();
		
		//Modblocks.BLOCKS.add(this);
		//ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
			EnumFacing side) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBed(IBlockState state, IBlockAccess world, BlockPos pos, Entity player) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
	@Override
	public boolean canBeReplacedByLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	@Override
	public boolean isBlockNormalCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		// TODO Auto-generated method stub
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isTranslucent(IBlockState state) {
		// TODO Auto-generated method stub
		return true;
	}

@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.INVISIBLE;
	}


}
