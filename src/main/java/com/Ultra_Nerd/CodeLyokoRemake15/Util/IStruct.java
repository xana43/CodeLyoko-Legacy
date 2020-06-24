package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.handlers.Conf;

import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraftforge.fml.common.FMLCommonHandler;

public interface IStruct {

	public static final WorldSettings worldserver = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(Conf.Dim);	
	public static final PlacementSettings set = (new PlacementSettings()).setChunk(null).setIgnoreEntities(false).setIgnoreStructureBlock(false).setMirror(Mirror.NONE).setRotation(Rotation.NONE);
}
