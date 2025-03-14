package com.Ultra_Nerd.CodeLyokoLegacy.Util.GeneralRendererUtils;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.render.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import org.joml.Math;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

import java.util.function.Supplier;

public record CommonRenderRoutines() {
    public record QuadRender() {
        private static final float MINIMUM_PIXEL = 1/16f;
        public enum RenderMode{
            ALL,
            NONE,
        }

        public static void drawCalculatedSize(final Sprite fluidSprite, final int pixelsIn, final int width, final int height, final float fillPercentage, final VertexConsumer vertexConsumer, final MatrixStack matrix, final int color, final int light, final int overlay){
            drawCalculatedSize(fluidSprite,pixelsIn,width,height,fillPercentage,vertexConsumer,matrix,color,light,overlay,RenderMode.ALL);
        }

        public static void drawCalculatedSize(final Sprite fluidSprite, final int pixelsIn, final int width, final int height, final float fillPercentage, final VertexConsumer vertexConsumer, final MatrixStack matrix, final int color, final int light, final int overlay,final RenderMode mode) {
            if(mode == RenderMode.NONE)
            {
                return;
            }
            final float xStartPosition = pixelsIn * MINIMUM_PIXEL;
            final float xWidth = width * MINIMUM_PIXEL;
            final float maxY = ((fillPercentage * height) * MINIMUM_PIXEL) + MINIMUM_PIXEL;
            final float minU = fluidSprite.getFrameU(xStartPosition);
            final float maxU = fluidSprite.getFrameU(xWidth);
            final float minV = fluidSprite.getFrameV(MINIMUM_PIXEL);
            final float maxV = fluidSprite.getFrameV(maxY);
            MatrixStack.Entry entry = matrix.peek();
            drawTexturedQuad(vertexConsumer, entry, xStartPosition, xStartPosition, xWidth, maxY, xStartPosition, minU, maxU, minV, maxV, color, light, overlay);
            drawStandardFace(matrix,ConstantUtil.RotationConstants.ROT_180_Y,vertexConsumer, entry, xStartPosition, xStartPosition, xWidth, maxY, xStartPosition, minU, maxU, minV, maxV, color, light, overlay);
            drawStandardFace(matrix,ConstantUtil.RotationConstants.ROT_90_Y,vertexConsumer, entry, xStartPosition, xStartPosition, xWidth, maxY, xStartPosition, minU, maxU, minV, maxV, color, light, overlay);
            drawStandardFace(matrix,ConstantUtil.RotationConstants.ROT_270_Y,vertexConsumer, entry, xStartPosition, xStartPosition, xWidth, maxY, xStartPosition, minU, maxU, minV, maxV, color, light, overlay);
            if(maxY < 1f)
            {
                matrix.push();
                manipulateMatrix(matrix,RotationAxis.POSITIVE_X.rotationDegrees(90));
                matrix.translate(0,0,1);
                entry = matrix.peek();
                drawTexturedQuad(vertexConsumer, entry, xStartPosition, -maxY, xWidth, 1, -maxY, minU, maxU, minV, maxV, color, light, overlay);
                matrix.pop();
            }
        }
        private static void drawStandardFace(final MatrixStack matrix,final Quaternionf rot,final VertexConsumer vertexConsumer, MatrixStack.Entry entry, final float minX, final float minZ, final float maxX, final float maxY, final float maxZ, final float minU,final float maxU ,final float minV, final float maxV, final int color, final int light, final int overlay)
        {
            matrix.push();
            manipulateMatrix(matrix,rot);
            entry = matrix.peek();
            drawTexturedQuad(vertexConsumer, entry, minX, minZ, maxX, maxY, maxZ, minU, maxU, minV, maxV, color, light, overlay);
            matrix.pop();
        }
        private static void manipulateMatrix(final MatrixStack matrix, final Quaternionf rot)
        {
            matrix.translate(0.5f,0.5f,0.5f);
            matrix.multiply(rot);
            matrix.translate(-0.5f, -0.5f, -0.5f);
        }
        private static void drawTexturedQuad(final VertexConsumer vertexConsumer, final MatrixStack.Entry matrixEntry, final float minX, final float minZ, final float maxX, final float maxY, final float maxZ, final float minU, final float maxU , final float minV, final float maxV, final int color, final int light, final int overlay) {
            vertexConsumer.vertex(matrixEntry, minX, MINIMUM_PIXEL, minZ).color(color).texture(minU, minV).light(light).overlay(overlay).normal(0, 1, 0).
            vertex(matrixEntry, minX, maxY, minZ).color(color).texture(minU, maxV).light(light).overlay(overlay).normal(0, 1, 0).
            vertex(matrixEntry, maxX, maxY, maxZ).color(color).texture(maxU, maxV).light(light).overlay(overlay).normal(0, 1, 0).
            vertex(matrixEntry, maxX, MINIMUM_PIXEL, maxZ).color(color).texture(maxU, minV).light(light).overlay(overlay).normal(0, 1, 0);
        }
    }
    public static void renderTranslucentTexturedSphere(final Tessellator tessellator, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices, final Identifier texture,final float textureU, final float textureV, final int red, final int green, final int blue, final int alpha,final float matrixX, final float matrixY, final float matrixZ)
    {
        renderTexturedSphere(tessellator,RADIUS,latitude,longitude,matrices,texture,textureU,GameRenderer::getRenderTypeEntityAlphaProgram,textureV,red,green,blue,alpha,matrixX,matrixY,matrixZ);
    }
    public static void renderTranslucentTexturedSphere(final Tessellator tessellator, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices, final Identifier texture)
    {
        renderTexturedSphere(tessellator,RADIUS,latitude,longitude,matrices,texture,0,GameRenderer::getRenderTypeEntityAlphaProgram,0,255,255,255,255,-.5f,-.5f,-1);
    }
    public static void renderTexturedSphere(final Tessellator tessellator, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices, final Identifier texture,final float textureU, final float textureV, final int red, final int green ,final int blue ,final int alpha,final float matrixX, final float matrixY, final float matrixZ)
    {
        renderTexturedSphere(tessellator,RADIUS,latitude,longitude,matrices,texture,textureU,GameRenderer::getPositionTexColorProgram,textureV,red,green,blue,alpha,matrixX,matrixY,matrixZ);
    }
    public static void renderTexturedSphere(final Tessellator tessellator, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices, final Identifier texture)
    {
        renderTexturedSphere(tessellator,RADIUS,latitude,longitude,matrices,texture,0,GameRenderer::getPositionTexColorProgram,0,255,255,255,255,-.5f,-.5f,-1);
    }
    public static void renderTexturedSphere(final Tessellator tessellator, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices, final Identifier texture,
                                            final float textureU, final Supplier<ShaderProgram> shaderProgramSupplier, final float textureV, final int red, final int green, final int blue, final int alpha, final float matrixX, final float matrixY, final float matrixZ)
    {
        RenderSystem.setShaderTexture(0,texture);
        RenderSystem.setShader(shaderProgramSupplier);
        for (int i = 0; i <= latitude; i++) {
            final double latitude0 = Math.PI * (-0.5 + (double) (i - 1) / latitude);
            final double zCoord0 = Math.sin(latitude0);
            final double zRadius0 = Math.cos(latitude0);
            final double latitude1 = Math.PI * (-0.5 + (double) i / latitude);
            final double zCoord1 = Math.sin(latitude1);
            final double zRadius1 = Math.cos(latitude1);
            matrices.push();
            matrices.translate(matrixX, matrixY, matrixZ);
            final Matrix4f matrix4f = matrices.peek().getPositionMatrix();

            final BufferBuilder bufferbuilder  = tessellator.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_TEXTURE_COLOR);
            for (int j = 0; j <= longitude; j++) {
                final double longitude0 = 2 * Math.PI * (double) (j - 1) / longitude;
                final double x = Math.cos(longitude0);
                final double y = Math.sin(longitude0);
                bufferbuilder.vertex(matrix4f, (float) (RADIUS * x * zRadius0), (float) (RADIUS * y * zRadius0),
                        (float) (RADIUS * zCoord0)).texture(textureU,textureV).color(red, green, blue, alpha);
                bufferbuilder.vertex(matrix4f, (float) (RADIUS * x * zRadius1), (float) (RADIUS * y * zRadius1),
                        (float) (RADIUS * zCoord1)).texture(textureU,textureV).color(red, green, blue, alpha);
            }
            bufferbuilder.end().close();
            matrices.pop();
        }
    }
    public static void renderColoredSphere(final Tessellator tessellator, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices)
    {
        renderColoredSphere(tessellator,RADIUS,latitude,longitude,matrices,255,255,255,255);
    }
    public static void renderColoredSphere(final Tessellator tessellator, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices,final int red, final int green,final int blue, final int alpha)
    {
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
            final BufferBuilder bufferBuilder = tessellator.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
            for (int j = 0; j <= longitude; j++) {
                final double longitude0 = 2 * Math.PI * (double) (j - 1) / longitude;
                final double x = Math.cos(longitude0);
                final double y = Math.sin(longitude0);
                bufferBuilder.vertex(matrix4f, (float) (RADIUS * x * zRadius0), (float) (RADIUS * y * zRadius0),
                        (float) (RADIUS * zCoord0)).color(red, green, blue, alpha);
                bufferBuilder.vertex(matrix4f, (float) (RADIUS * x * zRadius1), (float) (RADIUS * y * zRadius1),
                        (float) (RADIUS * zCoord1)).color(red, green, blue, alpha);
            }

            bufferBuilder.end().close();
            matrices.pop();
        }
    }
}
