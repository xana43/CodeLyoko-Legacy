package com.Ultra_Nerd.CodeLyokoLegacy.Util.Client.sky.ice;


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
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
public record CustomIceSky() implements DimensionRenderingRegistry.SkyRenderer {


    private static final Identifier sky1 = CodeLyokoMain.codeLyokoPrefix("textures/skies/ice/ice_sky.png");

    private static Tessellator tessellator;
    private static BufferBuilder bufferBuilder;

    @Override
    public void render(WorldRenderContext context) {
        // mc.textureManager.bindTexture(texturelocation);

        if(tessellator == null)
        {
            tessellator = Tessellator.getInstance();
        }
        if(bufferBuilder == null)
        {
            bufferBuilder = tessellator.getBuffer();
        }
        RenderSystem.setShaderTexture(0, ConstantUtil.skytop);
        RenderSystem.setShader(GameRenderer::getPositionTexColorProgram);

        final MatrixStack matrixStack = context.matrixStack();
        if(matrixStack == null)
        {
            return;
        }
        matrixStack.push();
        for (int i = 0; i < 6; ++i) {


            switch (i) {

                case 1 -> {
                    RenderSystem.setShaderTexture(0, sky1);
                    matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
                    matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0));
                }
                case 2 -> {
                    RenderSystem.setShaderTexture(0, sky1);
                    matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90.0F));
                    matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                }
                case 3 -> {
                    RenderSystem.setShaderTexture(0, ConstantUtil.skytop);
                    matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0F));
                }
                case 4 -> {
                    RenderSystem.setShaderTexture(0, sky1);
                    matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
                    matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90));
                }
                case 5 -> {
                    RenderSystem.setShaderTexture(0, sky1);
                    matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-90.0F));
                    matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
                }
                default -> {
                }
            }
        }
        final Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).texture(0.0F, 0.0F).color(40, 40, 40, 255).next();
        bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).texture(0.0F, 0.5F).color(40, 40, 40, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).texture(16.0F, 0.5F).color(40, 40, 40, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).texture(16.0F, 0.0F).color(40, 40, 40, 255).next();
        tessellator.draw();
        matrixStack.pop();
    }


}