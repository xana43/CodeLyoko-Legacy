package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.MantaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public final class MantaRenderer extends GeoEntityRenderer<MantaEntity> {
    public MantaRenderer(final EntityRendererFactory.Context ctx, final DefaultedEntityGeoModel<MantaEntity> modelProvider) {
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
