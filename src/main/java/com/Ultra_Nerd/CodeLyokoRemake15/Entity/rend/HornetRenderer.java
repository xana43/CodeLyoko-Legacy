package com.Ultra_Nerd.CodeLyokoRemake15.Entity.rend;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.HornetEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.model.ModelHornet;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
@OnlyIn(Dist.CLIENT)
public class HornetRenderer extends MobRenderer<HornetEntity, ModelHornet> {

    protected static final ResourceLocation tex = new ResourceLocation(Base.MOD_ID, "textures/entity/hornet/hornetbody.png");

    public HornetRenderer(EntityRendererManager rendManIn) {
        super(rendManIn, new ModelHornet(), 1f);
    }

    @Override
    protected void applyRotations(@Nonnull HornetEntity entityLiving, @Nonnull MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull HornetEntity entity) {
        return tex;
    }

}
