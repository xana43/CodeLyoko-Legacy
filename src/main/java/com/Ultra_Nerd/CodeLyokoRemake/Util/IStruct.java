package com.Ultra_Nerd.CodeLyokoRemake.Util;

import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Conf;

import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraftforge.fml.common.FMLCommonHandler;

public interface IStruct {

	public static final WorldServer worldserver = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(Conf.Dim);	
	public static final PlacementSettings set = (new PlacementSettings()).setChunk(null).setIgnoreEntities(false).setIgnoreStructureBlock(false).setMirror(Mirror.NONE).setRotation(Rotation.NONE);
}
