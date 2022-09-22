package com.Ultra_Nerd.CodeLyokoLegacy.util.client.sky.ice;


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;

@Environment(EnvType.CLIENT)
public record CustomIceSky() implements DimensionRenderingRegistry.SkyRenderer {


    private static final Identifier sky1 = CodeLyokoMain.CodeLyokoPrefix("textures/skies/ice/ice_sky.png");

    private static final Tessellator tessellator = Tessellator.getInstance();
    private static final BufferBuilder bufferBuilder = tessellator.getBuffer();

    @Override
    public void render(WorldRenderContext context) {
        // mc.textureManager.bindTexture(texturelocation);


        RenderSystem.setShaderTexture(0, ConstantUtil.skytop);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);

        final MatrixStack matrixStack = context.matrixStack();

        for (int i = 0; i < 6; ++i) {
            matrixStack.push();
            final Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
            switch (i) {

                case 1 -> {
                    RenderSystem.setShaderTexture(0, sky1);
                    matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(90.0F));
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(0));
                }
                case 2 -> {
                    RenderSystem.setShaderTexture(0, sky1);
                    matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-90.0F));
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180));
                }
                case 3 -> {
                    RenderSystem.setShaderTexture(0, ConstantUtil.skytop);
                    matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(180.0F));
                }
                case 4 -> {
                    RenderSystem.setShaderTexture(0, sky1);
                    matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(90.0F));
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(-90));
                }
                case 5 -> {
                    RenderSystem.setShaderTexture(0, sky1);
                    matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(-90.0F));
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90));
                }
            }


            bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
            bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).texture(0.0F, 0.0F).color(40, 40, 40, 255).next();
            bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).texture(0.0F, 0.5F).color(40, 40, 40, 255).next();
            bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).texture(16.0F, 0.5F).color(40, 40, 40, 255).next();
            bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).texture(16.0F, 0.0F).color(40, 40, 40, 255).next();
            tessellator.draw();
            matrixStack.pop();
        }

    }


}