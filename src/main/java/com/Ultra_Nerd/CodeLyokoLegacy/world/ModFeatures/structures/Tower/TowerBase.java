package com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.structures.Tower;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTags;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.PostPlacementProcessor;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.structure.StructurePiecesGenerator;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public final class TowerBase extends StructureFeature<StructurePoolFeatureConfig> {


    public TowerBase(Codec<StructurePoolFeatureConfig> codec)
    {

        super(codec, TowerBase::createPiecesGenerator, PostPlacementProcessor.EMPTY);


    }

    @Override
    public GenerationStep.Feature getGenerationStep() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }



    private static VerticalBlockSample sampleAreaPositive(final BlockPos pos, final int offset, StructureGeneratorFactory.Context<?> context)
    {
        VerticalBlockSample sample = new VerticalBlockSample(0,new BlockState[]{});

            for (int i = 0; i < offset; i++)
            {
                sample = context.chunkGenerator().getColumnSample(pos.getX() + i, pos.getZ() + i, context.world());

            }
        if(offset < 0)
        {
            throw new IllegalStateException("offset must be at least 0");
        }

        return sample;
    }
    private static VerticalBlockSample sampleAreaNegative(final BlockPos pos, final int offset, StructureGeneratorFactory.Context<?> context)
    {
        VerticalBlockSample sample = new VerticalBlockSample(0,new BlockState[]{});

        for (int i = offset; i < 0; i++)
        {
            sample = context.chunkGenerator().getColumnSample(pos.getX() + i, pos.getZ() + i, context.world());
        }
        if(offset > 0)
        {
            throw new IllegalStateException("offset must be below 0");
        }

        return sample;
    }
    private static @NotNull Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> createPiecesGenerator(StructureGeneratorFactory.@NotNull Context<StructurePoolFeatureConfig> context)
    {

        BlockPos blockPos = context.chunkPos().getCenterAtY(0);
        //int toplandY = context.chunkGenerator().getHeightOnGround(blockPos.getX(), blockPos.getZ(), Heightmap.Type.WORLD_SURFACE_WG,context.world());
        Optional<StructurePiecesGenerator<StructurePoolFeatureConfig>> pieceGen = Optional.empty();
        for (int i = context.world().getHeight() >> 1; i >0; i--)
        {

                if(sampleAreaPositive(blockPos,2,context).getState(i).isIn(ModTags.Blocks.LYOKO_BLOCKS)
                && sampleAreaNegative(blockPos,-2,context).getState(i).isIn(ModTags.Blocks.LYOKO_BLOCKS)
                        &&sampleAreaPositive(blockPos,2,context).getState(i) != Blocks.VOID_AIR.getDefaultState()
                        &&sampleAreaNegative(blockPos,-2,context).getState(i) != Blocks.VOID_AIR.getDefaultState()
                )
                {

                    blockPos = blockPos.offset(Direction.UP,i - 54);


                    pieceGen = StructurePoolBasedGenerator.generate(
                            context,
                            (structureManager, poolElement, pos, groundLevelDelta, rotation, elementBounds) -> new PoolStructurePiece(structureManager,poolElement,pos,groundLevelDelta,rotation,elementBounds),
                            blockPos,
                            false,
                            true
                    );
                    break;


                }



        }
        //blockPos = blockPos.offset(Direction.Axis.Y,toplandY >> 2);


        if(pieceGen.isPresent() && CodeLyokoMain.LOG.isDebugEnabled())
        {
            CodeLyokoMain.LOG.info("TowerBase at {}",blockPos);
        }
        return pieceGen;
    }
}
