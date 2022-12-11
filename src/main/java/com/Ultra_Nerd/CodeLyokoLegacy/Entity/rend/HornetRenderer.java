package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HornetEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelHornet;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;


public final class HornetRenderer extends GeoEntityRenderer<HornetEntity> {
    public HornetRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx, new ModelHornet());
    }

    @Override
    public RenderLayer getRenderType(final HornetEntity animatable, final float partialTicks, final MatrixStack stack, final VertexConsumerProvider renderTypeBuffer, final VertexConsumer vertexBuilder, final int packedLightIn, final Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(
                CodeLyokoMain.codeLyokoPrefix("textures/entity/hornet/hornetatlas.png"));
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
