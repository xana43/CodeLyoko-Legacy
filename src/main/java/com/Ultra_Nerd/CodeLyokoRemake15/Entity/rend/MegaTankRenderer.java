package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;


import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.MegaTankEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelMegaTank;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class MegaTankRenderer extends MobRenderer<MegaTankEntity, ModelMegaTank> {
    private static final ResourceLocation Tex = new ResourceLocation(Base.MOD_ID,"textures/entity/megatank/megatank.png");
    public MegaTankRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelMegaTank(), 2);
    }
    @Override
    protected void applyRotations(@Nonnull MegaTankEntity entityLiving, @Nonnull MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }
    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull MegaTankEntity entity) {
        return Tex;
    }
}
