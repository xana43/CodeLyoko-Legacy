package com.Ultra_Nerd.CodeLyokoRemake15.Util.client.sky.ice;


import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public final record CustomIceSky() implements ISkyRenderHandler {


    private static final ResourceLocation sky1 = new ResourceLocation(CodeLyokoMain.MOD_ID,"textures/skies/ice/ice_sky.png");
    private static final ResourceLocation skytop = new ResourceLocation(CodeLyokoMain.MOD_ID,"textures/skies/volcano/dark.png");



    @Override
    public void render(int ticks, float partialTicks, @NotNull PoseStack matrixStack, ClientLevel world, Minecraft mc) {
        // mc.textureManager.bindTexture(texturelocation);

        RenderSystem.setShaderTexture(0,skytop);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        final Tesselator tessellator = Tesselator.getInstance();
        final BufferBuilder bufferBuilder = tessellator.getBuilder();
        for(int i = 0; i < 6; ++i) {
            matrixStack.pushPose();
            if (i == 1) {
                RenderSystem.setShaderTexture(0,sky1);
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                matrixStack.mulPose(Vector3f.YP.rotationDegrees(0));
            }

            if (i == 2) {
                RenderSystem.setShaderTexture(0,sky1);
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
                matrixStack.mulPose(Vector3f.YP.rotationDegrees(180));

            }

            if (i == 3) {
                RenderSystem.setShaderTexture(0,skytop);
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(180.0F));
            }

            if (i == 4) {
                RenderSystem.setShaderTexture(0,sky1);
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
                matrixStack.mulPose(Vector3f.YP.rotationDegrees(-90));
            }

            if (i == 5) {
                RenderSystem.setShaderTexture(0,sky1);
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(-90.0F));
                matrixStack.mulPose(Vector3f.YP.rotationDegrees(90));
            }

            final Matrix4f matrix4f = matrixStack.last().pose();
            bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
            bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).uv(0.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).uv(0.0F, 0.5F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).uv(16.0F, 0.5F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).uv(16.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            tessellator.end();
            matrixStack.popPose();
        }

    }
}