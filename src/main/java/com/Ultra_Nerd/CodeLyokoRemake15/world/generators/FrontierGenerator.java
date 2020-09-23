package com.Ultra_Nerd.CodeLyokoRemake15.world.generators;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Frontier.FrontierGenSettings;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;

import javax.annotation.Nonnull;

public class FrontierGenerator extends ChunkGenerator<FrontierGenSettings> {

    public FrontierGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, FrontierGenSettings settingsIn) {
        super(worldIn, biomeProviderIn, settingsIn);

    }

    @Override
    public void generateSurface(@Nonnull WorldGenRegion p_225551_1_, @Nonnull IChunk chunk) {
        BlockState bedrock = ModBlocks.FRONTIER_BLOCK.get().getDefaultState();


        BlockPos.Mutable pos = new BlockPos.Mutable();

        int x;
        int z;

        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                chunk.setBlockState(pos.setPos(x, 40, z), bedrock, false);

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
