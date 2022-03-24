package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;


import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.MegaTankEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class MegaTankRenderer extends GeoEntityRenderer<MegaTankEntity> {

//new ModelMegaTank(), 2
    public MegaTankRenderer(EntityRendererProvider.Context renderManagerIn, AnimatedGeoModel<MegaTankEntity> MegaTankModel) {
        super(renderManagerIn,MegaTankModel );
    }

    @Override
    protected void applyRotations(@Nonnull MegaTankEntity entityLiving, @Nonnull PoseStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull MegaTankEntity entity) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/megatank/megatank.png");
    }
}
