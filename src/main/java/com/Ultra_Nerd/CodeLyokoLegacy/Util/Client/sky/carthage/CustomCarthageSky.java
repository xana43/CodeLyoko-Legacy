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


    private static final Identifier TEXTURE_LOCATION = new Identifier(CodeLyokoMain.MOD_ID,
            "textures/skies/sector5/sector5sky.png");
    private static Tessellator tessellator;
    private static BufferBuilder bufferBuilder;

    @Override
    public void render(final WorldRenderContext context) {
        if(tessellator == null)
        {
            tessellator = Tessellator.getInstance();
        }
        if(bufferBuilder == null)
        {
            bufferBuilder = tessellator.getBuffer();
        }
        RenderSystem.setShaderTexture(0, TEXTURE_LOCATION);
        RenderSystem.setShader(GameRenderer::getPositionTexColorProgram);
        final MatrixStack matrixStack = context.matrixStack();
        if(matrixStack == null)
        {
            return;
        }
        CodeLyokoMain.LOG.info("Rendering Sky");
        matrixStack.push();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        buildBuffer(context.positionMatrix());
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90.0F));
        buildBuffer(context.positionMatrix());
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0F));
        buildBuffer(context.positionMatrix());
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
        buildBuffer(context.positionMatrix());
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-90.0F));
        buildBuffer(context.positionMatrix());
        matrixStack.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(90.0F));
        buildBuffer(context.positionMatrix());
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
        buildBuffer(context.positionMatrix());


        tessellator.draw();

        matrixStack.pop();
    }

    private static void buildBuffer(Matrix4f matrix4f) {
        bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).texture(0.0F, 0.0F).color(40, 40, 40, 255).next();
        bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).texture(0.0F, 16.0F).color(40, 40, 40, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).texture(16.0F, 16.0F).color(40, 40, 40, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).texture(16.0F, 0.0F).color(40, 40, 40, 255).next();
    }
}
