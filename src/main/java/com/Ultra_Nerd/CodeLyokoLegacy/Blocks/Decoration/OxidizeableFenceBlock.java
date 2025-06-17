package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Decoration;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Degradable;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public final class OxidizeableFenceBlock extends FenceBlock implements Oxidizable {

    public static final MapCodec<OxidizeableFenceBlock> CODEC = RecordCodecBuilder.mapCodec(oxidizeableFenceBlockInstance -> oxidizeableFenceBlockInstance.group(OxidationLevel.CODEC.fieldOf("weathering_state").forGetter(Degradable::getDegradationLevel), createSettingsCodec()).apply(oxidizeableFenceBlockInstance, OxidizeableFenceBlock::new));

    private final Oxidizable.OxidationLevel oxidationLevel;
    public OxidizeableFenceBlock(final Oxidizable.OxidationLevel oxidationLevel,final Settings settings) {
        super(settings);
        this.oxidationLevel = oxidationLevel;
    }
    public MapCodec<OxidizeableFenceBlock> getFenceCodec() {
        return CODEC;
    }
    @Override
    public void randomTick(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        super.randomTick(state, world, pos, random);
        this.tickDegradation(state, world, pos, random);
    }

    @Override
    public boolean hasRandomTicks(final BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
    public Oxidizable.OxidationLevel getDegradationLevel() {
        return oxidationLevel;
    }
}
