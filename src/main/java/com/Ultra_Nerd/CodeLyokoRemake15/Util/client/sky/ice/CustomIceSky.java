package com.Ultra_Nerd.CodeLyokoRemake15.Util.client.sky.ice;


import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;

@OnlyIn(Dist.CLIENT)
public class CustomIceSky implements ISkyRenderHandler {


    private static ResourceLocation sky1 = null;
    private static ResourceLocation skytop = null;
    public CustomIceSky() {

        sky1 = new ResourceLocation(CodeLyokoMain.MOD_ID,"textures/skies/ice/ice_sky.png");
        skytop = new ResourceLocation(CodeLyokoMain.MOD_ID,"textures/skies/volcano/dark.png");
    }


    @Override
    public void render(int ticks, float partialTicks, PoseStack matrixStack, ClientLevel world, Minecraft mc) {
        // mc.textureManager.bindTexture(texturelocation);
        mc.textureManager.bindForSetup(skytop);
        Tesselator tessellator = Tesselator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuilder();
        for(int i = 0; i < 6; ++i) {
            matrixStack.pushPose();
            if (i == 1) {
                mc.textureManager.bindForSetup(sky1);
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                matrixStack.mulPose(Vector3f.YP.rotationDegrees(0));
            }

            if (i == 2) {
                mc.textureManager.bindForSetup(sky1);
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
                matrixStack.mulPose(Vector3f.YP.rotationDegrees(180));
            }

            if (i == 3) {
                mc.textureManager.bindForSetup(skytop);
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(180.0F));
            }

            if (i == 4) {
                mc.textureManager.bindForSetup(sky1);
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
                matrixStack.mulPose(Vector3f.YP.rotationDegrees(-90));
            }

            if (i == 5) {
                mc.textureManager.bindForSetup(sky1);
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(-90.0F));
                matrixStack.mulPose(Vector3f.YP.rotationDegrees(90));
            }

            Matrix4f matrix4f = matrixStack.last().pose();
            bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
            bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, -100.0F).uv(0.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.vertex(matrix4f, -100.0F, -100.0F, 100.0F).uv(0.0F, 16.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, 100.0F).uv(16.0F, 16.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.vertex(matrix4f, 100.0F, -100.0F, -100.0F).uv(16.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            tessellator.end();
            matrixStack.popPose();
        }

    }
}