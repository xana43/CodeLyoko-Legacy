package com.Ultra_Nerd.CodeLyokoRemake15.blocks;


import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;
import java.util.Random;

public class AntiMarabunta extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return true;
    }

    public AntiMarabunta() {
        super(Block.Properties.of(Material.BARRIER)
                .strength(6, 10)
                .sound(SoundType.STONE)
                .randomTicks()

        );
    }

    @Override
    public boolean isRandomlyTicking(BlockState p_49921_) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    public void tick(@Nonnull BlockState state, ServerLevel worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        //if (worldIn.isClientSide) {
            for (byte i = 0; i < 20; ++i) {
                BlockPos blockpos = pos.offset(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isLoaded(blockpos)) {
                    return;
                }

                BlockState iblockstate = worldIn.getBlockState(blockpos.above());
                BlockState iblockstate1 = worldIn.getBlockState(blockpos);

                if (iblockstate1.getBlock() == ModBlocks.MARABUNTA.get()) {
                    worldIn.setBlockAndUpdate(blockpos, ModBlocks.ANTI_MARABUNTA.get().defaultBlockState());
                }


            }

            for (byte i = 0; i < 1; ++i) {
                BlockPos blockpos = pos.offset(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isLoaded(blockpos)) {
                    return;
                }

                BlockState iblockstate = worldIn.getBlockState(blockpos.above());
                BlockState iblockstate1 = worldIn.getBlockState(blockpos);

                if (iblockstate1.getBlock() == ModBlocks.ANTI_MARABUNTA.get()) {
                    worldIn.setBlockAndUpdate(blockpos, Blocks.DIRT.defaultBlockState());
                }


            }


        //}
    }


}
