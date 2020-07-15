package com.Ultra_Nerd.CodeLyokoRemake15.world.generators;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthadge.Sector5GenSettings;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;

public class Sector5Generator extends ChunkGenerator<Sector5GenSettings> {


    public Sector5Generator(IWorld worldIn, BiomeProvider biomeProvidein, Sector5GenSettings settingsIn) {
        super(worldIn, biomeProvidein, settingsIn);
    }

    @Override
    public void generateSurface(WorldGenRegion p_225551_1_, IChunk chunk) {
        BlockState bedrock = ModFluids.DIO.get().getDefaultState();
        BlockState stone = ModBlocks.SECTOR_5.get().getDefaultState();
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
                int height = (int) (Math.tan(Math.sqrt((x - realz)^2 * (z - realx)^2)) * Math.PI);
                for (int y = 1 ; y < height ; y++) {
                    chunk.setBlockState(pos.setPos(x, y, z), stone, false);
                }
            }
        }
    }




    @Override
    public void makeBase(IWorld worldIn, IChunk chunkIn) {

    }

    @Override
    public int getHeight(int x, int z, Heightmap.Type heightmapType) {
        return 0;
    }



    @Override
    public int getGroundHeight() {
        return world.getSeaLevel()+1;
    }


}
