package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class TransparentBlock extends Block {

    public TransparentBlock(String name, Material material) {
        super(Block.Properties.create(Material.STRUCTURE_VOID)
                .hardnessAndResistance(-1, -1)
                .sound(SoundType.STONE)
                .harvestLevel(-1)
        );

    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        // TODO Auto-generated method stub
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public boolean isTransparent(BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
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
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        // TODO Auto-generated method stub
        return true;
    }
}
