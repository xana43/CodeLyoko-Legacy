package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {


    //public static final DeferredRegister<RealmsServer.WorldType> MOD_DIMENSIONS = DeferredRegister.create(ForgeRegistries.WORLD_TYPES,new ResourceLocation(CodeLyokoMain.MOD_ID,"Lyoko"));
    public static final ResourceKey<DimensionType> MOD_DIMENSION_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,new ResourceLocation(CodeLyokoMain.MOD_ID,"LyokoType"));


    private static void test()
    {

    }


}
