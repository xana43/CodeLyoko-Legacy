package com.Ultra_Nerd.CodeLyokoRemake.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Conf;
import com.Ultra_Nerd.CodeLyokoRemake.init.Modblocks;
import com.Ultra_Nerd.CodeLyokoRemake.world.biome.LyokoFS;
import com.Ultra_Nerd.CodeLyokoRemake.world.biome.LyokoICE;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenTower implements IWorldGenerator 
{

	
	public static final StructGen TOWER = new StructGen("tower");
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) 
	{
		
		if(world.provider.getDimension() == 1)
		{
			
		}
		else if(world.provider.getDimension() == 0)
		{
			
		}
		else if(world.provider.getDimension() == -1)
		{
		
		}
		else if(world.provider.getDimension() == Conf.Dim)
		{
			generateStructure(TOWER, world, random, chunkX, chunkZ, 90, Modblocks.DIGITAL_BLOCK , LyokoFS.class);
		}
		else if(world.provider.getDimension() == Conf.Dim2)
		{
			generateStructure(TOWER, world, random, chunkX, chunkZ, 90, Modblocks.DIGITAL_ICE , LyokoICE.class);
		}
		
	}
	
	
	
	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + random.nextInt(15);
		int z = (chunkZ * 16) + random.nextInt(15);
		int y = calchig(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x,y,z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(random.nextInt(chance) == 0)
				{
					generator.generate(world, random, pos);
				}
			}
		}
	}
	
	private static int calchig(World world, int x, int z, Block topBlock)
	{
		int y = world.getHeight();
		boolean foundG = false;
		while(!foundG && y-- >= 0)
		{
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundG = block == topBlock;
		}
		
		return y;
		
	}
}


