// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityBlok;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ModelBlok extends AnimatedGeoModel<EntityBlok> {


    @Override
    public ResourceLocation getModelLocation(EntityBlok object) {
        return null;
    }

    @Override
    public ResourceLocation getTextureLocation(EntityBlok object) {
        return new ResourceLocation(Base.MOD_ID, "textures/entity/blok/blok.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EntityBlok animatable) {
        return null;
    }
}


