package com.Ultra_Nerd.CodeLyokoRemake15.world.generators;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage.Sector5GenSettings;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;

import javax.annotation.Nonnull;

public class Sector5Generator extends ChunkGenerator<Sector5GenSettings> {


    public Sector5Generator(IWorld worldIn, BiomeProvider biomeProvidein, Sector5GenSettings settingsIn) {
        super(worldIn, biomeProvidein, settingsIn);
    }

    @Override
    public void generateSurface(@Nonnull WorldGenRegion p_225551_1_, IChunk chunk) {
        BlockState bedrock = ModFluids.DIGITAL_SEA_BLOCK.get().getDefaultState();
        BlockState stone = ModBlocks.SECTOR5_STEEL.get().getDefaultState();
        ChunkPos chunkpos = chunk.getPos();

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
                int realx = chunkpos.x * 16 + x;
                int realz = chunkpos.z * 16 + z;
                int height = (int) (65 * ((Math.sin(realx / 20.0f)*5) + ((Math.sin(realz / 20.0f)*5)))) ;
                for (int y = 1 ; y < height ; y++) {
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
        return world.getSeaLevel()+1;
    }


}
