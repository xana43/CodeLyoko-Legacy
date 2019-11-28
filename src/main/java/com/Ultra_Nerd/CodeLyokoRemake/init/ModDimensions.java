package com.Ultra_Nerd.CodeLyokoRemake.init;

import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;
import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Conf;
import com.Ultra_Nerd.CodeLyokoRemake.world.dimension.Lyoko;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

	
	public static final DimensionType LYOKO = DimensionType.register("Lyoko", "_lyoko", Conf.Dim, Lyoko.class, false);
	public static void registerDims()
	{
		DimensionManager.registerDimension(Conf.Dim, LYOKO);
		
	}
}
