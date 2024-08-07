package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Tower;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.LyokoVehicleEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
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
        super(AbstractBlock.Settings.copy(Blocks.BEDROCK)
                .sounds(BlockSoundGroup.GLASS)
                .noCollision().luminance(value -> 60)


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

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}