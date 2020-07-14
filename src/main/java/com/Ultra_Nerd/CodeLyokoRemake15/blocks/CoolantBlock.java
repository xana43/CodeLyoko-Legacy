package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;

import java.util.function.Supplier;

public class CoolantBlock extends FlowingFluidBlock{

	public CoolantBlock(Supplier<? extends FlowingFluid> supplier) {
		super(supplier, Block.Properties.from(Blocks.WATER));
		
		
		//Modblocks.BLOCKS.add(this);
		//ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	
	
	
	
	
}
