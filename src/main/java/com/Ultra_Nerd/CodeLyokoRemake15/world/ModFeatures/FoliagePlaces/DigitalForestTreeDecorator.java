package com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures.FoliagePlaces;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModPlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class DigitalForestTreeDecorator extends TreeDecorator {
    @Override
    protected @NotNull TreeDecoratorType<?> type() {
        return ModPlacers.DIGITAL_TREE_DECORATOR.get();
    }

    @Override
    public void place(@NotNull LevelSimulatedReader p_161745_, @NotNull BiConsumer<BlockPos, BlockState> p_161746_, @NotNull Random p_161747_, @NotNull List<BlockPos> p_161748_, @NotNull List<BlockPos> p_161749_) {

    }
}
