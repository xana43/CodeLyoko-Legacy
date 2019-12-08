package com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.flouride;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake.Base;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.blockBase;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.tileentity.ComputerReactor;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.tileentity.TileEntityElectricInfusingChamber;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.tileentity.TileEntityInfusingChamber;
import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Conf;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ElectricFlourideInfuser extends blockBase{

	public ElectricFlourideInfuser(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.METAL);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(INFUSING, false));
		// TODO Auto-generated constructor stub
	}
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool INFUSING = PropertyBool.create("infusing");
	
	
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		// TODO Auto-generated method stub
		return Item.getItemFromBlock(Modblocks.ELECTRICFLOURIDE_INFUSER);
	}
	
@Override
public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
	// TODO Auto-generated method stub
	return new ItemStack(Modblocks.ELECTRICFLOURIDE_INFUSER);
}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote)
		{
			playerIn.openGui(Base.instance, Conf.ELEINFUSING, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
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
	
	 public static void SetState(boolean act, World worldIn, BlockPos pos)
	 {
		 IBlockState state = worldIn.getBlockState(pos);
		 TileEntity tileentity = worldIn.getTileEntity(pos);
		 if(act) worldIn.setBlockState(pos, Modblocks.ELECTRICFLOURIDE_INFUSER.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(INFUSING, true), 3);
		 else worldIn.setBlockState(pos, Modblocks.ELECTRICFLOURIDE_INFUSER.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(INFUSING, false), 3);
		 if(tileentity != null)
		 {
			 tileentity.validate();
			 worldIn.setTileEntity(pos, tileentity);
		 }
	 }
	 
	 @Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		// TODO Auto-generated method stub
		return new TileEntityElectricInfusingChamber();
	}
	 @Override
	public boolean hasTileEntity(IBlockState state) {
		// TODO Auto-generated method stub
		return true;
	}
	 @Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		// TODO Auto-generated method stub
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
		
	}
	 
	 @Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		// TODO Auto-generated method stub
		worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()),2);
	}
	 
	 
	 @Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
	 
	 @Override
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
	protected BlockStateContainer createBlockState() {
		// TODO Auto-generated method stub
		return new BlockStateContainer(this, new IProperty[] {INFUSING,FACING});
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
	 @Override
		public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
			TileEntityElectricInfusingChamber tileentity = (TileEntityElectricInfusingChamber)worldIn.getTileEntity(pos);
			worldIn.spawnEntity(new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(), tileentity.handler.getStackInSlot(0)));
			worldIn.spawnEntity(new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(), tileentity.handler.getStackInSlot(1)));
			worldIn.spawnEntity(new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(), tileentity.handler.getStackInSlot(2)));
			
			super.breakBlock(worldIn, pos, state);
		}
		
}
