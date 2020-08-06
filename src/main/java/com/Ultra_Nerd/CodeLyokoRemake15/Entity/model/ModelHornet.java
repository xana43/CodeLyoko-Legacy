package com.Ultra_Nerd.CodeLyokoRemake15.Entity.model;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.HornetEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class ModelHornet<T extends HornetEntity> extends EntityModel<T> {

    @Override
    public void setRotationAngles(@Nonnull T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(@Nonnull MatrixStack matrixStackIn, @Nonnull IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {

    }

    @Nonnull
    @Override
    public Consumer<ModelRenderer> andThen(@Nonnull Consumer<? super ModelRenderer> after) {
        return null;
    }
}
