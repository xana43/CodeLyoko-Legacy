package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class TransparentBlock extends Block {

    public TransparentBlock() {
        super(Block.Properties.of(new Material.Builder(MaterialColor.NONE).nonSolid().build())
                .strength(-1, -1)
                .sound(SoundType.STONE)


        );

    }

    

    @Override
    public boolean canBeReplaced(BlockState p_60470_, BlockPlaceContext p_60471_) {
        return false;
    }

    @Override
    public boolean canBeReplaced(BlockState p_60535_, Fluid p_60536_) {
        return false;
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        return false;
    }

    @Override
    public void fallOn(Level p_152426_, BlockState p_152427_, BlockPos p_152428_, Entity p_152429_, float p_152430_) {
        super.fallOn(p_152426_, p_152427_, p_152428_, p_152429_, p_152430_);
        p_152429_.fallDistance = 0;
    }
}
