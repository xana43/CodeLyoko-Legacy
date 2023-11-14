package com.Ultra_Nerd.CodeLyokoLegacy.blocks.tower;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.LyokoVehicleEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public final class TowerEnter extends HorizontalFacingBlock {

    public TowerEnter() {
        super(FabricBlockSettings.copyOf(Blocks.BARRIER)

                .strength(-1, Integer.MAX_VALUE)
                .sounds(BlockSoundGroup.GLASS)
                .noCollision().luminance(60)


        );

    }

    @Override
    protected void appendProperties(final StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(FACING));
    }

    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if (!(entity instanceof PlayerEntity) && !(entity instanceof LyokoVehicleEntity)) {
            entity.damage(entity.getWorld().getDamageSources().outOfWorld(),Float.MAX_VALUE);
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(final ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public boolean canMobSpawnInside(final BlockState state) {
        return false;
    }
}