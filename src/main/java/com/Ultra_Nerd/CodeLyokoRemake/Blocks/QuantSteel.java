package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.HoloProjector.InvisRend;
import com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.HoloProjector.ProjectorTE;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class QuantSteel extends BlockContainer 
{
	public static final PropertyBool FORMED = PropertyBool.create("formed");
	public static final PropertyBool AIR = PropertyBool.create("air");
	
	public static boolean trans2;
		public QuantSteel(String name, Material material)
		{
			super(material);
			
			setSoundType(SoundType.METAL);
			setHardness(6.0f);
			setResistance(20);
			setHarvestLevel("pickaxe", 3);
			setUnlocalizedName(name);
			setRegistryName(name);
			Modblocks.BLOCKS.add(this);
			ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
			this.setDefaultState(this.blockState.getBaseState().withProperty(FORMED, false).withProperty(AIR, false));
			
		}
		
		
		
		
		@Override
		public boolean hasTileEntity() {
			// TODO Auto-generated method stub
			return true;
		}
		
		
		
		/*@Override
		public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
				EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
			if(ProjectorTE.valid)
			{
				SetModel2(true, worldIn, pos);
			}
			else
			{
				SetModel2(false, worldIn, pos);
			}
			return true;
		}
		
		@Override
		public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
			// TODO Auto-generated method stub
			if(ProjectorTE.valid)
			{
				SetModel2(true, worldIn, pos);
			}
			else
			{
				SetModel2(false, worldIn, pos);
			}
		}*/
		
		public static void SetModel2(boolean act, World worldIn, BlockPos pos) 
		{
			
			 IBlockState state = worldIn.getBlockState(pos);
			 //TileEntity tileentity = worldIn.getTileEntity(pos);
			 if(act) worldIn.setBlockState(pos, Modblocks.QUANTUM_STEEL.getDefaultState().withProperty(FORMED, true).withProperty(AIR, true), 3);
			 else worldIn.setBlockState(pos, Modblocks.QUANTUM_STEEL.getDefaultState().withProperty(FORMED, false).withProperty(AIR, false), 3);
			 
		}
		
		
		
		@Override
		public boolean isOpaqueCube(IBlockState state) {
			// TODO Auto-generated method stub
			if(state == FORMED)
			{
				return false;
			}
			else
			{
				return true;
			}
			
		}
		
		@Override
		public boolean isTranslucent(IBlockState state) {
			if(state == FORMED)
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
			if(state == FORMED)
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
			if(state == FORMED)
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
				return BlockRenderLayer.CUTOUT_MIPPED;
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
		
	/*@Override
	public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
		if(state == FORMED)
		{
		return super.canRenderInLayer((IBlockState) FORMED, layer.CUTOUT_MIPPED);
		}
		else
		{
			return super.canRenderInLayer(getDefaultState(), layer.SOLID);
		}
	}*/
		
		@Override
		protected BlockStateContainer createBlockState() {
			// TODO Auto-generated method stub
			return new BlockStateContainer(this, new IProperty[] {FORMED,AIR});
		}
		@Override
			public EnumBlockRenderType getRenderType(IBlockState state) {
                // TODO Auto-generated method stub
                if(state == FORMED)
                {
                return EnumBlockRenderType.INVISIBLE;
                }
                else
                {
                    return EnumBlockRenderType.MODEL;
                }
			}
		@Override
		public int getMetaFromState(IBlockState state) { return 0; }

		@Override
		public IBlockState getStateFromMeta(int meta) { return this.getDefaultState(); }






		@Override
		public TileEntity createNewTileEntity(World worldIn, int meta) {
			// TODO Auto-generated method stub
			return new InvisRend();
		}

		
}

