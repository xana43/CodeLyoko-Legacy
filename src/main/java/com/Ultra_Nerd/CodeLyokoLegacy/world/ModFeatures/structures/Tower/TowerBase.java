package com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.structures.Tower;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModStructures;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTags;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.heightprovider.HeightProvider;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public final class TowerBase extends Structure {
    public static final Codec<TowerBase> CODEC = RecordCodecBuilder.<TowerBase>mapCodec(instance ->
            instance.group(TowerBase.configCodecBuilder(instance),
                    StructurePool.REGISTRY_CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                    Identifier.CODEC.optionalFieldOf("start_jigsaw_name")
                            .forGetter(structure -> structure.startJigsawName),
                    Codec.intRange(0, 30).fieldOf("size").forGetter(structure -> Integer.valueOf(structure.size)),
                    HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                    Heightmap.Type.CODEC.optionalFieldOf("project_start_to_heightmap")
                            .forGetter(structure -> structure.projectStartToHeightmap),
                    Codec.intRange(1, 128).fieldOf("max_distance_from_center")
                            .forGetter(structure -> Integer.valueOf(structure.maxDistanceFromCenter))
            ).apply(instance, TowerBase::new)).codec();
    private final RegistryEntry<StructurePool> startPool;
    private final Optional<Identifier> startJigsawName;
    private final int size;
    private final HeightProvider startHeight;
    private final Optional<Heightmap.Type> projectStartToHeightmap;
    private final int maxDistanceFromCenter;

    public TowerBase(final Structure.Config config,final RegistryEntry<StructurePool> startPool,
            final Optional<Identifier> startJigsawName,final int size,final HeightProvider startHeight,
            final Optional<Heightmap.Type> projectStartToHeightmap,final int maxDistanceFromCenter) {

        super(config);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.size = size;
        this.startHeight = startHeight;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxDistanceFromCenter;

    }

    private static VerticalBlockSample sampleAreaPositive(final BlockPos pos, final Structure.Context context) {
        VerticalBlockSample sample = new VerticalBlockSample(0, new BlockState[]{});

        for (int i = 0; i < 2; i++) {
            sample = context.chunkGenerator()
                    .getColumnSample(pos.getX() + i, pos.getZ() + i, context.world(), context.noiseConfig());

        }


        return sample;
    }

    private static VerticalBlockSample sampleAreaNegative(final BlockPos pos, final Structure.Context context) {
        VerticalBlockSample sample = new VerticalBlockSample(0, new BlockState[]{});

        for (int i = -2; i < 0; i++) {
            sample = context.chunkGenerator()
                    .getColumnSample(pos.getX() + i, pos.getZ() + i, context.world(), context.noiseConfig());
        }


        return sample;
    }

    @Override
    public GenerationStep.Feature getFeatureGenerationStep() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }

    @Override
    public Optional<Structure.StructurePosition> getStructurePosition(final Structure.Context context) {

        BlockPos blockPos = context.chunkPos().getCenterAtY(0);
        //int toplandY = context.chunkGenerator().getHeightOnGround(blockPos.getX(), blockPos.getZ(), Heightmap.Type.WORLD_SURFACE_WG,context.world());
        Optional<StructurePosition> pieceGen = Optional.empty();
        for (int i = context.world().getHeight() >> 1; i > 0; i--) {

            if (sampleAreaPositive(blockPos, context).getState(i).isIn(ModTags.Blocks.LYOKO_BLOCKS)
                    && sampleAreaNegative(blockPos, context).getState(i).isIn(ModTags.Blocks.LYOKO_BLOCKS)
                    && !sampleAreaPositive(blockPos,context).getState(i).isOf(ModBlocks.DIGITAL_OCEAN_BLOCK)
                    && !sampleAreaNegative(blockPos,context).getState(i).isOf(ModBlocks.DIGITAL_OCEAN_BLOCK)
                    && !sampleAreaPositive(blockPos,context).getState(i).isOf(ModBlocks.DIGITAL_LAVA_BLOCK)
                    && !sampleAreaNegative(blockPos,context).getState(i).isOf(ModBlocks.DIGITAL_LAVA_BLOCK)
                    && !sampleAreaPositive(blockPos, context).getState(i).isOf(Blocks.VOID_AIR)
                    && !sampleAreaNegative(blockPos, context).getState(i).isOf(Blocks.VOID_AIR)
                    && !sampleAreaPositive(blockPos, context).getState(i).isOf(Blocks.AIR)
                    && !sampleAreaNegative(blockPos, context).getState(i).isOf(Blocks.AIR)
            ) {

                blockPos = blockPos.offset(Direction.UP, 1);
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
