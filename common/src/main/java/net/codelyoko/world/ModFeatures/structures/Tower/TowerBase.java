package net.codelyoko.world.ModFeatures.structures.Tower;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModStructures;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModTags;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public final class TowerBase extends Structure {
    public static final Codec<TowerBase> CODEC = RecordCodecBuilder.<TowerBase>mapCodec(instance ->
            instance.group(TowerBase.settingsCodec(instance),
                    StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                    ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name")
                            .forGetter(structure -> structure.startJigsawName),
                    Codec.intRange(0, 30).fieldOf("size").forGetter(structure -> structure.size),
                    HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                    Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap")
                            .forGetter(structure -> structure.projectStartToHeightmap),
                    Codec.intRange(1, 128).fieldOf("max_distance_from_center")
                            .forGetter(structure -> structure.maxDistanceFromCenter)
            ).apply(instance, TowerBase::new)).codec();
    private final Holder<StructureTemplatePool> startPool;
    private final Optional<ResourceLocation> startJigsawName;
    private final int size;
    private final HeightProvider startHeight;
    private final Optional<Heightmap.Types> projectStartToHeightmap;
    private final int maxDistanceFromCenter;

    public TowerBase(Structure.StructureSettings config, Holder<StructureTemplatePool> startPool,
            Optional<ResourceLocation> startJigsawName,
            int size, HeightProvider startHeight, Optional<Heightmap.Types> projectStartToHeightmap,
            int maxDistanceFromCenter) {

        super(config);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.size = size;
        this.startHeight = startHeight;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxDistanceFromCenter;

    }

    private static NoiseColumn sampleAreaPositive(final BlockPos pos, GenerationContext context) {
        NoiseColumn sample = new NoiseColumn(0, new BlockState[]{});

        for (int i = 0; i < 2; i++) {
            sample = context.chunkGenerator().getBaseColumn(pos.getX() + i, pos.getZ() + i, context.heightAccessor(),
                    context.randomState());

        }
        if (2 < 0) {
            throw new IllegalStateException("offset must be at least 0");
        }

        return sample;
    }

    private static NoiseColumn sampleAreaNegative(final BlockPos pos, GenerationContext context) {
        NoiseColumn sample = new NoiseColumn(0, new BlockState[]{});

        for (int i = -2; i < 0; i++) {
            sample = context.chunkGenerator().getBaseColumn(pos.getX() + i, pos.getZ() + i, context.heightAccessor(),
                    context.randomState());
        }
        if (-2 > 0) {
            throw new IllegalStateException("offset must be below 0");
        }

        return sample;
    }



    @Override
    public @NotNull Optional<Structure.GenerationStub> findGenerationPoint(GenerationContext context) {

        BlockPos blockPos = context.chunkPos().getMiddleBlockPosition(0);
        //int toplandY = context.chunkGenerator().getHeightOnGround(blockPos.getX(), blockPos.getZ(), Heightmap.Type.WORLD_SURFACE_WG,context.world());
        Optional<GenerationStub> pieceGen = Optional.empty();
        for (int i = context.heightAccessor().getHeight() >> 1; i > 0; i--) {

            if (sampleAreaPositive(blockPos, context).getBlock(i).is(ModTags.Blocks.LYOKO_BLOCKS)
                    && sampleAreaNegative(blockPos, context).getBlock(i).is(ModTags.Blocks.LYOKO_BLOCKS)
                    && sampleAreaPositive(blockPos, context).getBlock(i) != Blocks.VOID_AIR.defaultBlockState()
                    && sampleAreaNegative(blockPos, context).getBlock(i) != Blocks.VOID_AIR.defaultBlockState()
            ) {

                blockPos = BlockPos.of(blockPos.offset(i - 54, Direction.UP));


                pieceGen = JigsawPlacement.addPieces(
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
    public StructureType<?> type() {
        return ModStructures.towerStruct;
    }


}
