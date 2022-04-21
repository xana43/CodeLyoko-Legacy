// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoLegacy.Entity.model;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.MegaTankEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;


public final class ModelMegaTank extends AnimatedGeoModel<MegaTankEntity> {
    @Override
    public Identifier getModelLocation(final MegaTankEntity object) {
        return null;
    }

    @Override
    public Identifier getTextureLocation(final MegaTankEntity object) {
        return null;
    }

    @Override
    public Identifier getAnimationFileLocation(final MegaTankEntity animatable) {
        return null;
    }

/*
    @Override
    public @NotNull ResourceLocation getModelLocation(MegaTankEntity object) {
        return CodeLyokoMain.CodeLyokoPrefix("geo/megatank.geo.json");
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(MegaTankEntity object) {
        return new ResourceLocation(CodeLyokoMain.MOD_ID,"textures/entity/megatank/megatank.png");
    }

    @Override
    public @NotNull ResourceLocation getAnimationFileLocation(MegaTankEntity animatable) {
        return new ResourceLocation(CodeLyokoMain.MOD_ID,"animations/entities/megatank.json");
    }

 */
}