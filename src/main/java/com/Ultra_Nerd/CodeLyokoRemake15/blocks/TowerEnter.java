package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;


public class TowerEnter extends Block {

	public static final DirectionProperty DIRTOWER2 = HorizontalBlock.HORIZONTAL_FACING;
public TowerEnter() {
	super(Properties.create(Material.MISCELLANEOUS)
			
			.hardnessAndResistance(-1, -1)
			.sound(SoundType.GLASS)
			.lightValue(5)
			.doesNotBlockMovement()

				
				
				
		);
    
}
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DIRTOWER2);
	}






	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		// TODO Auto-generated method stub
		return this.getDefaultState().with(DIRTOWER2, context.getPlacementHorizontalFacing().getOpposite());
	}

	//mod compatiability
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(DIRTOWER2,rot.rotate(state.get(DIRTOWER2)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(DIRTOWER2)));
	}
	//

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