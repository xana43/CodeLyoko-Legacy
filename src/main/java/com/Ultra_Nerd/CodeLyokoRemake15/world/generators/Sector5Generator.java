package com.Ultra_Nerd.CodeLyokoRemake15.world.generators;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage.Sector5GenSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
        BlockState white = ModBlocks.TOWER_WHITE.get().getDefaultState();
        BlockState blue = ModBlocks.TOWER_BLUE.get().getDefaultState();
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
                int realX = chunkpos.x * 16 + x;
                int realZ = chunkpos.z * 16 + z;
                int height = (int) (Math.sqrt(Math.pow(128, 2) - Math.pow(realX, 2) - Math.pow(realZ, 2)));
                int innerHeight = (int) (Math.sqrt(Math.pow(126, 2) - Math.pow(realX, 2) - Math.pow(realZ, 2)));
                createSphere(chunk, stone, pos, x, z, height, innerHeight);

                int heightSpawn = (int) (Math.sqrt(Math.pow(25, 2) - Math.pow(realX, 2) - Math.pow(realZ, 2)));
                int innerHeightSpawn = (int) (Math.sqrt(Math.pow(23, 2) - Math.pow(realX, 2) - Math.pow(realZ, 2)));
                createSphere(chunk, stone, pos, x, z, heightSpawn, innerHeightSpawn);
                for (int h = 0; h < heightSpawn; h++) {
                    if ((realZ==-1 || realZ==0 || realZ==1) && realX>11) {
                        chunk.setBlockState(pos.setPos(realX, h + 128, realZ), Blocks.AIR.getDefaultState(), false);
                        //chunk.setBlockState(pos.setPos(x, 127 - h, z), Blocks.AIR.getDefaultState(), false);
                    }
                }

                double disc = Math.pow(realX, 2) + Math.pow(realZ, 2);
                if (disc <= Math.pow(23, 2)) {
                    chunk.setBlockState(pos.setPos(realX, 127, realZ), blue, false);
                }
                if ((realX >= -23 && realX <= -12) || (realX >= 12 && realX <= 23)) {
                    if (realZ == 0) {
                        chunk.setBlockState(pos.setPos(realX, 127, realZ), white, false);

                    } else if (realZ == -1) {
                        chunk.setBlockState(pos.setPos(realX, 127, realZ), white, false);

                    } else if (realZ == 1) {
                        chunk.setBlockState(pos.setPos(realX, 127, realZ), white, false);
                    }
                }

                if (disc <= Math.pow(12, 2)) {
                    chunk.setBlockState(pos.setPos(realX, 127, realZ), white, false);
                }
                if (disc <= Math.pow(10, 2)) {
                    chunk.setBlockState(pos.setPos(realX, 127, realZ), blue, false);
                }
                if (disc <= Math.pow(7, 2)) {
                    chunk.setBlockState(pos.setPos(realX, 127, realZ), white, false);
                }
                if (disc <= Math.pow(4, 2)) {
                    chunk.setBlockState(pos.setPos(realX, 127, realZ), blue, false);
                }
                if (disc <= Math.pow(1, 2)) {
                    chunk.setBlockState(pos.setPos(realX, 127, realZ), white, false);
                }
            }
        }
    }

    private void createSphere(IChunk chunk, BlockState stone, BlockPos.Mutable pos, int x, int z, int height, int innerHeight) {
        for (int h = 0; h < height; h++) {
            chunk.setBlockState(pos.setPos(x, h + 128, z), stone, false);
            chunk.setBlockState(pos.setPos(x, 127 - h, z), stone, false);
        }
        for (int y = 0; y < innerHeight; y++) {
            chunk.setBlockState(pos.setPos(x, y + 128, z), Blocks.AIR.getDefaultState(), false);
            chunk.setBlockState(pos.setPos(x, 127 - y, z), Blocks.AIR.getDefaultState(), false);
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
