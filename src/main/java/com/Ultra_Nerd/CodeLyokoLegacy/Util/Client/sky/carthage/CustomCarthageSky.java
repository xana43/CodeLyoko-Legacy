package com.Ultra_Nerd.CodeLyokoLegacy.Util.Client.sky.carthage;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public record CustomCarthageSky() implements DimensionRenderingRegistry.SkyRenderer/*implements ISkyRenderHandler*/ {


    private static final Identifier TEXTURE_LOCATION = CodeLyokoMain.codeLyokoPrefix(
            "textures/skies/sector5/sector5sky.png");
    private static Tessellator tessellator;

    @Override
    public void render(final WorldRenderContext context) {
        if(tessellator == null) {
           tessellator = Tessellator.getInstance();
        }
        RenderSystem.setShaderTexture(0, TEXTURE_LOCATION);
        RenderSystem.setShader(GameRenderer::getPositionTexColorProgram);
        final MatrixStack matrixStack = context.matrixStack();
        if(matrixStack == null)
        {
            return;
        }
        CodeLyokoMain.LOG.info("Rendering Sky");
        final Matrix4f positionMatrix = context.positionMatrix();
        matrixStack.push();
        final BufferBuilder bufferBuilder = tessellator.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        buildBuffer(bufferBuilder,positionMatrix);
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90.0F));
        buildBuffer(bufferBuilder,positionMatrix);
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0F));
        buildBuffer(bufferBuilder,positionMatrix);
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
        buildBuffer(bufferBuilder,positionMatrix);
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-90.0F));
        buildBuffer(bufferBuilder,positionMatrix);
        matrixStack.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(90.0F));
        buildBuffer(bufferBuilder,positionMatrix);
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
        buildBuffer(bufferBuilder,positionMatrix);


        bufferBuilder.end().close();

        matrixStack.pop();
    }

    private static void buildBuffer(final BufferBuilder bufferBuilder,final Matrix4f matrix4f) {
        bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).texture(0.0F, 0.0F).color(40, 40, 40, 255);
        bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).texture(0.0F, 16.0F).color(40, 40, 40, 255);
        bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).texture(16.0F, 16.0F).color(40, 40, 40, 255);
        bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).texture(16.0F, 0.0F).color(40, 40, 40, 255);
    }
}
