// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityFan;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ModelFan extends AnimatedGeoModel<EntityFan>{




    @Override
    public ResourceLocation getModelLocation(EntityFan object) {
        return CodeLyokoMain.CodeLyokoPrefix("geo/fan.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EntityFan object) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/projectiles/fan/fan.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EntityFan animatable) {
        return new ResourceLocation(CodeLyokoMain.MOD_ID, "animations/entities/fan.json");
    }
}