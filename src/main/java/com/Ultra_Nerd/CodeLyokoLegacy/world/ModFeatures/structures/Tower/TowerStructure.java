package com.Ultra_Nerd.CodeLyokoLegacy.world.ModFeatures.structures.Tower;

public final class TowerStructure /*extends StructureFeature<JigsawConfiguration>*/{
    /*
   public TowerStructure()
   {
       super(JigsawConfiguration.CODEC, TowerStructure::createPiecesGenerator,PostPlacementProcessor.NONE);
   }

    @Override
    public GenerationStep.@NotNull Decoration step() {
        return GenerationStep.Decoration.TOP_LAYER_MODIFICATION;
    }

    private static boolean isFeatureChunk(PieceGeneratorSupplier.@NotNull Context<JigsawConfiguration> context)
    {
        final ChunkPos pos = context.chunkPos();
        return  !context.chunkGenerator().hasFeatureChunkInRange(BuiltinStructureSets.JUNGLE_TEMPLES, context.seed(), pos.x, pos.z, 10);
    }
    private static @NotNull Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.@NotNull Context<JigsawConfiguration> context)
    {
        if(!TowerStructure.isFeatureChunk(context))
        {
            return Optional.empty();
        }
       BlockPos blockPos = context.chunkPos().getMiddleBlockPosition(-10);
        int toplandY = context.chunkGenerator().getFirstFreeHeight(blockPos.getX(), blockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG,context.heightAccessor());
        blockPos = blockPos.above(toplandY >> 1);
        Optional<PieceGenerator<JigsawConfiguration>> pieceGen =
                JigsawPlacement.addPieces(
                        context,
                        PoolElementStructurePiece::new,
                        blockPos,
                        false,
                        true
                );
        if(pieceGen.isPresent())
        {
            CodeLyokoMain.Log.info("tower at {}",blockPos);
        }
        return pieceGen;
    }

     */





}
