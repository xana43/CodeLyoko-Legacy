package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Tower;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.LyokoVehicleEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class TowerBottomBlock extends Block {
    public TowerBottomBlock(final Settings settings) {
        super(settings);
    }


    @Override
    public void onLandedUpon(final World world, final BlockState state, final BlockPos pos, final Entity entity, final float fallDistance) {
        super.onLandedUpon(world, state, pos, entity, fallDistance);
        if (!(entity instanceof PlayerEntity) && !(entity instanceof LyokoVehicleEntity)) {
            entity.damage(entity.getWorld().getDamageSources().outOfWorld(), Float.MAX_VALUE);
        }
    }

    @Override
    public void onSteppedOn(final World world, final BlockPos pos, final BlockState state, final Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
        final Iterable<BlockPos> blockList = BlockPos.iterate(pos.getX() - 7, pos.getY(), pos.getZ() - 7, pos.getX() + 7,
                pos.getY() + 32, pos.getZ() + 7);
        for (BlockPos blockPos : blockList) {
            if (world.getBlockState(blockPos).getBlock() == ModBlocks.TOWER_BLUE) {
                if (entity instanceof PlayerEntity)
                    entity.setPos(blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5);
            }
        }
        if (!(entity instanceof PlayerEntity) && !(entity instanceof LyokoVehicleEntity)) {
            entity.damage(entity.getWorld().getDamageSources().outOfWorld(), Integer.MAX_VALUE);
        }
    }


}