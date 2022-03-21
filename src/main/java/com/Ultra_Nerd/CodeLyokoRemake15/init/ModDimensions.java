package com.Ultra_Nerd.CodeLyokoRemake15.init;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.mojang.realmsclient.dto.RealmsServer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionDefaults;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModDimensions {

    DimensionType
    public static final DeferredRegister MOD_DIMENSIONS = DeferredRegister.create(ForgeRegistries.WORLD_TYPES,new ResourceLocation(Base.MOD_ID,"Lyoko"));
    public static final ResourceKey<DimensionType> MOD_DIMENSION_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,new ResourceLocation(Base.MOD_ID,"LyokoType"));


    private static void test()
    {

    }


}
