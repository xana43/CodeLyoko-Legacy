package com.Ultra_Nerd.CodeLyokoRemake.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class tree extends blockBase 
{

	
		public tree(String name, Material material)
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
