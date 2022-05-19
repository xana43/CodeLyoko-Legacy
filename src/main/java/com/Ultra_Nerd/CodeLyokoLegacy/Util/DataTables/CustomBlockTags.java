package com.Ultra_Nerd.CodeLyokoLegacy.Util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.tag.BlockTags;

public final class CustomBlockTags extends FabricTagProvider.BlockTagProvider {
    public CustomBlockTags(final FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.ARCHITECTURE_WORK_STATION,
                ModBlocks.ELECTROPLATING_ANODE,
                ModBlocks.ELECTROPLATING_CATHODE,
                ModBlocks.SCANNER_BASE,
                ModBlocks.SCANNER_FRAME,
                ModBlocks.SCANNER_TOP,
                ModBlocks.TYUYAMUNITE_ORE,
                ModBlocks.CHIPLET_BASIC_BLOCK,
                ModBlocks.CHIPLET_ADVANCED_BLOCK
        );
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.CHIPLET_FRANZ_BLOCK
        );
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(
                ModBlocks.ARCHITECTURE_WORK_STATION,
                ModBlocks.ELECTROPLATING_ANODE,
                ModBlocks.ELECTROPLATING_CATHODE,
                ModBlocks.SCANNER_BASE,
                ModBlocks.SCANNER_FRAME,
                ModBlocks.SCANNER_TOP,
                ModBlocks.TYUYAMUNITE_ORE,
                ModBlocks.CHIPLET_ADVANCED_BLOCK,
                ModBlocks.CHIPLET_BASIC_BLOCK,
                ModBlocks.CHIPLET_FRANZ_BLOCK


        );
        getOrCreateTagBuilder(BlockTags.SAND).add(
                ModBlocks.SILICA_SAND
        );
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(
                ModBlocks.SILICA_SAND
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
