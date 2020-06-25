package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ProjectorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.state.IProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class HologramProjectorBlock extends ContainerBlock {
	
	public HologramProjectorBlock()
	{
super(Block.Properties.create(Material.IRON)
				
				.hardnessAndResistance(6, 10)
				.sound(SoundType.METAL)
				.lightValue(2)
				.harvestLevel(0)
				.harvestTool(ToolType.PICKAXE)
				
					
					
					
					
			);
		
	}
	public static PropertyBool VALID = PropertyBool.create("valid");
	public static boolean trans = false;
	
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		// TODO Auto-generated method stub
		return new ProjectorTileEntity();
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
		 
		 if(act) worldIn.setBlockState(pos, Modblocks.HOLOPROJECTOR.getDefaultState().withProperty(VALID, true), 3);
		 else worldIn.setBlockState(pos, Modblocks.HOLOPROJECTOR.getDefaultState().withProperty(VALID, false), 3);
		 if(tileentity != null)
		 {
			 tileentity.validate();
			 worldIn.setTileEntity(pos, tileentity);
		 }
		 
		
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		if(state == VALID || trans)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	@Override
	public boolean isTranslucent(IBlockState state) {
		if(state == VALID || trans)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		if(state == VALID || trans)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		// TODO Auto-generated method stub
		if(state == VALID || trans)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		// TODO Auto-generated method stub
		if(trans)
		{
			return BlockRenderLayer.TRANSLUCENT;
		}
		else
		{
			return BlockRenderLayer.SOLID;
		}	
		
	}
	
@Override
protected BlockStateContainer createBlockState() {
	// TODO Auto-generated method stub
	return new BlockStateContainer(this, new IProperty[] {VALID});
}
@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
@Override
public int getMetaFromState(IBlockState state) { return 0; }

@Override
public IBlockState getStateFromMeta(int meta) { return this.getDefaultState(); }

}
