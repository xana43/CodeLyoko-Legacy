package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;

import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class DIO extends FlowingFluidBlock {

	
	public DIO(Supplier<? extends FlowingFluid> supplier, Properties properties) {
		super(supplier, properties);
		
		
	}
	
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		// TODO Auto-generated method stub
		
			entityIn.attackEntityFrom(DamageSource.OUT_OF_WORLD, Integer.MAX_VALUE);
		
	}
	
	
	
	

	
	
	

	
	
	
	
	
	
	

}
