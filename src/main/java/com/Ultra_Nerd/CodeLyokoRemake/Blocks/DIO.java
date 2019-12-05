package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DIO extends blockBase 
{

	
		public DIO(String name, Material material)
		{
			super(name, material);
			
			setSoundType(SoundType.WOOD);
			setHardness(-1);
			setResistance(-1);
			setHarvestLevel("axe", -1);
			
			
			
        }
        
        @Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return NULL_AABB;
    }
    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        entityIn.attackEntityFrom(new DamageSource(this.getUnlocalizedName()), RANDOM.nextInt(250));
    }
}
