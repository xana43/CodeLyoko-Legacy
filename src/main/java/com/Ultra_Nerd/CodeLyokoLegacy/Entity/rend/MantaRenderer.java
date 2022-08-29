package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.MantaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public final class MantaRenderer extends GeoEntityRenderer<MantaEntity> {
    public MantaRenderer(final EntityRendererFactory.Context ctx, final AnimatedGeoModel<MantaEntity> modelProvider) {
        super(ctx, modelProvider);
    }

//new ModelManta(), 2f
    /*
    public MantaRenderer(EntityRendererProvider.@NotNull Context renderManagerIn, AnimatedGeoModel<MantaEntity> manta) {
        super(renderManagerIn,manta);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureResource(@Nonnull MantaEntity entity) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/manta/mantatemplate.png");
    }

     */
}
