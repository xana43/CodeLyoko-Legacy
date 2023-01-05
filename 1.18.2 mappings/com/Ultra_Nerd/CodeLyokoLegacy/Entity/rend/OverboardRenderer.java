package com.Ultra_Nerd.CodeLyokoLegacy.Entity.rend;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.model.ModelOverboard;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.OverboardEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;


public final class OverboardRenderer<T extends OverboardEntity> extends EntityRenderer<T>  {




    private final @NotNull EntityModel<T> OverBoardModel;




    public OverboardRenderer(EntityRendererFactory.@NotNull Context renderManager) {
        super(renderManager);
        this.shadowRadius = 1f;
        this.OverBoardModel = new ModelOverboard<>(renderManager.getPart(ModelOverboard.LAYER_LOCATION));

    }
    private static final Identifier OVERBOARD_TEX = CodeLyokoMain.CodeLyokoPrefix("textures/entity/overboard/overboarduv.png");
    @Override
    public Identifier getTexture(final T entity) {
        return OVERBOARD_TEX;
    }

    @Override
    public void render(@Nonnull T entityIn, float entityYaw, float partialTicks, @Nonnull MatrixStack matrixStackIn, @Nonnull VertexConsumerProvider bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();
        matrixStackIn.scale(-2F, -2F, 2.0F);
        matrixStackIn.translate(0, -1.5f, 0);
        matrixStackIn.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(360 + entityYaw));
        //assert MinecraftClient.getInstance().player != null;
        //this.OverBoardModel.setAngles(entityIn, 0, 0, 0, 0, 0);
        final VertexConsumer vertexBuilder = bufferIn.getBuffer(this.OverBoardModel.getLayer(this.getTexture(entityIn)));
        this.OverBoardModel.render(matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        matrixStackIn.pop();
    }






}