package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.GuardianEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.MathGuardianModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class GuardianRenderer extends MobRenderer<GuardianEntity, MathGuardianModel> {



    public GuardianRenderer(EntityRendererProvider.Context rendManIn) {
        super(rendManIn, new MathGuardianModel(), 1f);
    }

    @Override
    protected void setupRotations(@Nonnull GuardianEntity entityLiving, @Nonnull PoseStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.setupRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull GuardianEntity entity) {
        return CodeLyokoMain.CodeLyokoPrefix("textures/entity/guardian/guardian.png");
    }

}
