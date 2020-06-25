package com.Ultra_Nerd.CodeLyokoRemake15.blocks;




import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class AntiMarabunta extends Block {
    protected static final VoxelShape SOUL_SAND_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D);
    public AntiMarabunta()
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

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!worldIn.isRemote)
        {


            for (int i = 0; i < 9000; ++i)
            {
                BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                {
                    return;
                }

                BlockState iblockstate = worldIn.getBlockState(blockpos.up());
                BlockState iblockstate1 = worldIn.getBlockState(blockpos);

                if (iblockstate1.getBlock() == ModBlocks.MARABUNTA.get())
                {
                    worldIn.setBlockState(blockpos, ModBlocks.ANTI_MARABUNTA.get().getDefaultState());
                }


            }

            for (int i = 0; i < 1; ++i)
            {
                BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                {
                    return;
                }

                BlockState iblockstate = worldIn.getBlockState(blockpos.up());
                BlockState iblockstate1 = worldIn.getBlockState(blockpos);

                if (iblockstate1.getBlock() == ModBlocks.ANTI_MARABUNTA.get())
                {
                    worldIn.setBlockState(blockpos, Blocks.DIRT.getDefaultState());
                }


            }


        }
    }

    /**
     * Called When an Entity Collided with the Block
     */












}
