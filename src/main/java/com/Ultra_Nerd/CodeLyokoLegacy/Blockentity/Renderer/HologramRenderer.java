package com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.HologramProjectorTileEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.GeneralRendererUtils.CommonRenderRoutines;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public record HologramRenderer(
        BlockEntityRendererFactory.Context thisContext) implements BlockEntityRenderer<HologramProjectorTileEntity> {
    private static final float RADIUS = 6f;
    private static final int latitude = 200, longitude = 200;
    private static final Tessellator tessellator = Tessellator.getInstance();

    @Override
    public void render(HologramProjectorTileEntity entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
        CommonRenderRoutines.renderColoredSphere(tessellator,RADIUS,latitude,longitude,matrices);
    }
}
