package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;


public class SeaPylon extends Block {

	public static final DirectionProperty DIRPYLON = HorizontalBlock.HORIZONTAL_FACING;
public SeaPylon() {
	super(Properties.create(Material.MISCELLANEOUS)
			
			.hardnessAndResistance(-1, -1)
			.sound(SoundType.GLASS)
			.lightValue(8)
			.notSolid()

				
				
				
		);
    
}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DIRPYLON);
	}

	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		return 5;
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		// TODO Auto-generated method stub
		return this.getDefaultState().with(DIRPYLON, context.getPlacementHorizontalFacing().getOpposite());
	}

	//mod compatiability
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(DIRPYLON,rot.rotate(state.get(DIRPYLON)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(DIRPYLON)));
	}
	//


	@Override
	public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
		return false;
	}

	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isTransparent(BlockState state) {
		// TODO Auto-generated method stub
		return true;
	}




}