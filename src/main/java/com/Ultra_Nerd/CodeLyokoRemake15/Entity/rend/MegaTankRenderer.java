package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;


import com.Ultra_Nerd.CodeLyokoRemake15.Entity.MegaTankEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelMegaTank;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nonnull;


public class MegaTankRenderer extends GeoEntityRenderer<MegaTankEntity> {
    public MegaTankRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelMegaTank());
    }

//new ModelMegaTank(), 2


    @Override
    protected void applyRotations(@Nonnull MegaTankEntity entityLiving, @Nonnull PoseStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }


}
