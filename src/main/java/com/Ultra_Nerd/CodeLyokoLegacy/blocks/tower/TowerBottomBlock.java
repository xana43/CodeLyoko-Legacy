package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower;

import net.minecraft.block.Block;

public final class TowerBottomBlock extends Block {
    public TowerBottomBlock(final Settings settings) {
        super(settings);
    }
/*
    public TowerBottomBlock(@NotNull Properties properties) {
        super(properties);
    }



    @Override
    public void updateEntityAfterFallOn(BlockGetter p_49821_, Entity p_49822_) {
        super.updateEntityAfterFallOn(p_49821_, p_49822_);
        if (!(p_49822_ instanceof Player)) {
            p_49822_.hurt(DamageSource.OUT_OF_WORLD, Integer.MAX_VALUE);
        }
    }



    @Override
    public void stepOn(@NotNull Level worldIn, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entityIn) {
        super.stepOn(worldIn,pos,state,entityIn);
        Iterable<BlockPos> blockList = BlockPos.betweenClosed(pos.getX() - 7, pos.getY(), pos.getZ() - 7, pos.getX() + 7, pos.getY() + 32, pos.getZ() + 7);
        for (BlockPos blockPos : blockList) {
            if (worldIn.getBlockState(blockPos).getBlock() == ModBlocks.TOWER_BLUE.get()) {
                if (entityIn instanceof Player)
                    entityIn.setPos(blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5);
//                EnderTeleportEvent event = new EnderTeleportEvent((LivingEntity) entityIn, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0.0f);

            }
        }
        if (!(entityIn instanceof Player)) {
            entityIn.hurt(DamageSource.OUT_OF_WORLD, Integer.MAX_VALUE);
        }
    }

 */


}