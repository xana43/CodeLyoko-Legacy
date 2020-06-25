package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class DigitalSeaBlock extends FlowingFluidBlock {

	
	public DigitalSeaBlock(Supplier<? extends FlowingFluid> supplier) {
		super(supplier, Block.Properties.create(Material.WATER).doesNotBlockMovement().noDrops().notSolid().hardnessAndResistance(100));
	   		
	}
	
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		// TODO Auto-generated method stub
		
			entityIn.attackEntityFrom(DamageSource.OUT_OF_WORLD, Integer.MAX_VALUE);
		
	}
	
	
	
	

	
	
	

	
	
	
	
	
	
	

}
