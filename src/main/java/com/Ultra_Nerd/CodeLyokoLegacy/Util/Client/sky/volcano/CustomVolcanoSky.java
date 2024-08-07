package com.Ultra_Nerd.CodeLyokoLegacy.Util.Client.sky.volcano;


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

//@OnlyIn(Dist.CLIENT)
@Environment(EnvType.CLIENT)
public record CustomVolcanoSky() implements DimensionRenderingRegistry.SkyRenderer/*implements ISkyRenderHandler*/ {


    private static final Identifier sky1 = CodeLyokoMain.codeLyokoPrefix("textures/skies/volcano/sky1.png");
    private static final Identifier sky2 = CodeLyokoMain.codeLyokoPrefix("textures/skies/volcano/sky2.png");


    private static Tessellator tessellator;
    private static BufferBuilder bufferBuilder;

    @Override
    public void render(final WorldRenderContext ctx) {
        if(tessellator == null)
        {
            tessellator = Tessellator.getInstance();
        }
        if(bufferBuilder == null)
        {
            bufferBuilder = tessellator.getBuffer();
        }
        // mc.textureManager.bindTexture(texturelocation);
        RenderSystem.setShader(GameRenderer::getPositionTexColorProgram);
        RenderSystem.setShaderTexture(0, ConstantUtil.skytop);

        final MatrixStack matrixStack = ctx.matrixStack();
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
                    RenderSystem.setShaderTexture(0, sky2);
                    matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90.0F));
                    matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                }
                case 3 -> {
                    RenderSystem.setShaderTexture(0, ConstantUtil.skytop);
                    matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180.0F));
                    matrixStack.translate(0, 50, 0);
                }
                case 4 -> {
                    RenderSystem.setShaderTexture(0, sky2);
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
        bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).texture(0, 0).color(40, 40, 40, 255).next();
        bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).texture(0, 1).color(40, 40, 40, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0F, -90.0F, 100.0F).texture(1, 1).color(40, 40, 40, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0F, -90.0F, -100.0F).texture(1, 0).color(40, 40, 40, 255).next();
        tessellator.draw();
        matrixStack.pop();

    }


}