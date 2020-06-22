package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UraniumBlock extends Block {

	public UraniumBlock(String name,Material materialIn) {
		super(materialIn);
		
		setSoundType(SoundType.METAL);
		setHardness(6.0f);
		setResistance(10);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.2f);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		// TODO Auto-generated method stub
		 entityIn.attackEntityFrom(new DamageSource(this.getUnlocalizedName()), RANDOM.nextInt(1));
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		// TODO Auto-generated method stub
		entityIn.attackEntityFrom(new DamageSource(this.getUnlocalizedName()), RANDOM.nextInt(1));
	}
	
	
	 

}
