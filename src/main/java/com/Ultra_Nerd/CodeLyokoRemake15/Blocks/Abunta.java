package com.Ultra_Nerd.CodeLyokoRemake15.Blocks;



import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers.Conf;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.Modblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Abunta extends Block {
	 protected static final AxisAlignedBB SOUL_SAND_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D);
	public Abunta(String name, final Properties properties)
	{
		super(properties);
		
		setRegistryName(name);
		Modblocks.BLOCKS.add(this);
		ModItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
    public AxisAlignedBB getCollisionBoundingBox(BlockState blockState, BlockAccess worldIn, BlockPos pos)
    {
        return SOUL_SAND_AABB;
    }

    /**
     * Called When an Entity Collided with the Block
     */
	
	public void updateTick(World worldIn, BlockPos pos, BlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
           
               if(worldIn.provider.getDimension() == 0)
               {
                    for (int i = 0; i < 900; ++i)
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
