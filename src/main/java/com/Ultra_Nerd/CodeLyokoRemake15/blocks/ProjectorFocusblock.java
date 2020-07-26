package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class ProjectorFocusblock extends ContainerBlock {
	public static BooleanProperty VALIDFOCUS = BooleanProperty.create("validfocus");


	public ProjectorFocusblock()
	{
	super(Properties.create(Material.GLASS)
				.hardnessAndResistance(6, 10)
				.sound(SoundType.GLASS)
				.lightValue(2)
				.harvestLevel(0)
				.harvestTool(ToolType.PICKAXE)
			);
		this.setDefaultState(this.getDefaultState().with(VALIDFOCUS,false));
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(VALIDFOCUS,false);
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder.add(VALIDFOCUS));
	}


	@Override
	public BlockRenderType getRenderType(BlockState state) {
		if(this.getDefaultState().get(VALIDFOCUS))
		{
			return BlockRenderType.INVISIBLE;
		}
		else
		{
			return BlockRenderType.MODEL;
		}
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void SetModelFocus(boolean act, World worldIn, BlockPos pos)
	{
		 BlockState state = worldIn.getBlockState(pos);
		 TileEntity tileentity = worldIn.getTileEntity(pos);

		 if(act) {
			 worldIn.setBlockState(pos, ModBlocks.PROJECTOR_FOCUS.get().getDefaultState().with(VALIDFOCUS, true), 3);

		 }
		 else {

			 worldIn.setBlockState(pos, ModBlocks.PROJECTOR_FOCUS.get().getDefaultState().with(VALIDFOCUS, false), 3);

		 }


	}


	@Nullable
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return null;
	}
}
