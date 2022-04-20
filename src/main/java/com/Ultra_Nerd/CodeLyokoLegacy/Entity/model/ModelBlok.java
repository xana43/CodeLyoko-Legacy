// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoLegacy.Entity.model;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityBlok;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public final class ModelBlok extends AnimatedGeoModel<EntityBlok> {

private static final ResourceLocation BlokModelLocation = CodeLyokoMain.CodeLyokoPrefix("geo/blok.geo.json");
private static final ResourceLocation BlokTextureLocation = CodeLyokoMain.CodeLyokoPrefix("textures/entity/blok/blok.png");
    @Override
    public @NotNull ResourceLocation getModelLocation(EntityBlok object) {
        return BlokModelLocation;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(EntityBlok object) {
        return BlokTextureLocation;
    }

    @Override
    public @Nullable ResourceLocation getAnimationFileLocation(EntityBlok animatable) {
        return null;
    }
}


