package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Souinds;
import com.Ultra_Nerd.CodeLyokoRemake.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TowerBlockNonSolid extends blockBase {
	
	
	
	public TowerBlockNonSolid(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.GLASS);
		setHardness(20);
		setResistance(20);
		setHarvestLevel("spade", 20);
		setLightLevel(4);
	}
	
	@Nullable
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i,
			int j, int k) {
		return NULL_AABB;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return NULL_AABB;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public Boolean isEntityInsideMaterial(IBlockAccess world, BlockPos blockpos, IBlockState iblockstate, Entity entity,double yToTest, Material materialIn, boolean testingHead) {
		Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getMusicRecord(Souinds.SHOOT));
		return true;
	}
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
