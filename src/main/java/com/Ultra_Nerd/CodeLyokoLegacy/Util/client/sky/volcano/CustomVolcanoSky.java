package com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.volcano;


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
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;

//@OnlyIn(Dist.CLIENT)
@Environment(EnvType.CLIENT)
public record CustomVolcanoSky() implements DimensionRenderingRegistry.SkyRenderer/*implements ISkyRenderHandler*/ {


    private static final Identifier sky1 = CodeLyokoMain.CodeLyokoPrefix("textures/skies/volcano/sky1.png");
    private static final Identifier sky2 = CodeLyokoMain.CodeLyokoPrefix("textures/skies/volcano/sky2.png");


    private static final Tessellator tessellator = Tessellator.getInstance();
    private static final BufferBuilder bufferBuilder = tessellator.getBuffer();

    @Override
    public void render(final WorldRenderContext ctx) {
        // mc.textureManager.bindTexture(texturelocation);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderTexture(0, ConstantUtil.skytop);

        final MatrixStack matrixStack = ctx.matrixStack();

        for (byte i = 0; i < 6; ++i) {
            matrixStack.push();
            switch (i) {
                case 1 -> {
                    RenderSystem.setShaderTexture(0, sky1);
                    matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(90.0F));
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(0));
                }
                case 2 -> {
                    RenderSystem.setShaderTexture(0, sky2);
                    matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-90.0F));
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180));
                }
                case 3 -> {
                    RenderSystem.setShaderTexture(0, ConstantUtil.skytop);
                    matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(180.0F));


                    matrixStack.translate(0, 50, 0);
                }
                case 4 -> {
                    RenderSystem.setShaderTexture(0, sky2);
                    matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(90.0F));
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(-90));
                }
                case 5 -> {
                    RenderSystem.setShaderTexture(0, sky1);
                    matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(-90.0F));
                    matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90));
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


}