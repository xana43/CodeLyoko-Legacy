package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class QuantSteel extends blockBase 
{
	public static final PropertyBool VALID2 = PropertyBool.create("valids");
	public static final PropertyBool AIR = PropertyBool.create("air");
	public static boolean trans2;
		public QuantSteel(String name, Material material)
		{
			super(name, material);
			
			setSoundType(SoundType.GLASS);
			setHardness(6.0f);
			setResistance(20);
			setHarvestLevel("pickaxe", 3);
			setLightLevel(0);
			this.setDefaultState(this.blockState.getBaseState().withProperty(VALID2, true).withProperty(AIR, true));
			
		}
		
		public static void SetModel2(boolean act, World worldIn, BlockPos pos) 
		{
			 IBlockState state = worldIn.getBlockState(pos);
			 TileEntity tileentity = worldIn.getTileEntity(pos);
			 if(act) worldIn.setBlockState(pos, Modblocks.QUANTUM_STEEL.getDefaultState().withProperty(VALID2, true).withProperty(AIR, true), 3);
			 else worldIn.setBlockState(pos, Modblocks.QUANTUM_STEEL.getDefaultState().withProperty(VALID2, false).withProperty(AIR, false), 3);
			 if(tileentity != null)
			 {
				 tileentity.validate();
				 worldIn.setTileEntity(pos, tileentity);
			 }
		}
		
		
		@Override
		public boolean isOpaqueCube(IBlockState state) {
			// TODO Auto-generated method stub
			if(state == VALID2)
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
			if(state == VALID2)
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
			if(state == VALID2)
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
			if(state == VALID2)
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
			if(trans2)
			{
				return BlockRenderLayer.CUTOUT;
			}
			else
			{
				return BlockRenderLayer.SOLID;
			}	
			
		}
		
		@Override
		public boolean isBlockNormalCube(IBlockState state) {
			// TODO Auto-generated method stub
			if(state == AIR)
			{
				return false;
			}
			else
			{
				return true;
			}	
			
			
		
		}
		
	
		
		@Override
		protected BlockStateContainer createBlockState() {
			// TODO Auto-generated method stub
			return new BlockStateContainer(this, new IProperty[] {VALID2,AIR});
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

