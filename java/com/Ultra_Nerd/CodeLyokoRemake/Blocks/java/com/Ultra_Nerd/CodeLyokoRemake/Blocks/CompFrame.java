package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import javax.swing.Icon;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.world.IBlockAccess;

public class CompFrame extends blockBase 
{

	
		public CompFrame(String name, Material material)
		{
			super(name, material);
			
			setSoundType(SoundType.METAL);
			setHardness(1.0f);
			setResistance(20);
			setHarvestLevel("pickaxe", 0);
			setLightLevel(0.0f);
			
			
		}
		
		
		public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side)
		{
			return this.getBlockTexture(world, x, y, z, side);
			
		}
		
}
