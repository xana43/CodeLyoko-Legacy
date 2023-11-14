package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelHornet;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.HornetEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


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
    public ResourceLocation getTextureResource(@Nonnull HornetEntity entity) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/hornet/hornetatlas.png");
    }*/

}
