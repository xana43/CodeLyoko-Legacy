package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;

public final class CustomBlockTags extends FabricTagProvider.BlockTagProvider {
    public CustomBlockTags(final FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        //blocks for iron
        final Block[] commonBlocksPICKIRON = {
                ModBlocks.ARCHITECTURE_WORK_STATION,
                ModBlocks.ELECTROPLATING_ANODE,
                ModBlocks.ELECTROPLATING_CATHODE,
                ModBlocks.SCANNER_BASE,
                ModBlocks.SCANNER_FRAME,
                ModBlocks.SCANNER_TOP,
                ModBlocks.TYUYAMUNITE_ORE,
                ModBlocks.CHIPLET_BASIC_BLOCK,
                ModBlocks.CHIPLET_ADVANCED_BLOCK,
                ModBlocks.HOLOPROJECTOR,
                ModBlocks.FLUORITE_ORE,
                ModBlocks.FLUORITE_BLOCK,
                ModBlocks.FLUORIDE_INFUSER,
                ModBlocks.CABLE_BLOCK,
                ModBlocks.COMPUTER_KEYBOARD,
                ModBlocks.GUMMITE_ORE
        };
        for (final Block block : commonBlocksPICKIRON) {
            getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        //for diamond
        final Block[] commonBlocksPICKDIAMOND =
                {
                        ModBlocks.CHIPLET_FRANZ_BLOCK
                };
        for (final Block block : commonBlocksPICKDIAMOND)
        {
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        getOrCreateTagBuilder(BlockTags.SAND).add(
                ModBlocks.SILICA_SAND
        );
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(
                ModBlocks.SILICA_SAND
        );
        getOrCreateTagBuilder(BlockTags.ICE).add(
                ModBlocks.DIGITAL_ICE
        );

    }
/*
    public CustomBlockTags(final DataGenerator p_126511_, @Nullable final ExistingFileHelper existingFileHelper) {
        super(p_126511_, CodeLyokoMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //super.addTags();
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BORNITE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BORNITE_ORE.get());
        tag(Tags.Blocks.ORES)
                .add(ModBlocks.BORNITE_ORE.get());


    }

    @Override
    public @NotNull String getName() {
        return "ModBlock Tags";
    }

 */
}
