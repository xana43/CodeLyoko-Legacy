package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.GuardianEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelGuardian;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class GuardianRenderer extends MobRenderer<GuardianEntity, ModelGuardian> {

    protected static final ResourceLocation tex = new ResourceLocation(Base.MOD_ID, "textures/entity/guardian/guardian.png");

    public GuardianRenderer(EntityRendererManager rendManIn) {
        super(rendManIn, new ModelGuardian(), 1f);
    }

    @Override
    protected void applyRotations(@Nonnull GuardianEntity entityLiving, @Nonnull MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull GuardianEntity entity) {
        return tex;
    }

}
