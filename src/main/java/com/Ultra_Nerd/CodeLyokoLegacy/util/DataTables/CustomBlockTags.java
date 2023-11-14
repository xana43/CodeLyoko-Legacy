package com.Ultra_Nerd.CodeLyokoLegacy.util.DataTables;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public final class CustomBlockTags extends FabricTagProvider.BlockTagProvider {


    public CustomBlockTags(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup arg) {
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
                ModBlocks.GUMMITE_ORE,
                ModBlocks.AUTUNITE_ORE,
                ModBlocks.BORNITE_ORE,
                ModBlocks.CARNOTITE_ORE,
                ModBlocks.CHALCOCITE_ORE,
                ModBlocks.CHALCOPYRITE_ORE,
                ModBlocks.COFFINITE_ORE,
                ModBlocks.COVELLITE_ORE,
                ModBlocks.SALEEITE_ORE,
                ModBlocks.COMPUTER_CORE
        };
        for (final Block block : commonBlocksPICKIRON) {
            getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        //for diamond
        final Block[] commonBlocksPICKDIAMOND =
                {
                        ModBlocks.CHIPLET_FRANZ_BLOCK,
                        ModBlocks.QUANTUM_CORE,
                };
        for (final Block block : commonBlocksPICKDIAMOND) {
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(block);
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        //for sand based blocks
        final Block[] commonBlocksSAND ={
                ModBlocks.SILICA_SAND
        };
        for(final Block block : commonBlocksSAND)
        {
            getOrCreateTagBuilder(BlockTags.SAND).add(block);
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(block);
        }
        //for all lyoko blocks
        final Block[] commonBlocksLYOKO ={
                ModBlocks.SECTOR5_STEEL,
                ModBlocks.DIGITAL_DARKNESS,
                ModBlocks.DIGITAL_DIRT,
                ModBlocks.DIGITAL_ICE,
                ModBlocks.DIGITAL_LAVA_BLOCK,
                ModBlocks.DIGITAL_LEAF_MOUNTAIN,
                ModBlocks.DIGITAL_OCEAN_BLOCK,
                ModBlocks.DIGITAL_ROCK,
                ModBlocks.DIGITAL_SAND,
                ModBlocks.DIGITAL_SEA_PYLON,
                ModBlocks.DIGITAL_WOOD_FOREST,
                ModBlocks.DIGITAL_WOOD_MOUNTAIN,
                ModBlocks.TOWER_WALL,
                ModBlocks.TOWER_WALL_CORNER,
                ModBlocks.TOWER_WHITE,
                ModBlocks.TOWER_TOP,
                ModBlocks.TOWER_INTERFACE,
                ModBlocks.TOWER_ENTER,
                ModBlocks.TOWER_BOTTOM,
                ModBlocks.TOWER_BASE,
                ModBlocks.TOWER_BASE_CORNER,
        };
        for(final Block block: commonBlocksLYOKO)
        {
            getOrCreateTagBuilder(ModTags.Blocks.LYOKO_BLOCKS).add(block);
        }
        getOrCreateTagBuilder(BlockTags.ICE).add(
                ModBlocks.DIGITAL_ICE
        );
        getOrCreateTagBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS).add(
          ModBlocks.TOWER_INTERFACE
        );

        //for uranium related blocks
        final Block[] commonUraniumOres = {
                ModBlocks.AUTUNITE_ORE,
                ModBlocks.BORNITE_ORE,
                ModBlocks.CARNOTITE_ORE,
                ModBlocks.CHALCOCITE_ORE,
                ModBlocks.CHALCOPYRITE_ORE,
                ModBlocks.COFFINITE_ORE,
                ModBlocks.COVELLITE_ORE,
                ModBlocks.GUMMITE_ORE,
                ModBlocks.METAAUTUNITE_ORE,
                ModBlocks.METATORBERNITE_ORE,
                ModBlocks.METATYUYAMUNITE_ORE,
                ModBlocks.SALEEITE_ORE,
                ModBlocks.SKLODOWSKITE_ORE,
                ModBlocks.TORBERNITE_ORE,
                ModBlocks.TYUYAMUNITE_ORE,
                ModBlocks.URANINITE_ORE,
                ModBlocks.URANOPHANE_ORE,
        };
        for (final Block block: commonUraniumOres)
        {
            getOrCreateTagBuilder(ModTags.Blocks.URANIUM_ORE_TAG).add(block);
            getOrCreateTagBuilder(ModTags.Blocks.URANIUM_ORES_TAG).add(block);
            getOrCreateTagBuilder(TagKey.of(Registries.BLOCK.getKey(), new Identifier("c","ores"))).add(block);
        }
        getOrCreateTagBuilder(ModTags.Blocks.URANIUM_235_BLOCKS).add(ModBlocks.URANIUM_BLOCK_235);
        getOrCreateTagBuilder(ModTags.Blocks.URANIUM_238_BLOCKS).add(ModBlocks.URANIUM_BLOCK_238);
        final Block[] commonLeaves = {
          ModBlocks.DIGITAL_LEAF_MOUNTAIN
        };
        for (final Block block : commonLeaves)
        {
            getOrCreateTagBuilder(BlockTags.LEAVES).add(block);
            getOrCreateTagBuilder(TagKey.of(Registries.BLOCK.getKey(), new Identifier("c","leaves"))).add(block);
        }
        getOrCreateTagBuilder(BlockTags.CHERRY_LOGS).add(ModBlocks.DIGITAL_WOOD_MOUNTAIN);
        getOrCreateTagBuilder(BlockTags.JUNGLE_LOGS).add(ModBlocks.DIGITAL_WOOD_FOREST);
        //for fluid blocks
        getOrCreateTagBuilder(ModTags.Blocks.COMMON_LAVA_TAG).add(ModBlocks.DIGITAL_LAVA_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.COMMON_LAVA_TAG).add(ModBlocks.URANIUM_WASTE_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.COMMON_WATER_TAG).add(ModBlocks.LIQUID_HELIUM_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.COMMON_VISUAL_WATER_TAG).add(ModBlocks.LIQUID_HELIUM_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.COMMON_WATER_TAG).add(ModBlocks.DIGITAL_OCEAN_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.COMMON_VISUAL_WATER_TAG).add(ModBlocks.DIGITAL_OCEAN_BLOCK);


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
