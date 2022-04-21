package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.BlockStateProviderType;

import java.util.Random;

public final class BlockStateSimple extends BlockStateProvider {
    @Override
    protected BlockStateProviderType<?> getType() {
        return null;
    }

    @Override
    public BlockState getBlockState(final Random random, final BlockPos pos) {
        return null;
    }
    /*
    public BlockStateSimple(final DataGenerator gen,final ExistingFileHelper exFileHelper) {
        super(gen, CodeLyokoMain.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.BORNITE_ORE.get());
    }

    @Override
    protected BlockStateProviderType<?> getType() {
        return null;
    }

    @Override
    public BlockState getBlockState(final Random random, final BlockPos pos) {
        return null;
    }

     */
}
