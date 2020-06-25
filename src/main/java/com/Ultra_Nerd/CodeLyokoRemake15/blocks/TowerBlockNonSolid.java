package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class TowerBlockNonSolid extends Block {
	
	
	
	public TowerBlockNonSolid()
	{
		super(Block.Properties.create(Material.IRON)
				
				.hardnessAndResistance(20, 20)
				.sound(SoundType.GLASS)
				.lightValue(0)
				.harvestLevel(20)
				.harvestTool(ToolType.SHOVEL)
					
					
					
					
			);
		
		
	}
	
	@Nullable
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i,int j, int k) {
		return null;
	}
	
	
	
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {
		// TODO Auto-generated method stub
	return null;
	}

	
	@Override
	public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isTransparent(BlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
  @Override
public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
	// TODO Auto-generated method stub
	return false;
}	
	
  
	

	
}
