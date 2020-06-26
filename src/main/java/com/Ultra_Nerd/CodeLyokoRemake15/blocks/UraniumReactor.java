package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class UraniumReactor extends Block{

	public UraniumReactor() {
		super(Block.Properties.create(Material.IRON)

				.hardnessAndResistance(6, 10)
				.sound(SoundType.METAL)
				.lightValue(0)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE));

		// TODO Auto-generated constructor stub
	}
	/*
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote)
		{
			playerIn.openGui(Base.instance, Conf.URANIUM, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		// TODO Auto-generated method stub
		return new ComputerReactorTileEntity();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		ComputerReactorTileEntity tileentity = (ComputerReactorTileEntity)worldIn.getTileEntity(pos);
		worldIn.spawnEntity(new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(), tileentity.handle.getStackInSlot(0)));
		super.breakBlock(worldIn, pos, state);
	}
	*/
	
}
