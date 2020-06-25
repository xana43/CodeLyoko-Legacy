package com.Ultra_Nerd.CodeLyokoRemake15.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.state.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class TowerWall extends BlockHorizontal {

public TowerWall(String name) {
	super(Block.Properties.create(Material.MISCELLANEOUS)
			
			.hardnessAndResistance(-1, -1)
			.sound(SoundType.GLASS)
			.lightValue(4)
				
				
				
				
		);
    
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