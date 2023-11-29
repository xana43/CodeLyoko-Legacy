package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Sector;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModDimensions;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public final class SectorEntrance extends Block {
    public enum SELECTORS {
        FOREST(ModDimensions.forestSectorWorld),
        DESERT(ModDimensions.desertSectorWorld),
        ICE(ModDimensions.iceSectorWorld),
        MOUNTAIN(ModDimensions.mountainSectorWorld),
        CARTHAGE(ModDimensions.carthage),
        DIGITAL_OCEAN(ModDimensions.digitalOceanWorld),
        VOLCANO(ModDimensions.volcanoWorld);

        private final RegistryKey<World> worldRegistryKey;
        SELECTORS(final RegistryKey<World> dimension)
        {
            worldRegistryKey = dimension;
        }

        public final RegistryKey<World> getWorldRegistryKey() {
            return worldRegistryKey;
        }
    }
    private final int sectorSelector;
    public SectorEntrance(final Settings settings,final SELECTORS selectors) {
        super(settings.nonOpaque().dropsNothing().solid().noBlockBreakParticles());
        sectorSelector = selectors.ordinal();
    }


    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public void onLandedUpon(final World world, final BlockState state, final BlockPos pos, final Entity entity, final float fallDistance) {
        super.onLandedUpon(world, state, pos, entity, fallDistance);

        if(!world.isClient()) {
            final ServerWorld serverWorld = Objects.requireNonNull(world.getServer()).getWorld(SELECTORS.values()[sectorSelector].getWorldRegistryKey());
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





}
