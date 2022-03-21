// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.MegaTankEntity;

import net.minecraft.resources.ResourceLocation;

import software.bernie.geckolib3.model.AnimatedGeoModel;


public class ModelMegaTank extends AnimatedGeoModel<MegaTankEntity> {


    @Override
    public ResourceLocation getModelLocation(MegaTankEntity object) {
        return null;
    }

    @Override
    public ResourceLocation getTextureLocation(MegaTankEntity object) {
        return new ResourceLocation(Base.MOD_ID,"textures/entity/megatank/megatank.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MegaTankEntity animatable) {
        return new ResourceLocation(Base.MOD_ID,"animations/entities/megatank.json");
    }
}