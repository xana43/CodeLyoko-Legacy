package com.Ultra_Nerd.CodeLyokoRemake.Blocks;



import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class Marabunta extends BlockFire {
	
	public Marabunta(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(6.0f);
		setResistance(10);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.2f);
	}
	
	
}
