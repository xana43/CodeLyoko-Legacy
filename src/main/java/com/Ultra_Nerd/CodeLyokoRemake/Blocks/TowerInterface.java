package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake.Base;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.tileentity.Interface;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Conf;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TowerInterface extends blockBase {
	
	public static final AxisAlignedBB INTER = new AxisAlignedBB(0.3125D, 0, 0.3125D, 0.8125D, 1.25D, 0.8125D);
	
	public TowerInterface(String name, Material mats)
	{
		super(name, mats);
		setSoundType(SoundType.METAL);
		setHardness(-1);
		setResistance(-1);
		setHarvestLevel("pickaxe", -1);
		setLightLevel(0.5f);
		setCreativeTab(null);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote)
		{
			playerIn.openGui(Base.instance, Conf.INTERFACE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
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
		return INTER;
	}
	@Override
	public boolean hasTileEntity(IBlockState state) {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		// TODO Auto-generated method stub
		return new Interface();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		Interface tileentity = (Interface)worldIn.getTileEntity(pos);
		
		super.breakBlock(worldIn, pos, state);
	}
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	@Override
	protected BlockStateContainer createBlockState() {
	    return new BlockStateContainer(this, new IProperty[] { FACING });
	}
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if(!worldIn.isRemote)
		{
			IBlockState north = worldIn.getBlockState(pos.north());
			IBlockState south = worldIn.getBlockState(pos.south());
			IBlockState east = worldIn.getBlockState(pos.east());
			IBlockState west = worldIn.getBlockState(pos.west());
			EnumFacing face = (EnumFacing)state.getValue(FACING);
			
			if(face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH;
			else if(face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) face = EnumFacing.NORTH;
			else if(face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) face = EnumFacing.EAST;
			else if(face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) face = EnumFacing.WEST;
			worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);
			
			
		}
		
	}
	@Override
		public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
				float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
			// TODO Auto-generated method stub
			return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
			
		}
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		// TODO Auto-generated method stub
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}
	 
	 @Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		// TODO Auto-generated method stub
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}
	 
	 @Override
		public IBlockState getStateFromMeta(int meta) {
			// TODO Auto-generated method stub
			EnumFacing facing = EnumFacing.getFront(meta);
			if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
			return this.getDefaultState().withProperty(FACING, facing);
		}

		 @Override
		public int getMetaFromState(IBlockState state) {
			// TODO Auto-generated method stub
			return ((EnumFacing)state.getValue(FACING)).getIndex();
		}
}
