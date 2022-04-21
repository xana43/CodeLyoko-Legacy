package com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.FoliagePlaces;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public final class DigitalForestTreeDecorator extends TreeDecorator {
   // @Override
   // protected @NotNull TreeDecoratorType<?> type() {
      //  return ModPlacers.DIGITAL_TREE_DECORATOR.get();
    //}

    //@Override
  //  public void place(@NotNull LevelSimulatedReader p_161745_, @NotNull BiConsumer<BlockPos, BlockState> p_161746_, @NotNull Random p_161747_, @NotNull List<BlockPos> p_161748_, @NotNull List<BlockPos> p_161749_) {
//
    //}

    @Override
    protected TreeDecoratorType<?> getType() {
        return null;
    }

    @Override
    public void generate(final TestableWorld world, final BiConsumer<BlockPos, BlockState> replacer, final Random random, final List<BlockPos> logPositions, final List<BlockPos> leavesPositions) {

    }
}
