package com.Ultra_Nerd.CodeLyokoRemake15.blocks;


import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import java.util.Random;

public class AntiMarabunta extends Block {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);
    public AntiMarabunta() {
        super(Block.Properties.create(Material.DRAGON_EGG)
                .hardnessAndResistance(6, 10)
                .sound(SoundType.STONE)
                .lightValue(0)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .tickRandomly()
        );
    }

    @Nonnull
    @Override
    public VoxelShape getCollisionShape(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos,
                                        @Nonnull ISelectionContext context) {
        // TODO Auto-generated method stub
        return SHAPE;
    }

    @Override
    public void tick(@Nonnull BlockState state, ServerLevel worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        if (worldIn.isClientSide) {
            for (byte i = 0; i < 20; ++i) {
                BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos)) {
                    return;
                }

                BlockState iblockstate = worldIn.getBlockState(blockpos.up());
                BlockState iblockstate1 = worldIn.getBlockState(blockpos);

                if (iblockstate1.getBlock() == ModBlocks.MARABUNTA.get()) {
                    worldIn.setBlockState(blockpos, ModBlocks.ANTI_MARABUNTA.get().getDefaultState());
                }


            }

            for (byte i = 0; i < 1; ++i) {
                BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos)) {
                    return;
                }

                BlockState iblockstate = worldIn.getBlockState(blockpos.up());
                BlockState iblockstate1 = worldIn.getBlockState(blockpos);

                if (iblockstate1.getBlock() == ModBlocks.ANTI_MARABUNTA.get()) {
                    worldIn.setBlockState(blockpos, Blocks.DIRT.getDefaultState());
                }


            }


        }
    }


}
