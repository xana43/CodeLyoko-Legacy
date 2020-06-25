package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class HologramBlock extends Block {

    public HologramBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(6, 10)
                .sound(SoundType.GLASS)
                .lightValue(2)
        );
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
    public boolean isTransparent(BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }
}
