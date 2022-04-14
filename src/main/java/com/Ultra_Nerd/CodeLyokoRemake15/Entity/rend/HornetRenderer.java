package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.HornetEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nonnull;


public final class HornetRenderer extends GeoEntityRenderer<HornetEntity> {


//new ModelHornet(), 1f
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
    }

}
