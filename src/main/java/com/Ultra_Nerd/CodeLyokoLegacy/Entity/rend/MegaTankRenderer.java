package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;


import com.Ultra_Nerd.CodeLyokoLegacy.Entity.MegaTankEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelMegaTank;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public final class MegaTankRenderer extends GeoEntityRenderer<MegaTankEntity>/*extends GeoEntityRenderer<MegaTankEntity>*/ {
    public MegaTankRenderer(final EntityRendererFactory.Context ctx) {
        super(ctx, new ModelMegaTank());
    }/*
    public MegaTankRenderer(final EntityRendererFactory.Context ctx, final AnimatedGeoModel<MegaTankEntity> modelProvider) {
        super(ctx, modelProvider);
    }
  /*  public MegaTankRenderer(EntityRendererProvider.@NotNull Context renderManager) {
        super(renderManager, new ModelMegaTank());
    }

//new ModelMegaTank(), 2


    @Override
    protected void applyRotations(@Nonnull MegaTankEntity entityLiving, @Nonnull PoseStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }

   */


}
