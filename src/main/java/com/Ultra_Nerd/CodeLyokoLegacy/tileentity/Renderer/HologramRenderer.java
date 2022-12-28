package com.Ultra_Nerd.CodeLyokoLegacy.tileentity.Renderer;

import com.Ultra_Nerd.CodeLyokoLegacy.tileentity.HologramProjectorTileEntity;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Math;
import org.joml.Matrix4f;

public record HologramRenderer(
        BlockEntityRendererFactory.Context thisContext) implements BlockEntityRenderer<HologramProjectorTileEntity> {
    private static final float RADIUS = 6f;
    private static final int latitude = 200, longitude = 200;
    private static final Tessellator tessellator = Tessellator.getInstance();
    private static final BufferBuilder bufferbuilder = tessellator.getBuffer();

    @Override
    public void render(final HologramProjectorTileEntity entity, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumers, final int light, final int overlay) {

        RenderSystem.setShader(GameRenderer::getPositionColorProgram);
        for (int i = 0; i <= latitude; i++) {
            final double latitude0 = Math.PI * (-0.5 + (double) (i - 1) / latitude);
            final double zCoord0 = Math.sin(latitude0);
            final double zRadius0 = Math.cos(latitude0);

            final double latitude1 = Math.PI * (-0.5 + (double) i / latitude);
            final double zCoord1 = Math.sin(latitude1);
            final double zRadius1 = Math.cos(latitude1);
            matrices.push();
            matrices.translate(0.5f, 0.5f, 1);
            final Matrix4f matrix4f = matrices.peek().getPositionMatrix();
            bufferbuilder.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
            for (int j = 0; j <= longitude; j++) {
                final double longitude0 = 2 * Math.PI * (double) (j - 1) / longitude;
                final double x = Math.cos(longitude0);
                final double y = Math.sin(longitude0);
                bufferbuilder.vertex(matrix4f, (float) (RADIUS * x * zRadius0), (float) (RADIUS * y * zRadius0),
                        (float) (RADIUS * zCoord0)).color(0, 0, 128, 32).next();
                bufferbuilder.vertex(matrix4f, (float) (RADIUS * x * zRadius1), (float) (RADIUS * y * zRadius1),
                        (float) (RADIUS * zCoord1)).color(0, 0, 128, 32).next();
            }

            tessellator.draw();
            matrices.pop();
        }


    }
}
