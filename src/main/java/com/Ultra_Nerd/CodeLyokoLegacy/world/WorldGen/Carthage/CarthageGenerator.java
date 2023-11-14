package com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Carthage;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.world.WorldGen.Common.CustomGenSettings;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.Blender;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.noise.NoiseConfig;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public final class CarthageGenerator extends ChunkGenerator {


    private static final Codec<CustomGenSettings> SETTINGS_CODEC = RecordCodecBuilder.create(
            settingsInstance -> settingsInstance.group(
                            Codec.INT.fieldOf("base").forGetter(CustomGenSettings::baseHeight),
                            Codec.FLOAT.fieldOf("verticalvariance").forGetter(CustomGenSettings::verticalVariance),
                            Codec.FLOAT.fieldOf("horizontalvariance").forGetter(CustomGenSettings::horizontalVariance))
                    .apply(settingsInstance, CustomGenSettings::new));
    public static final Codec<CarthageGenerator> CARTHAGE_GENERATOR_CODEC = RecordCodecBuilder.create(
            carthageGeneratorInstance ->
                    carthageGeneratorInstance.group(
                            BiomeSource.CODEC.fieldOf("biome_source")
                                    .forGetter(carthageGenerator -> carthageGenerator.biomeSource),
                            SETTINGS_CODEC.fieldOf("settings").forGetter(CarthageGenerator::getCarthageSettings)

                    ).apply(carthageGeneratorInstance, CarthageGenerator::new)
    );
    private final CustomGenSettings settings;


    public CarthageGenerator(final BiomeSource biomeSource,
            final CustomGenSettings settings) {
        super(biomeSource);
        this.settings = settings;
    }






    public CustomGenSettings getCarthageSettings() {
        return settings;
    }


    @Override
    protected @NotNull Codec<? extends ChunkGenerator> getCodec() {
        return CARTHAGE_GENERATOR_CODEC;
    }

    @Override
    public void carve(final ChunkRegion chunkRegion, final long seed, final NoiseConfig noiseConfig, final BiomeAccess world, final StructureAccessor structureAccessor, final Chunk chunk, final GenerationStep.Carver carverStep) {

    }


    @Override
    public void buildSurface(final ChunkRegion region, StructureAccessor featureManager, final NoiseConfig config,
            @NotNull Chunk chunk) {
        final BlockState bedrock = ModBlocks.DIGITAL_OCEAN_BLOCK.getDefaultState();
        final BlockState stone = ModBlocks.SECTOR5_STEEL.getDefaultState();
        final BlockState white = ModBlocks.TOWER_WHITE.getDefaultState();
        final BlockState blue = ModBlocks.TOWER_BLUE.getDefaultState();
        final ChunkPos chunkpos = chunk.getPos();

        final BlockPos.Mutable pos = new BlockPos.Mutable();


        byte x;
        byte z;

        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                chunk.setBlockState(pos.set(x, 0, z), bedrock, false);
            }
        }
        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                final int realX = (chunkpos.x << 4) + x;
                final int realZ = (chunkpos.z << 4) + z;
                final int height = (int) (Math.sqrt(Math.pow(128, 2) - Math.pow(realX, 2) - Math.pow(realZ, 2)));
                final int innerHeight = (int) (Math.sqrt(Math.pow(126, 2) - Math.pow(realX, 2) - Math.pow(realZ, 2)));
                createSphere(chunk, stone, pos, x, z, height, innerHeight);

                final int heightSpawn = (int) (Math.sqrt(Math.pow(25, 2) - Math.pow(realX, 2) - Math.pow(realZ, 2)));
                final int innerHeightSpawn = (int) (Math.sqrt(
                        Math.pow(23, 2) - Math.pow(realX, 2) - Math.pow(realZ, 2)));
                createSphere(chunk, stone, pos, x, z, heightSpawn, innerHeightSpawn);
                for (int h = 0; h < heightSpawn; h++) {
                    if ((realZ == -1 || realZ == 0 || realZ == 1) && realX > 11) {
                        chunk.setBlockState(pos.set(realX, h + 128, realZ), Blocks.AIR.getDefaultState(), false);
                        //chunk.setBlockState(pos.setPos(x, 127 - h, z), Blocks.AIR.getDefaultState(), false);
                    }
                }

                final double disc = Math.pow(realX, 2) + Math.pow(realZ, 2);
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
    public void populateEntities(final ChunkRegion region) {

    }

    @Override
    public int getWorldHeight() {
        return 0;
    }


    @Override
    public CompletableFuture<Chunk> populateNoise(final Executor executor, final Blender blender, final NoiseConfig noiseConfig, final StructureAccessor structureAccessor, final Chunk chunk) {
        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    public int getSeaLevel() {
        return 1;
    }


    private static void createSphere(@NotNull Chunk chunk, @NotNull BlockState stone, BlockPos.@NotNull Mutable pos, int x, int z, int height, int innerHeight) {
        for (int h = 0; h < height; h++) {
            chunk.setBlockState(pos.set(x, h + 128, z), stone, false);
            chunk.setBlockState(pos.set(x, 127 - h, z), stone, false);
        }
        for (int y = 0; y < innerHeight; y++) {
            chunk.setBlockState(pos.set(x, y + 128, z), Blocks.AIR.getDefaultState(), false);
            chunk.setBlockState(pos.set(x, 127 - y, z), Blocks.AIR.getDefaultState(), false);
        }
    }


    private static int getHeightAt(final int baseHeight, final float verticalVariance,final float horizontalVariance,final int x,final int z) {
        return (int) (baseHeight + Math.sin(x / horizontalVariance) * verticalVariance + Math.cos(
                z / horizontalVariance) * verticalVariance);
    }


    @Override
    public int getMinimumY() {
        return 0;
    }

    @Override
    public int getHeight(final int x, final int z, final Heightmap.Type heightmap, final HeightLimitView world, final NoiseConfig noiseConfig) {
        return 0;
    }


    @Override
    public int getHeightOnGround(final int x, final int z, final Heightmap.Type heightmap, final HeightLimitView world, final NoiseConfig config) {
        final int baseHeight = settings.baseHeight();
        final float verticalVariance = settings.verticalVariance();
        final float horizontalVariance = settings.horizontalVariance();

        return getHeightAt(baseHeight, verticalVariance, horizontalVariance, x, z);
    }

    @Override
    public void getDebugHudText(final List<String> text, final NoiseConfig noiseConfig, final BlockPos pos) {

    }


    @Override
    public VerticalBlockSample getColumnSample(final int x, final int z, final HeightLimitView world, NoiseConfig config) {
        final int y = getHeightOnGround(x, z, Heightmap.Type.WORLD_SURFACE_WG, world, config);
        final BlockState none = Blocks.AIR.getDefaultState();
        final BlockState[] states = new BlockState[y];
        for (int i = 1; i < y; i++) {
            states[i] = none;
        }


        return new VerticalBlockSample(world.getBottomY(), states);
    }


}
