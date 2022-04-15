package com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModWorldFeatures;
import com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Common.CustomGenSettings;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public final class CarthageGenerator extends ChunkGenerator {

private static final Codec<CustomGenSettings> SETTINGS_CODEC = RecordCodecBuilder.create(
        settingsInstance -> settingsInstance.group(
                Codec.INT.fieldOf("base").forGetter(CustomGenSettings::baseHeight),
                Codec.FLOAT.fieldOf("verticalvariance").forGetter(CustomGenSettings::verticalVariance),
                Codec.FLOAT.fieldOf("horizontalvariance").forGetter(CustomGenSettings::horizontalVariance))
                .apply(settingsInstance,CustomGenSettings::new));
public static final Codec<CarthageGenerator> CARTHAGE_GENERATOR_CODEC = RecordCodecBuilder.create(
        carthageGeneratorInstance ->
                carthageGeneratorInstance.group(
                        RegistryOps.retrieveRegistry(Registry.STRUCTURE_SET_REGISTRY).forGetter(CarthageGenerator::getStructRegistry),
                        RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter(CarthageGenerator::getThisBiomeRegistry),
                        SETTINGS_CODEC.fieldOf("settings").forGetter(CarthageGenerator::getCarthageSettings)
                ).apply(carthageGeneratorInstance,CarthageGenerator::new)
);

    private final CustomGenSettings settings;
    public CarthageGenerator(@NotNull Registry<StructureSet> structureSets, Registry<Biome> registry, CustomGenSettings settings) {
        super(structureSets,getSet(structureSets), new CarthageBiomeProvider(registry));
        this.settings = settings;

    }



    private static @NotNull Optional<HolderSet<StructureSet>> getSet(@NotNull Registry<StructureSet> thisStructureRegistry)
    {
        HolderSet.Named<StructureSet> structureSetNamed = thisStructureRegistry.getOrCreateTag(TagKey.create(Registry.STRUCTURE_SET_REGISTRY,
                ModWorldFeatures.RL_LYOKO_STRUCTURE_SET));
        return Optional.of(structureSetNamed);
    }


    public Registry<Biome> getThisBiomeRegistry()
    {
        return ((CarthageBiomeProvider)biomeSource).getBiomeRegistry();
    }

    public @NotNull Registry<StructureSet> getStructRegistry()
    {
        return structureSets;
    }

    public CustomGenSettings getCarthageSettings()
    {
        return settings;
    }

    @Override
    protected @NotNull Codec<? extends ChunkGenerator> codec() {
        return CARTHAGE_GENERATOR_CODEC;
    }

    @Override
    public @NotNull ChunkGenerator withSeed(long p_62156_) {
        return new CarthageGenerator(getStructRegistry(),getThisBiomeRegistry(),settings);
    }

    @Override
    public Climate.@NotNull Sampler climateSampler() {
        return new Climate.Sampler(DensityFunctions.constant(0.0),DensityFunctions.constant(0.0),DensityFunctions.constant(0.0),
                DensityFunctions.constant(0.0),DensityFunctions.constant(0.0), DensityFunctions.constant(0.0),Collections.emptyList());
    }

    @Override
    public void applyCarvers(WorldGenRegion p_187691_, long p_187692_, BiomeManager p_187693_, StructureFeatureManager p_187694_, ChunkAccess p_187695_, GenerationStep.Carving p_187696_) {

    }

    @Override
    public void buildSurface(@Nonnull WorldGenRegion p_225551_1_, StructureFeatureManager featureManager, @NotNull ChunkAccess chunk) {
        BlockState bedrock = ModFluids.DIGITAL_SEA_BLOCK.get().defaultBlockState();
        BlockState stone = ModBlocks.SECTOR5_STEEL.get().defaultBlockState();
        BlockState white = ModBlocks.TOWER_WHITE.get().defaultBlockState();
        BlockState blue = ModBlocks.TOWER_BLUE.get().defaultBlockState();
        ChunkPos chunkpos = chunk.getPos();

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();


        int x;
        int z;

        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                chunk.setBlockState(pos.set(x, 0, z), bedrock, false);
            }
        }
        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                int realX = (chunkpos.x << 4) + x;
                int realZ = (chunkpos.z << 4) + z;
                int height = (int) (Math.sqrt(Math.pow(128, 2) - Math.pow(realX, 2) - Math.pow(realZ, 2)));
                int innerHeight = (int) (Math.sqrt(Math.pow(126, 2) - Math.pow(realX, 2) - Math.pow(realZ, 2)));
                createSphere(chunk, stone, pos, x, z, height, innerHeight);

                int heightSpawn = (int) (Math.sqrt(Math.pow(25, 2) - Math.pow(realX, 2) - Math.pow(realZ, 2)));
                int innerHeightSpawn = (int) (Math.sqrt(Math.pow(23, 2) - Math.pow(realX, 2) - Math.pow(realZ, 2)));
                createSphere(chunk, stone, pos, x, z, heightSpawn, innerHeightSpawn);
                for (int h = 0; h < heightSpawn; h++) {
                    if ((realZ == -1 || realZ == 0 || realZ == 1) && realX > 11) {
                        chunk.setBlockState(pos.set(realX, h + 128, realZ), Blocks.AIR.defaultBlockState(), false);
                        //chunk.setBlockState(pos.setPos(x, 127 - h, z), Blocks.AIR.getDefaultState(), false);
                    }
                }

                double disc = Math.pow(realX, 2) + Math.pow(realZ, 2);
                if (disc <= Math.pow(23, 2)) {
                    chunk.setBlockState(pos.set(realX, 127, realZ), blue, false);
                }
                if ((realX >= -23 && realX <= -12) || (realX >= 12 && realX <= 23)) {
                    if (realZ == 0) {
                        chunk.setBlockState(pos.set(realX, 127, realZ), white, false);

                    } else if (realZ == -1) {
                        chunk.setBlockState(pos.set(realX, 127, realZ), white, false);

                    } else if (realZ == 1) {
                        chunk.setBlockState(pos.set(realX, 127, realZ), white, false);
                    }
                }

                if (disc <= Math.pow(12, 2)) {
                    chunk.setBlockState(pos.set(realX, 127, realZ), white, false);
                }
                if (disc <= Math.pow(10, 2)) {
                    chunk.setBlockState(pos.set(realX, 127, realZ), blue, false);
                }
                if (disc <= Math.pow(7, 2)) {
                    chunk.setBlockState(pos.set(realX, 127, realZ), white, false);
                }
                if (disc <= Math.pow(4, 2)) {
                    chunk.setBlockState(pos.set(realX, 127, realZ), blue, false);
                }
                if (disc <= Math.pow(1, 2)) {
                    chunk.setBlockState(pos.set(realX, 127, realZ), white, false);
                }
            }
        }
    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion p_62167_) {

    }



    @Override
    public int getGenDepth() {
        return 0;
    }

    @Override
    public @NotNull CompletableFuture<ChunkAccess> fillFromNoise(@NotNull Executor p_187748_, @NotNull Blender p_187749_, @NotNull StructureFeatureManager p_187750_, @NotNull ChunkAccess p_187751_) {
        return CompletableFuture.completedFuture(p_187751_);
    }

    @Override
    public int getSeaLevel() {
        return 1;
    }

    @Override
    public int getMinY() {
        return 0;
    }

    private void createSphere(@NotNull ChunkAccess chunk, @NotNull BlockState stone, BlockPos.@NotNull MutableBlockPos pos, int x, int z, int height, int innerHeight) {
        for (int h = 0; h < height; h++) {
            chunk.setBlockState(pos.set(x, h + 128, z), stone, false);
            chunk.setBlockState(pos.set(x, 127 - h, z), stone, false);
        }
        for (int y = 0; y < innerHeight; y++) {
            chunk.setBlockState(pos.set(x, y + 128, z), Blocks.AIR.defaultBlockState(), false);
            chunk.setBlockState(pos.set(x, 127 - y, z), Blocks.AIR.defaultBlockState(), false);
        }
    }


private int getHeightAt(int baseHeight,float vertialVariance, float horizontalVariance,int x, int z)
{
    return (int) (baseHeight+Math.sin(x/horizontalVariance) * vertialVariance + Math.cos(z/horizontalVariance) * vertialVariance);
}

    @Override
    public int getBaseHeight(int x, int z, @Nonnull Heightmap.Types heightmapType, LevelHeightAccessor levelHeightAccessor) {
        int baseHeight = settings.baseHeight();
        float verticalVariance = settings.verticalVariance();
        float horizontalVariance = settings.horizontalVariance();

        return getHeightAt(baseHeight,verticalVariance,horizontalVariance,x,z);
    }

    @Override
    public @NotNull NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor levelHeightAccessor) {
        int y = getBaseHeight(x,z, Heightmap.Types.WORLD_SURFACE_WG,levelHeightAccessor);
        BlockState none = Blocks.AIR.defaultBlockState();
        BlockState[] states = new BlockState[y];
        for(int i = 1; i < y; i++)
        {
            states[i] = none;
        }


        return new NoiseColumn(levelHeightAccessor.getMinBuildHeight(),states);
    }

    @Override
    public void addDebugScreenInfo(List<String> p_208054_, BlockPos p_208055_) {

    }


}
