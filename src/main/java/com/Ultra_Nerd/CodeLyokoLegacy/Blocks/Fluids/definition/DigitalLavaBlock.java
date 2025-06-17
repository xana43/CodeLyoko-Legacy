package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.definition;

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
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public final class DigitalLavaBlock extends FluidBlock {
    public DigitalLavaBlock(final Settings settings) {
        super(ModFluids.STILL_DIGITAL_LAVA, settings);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        super.onEntityCollision(state, world, pos, entity, handler);
        if (world.isClient()) {
            return;
        }
        entity.setOnFireFromLava();

        if(entity instanceof PlayerEntity) {
            entity.damage((ServerWorld) world,ModDamageSources.of(world, ModDamageTypes.DIGITAL_LAVA), Float.MAX_VALUE);
            return;
        }
        entity.kill((ServerWorld) world);
    }

    @Override
    public float getAmbientOcclusionLightLevel(final BlockState state, final BlockView world, final BlockPos pos) {
        return Float.MAX_VALUE;
    }


}
