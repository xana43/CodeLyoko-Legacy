package com.Ultra_Nerd.CodeLyokoRemake15.Util.client.sky.volcano;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Matrix4f;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.SkyRenderHandler;
@OnlyIn(Dist.CLIENT)
public class CustomVolcanoSky implements SkyRenderHandler {


    private static ResourceLocation sky1 = null;
    private static ResourceLocation sky2 = null;
    private static ResourceLocation skytop = null;
    public CustomVolcanoSky() {

        sky1 = new ResourceLocation(Base.MOD_ID,"textures/skies/volcano/sky1.png");
        sky2 = new ResourceLocation(Base.MOD_ID,"textures/skies/volcano/sky2.png");
        skytop = new ResourceLocation(Base.MOD_ID,"textures/skies/volcano/dark.png");
    }


    @Override
    public void render(int ticks, float partialTicks, MatrixStack matrixStack, ClientWorld world, Minecraft mc) {
       // mc.textureManager.bindTexture(texturelocation);
        mc.textureManager.bindTexture(skytop);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        for(int i = 0; i < 6; ++i) {
            matrixStack.push();
            if (i == 1) {
                mc.textureManager.bindTexture(sky1);
                matrixStack.rotate(Vector3f.XP.rotationDegrees(90.0F));
                matrixStack.rotate(Vector3f.YP.rotationDegrees(0));
            }

            if (i == 2) {
                mc.textureManager.bindTexture(sky2);
                matrixStack.rotate(Vector3f.XP.rotationDegrees(-90.0F));
                matrixStack.rotate(Vector3f.YP.rotationDegrees(180));
            }

            if (i == 3) {
                mc.textureManager.bindTexture(skytop);
                matrixStack.rotate(Vector3f.XP.rotationDegrees(180.0F));
            }

            if (i == 4) {
                mc.textureManager.bindTexture(sky2);
                matrixStack.rotate(Vector3f.ZP.rotationDegrees(90.0F));
                matrixStack.rotate(Vector3f.YP.rotationDegrees(-90));
            }

            if (i == 5) {
                mc.textureManager.bindTexture(sky1);
                matrixStack.rotate(Vector3f.ZP.rotationDegrees(-90.0F));
                matrixStack.rotate(Vector3f.YP.rotationDegrees(90));
            }

            Matrix4f matrix4f = matrixStack.getLast().getMatrix();
            bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            bufferBuilder.pos(matrix4f, -100.0F, -100.0F, -100.0F).tex(0.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.pos(matrix4f, -100.0F, -100.0F, 100.0F).tex(0.0F, 1.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.pos(matrix4f, 100.0F, -100.0F, 100.0F).tex(1.0F, 1.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.pos(matrix4f, 100.0F, -100.0F, -100.0F).tex(1.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            tessellator.draw();
            matrixStack.pop();
        }

    }
}
