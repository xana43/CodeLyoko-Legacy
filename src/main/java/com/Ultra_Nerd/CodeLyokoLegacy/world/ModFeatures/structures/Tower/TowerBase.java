package com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.structures.Tower;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModStructures;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTags;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.*;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.VerticalBlockSample;

import net.minecraft.world.gen.heightprovider.HeightProvider;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public final class TowerBase extends Structure{

    private final RegistryEntry<StructurePool> startPool;
    private final Optional<Identifier> startJigsawName;
    private final int size;
    private final HeightProvider startHeight;
    private final Optional<Heightmap.Type> projectStartToHeightmap;
    private final int maxDistanceFromCenter;
    public TowerBase(Structure.Config config,RegistryEntry<StructurePool> startPool,Optional<Identifier> startJigsawName,int size,HeightProvider startHeight,Optional<Heightmap.Type> projectStartToHeightmap,int maxDistanceFromCenter)
    {

        super(config);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.size = size;
        this.startHeight = startHeight;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxDistanceFromCenter;

    }


    @Override
    public GenerationStep.Feature getFeatureGenerationStep() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }

    private static VerticalBlockSample sampleAreaPositive(final BlockPos pos, Structure.Context context)
    {
        VerticalBlockSample sample = new VerticalBlockSample(0,new BlockState[]{});

            for (int i = 0; i < 2; i++)
            {
                sample = context.chunkGenerator().getColumnSample(pos.getX() + i, pos.getZ() + i, context.world(),context.noiseConfig());

            }
        if(2 < 0)
        {
            throw new IllegalStateException("offset must be at least 0");
        }

        return sample;
    }
    private static VerticalBlockSample sampleAreaNegative(final BlockPos pos, Structure.Context context)
    {
        VerticalBlockSample sample = new VerticalBlockSample(0,new BlockState[]{});

        for (int i = -2; i < 0; i++)
        {
            sample = context.chunkGenerator().getColumnSample(pos.getX() + i, pos.getZ() + i, context.world(),context.noiseConfig());
        }
        if(-2 > 0)
        {
            throw new IllegalStateException("offset must be below 0");
        }

        return sample;
    }
    @Override
    public @NotNull Optional<Structure.StructurePosition> getStructurePosition(Structure.Context context)
    {

        BlockPos blockPos = context.chunkPos().getCenterAtY(0);
        //int toplandY = context.chunkGenerator().getHeightOnGround(blockPos.getX(), blockPos.getZ(), Heightmap.Type.WORLD_SURFACE_WG,context.world());
        Optional<StructurePosition> pieceGen = Optional.empty();
        for (int i = context.world().getHeight() >> 1; i >0; i--)
        {

                if(sampleAreaPositive(blockPos, context).getState(i).isIn(ModTags.Blocks.LYOKO_BLOCKS)
                && sampleAreaNegative(blockPos, context).getState(i).isIn(ModTags.Blocks.LYOKO_BLOCKS)
                        &&sampleAreaPositive(blockPos, context).getState(i) != Blocks.VOID_AIR.getDefaultState()
                        &&sampleAreaNegative(blockPos, context).getState(i) != Blocks.VOID_AIR.getDefaultState()
                )
                {

                    blockPos = blockPos.offset(Direction.UP,i - 54);


                    pieceGen = StructurePoolBasedGenerator.generate(
                            context,

                            this.startPool,
                            this.startJigsawName,
                            this.size,
                            blockPos,
                            false,
                            this.projectStartToHeightmap,
                            this.maxDistanceFromCenter
                    );
                    break;


                }



        }
        //blockPos = blockPos.offset(Direction.Axis.Y,toplandY >> 2);



        return pieceGen;
    }

    @Override
    public StructureType<?> getType() {
        return ModStructures.towerStruct;
    }


}
