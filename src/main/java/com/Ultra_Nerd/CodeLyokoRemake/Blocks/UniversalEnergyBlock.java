package com.Ultra_Nerd.CodeLyokoRemake.Blocks;


import com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.UniversalStorage.UniversalStore;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import scala.swing.TextComponent;

public class UniversalEnergyBlock extends blockBase {

	private UniversalStore Text = new UniversalStore();
	public UniversalEnergyBlock(String name, Material material) {
		super(name, material);
		//setRegistryName(name);
		setUnlocalizedName(name);
		setHarvestLevel("pickaxe", 2);
		setResistance(10);
		setHardness(3);
		// TODO Auto-generated constructor stub
	}
	
  @Override
public boolean hasTileEntity(IBlockState state) {
	// TODO Auto-generated method stub
	return true;
}
  
  @Override
public TileEntity createTileEntity(World world, IBlockState state) {
	// TODO Auto-generated method stub
	return new UniversalStore();
}
  
  @Override
public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
		EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	playerIn.sendMessage(new TextComponentString(Integer.toString(Text.getall(0)) + "/" + Integer.toString(Text.getStoreMax())) );
	return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
}

}
