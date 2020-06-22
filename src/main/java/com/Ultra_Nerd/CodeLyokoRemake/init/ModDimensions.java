package com.Ultra_Nerd.CodeLyokoRemake.init;

import com.Ultra_Nerd.CodeLyokoRemake.Util.handlers.Conf;
import com.Ultra_Nerd.CodeLyokoRemake.world.dimension.Ice;
import com.Ultra_Nerd.CodeLyokoRemake.world.dimension.Lyoko;
import com.Ultra_Nerd.CodeLyokoRemake.world.dimension.Mountain;
import com.Ultra_Nerd.CodeLyokoRemake.world.dimension.desert;
import com.Ultra_Nerd.CodeLyokoRemake.world.dimension.ocean;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

	
	public static final DimensionType LYOKO = DimensionType.register("Lyoko", "_lyoko", Conf.Dim, Lyoko.class, false);
    public static final DimensionType LYOKODESERT = DimensionType.register("Lyoko Desert Sector","_lyokodes", Conf.Dim3, desert.class, false);
    public static final DimensionType LYOKOICE = DimensionType.register("Lyoko Ice Sector", "_lyokoice", Conf.Dim2, Ice.class, false);
    public static final DimensionType LYOKOOCEAN = DimensionType.register("Digital Sea", "_lyokoocean", Conf.Dim4, ocean.class, false);
    public static final DimensionType LYOKOMOUNTAIN = DimensionType.register("Lyoko Mountain Sector", "_lyokomountaij", Conf.Dim5,Mountain.class, false);
	public static void registerDims()
	{
		DimensionManager.registerDimension(Conf.Dim, LYOKO);
        DimensionManager.registerDimension(Conf.Dim2, LYOKOICE);
        DimensionManager.registerDimension(Conf.Dim3, LYOKODESERT);
        DimensionManager.registerDimension(Conf.Dim4, LYOKOOCEAN);
        DimensionManager.registerDimension(Conf.Dim5, LYOKOMOUNTAIN);
	}
}
