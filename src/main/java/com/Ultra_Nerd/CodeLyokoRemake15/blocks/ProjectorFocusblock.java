package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class ProjectorFocusblock extends Block {
	public static BooleanProperty VALIDFOCUS = BooleanProperty.create("validfocus");


	public ProjectorFocusblock()
	{
	super(Properties.create(Material.GLASS)
				.hardnessAndResistance(6, 10)
				.sound(SoundType.GLASS)
				.lightValue(2)
				.harvestLevel(0)
				.harvestTool(ToolType.PICKAXE)
			.notSolid()
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
	public boolean hasTileEntity(BlockState state) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void SetModelFocus(boolean act, World worldIn, BlockPos pos)
	{
		 BlockState state = worldIn.getBlockState(pos);
		 TileEntity tileentity = worldIn.getTileEntity(pos);

		 if(act) {
			 worldIn.setBlockState(pos, state.with(VALIDFOCUS, true));

		 }
		 else {

			 worldIn.setBlockState(pos, state.with(VALIDFOCUS, false));

		 }


	}



}
