// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.Ultra_Nerd.CodeLyokoLegacy.Entity.model;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.KankrelatEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public final class ModelKankrelat extends DefaultedEntityGeoModel<KankrelatEntity> {
    public ModelKankrelat(final Identifier assetSubpath) {
        super(assetSubpath);
    }

    @Override
    public Identifier getModelResource(final KankrelatEntity object) {
        return null;
    }

    @Override
    public Identifier getTextureResource(final KankrelatEntity object) {
        return null;
    }

    @Override
    public Identifier getAnimationResource(final KankrelatEntity animatable) {
        return null;
    }

    /*
    @Override
    public @NotNull ResourceLocation getAnimationResource(KankrelatEntity animatable) {
        return CodeLyokoMain.CodeLyokoPrefix("animations/entity/kankrelat.json");
    }

    @Override
    public @Nullable ResourceLocation getModelResource(KankrelatEntity object) {
        return null;
    }

    @Override
    public @Nullable ResourceLocation getTextureResource(KankrelatEntity object) {
        return null;
    }

     */


}