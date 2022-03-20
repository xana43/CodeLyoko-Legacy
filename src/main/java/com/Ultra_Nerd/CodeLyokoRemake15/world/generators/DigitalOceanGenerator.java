package com.Ultra_Nerd.CodeLyokoRemake15.world.generators;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean.OceanGenSettings;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class DigitalOceanGenerator extends ChunkGenerator<OceanGenSettings> {

    public DigitalOceanGenerator(LevelAccessor worldIn, BiomeSource biomeProviderIn, OceanGenSettings settingsIn) {
        super(worldIn, biomeProviderIn, settingsIn);

    }

    //TODO:Generate digital sea roof
    @Override
    public void buildSurface(@Nonnull WorldGenRegion p_225551_1_, @NotNull StructureFeatureManager manager, @Nonnull ChunkAccess chunk) {
        BlockState bedrock = Blocks.BEDROCK.defaultBlockState();
        BlockState stone = ModFluids.DIGITAL_SEA_BLOCK.get();
        Block steel = ModBlocks.SECTOR5_STEEL.get();
        Block pylon = ModBlocks.DIGITAL_SEA_PYLON.get();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        int x;
        int z;

        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                chunk.setBlockState(pos.set(x, 0, z), bedrock, false);
                chunk.setBlockState(pos.set(x, 255, z), bedrock, false);
            }
        }

        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {

                int height = /*(int)*/ 256;//(65 * Math.tan(realx / 20.0f) * 60 + Math.tan(realz / 20.0f) * 60);
                for (int y = 1; y < height; y++) {
                    chunk.setBlockState(pos.set(x, y, z), stone, false);
                }
            }

        }
    }

    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return null;
    }

    @Override
    public ChunkGenerator withSeed(long p_62156_) {
        return null;
    }

    @Override
    public Climate.Sampler climateSampler() {
        return null;
    }

    @Override
    public void applyCarvers(WorldGenRegion p_187691_, long p_187692_, BiomeManager p_187693_, StructureFeatureManager p_187694_, ChunkAccess p_187695_, GenerationStep.Carving p_187696_) {

    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion p_62167_) {

    }

    @Override
    public int getGenDepth() {
        return 0;
    }

    @Override
    public void makeBase(@Nonnull IWorld worldIn, @Nonnull IChunk chunkIn) {

    }

    @Override
    public int getHeight(int x, int z, @Nonnull Heightmap.Type heightmapType) {
        return 0;
    }

    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Executor p_187748_, Blender p_187749_, StructureFeatureManager p_187750_, ChunkAccess p_187751_) {
        return null;
    }




    @Override
    public int getSeaLevel() {
        return 0;
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public int getBaseHeight(int p_156153_, int p_156154_, Heightmap.Types p_156155_, LevelHeightAccessor p_156156_) {
        return 0;
    }

    @Override
    public NoiseColumn getBaseColumn(int p_156150_, int p_156151_, LevelHeightAccessor p_156152_) {
        return null;
    }

    @Override
    public void addDebugScreenInfo(List<String> p_208054_, BlockPos p_208055_) {

    }
}
