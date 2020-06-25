package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;

import java.util.function.Supplier;

public class CoolantBlock extends FlowingFluidBlock{

	public CoolantBlock(Supplier<? extends FlowingFluid> supplier, Properties proper) {
		super(supplier,proper);
		
		
		//Modblocks.BLOCKS.add(this);
		//ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	
	
	
	
	
}
