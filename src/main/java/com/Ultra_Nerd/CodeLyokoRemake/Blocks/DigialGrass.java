package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class DigialGrass extends blockBase {
	
	public DigialGrass(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.GROUND);
		setHardness(2);
		setResistance(10);
		setHarvestLevel("spade", 1);
		setLightLevel(0.0f);
	}
	
	
	
	
	
}
