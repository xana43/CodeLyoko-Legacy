package com.Ultra_Nerd.CodeLyokoLegacy.Blocks;


import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public final class AntiMarabunta extends Block {
    private static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    public AntiMarabunta(Settings settings) {
        super(settings);
    }


    @Override
    public void randomTick(final BlockState state, final ServerWorld worldIn, final BlockPos pos, final Random rand) {
        super.randomTick(state, worldIn, pos, rand);
        for (byte i = 0; i < 127; ++i) {
            final BlockPos blockpos = pos.offset(Direction.random(rand), rand.nextInt(3) - 1);

            if (blockpos.getY() >= -50 && blockpos.getY() < 384 && !worldIn.isChunkLoaded(blockpos)) {
                return;
            }

            //BlockState iblockstate = worldIn.getBlockState(blockpos.above());
            final BlockState iblockstate1 = worldIn.getBlockState(blockpos);

            if (iblockstate1.getBlock() == ModBlocks.MARABUNTA) {
                worldIn.setBlockState(blockpos, ModBlocks.ANTI_MARABUNTA.getDefaultState());
            }


        }

        for (byte i = 127; i > -1; i--) {
            final BlockPos blockpos = pos.offset(Direction.random(rand),
                    rand.nextInt(3) - 1);

            if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isChunkLoaded(blockpos)) {
                return;
            }

            //BlockState iblockstate = worldIn.getBlockState(blockpos.above());
            final BlockState iblockstate1 = worldIn.getBlockState(blockpos);

            if (iblockstate1.getBlock() == ModBlocks.ANTI_MARABUNTA && i == 0) {
                worldIn.setBlockState(blockpos, Blocks.DIRT.getDefaultState());
            }


        }

    }

    @Override
    public boolean hasRandomTicks(final BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return SHAPE;
    }
}
