package com.Ultra_Nerd.CodeLyokoRemake15.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class UniversalEnergyBlock extends Block {

	//private UniversalEnergyStorageTileEntity Text = new UniversalEnergyStorageTileEntity();
	public UniversalEnergyBlock() {
		super(Block.Properties.create(Material.MISCELLANEOUS)

				.hardnessAndResistance(3, 10)
				.sound(SoundType.GLASS)
				.lightValue(4)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)




		);

	}
	/*
  @Override
public boolean hasTileEntity(IBlockState state) {
	// TODO Auto-generated method stub
	return true;
}
  
  @Override
public TileEntity createTileEntity(World world, IBlockState state) {
	// TODO Auto-generated method stub
	return new UniversalEnergyStorageTileEntity();
}
  
  @Override
public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
		EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	playerIn.sendMessage(new TextComponentString(Integer.toString(Text.getall(0)) + "RF" + "/" + Integer.toString(Text.getStoreMax()) + "RF") );
	return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
}
*/
}
