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

public class TowerBlockWhite extends blockBase {
	
	public TowerBlockWhite(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.GLASS);
		setHardness(20);
		setResistance(20);
		setHarvestLevel("spade", 20);
		setLightLevel(4);
	}
	
	
	
	
	
}
