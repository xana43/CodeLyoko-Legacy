package com.Ultra_Nerd.CodeLyokoRemake15.blocks;


import com.Ultra_Nerd.CodeLyokoRemake15.blocks.machine.universal_storage.UniversalStore;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class UniversalEnergyBlock extends Block {

	private UniversalStore Text = new UniversalStore();
	public UniversalEnergyBlock(String name, Material material) {
		super(material);
		//setRegistryName(name);
		setUnlocalizedName(name);
		setHarvestLevel("pickaxe", 2);
		setResistance(10);
		setHardness(3);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
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
	playerIn.sendMessage(new TextComponentString(Integer.toString(Text.getall(0)) + "RF" + "/" + Integer.toString(Text.getStoreMax()) + "RF") );
	return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
}

}
