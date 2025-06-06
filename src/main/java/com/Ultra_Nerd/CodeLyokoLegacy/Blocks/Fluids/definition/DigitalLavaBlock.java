package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.definition;

import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModDamageSources;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModDamageTypes;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public final class DigitalLavaBlock extends FluidBlock {
    public DigitalLavaBlock() {
        super(ModFluids.STILL_DIGITAL_LAVA, Settings.copy(Blocks.LAVA));
    }

    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if (world.isClient()) {
            return;
        }
        entity.setOnFireFromLava();

        if(entity instanceof PlayerEntity) {
            entity.damage(ModDamageSources.of(world, ModDamageTypes.DIGITAL_LAVA), Float.MAX_VALUE);
            return;
        }
        entity.kill();

    }

    @Override
    public float getAmbientOcclusionLightLevel(final BlockState state, final BlockView world, final BlockPos pos) {
        return Float.MAX_VALUE;
    }


}
