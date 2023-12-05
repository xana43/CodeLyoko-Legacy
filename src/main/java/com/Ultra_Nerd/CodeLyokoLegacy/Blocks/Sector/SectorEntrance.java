package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Sector;

import com.Ultra_Nerd.CodeLyokoLegacy.util.Enums.DimensionSelector;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public final class SectorEntrance extends Block {
    private final DimensionSelector sectorSelector;
    public SectorEntrance(final Settings settings,final DimensionSelector sectorSelector) {
        super(settings.nonOpaque().dropsNothing().solid().noBlockBreakParticles());
        this.sectorSelector = sectorSelector;
    }


    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.INVISIBLE;
    }


    private void teleportToDimension(final World world,final Entity entity)
    {
        if(!world.isClient()) {
            final ServerWorld serverWorld = Objects.requireNonNull(world.getServer()).getWorld(sectorSelector.getWorldRegistryKey());
            float validAirHeight = 0;
            validAirHeight += entity.getHeight();
            if(!entity.getPassengerList().isEmpty())
            {
                for(final Entity passengerEntity : entity.getPassengerList())
                {
                    validAirHeight += passengerEntity.getHeight();
                }
            }
            final BlockPos validPosition = MethodUtil.HelperMethods.getValidPosition(serverWorld, validAirHeight);
            entity.teleport(serverWorld, validPosition.getX(), validPosition.getY(), validPosition.getZ(), PositionFlag.VALUES, entity.getYaw(), entity.getPitch());
        }
    }

    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        teleportToDimension(world,entity);
    }

    @Override
    public void onSteppedOn(final World world, final BlockPos pos, final BlockState state, final Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
        teleportToDimension(world,entity);
    }

    @Override
    public void onLandedUpon(final World world, final BlockState state, final BlockPos pos, final Entity entity, final float fallDistance) {
        super.onLandedUpon(world, state, pos, entity, fallDistance);
        teleportToDimension(world,entity);
    }





}
