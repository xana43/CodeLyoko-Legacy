package com.Ultra_Nerd.CodeLyokoLegacy.blocks;


import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.Random;
import java.util.function.Function;

public final class AntiMarabunta extends Block {
    private static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    @Override
    public boolean canMobSpawnInside() {
        return super.canMobSpawnInside();
    }



    public AntiMarabunta() {
        super(FabricBlockSettings.of(Material.BARRIER).strength(6,10).sounds(BlockSoundGroup.STONE).ticksRandomly());
    }

    @Override
    public void randomTick(final BlockState state, final ServerWorld worldIn, final BlockPos pos, final Random rand) {
        super.randomTick(state, worldIn, pos, rand);
        for (byte i = 0; i < 30; ++i) {
            BlockPos blockpos = pos.offset(Direction.random(rand),rand.nextInt(3) - 1);

            if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isChunkLoaded(blockpos)) {
                return;
            }

            //BlockState iblockstate = worldIn.getBlockState(blockpos.above());
            final BlockState iblockstate1 = worldIn.getBlockState(blockpos);

            if (iblockstate1.getBlock() == ModBlocks.MARABUNTA) {
                worldIn.setBlockState(blockpos, ModBlocks.ANTI_MARABUNTA.getDefaultState());
            }


        }

        for (byte i = 0; i < 1; ++i) {
            BlockPos blockpos = pos.offset(Direction.random(rand),rand.nextInt(3) - 1);

            if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isChunkLoaded(blockpos)) {
                return;
            }

            //BlockState iblockstate = worldIn.getBlockState(blockpos.above());
            final BlockState iblockstate1 = worldIn.getBlockState(blockpos);

            if (iblockstate1.getBlock() == ModBlocks.ANTI_MARABUNTA) {
                worldIn.setBlockState(blockpos, Blocks.DIRT.getDefaultState());
            }


        }

    }

    @Override
    public boolean hasRandomTicks(final BlockState state) {
        return true;
    }

    @Override
    protected ImmutableMap<BlockState, VoxelShape> getShapesForStates(final Function<BlockState, VoxelShape> stateToShape) {
        return  ImmutableMap.<BlockState, VoxelShape>builder().put(this.getDefaultState(),SHAPE).build();
    }










}
