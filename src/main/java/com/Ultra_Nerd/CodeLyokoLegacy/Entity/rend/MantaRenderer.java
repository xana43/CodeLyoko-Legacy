package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.MantaEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nonnull;


public final class MantaRenderer extends GeoEntityRenderer<MantaEntity> {

//new ModelManta(), 2f
    public MantaRenderer(EntityRendererProvider.@NotNull Context renderManagerIn, AnimatedGeoModel<MantaEntity> manta) {
        super(renderManagerIn,manta);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull MantaEntity entity) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/manta/mantatemplate.png");
    }
}
