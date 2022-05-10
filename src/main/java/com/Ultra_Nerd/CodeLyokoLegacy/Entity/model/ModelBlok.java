// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoLegacy.Entity.model;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityBlok;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public final class ModelBlok extends AnimatedGeoModel<EntityBlok> {




    @Override
    public Identifier getModelLocation(final EntityBlok object) {
        return CodeLyokoMain.CodeLyokoPrefix("geo/blok.geo.json");
    }

    @Override
    public Identifier getTextureLocation(final EntityBlok object) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/blok/blok.png");
    }

    @Override
    public Identifier getAnimationFileLocation(final EntityBlok animatable) {
        return null;
    }
}


