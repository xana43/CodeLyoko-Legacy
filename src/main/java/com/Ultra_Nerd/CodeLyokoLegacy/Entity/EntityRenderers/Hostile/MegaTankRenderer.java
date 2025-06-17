package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Hostile;


import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelMegaTank;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.MegaTankEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;


public final class MegaTankRenderer<R extends EntityRenderState & GeoRenderState> extends GeoEntityRenderer<MegaTankEntity,R>/*extends GeoEntityRenderer<MegaTankEntity>*/ {
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
