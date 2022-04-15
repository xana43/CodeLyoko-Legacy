package com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.FoliagePlaces;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModPlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.BiConsumer;

public final class DigitalForestTreePlacer extends MegaJungleFoliagePlacer {


    public DigitalForestTreePlacer(@NotNull IntProvider p_161454_, @NotNull IntProvider p_161455_, int p_161456_) {
        super(p_161454_, p_161455_, p_161456_);
    }

    @Override
    protected @NotNull FoliagePlacerType<?> type() {
        return ModPlacers.DIGITAL_TREE_PLACER.get();

    }

    @Override
    protected void createFoliage(LevelSimulatedReader p_161422_, BiConsumer<BlockPos, BlockState> p_161423_, Random p_161424_, TreeConfiguration p_161425_, int p_161426_, FoliageAttachment p_161427_, int p_161428_, int p_161429_, int p_161430_) {

    }

    @Override
    public int foliageHeight(Random p_68568_, int p_68569_, TreeConfiguration p_68570_) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(Random p_68562_, int p_68563_, int p_68564_, int p_68565_, int p_68566_, boolean p_68567_) {
        return false;
    }
}
