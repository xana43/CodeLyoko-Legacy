package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.HoloProjector.ProjectorTE;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class HoloPro extends BlockContainer {
	
	public HoloPro(String name, Material material)
	{
		super(material);
		setSoundType(SoundType.STONE);
		setLightLevel(2);
		setUnlocalizedName(name);
		setRegistryName(name);
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

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

	
	
	
	
}
