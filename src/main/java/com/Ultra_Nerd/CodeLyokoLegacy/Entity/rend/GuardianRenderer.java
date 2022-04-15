package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.GuardianEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.MathGuardianModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class GuardianRenderer extends MobRenderer<GuardianEntity, MathGuardianModel> {



    public GuardianRenderer(EntityRendererProvider.@NotNull Context rendManIn) {
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
