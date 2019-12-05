package com.Ultra_Nerd.CodeLyokoRemake.Blocks;



import java.util.Random;

import javax.annotation.Nullable;

import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Conf;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Abunta extends blockBase {
	 protected static final AxisAlignedBB SOUL_SAND_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D);
	public Abunta(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(6.0f);
		setResistance(10);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.2f);
		setTickRandomly(true);
	}
	
	@Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return SOUL_SAND_AABB;
    }

    /**
     * Called When an Entity Collided with the Block
     */
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
           
               if(worldIn.provider.getDimension() == 0)
               {
                    for (int i = 0; i < 90; ++i)
                    {
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                        {
                            return;
                        }

                        IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                        if (iblockstate1.getBlock() == Modblocks.MARABUNTA)
                        {
                            worldIn.setBlockState(blockpos, Modblocks.ANTI_MARABUNTA.getDefaultState());
                        }
                        
                        
                    }
                    
                    for (int i = 0; i < 1; ++i)
                    {
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                        {
                            return;
                        }

                        IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                        if (iblockstate1.getBlock() == Modblocks.ANTI_MARABUNTA)
                        {
                            worldIn.setBlockState(blockpos, Blocks.DIRT.getDefaultState());
                        }
                        
                        
                    }
               }  
               else if(worldIn.provider.getDimension() == Conf.Dim)
               {
            	   for (int i = 0; i < 90; ++i)
                   {
                       BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                       if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                       {
                           return;
                       }

                       IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                       IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                       if (iblockstate1.getBlock() == Modblocks.MARABUNTA)
                       {
                           worldIn.setBlockState(blockpos, Modblocks.ANTI_MARABUNTA.getDefaultState());
                       }
                       
                       
                   }
                   
                   for (int i = 0; i < 1; ++i)
                   {
                       BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                       if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                       {
                           return;
                       }

                       IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                       IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                       if (iblockstate1.getBlock() == Modblocks.ANTI_MARABUNTA)
                       {
                           worldIn.setBlockState(blockpos, Modblocks.DIGITAL_BLOCK.getDefaultState());
                       }
                       
                       
                   }
               }
               else if(worldIn.provider.getDimension() == Conf.Dim2)
               {
            	   for (int i = 0; i < 90; ++i)
                   {
                       BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                       if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                       {
                           return;
                       }

                       IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                       IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                       if (iblockstate1.getBlock() == Modblocks.MARABUNTA)
                       {
                           worldIn.setBlockState(blockpos, Modblocks.ANTI_MARABUNTA.getDefaultState());
                       }
                       
                       
                   }
                   
                   for (int i = 0; i < 1; ++i)
                   {
                       BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                       if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                       {
                           return;
                       }

                       IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                       IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                       if (iblockstate1.getBlock() == Modblocks.ANTI_MARABUNTA)
                       {
                           worldIn.setBlockState(blockpos, Modblocks.DIGITAL_ICE.getDefaultState());
                       }
                       
                       
                   }
               }
                    
        }
            
        
    }
	
	@Override
	public boolean canEntitySpawn(IBlockState state, Entity entityIn) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
