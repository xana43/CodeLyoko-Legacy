package com.Ultra_Nerd.CodeLyokoRemake15.world.ModFeatures.structures.Tower;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;

public class TowerStructure extends StructureFeature {
    public TowerStructure(Codec p_197165_, PieceGeneratorSupplier p_197166_) {
        super(p_197165_, p_197166_);
    }
    /*public TowerStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    public boolean canGenerate(RegistryAccess registryAccess, ChunkGenerator generatorIn, BiomeSource biomeIn, StructureManager manager, long value, ChunkPos chunkPos, FeatureConfiguration featureConfiguration, LevelHeightAccessor heightAccessor, Predicate predicate) {
        ChunkPos pos =
        if (chunkX == pos.x && chunkZ == pos.z) {
            return generatorIn.hasStructure(biomeIn, this);
        }
        return false;
    }


    @Override
    public PostPlacementProcessor getPostPlacementProcessor() {
        return super.getPostPlacementProcessor();
    }

    @Nonnull
    @Override
    public IStartFactory getStartFactory() {
        return TowerStructure.Start::new;
    }

    @Nonnull
    @Override
    public String getStructureName() {
        return CodeLyokoMain.MOD_ID + ":tower";
    }

    //depreciated
    @Override
    public int getSize() {
        return 0;
    }

    @Nonnull
    @Override
    protected ChunkPos getStartPositionForPosition(@Nonnull ChunkGenerator<?> chunkGenerator, @Nonnull Random random, int x, int z, int spacingOffsetsX, int spacingOffsetsZ) {
        int maxDistance = 20;
        int minDistance = 10;
        int xTemp = x + maxDistance * spacingOffsetsX;
        int ztemp = z + maxDistance * spacingOffsetsZ;
        int xTemp2 = xTemp < 0 ? xTemp - maxDistance + 1 : xTemp;
        int zTemp2 = ztemp < 0 ? ztemp - maxDistance + 1 : ztemp;
        int validChunkX = xTemp2 / maxDistance;
        int validChunkZ = zTemp2 / maxDistance;

        ((SharedSeedRandom) random).setLargeFeatureSeedWithSalt(chunkGenerator.getSeed(), validChunkX, validChunkZ, this.getSeedModifier());
        validChunkX = validChunkX * maxDistance;
        validChunkZ = validChunkZ * maxDistance;
        validChunkX = validChunkX + random.nextInt(maxDistance - minDistance);
        validChunkZ = validChunkZ + random.nextInt(maxDistance - minDistance);
        return new ChunkPos(validChunkX, validChunkZ);
    }

    protected int getSeedModifier() {
        return 234592323;
    }

    public static class Start extends StructureStart {

        public Start(Structure<?> structure, int chunkX, int chunkZ, BoundingBox boundingBox, int reference, long seed) {
            super(structure, chunkX, chunkZ, boundingBox, reference, seed);
        }

        @Override
        public void init(@Nonnull ChunkGenerator<?> generator, @Nonnull TemplateManager templateManagerIn, int chunkX, int chunkZ, @Nonnull Biome biomeIn) {
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];

            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;
            int y = generator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
            BlockPos pos = new BlockPos(x, y, z);

            TowerParts.Start(templateManagerIn, pos, rotation, this.components, this.rand);
            this.recalculateStructureSize();
            CodeLyokoMain.Log.info("a tower has spawned at: " + pos);

        }
    }

     */
}
