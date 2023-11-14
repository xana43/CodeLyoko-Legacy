package com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityRenderers.Vehicle;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityModels.ModelOverbike;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.OverbikeEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;


public final class OverbikeRenderer<T extends OverbikeEntity> extends EntityRenderer<T> {


    @Override
    public Identifier getTexture(final T entity) {
        return OVERBIKE_TEXTURE;
    }

    private final ModelOverbike BikeModel;

    public OverbikeRenderer(EntityRendererFactory.@NotNull Context renderManager) {
        super(renderManager);
        this.shadowRadius = 1f;
        BikeModel = new ModelOverbike(renderManager.getPart(ModelOverbike.LAYER_LOCATION));

    }
    private static final Identifier OVERBIKE_TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/entity/overbike/overbiketexture.png");
    @Override
    public void render(final T entityIn, final float entityYaw, final float partialTicks, final MatrixStack matrixStackIn, final VertexConsumerProvider bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();
        matrixStackIn.scale(-.5F, -.5F, .5F);
        matrixStackIn.translate(0, -1.5f, 0);
        this.BikeModel.setAngles(entityIn, 0, 0, 0, 0, 0);
        VertexConsumer vertexBuilder = bufferIn.getBuffer(this.BikeModel.getLayer(this.getTexture(entityIn)));
        this.BikeModel.render(matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        matrixStackIn.pop();
    }







}
