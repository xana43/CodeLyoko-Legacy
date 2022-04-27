package com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.carthage;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.client.util.math.Vector3d;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;
import org.jetbrains.annotations.NotNull;
@Environment(EnvType.CLIENT)
public record CustomCarthadgeSky() implements DimensionRenderingRegistry.SkyRenderer/*implements ISkyRenderHandler*/ {



    private static final Identifier texturelocation = new Identifier(CodeLyokoMain.MOD_ID, "textures/skies/sector5/sector5sky.png");





    @Override
    public void render(final WorldRenderContext context) {
        RenderSystem.setShaderTexture(0, texturelocation);
        final Tessellator tessellator = Tessellator.getInstance();
        final BufferBuilder bufferBuilder = tessellator.getBuffer();
        final MatrixStack matrixStack = context.matrixStack();

        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        for (int i = 0; i < 6; ++i) {
            matrixStack.push();
            if(i == 0)
            {
                matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(0.0F));
            }
            if (i == 1) {
                matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(90.0F));

            }

            if (i == 2) {
                matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-90.0F));
            }

            if (i == 3) {
                matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(180.0F));
            }

            if (i == 4) {
                matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(90.0F));
            }

            if (i == 5) {
                matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(-90.0F));
            }
            final Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
            bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
            bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).texture(0.0F, 0.0F).color(40, 40, 40, 255).next();
            bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).texture(0.0F, 16.0F).color(40, 40, 40, 255).next();
            bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).texture(16.0F, 16.0F).color(40, 40, 40, 255).next();
            bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).texture(16.0F, 0.0F).color(40, 40, 40, 255).next();
            tessellator.draw();
            matrixStack.pop();


        }
    }
}
