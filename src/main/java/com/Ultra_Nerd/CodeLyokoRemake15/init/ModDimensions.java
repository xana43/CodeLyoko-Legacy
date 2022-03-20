package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {

    public static final ResourceKey<Level> MOD_DIMENSIONS = ResourceKey.create(Registry.DIMENSION_REGISTRY,new ResourceLocation(Base.MOD_ID,"Lyoko"));
    public static final ResourceKey<DimensionType> MOD_DIMENSION_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,new ResourceLocation(Base.MOD_ID,"LyokoType"));



}
