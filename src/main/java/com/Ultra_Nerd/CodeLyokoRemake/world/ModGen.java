package com.Ultra_Nerd.CodeLyokoRemake.world;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModGen implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkgen, IChunkProvider chunkprov) 
	{
		if(world.provider.getDimension() == 0)
		{
			generateOverworld(rand, chunkX, chunkZ, world, chunkgen, chunkprov);
		}
		
		
	}
	
	private void generateOverworld(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkgen, IChunkProvider chunkprov)
	{
		generateOre(Modblocks.COFFINITE_ORE.getDefaultState(), world, rand, chunkX * 16, chunkZ * 16, 1,30,rand.nextInt(5) + 4, 8);
		generateOre(Modblocks.URANINITE_ORE.getDefaultState(), world, rand, chunkX * 16, chunkZ * 16, 1,40,rand.nextInt(5) + 4, 10);
		generateOre(Modblocks.SILICA_SAND.getDefaultState(), world, rand, chunkX * 16, chunkZ * 16, 63,64,rand.nextInt(8) + 8, 14);
		
	}
	
	private void generateOre(IBlockState ore, World world, Random rand, int x, int z, int minY, int maxY, int size, int chance)
	{
		int deltY = maxY - minY;
		for(int i = 0; i < chance; i++)
		{
			BlockPos pos = new BlockPos(x + rand.nextInt(16),minY + rand.nextInt(deltY), z + rand.nextInt(16));
			WorldGenMinable generator = new WorldGenMinable(ore,size);
			generator.generate(world , rand, pos);
		}
		
	}
	
	

}
