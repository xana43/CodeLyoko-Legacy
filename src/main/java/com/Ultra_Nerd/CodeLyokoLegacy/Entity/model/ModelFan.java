
package com.Ultra_Nerd.CodeLyokoLegacy.Entity.model;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityFan;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public final class ModelFan extends AnimatedGeoModel<EntityFan>{


    private static final ResourceLocation FAN_MODEL = CodeLyokoMain.CodeLyokoPrefix("geo/fan.geo.json");
    private static final ResourceLocation FAN_TEXTURE = CodeLyokoMain.CodeLyokoPrefix("textures/entity/projectiles/fan/fan.png");
    private static final ResourceLocation FAN_ANIMATION = CodeLyokoMain.CodeLyokoPrefix("animations/entities/fan.json");

    @Override
    public @NotNull ResourceLocation getModelLocation(EntityFan object) {
        return FAN_MODEL;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(EntityFan object) {
        return FAN_TEXTURE;
    }

    @Override
    public @NotNull ResourceLocation getAnimationFileLocation(EntityFan animatable) {
        return FAN_ANIMATION;
    }
}