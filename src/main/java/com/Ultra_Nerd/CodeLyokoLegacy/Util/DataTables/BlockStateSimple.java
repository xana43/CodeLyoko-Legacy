package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public final class BlockStateSimple extends FabricModelProvider {
    public BlockStateSimple(final FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(final BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerStateWithModelReference(ModBlocks.DIGITAL_LAVA_BLOCK, Blocks.LAVA);
    }

    @Override
    public void generateItemModels(final ItemModelGenerator itemModelGenerator) {

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
