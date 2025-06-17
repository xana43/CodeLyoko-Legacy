package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.definition;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.MantaEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.Piranha;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.SkidbladnirEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModDamageSources;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModDamageTypes;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class DigitalSeaBlock extends FluidBlock {


    public DigitalSeaBlock(final Settings settings) {
        super(ModFluids.STILL_DIGITAL_OCEAN, settings);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        super.onEntityCollision(state, world, pos, entity, handler);
        if(world.isClient())
        {
            return;
        }
        final ServerWorld worldServer = (ServerWorld) world;
        if(entity instanceof SkidbladnirEntity)
        {
            return;
        }
        if(entity instanceof Piranha)
        {
            return;
        }
        if(entity instanceof MantaEntity)
        {
            return;
        }
        if(entity instanceof PlayerEntity) {
            entity.damage(worldServer,ModDamageSources.of(world, ModDamageTypes.DIGITAL_OCEAN), Float.MAX_VALUE);
            return;
        }
        entity.kill(worldServer);
    }
}
