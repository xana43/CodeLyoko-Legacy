package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class COOL extends BlockFluidClassic{

	public COOL(String name,Fluid fluid, Material material) {
		super(fluid, material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		//setDensity(10);
		this.getFluid().setDensity(40);
		
		//Modblocks.BLOCKS.add(this);
		//ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}
	
	
}
