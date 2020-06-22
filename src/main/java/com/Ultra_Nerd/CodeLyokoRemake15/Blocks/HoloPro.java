package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.HoloProjector.ProjectorTE;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HoloPro extends BlockContainer {
	
	public HoloPro(String name, Material material)
	{
		super(material);
		setSoundType(SoundType.STONE);
		setLightLevel(2);
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VALID, false));
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	public static PropertyBool VALID = PropertyBool.create("valid");
	public static boolean trans = false;
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		// TODO Auto-generated method stub
		return new ProjectorTE();
	}
	@Override
	public boolean hasTileEntity(IBlockState state) {
		// TODO Auto-generated method stub
		return true;
	}

	public static void SetModel(boolean act, World worldIn, BlockPos pos) 
	{
		 IBlockState state = worldIn.getBlockState(pos);
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
