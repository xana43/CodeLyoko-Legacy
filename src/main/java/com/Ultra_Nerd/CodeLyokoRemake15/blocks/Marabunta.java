package com.Ultra_Nerd.CodeLyokoRemake15.blocks;



import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers.registry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class Marabunta extends Block {
	 protected static final VoxelShape SOUL_SAND_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D);
	public Marabunta()
	{
		super(Block.Properties.create(Material.DRAGON_EGG)
				
				.hardnessAndResistance(6, 10)
				.sound(SoundType.STONE)
				.lightValue(0)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				.tickRandomly()
					
					
					
					
			);
		
	}
	
	
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {
		// TODO Auto-generated method stub
		return SOUL_SAND_AABB;
	}
    /**
     * Called When an Entity Collided with the Block
     */
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		entityIn.setMotion(0.4D, 1, 0.4D);
        entityIn.attackEntityFrom(new DamageSource(this.getTranslationKey()), RANDOM.nextInt(10));
	}
	
 @Override
public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
	// TODO Auto-generated method stub
	 if (!worldIn.isRemote)
     {
        
            
                 for (int i = 0; i < 90; ++i)
                 {
                     BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                     if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                     {
                         return;
                     }

                    // BlockState iblockstate = worldIn.getBlockState(blockpos.up());
                     BlockState iblockstate1 = worldIn.getBlockState(blockpos);

                     if (iblockstate1.getBlock() == Blocks.GRASS || iblockstate1.getBlock() == Blocks.DIRT ||    iblockstate1.getBlock() == registry.DIGITAL_BLOCK.get() || iblockstate1.getBlock() == registry.DIGITAL_ICE.get())
                     {
                         worldIn.setBlockState(blockpos, registry.MARABUNTA.get().getDefaultState());
                     }
                 }
     }
}
	
	
	
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
