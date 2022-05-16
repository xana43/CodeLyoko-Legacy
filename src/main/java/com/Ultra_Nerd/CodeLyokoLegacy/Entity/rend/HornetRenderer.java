package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HornetEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelHornet;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public final class HornetRenderer extends GeoEntityRenderer<HornetEntity> {
    public HornetRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx, new ModelHornet());
    }


//new ModelHornet(), 1f
    /*
    public HornetRenderer(EntityRendererProvider.@NotNull Context rendManIn, AnimatedGeoModel<HornetEntity> animatedGeoModel) {
        super(rendManIn, animatedGeoModel);
    }

    @Override
    protected void applyRotations(@Nonnull HornetEntity entityLiving, @Nonnull PoseStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull HornetEntity entity) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/hornet/hornetatlas.png");
    }*/

}
