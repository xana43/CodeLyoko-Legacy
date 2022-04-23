package com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.carthage;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.client.util.math.Vector3d;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;
import org.jetbrains.annotations.NotNull;

public record CustomCarthadgeSky() implements DimensionRenderingRegistry.SkyRenderer/*implements ISkyRenderHandler*/ {



    private static final Identifier texturelocation = new Identifier(CodeLyokoMain.MOD_ID, "textures/skies/sector5/sector5sky.png");





    @Override
    public void render(final WorldRenderContext context) {
        RenderSystem._setShaderTexture(0, texturelocation);
        final Tessellator tessellator = Tessellator.getInstance();
        final BufferBuilder bufferBuilder = tessellator.getBuffer();
        final MatrixStack matrixStack = context.matrixStack();

        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        for (int i = 0; i < 6; ++i) {
/*
            matrixStack.push();
            if(i == 0)
            {
                matrixStack.multiply(Q.rotationDegrees(0.0F));
            }
            if (i == 1) {
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));

            }

            if (i == 2) {
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
            }

            if (i == 3) {
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(180.0F));
            }

            if (i == 4) {
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
            }

            if (i == 5) {
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(-90.0F));
            }
            final Matrix4f matrix4f = matrixStack.last().pose();
            bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
            bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).uv(0.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).uv(0.0F, 16.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).uv(16.0F, 16.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).uv(16.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            tessellator.end();
            matrixStack.popPose();

 */
        }
    }
}
