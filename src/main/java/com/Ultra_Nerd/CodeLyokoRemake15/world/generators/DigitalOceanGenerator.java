package com.Ultra_Nerd.CodeLyokoRemake15.world.generators;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean.OceanGenSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;

import javax.annotation.Nonnull;

public class DigitalOceanGenerator extends ChunkGenerator<OceanGenSettings> {

    public DigitalOceanGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, OceanGenSettings settingsIn) {
        super(worldIn, biomeProviderIn, settingsIn);

    }
//TODO:Generate digital sea roof
    @Override
    public void generateSurface(@Nonnull WorldGenRegion p_225551_1_, @Nonnull IChunk chunk) {
        BlockState bedrock = Blocks.BEDROCK.getDefaultState();
        BlockState stone = ModFluids.DIGITAL_SEA_BLOCK.get().getDefaultState();
        Block steel = ModBlocks.SECTOR5_STEEL.get();
        Block pylon = ModBlocks.DIGITAL_SEA_PYLON.get();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        int x;
        int z;

        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                chunk.setBlockState(pos.setPos(x, 0, z), bedrock, false);
            }
        }

        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {

                int height = /*(int)*/ 256;//(65 * Math.tan(realx / 20.0f) * 60 + Math.tan(realz / 20.0f) * 60);
                for (int y = 1; y < height; y++) {
                    chunk.setBlockState(pos.setPos(x, y, z), stone, false);
                }
            }

        }
    }


    @Override
    public void makeBase(@Nonnull IWorld worldIn, @Nonnull IChunk chunkIn) {

    }

    @Override
    public int getHeight(int x, int z, @Nonnull Heightmap.Type heightmapType) {
        return 0;
    }


    @Override
    public int getGroundHeight() {
        return world.getSeaLevel() + 1;
    }

}
