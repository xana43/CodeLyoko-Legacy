package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
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

public class HologramProjectorBlock extends Block {
	public static BooleanProperty VALID = BooleanProperty.create("valid");

	public HologramProjectorBlock()
	{
	super(Block.Properties.create(Material.IRON)
				
				.hardnessAndResistance(6, 10)
				.sound(SoundType.METAL)
				.lightValue(2)
				.harvestLevel(0)
				.harvestTool(ToolType.PICKAXE)
				
					
					
					
					
			);
		this.setDefaultState(this.getDefaultState().with(VALID,false));

	}


	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder.add(BooleanProperty.create("valid")));
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getBlock().getDefaultState().with(VALID,false);
	}


	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}


	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntities.HOLOGRAM_TILE_ENTITY.get().create();
	}


	
	@Override
	public boolean hasTileEntity() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		// TODO Auto-generated method stub
		return true;
	}

	public static void SetModel(boolean act, World worldIn, BlockPos pos)
	{
		 BlockState state = worldIn.getBlockState(pos);
		 TileEntity tileentity = worldIn.getTileEntity(pos);

		 if(act) {
			 worldIn.setBlockState(pos, state.with(VALID,true));

		 }
		 else {
			 worldIn.setBlockState(pos, state.with(VALID,false));
		 }



	}





}
