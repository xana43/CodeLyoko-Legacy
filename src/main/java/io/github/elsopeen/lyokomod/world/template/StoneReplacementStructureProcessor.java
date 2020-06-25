package io.github.elsopeen.lyokomod.world.template;

import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import io.github.elsopeen.lyokomod.init.ModBlocks;
import io.github.elsopeen.lyokomod.init.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.Template;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class StoneReplacementStructureProcessor extends StructureProcessor {
    @Nullable
    @Override
    public Template.BlockInfo process(@Nonnull IWorldReader world, @Nonnull BlockPos pos, @Nonnull Template.BlockInfo blockInfo0, @Nonnull Template.BlockInfo blockInfo, @Nonnull PlacementSettings placementSettings, @Nullable Template template) {
        Block block = blockInfo.state.getBlock();
        if(world.getDimension().equals(ModDimensions.LYOKO_BANQUISE.get())){
            if (block == Blocks.STONE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.BANQUISE_ICE.get().getDefaultState(), null);
            } else if (block == Blocks.GRANITE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.BANQUISE_ICE.get().getDefaultState(), null);
            } else if (block == Blocks.DIORITE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.BANQUISE_ICE.get().getDefaultState(), null);
            } else if (block == Blocks.ANDESITE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.BANQUISE_ICE.get().getDefaultState(), null);
            }
        } else if (world.getDimension().equals(ModDimensions.LYOKO_DESERT.get())) {
            if (block == Blocks.STONE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.DESERT_SAND.get().getDefaultState(), null);
            } else if (block == Blocks.GRANITE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.DESERT_SAND.get().getDefaultState(), null);
            } else if (block == Blocks.DIORITE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.DESERT_SAND.get().getDefaultState(), null);
            } else if (block == Blocks.ANDESITE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.DESERT_SAND.get().getDefaultState(), null);
            }
        } else if (world.getDimension().equals(ModDimensions.LYOKO_MOUNTAIN.get())) {
            if (block == Blocks.STONE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.MOUNTAIN_ROCK.get().getDefaultState(), null);
            } else if (block == Blocks.GRANITE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.MOUNTAIN_ROCK.get().getDefaultState(), null);
            } else if (block == Blocks.DIORITE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.MOUNTAIN_ROCK.get().getDefaultState(), null);
            } else if (block == Blocks.ANDESITE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.MOUNTAIN_ROCK.get().getDefaultState(), null);
            }
        } else if (world.getDimension().equals(ModDimensions.LYOKO_FOREST.get())) {
            if (block == Blocks.STONE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.FOREST_GRASS.get().getDefaultState(), null);
            } else if (block == Blocks.GRANITE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.FOREST_GRASS.get().getDefaultState(), null);
            } else if (block == Blocks.DIORITE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.FOREST_GRASS.get().getDefaultState(), null);
            } else if (block == Blocks.ANDESITE) {
                return new Template.BlockInfo(blockInfo.pos, ModBlocks.FOREST_GRASS.get().getDefaultState(), null);
            }
        }

        return blockInfo;
    }

    @Override
    @Nonnull
    protected IStructureProcessorType getType() {
        return IStructureProcessorType.JIGSAW_REPLACEMENT;
    }

    @Override
    @Nonnull
    protected <T> Dynamic<T> serialize0(@Nonnull DynamicOps<T> ops) {
        return new Dynamic<>(ops, ops.emptyMap());
    }
}
