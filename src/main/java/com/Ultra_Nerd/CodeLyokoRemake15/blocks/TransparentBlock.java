package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nonnull;
import java.util.function.Predicate;

public class TransparentBlock extends Block {

    public TransparentBlock() {
        super(Block.Properties.create(Material.GLASS)
                .hardnessAndResistance(-1, -1)
                .sound(SoundType.STONE)
                .harvestLevel(-1)
                .notSolid()
        );

    }

    @Nonnull
    @Override
    public BlockRenderType getRenderType(@Nonnull BlockState state) {
        // TODO Auto-generated method stub
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public boolean isTransparent(@Nonnull BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isViewBlocking(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return false;
    }


    @Override
    public boolean isNormalCube(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isReplaceable(@Nonnull BlockState state, @Nonnull BlockItemUseContext useContext) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isReplaceableOreGen(BlockState state, IWorldReader world, BlockPos pos,
                                       Predicate<BlockState> target) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isSideInvisible(@Nonnull BlockState state, @Nonnull BlockState adjacentBlockState, @Nonnull Direction side) {
        // TODO Auto-generated method stub
        return true;
    }
}
