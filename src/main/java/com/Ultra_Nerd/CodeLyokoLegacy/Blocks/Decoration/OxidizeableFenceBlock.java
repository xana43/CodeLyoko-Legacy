package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Decoration;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public final class OxidizeableFenceBlock extends FenceBlock implements ModdedOxidizable {



    private final Oxidizable.OxidationLevel oxidationLevel;
    public OxidizeableFenceBlock(final Oxidizable.OxidationLevel oxidationLevel,final Settings settings) {
        super(settings);
        this.oxidationLevel = oxidationLevel;
    }

    @Override
    public void randomTick(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        super.randomTick(state, world, pos, random);
        this.tickDegradation(state, world, pos, random);
    }

    @Override
    public boolean hasRandomTicks(final BlockState state) {
        return ModdedOxidizable.getModdedIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return oxidationLevel;
    }
}
