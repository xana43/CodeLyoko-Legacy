package com.Ultra_Nerd.CodeLyokoLegacy.Entity.BlockEntityModels;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

/**
 * @author Ultra_Nerd
 * @desc <br/>
 * @since 2025-06-14
 */
public class CustomSuperComputerModel<T extends GeoAnimatable> extends GeoModel<T> {
    private final Identifier AnimationPath = CodeLyokoMain.codeLyokoPrefix("animations/block/supercomputer.animation.json");


    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return null;
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return null;
    }

    @Override
    public Identifier getAnimationResource(T animatable) {
        return AnimationPath;
    }
}
