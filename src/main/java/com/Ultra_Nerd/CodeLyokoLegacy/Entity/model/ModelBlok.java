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


    @Override
    public @NotNull ResourceLocation getModelLocation(EntityBlok object) {
        return CodeLyokoMain.CodeLyokoPrefix("geo/blok.geo.json");
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(EntityBlok object) {
        return new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/entity/blok/blok.png");
    }

    @Override
    public @Nullable ResourceLocation getAnimationFileLocation(EntityBlok animatable) {
        return null;
    }
}


