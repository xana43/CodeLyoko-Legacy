// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoLegacy.Entity.model;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HornetEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public final class ModelHornet extends AnimatedGeoModel<HornetEntity> {
    @Override
    public Identifier getModelLocation(final HornetEntity object) {

        return CodeLyokoMain.CodeLyokoPrefix("geo/hornet.geo.json");
    }

    @Override
    public Identifier getTextureLocation(final HornetEntity object) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/hornet/hornetatlas.png");
    }

    @Override
    public Identifier getAnimationFileLocation(final HornetEntity animatable) {

        return CodeLyokoMain.CodeLyokoPrefix("animations/entities/hornet.json");
    }



    /*
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

 */
}