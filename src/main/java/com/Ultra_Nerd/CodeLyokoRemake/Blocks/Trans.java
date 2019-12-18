package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.HoloProjector.ProjectorTE;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.block.model.ModelBlock;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scala.reflect.internal.Trees.This;

public class Trans extends blockBase {
	
	public Trans(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setLightLevel(2);
		setUnlocalizedName(name);
		setRegistryName(name);
				
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	

	
	@Override
	public boolean isFullBlock(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isBlockNormalCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		// TODO Auto-generated method stub
		return BlockRenderLayer.CUTOUT;
	}

@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.INVISIBLE;
	}

}
