package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelHoverboard;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.HoverboardEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import javax.annotation.Nonnull;


public final class HoverboardRenderer<T extends HoverboardEntity> extends EntityRenderer<T> {


    @Override
    public Identifier getTexture(final T entity) {
        return HoverboardTex;
    }

    private final @NotNull ModelHoverboard <T> BoardModel;
    public HoverboardRenderer(EntityRendererFactory.@NotNull Context manager) {
        super(manager);
        this.BoardModel = new ModelHoverboard<>(manager.getPart(ModelHoverboard.LAYER_LOCATION));
    }
   private static final Identifier HoverboardTex = CodeLyokoMain.codeLyokoPrefix("textures/entity/hoverboard/hoverboard.png");
    @Override
    public void render(@Nonnull T entityIn, float entityYaw, float partialTicks, @Nonnull MatrixStack matrixStackIn,
            @Nonnull VertexConsumerProvider bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.translate(0, -1.5f, 0);
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(360 + entityYaw));
        this.BoardModel.setAngles(entityIn, 0, 0, 0, 0, 0);
        final VertexConsumer vertexBuilder = bufferIn.getBuffer(this.BoardModel.getLayer(this.getTexture(entityIn)));
        this.BoardModel.render(matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        matrixStackIn.pop();
    }






}
