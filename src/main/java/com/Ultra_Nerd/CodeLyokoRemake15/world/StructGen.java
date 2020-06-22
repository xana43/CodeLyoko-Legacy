package com.Ultra_Nerd.CodeLyokoRemake15.world;

import java.util.Random;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.IStruct;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.ref;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class StructGen extends WorldGenerator implements IStruct{

	
	public static String structname;
	public StructGen(String name)
	{
		this.structname = name;
	}

	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
	
		this.Gen(worldIn, position);
		return true;
	}
	public static void Gen(World world, BlockPos pos)
	{
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager man = worldserver.getStructureTemplateManager();
		ResourceLocation loc = new ResourceLocation(ref.MOD_ID, structname);
		Template temp  = man.get(mcServer, loc);
		
		if(temp != null)
		{
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state,3);
			temp.addBlocksToWorldChunk(world, pos, set);
		}
		
		
		
	}
}
