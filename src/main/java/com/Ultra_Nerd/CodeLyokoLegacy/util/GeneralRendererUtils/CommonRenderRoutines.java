package com.Ultra_Nerd.CodeLyokoLegacy.util.GeneralRendererUtils;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.joml.Math;
import org.joml.Matrix4f;

import java.util.function.Supplier;

public record CommonRenderRoutines() {
    public static void renderTranslucentTexturedSphere(final Tessellator tessellator, final BufferBuilder bufferbuilder, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices, final Identifier texture,final float textureU, final float textureV, final int red, final int green, final int blue, final int alpha,final float matrixX, final float matrixY, final float matrixZ)
    {
        renderTexturedSphere(tessellator,bufferbuilder,RADIUS,latitude,longitude,matrices,texture,textureU,GameRenderer::getRenderTypeEntityAlphaProgram,textureV,red,green,blue,alpha,matrixX,matrixY,matrixZ);
    }
    public static void renderTranslucentTexturedSphere(final Tessellator tessellator, final BufferBuilder bufferbuilder, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices, final Identifier texture)
    {
        renderTexturedSphere(tessellator,bufferbuilder,RADIUS,latitude,longitude,matrices,texture,0,GameRenderer::getRenderTypeEntityAlphaProgram,0,255,255,255,255,-.5f,-.5f,-1);
    }
    public static void renderTexturedSphere(final Tessellator tessellator, final BufferBuilder bufferbuilder, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices, final Identifier texture,final float textureU, final float textureV, final int red, final int green ,final int blue ,final int alpha,final float matrixX, final float matrixY, final float matrixZ)
    {
        renderTexturedSphere(tessellator,bufferbuilder,RADIUS,latitude,longitude,matrices,texture,textureU,GameRenderer::getPositionTexColorProgram,textureV,red,green,blue,alpha,matrixX,matrixY,matrixZ);
    }
    public static void renderTexturedSphere(final Tessellator tessellator, final BufferBuilder bufferbuilder, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices, final Identifier texture)
    {
        renderTexturedSphere(tessellator,bufferbuilder,RADIUS,latitude,longitude,matrices,texture,0,GameRenderer::getPositionTexColorProgram,0,255,255,255,255,-.5f,-.5f,-1);
    }
    public static void renderTexturedSphere(final Tessellator tessellator, final BufferBuilder bufferbuilder, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices, final Identifier texture,
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
            bufferbuilder.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_TEXTURE_COLOR);
            for (int j = 0; j <= longitude; j++) {
                final double longitude0 = 2 * Math.PI * (double) (j - 1) / longitude;
                final double x = Math.cos(longitude0);
                final double y = Math.sin(longitude0);
                bufferbuilder.vertex(matrix4f, (float) (RADIUS * x * zRadius0), (float) (RADIUS * y * zRadius0),
                        (float) (RADIUS * zCoord0)).texture(textureU,textureV).color(red, green, blue, alpha).next();
                bufferbuilder.vertex(matrix4f, (float) (RADIUS * x * zRadius1), (float) (RADIUS * y * zRadius1),
                        (float) (RADIUS * zCoord1)).texture(textureU,textureV).color(red, green, blue, alpha).next();
            }

            tessellator.draw();
            matrices.pop();
        }
    }
    public static void renderColoredSphere(final Tessellator tessellator, final BufferBuilder bufferbuilder, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices)
    {
        renderColoredSphere(tessellator,bufferbuilder,RADIUS,latitude,longitude,matrices,255,255,255,255);
    }
    public static void renderColoredSphere(final Tessellator tessellator, final BufferBuilder bufferbuilder, final float RADIUS, final int latitude, final int longitude, final MatrixStack matrices,final int red, final int green,final int blue, final int alpha)
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
            bufferbuilder.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
            for (int j = 0; j <= longitude; j++) {
                final double longitude0 = 2 * Math.PI * (double) (j - 1) / longitude;
                final double x = Math.cos(longitude0);
                final double y = Math.sin(longitude0);
                bufferbuilder.vertex(matrix4f, (float) (RADIUS * x * zRadius0), (float) (RADIUS * y * zRadius0),
                        (float) (RADIUS * zCoord0)).color(red, green, blue, alpha).next();
                bufferbuilder.vertex(matrix4f, (float) (RADIUS * x * zRadius1), (float) (RADIUS * y * zRadius1),
                        (float) (RADIUS * zCoord1)).color(red, green, blue, alpha).next();
            }

            tessellator.draw();
            matrices.pop();
        }
    }
}
