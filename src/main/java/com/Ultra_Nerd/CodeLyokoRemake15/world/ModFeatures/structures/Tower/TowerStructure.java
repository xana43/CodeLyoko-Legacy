package com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures.structures.Tower;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class TowerStructure extends StructureFeature<JigsawConfiguration>{
   public TowerStructure()
   {
       super(JigsawConfiguration.CODEC, TowerStructure::createPiecesGenerator,PostPlacementProcessor.NONE);
   }

    @Override
    public GenerationStep.@NotNull Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }


    private static @NotNull Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<JigsawConfiguration> context)
    {
        BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);
        blockpos = findSuitableSpot(context,blockpos);
        return JigsawPlacement.addPieces(context, PoolElementStructurePiece::new,blockpos,false,false);
    }



    private static BlockPos findSuitableSpot(PieceGeneratorSupplier.Context<JigsawConfiguration> context, BlockPos pos)
    {
        LevelHeightAccessor heightAccessor = context.heightAccessor();
        int y = context.chunkGenerator().getBaseHeight(pos.getX(), pos.getZ(), Heightmap.Types.WORLD_SURFACE_WG,heightAccessor);
        WorldgenRandom random = new WorldgenRandom(new LegacyRandomSource(context.seed()));
        random.setLargeFeatureSeed(context.seed(),context.chunkPos().x,context.chunkPos().z);
        y = random.nextIntBetweenInclusive(heightAccessor.getMinBuildHeight() +20,y - 10 );
        NoiseColumn baseColum = context.chunkGenerator().getBaseColumn(pos.getX(), pos.getZ(), heightAccessor);
        int yy = y;
        int lower = heightAccessor.getMinBuildHeight() + 3;
        while (yy > lower && !baseColum.getBlock(yy).isAir())
        {
            yy--;
        }
        if(yy > lower)
        {
            while (yy > lower && baseColum.getBlock(yy).isAir())
            {
                yy--;
            }
            if(yy > lower)
            {
                y = yy +1;
            }
        }
        return pos.atY(y);
    }

}
