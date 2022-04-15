// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoLegacy.Entity.model;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HornetEntity;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public final class ModelHornet<T extends HornetEntity> extends AnimatedGeoModel<HornetEntity> {




    @Override
    public @Nullable ResourceLocation getModelLocation(HornetEntity object) {
        return null;
    }

    @Override
    public @Nullable ResourceLocation getTextureLocation(HornetEntity object) {
        return null;
    }

    @Override
    public @NotNull ResourceLocation getAnimationFileLocation(HornetEntity animatable) {
        return new ResourceLocation(CodeLyokoMain.MOD_ID, "animations/entities/hornet.json");
    }
}