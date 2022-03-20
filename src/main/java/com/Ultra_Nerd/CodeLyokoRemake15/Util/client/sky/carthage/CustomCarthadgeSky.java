package com.Ultra_Nerd.CodeLyokoRemake15.Util.client.sky.carthage;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Matrix4f;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.SkyRenderHandler;

@OnlyIn(Dist.CLIENT)
public class CustomCarthadgeSky implements SkyRenderHandler {


    private final ResourceLocation texturelocation;

    public CustomCarthadgeSky() {

        texturelocation = new ResourceLocation(Base.MOD_ID, "textures/skies/sector5/sector5sky.png");

    }


    @Override
    public void render(int ticks, float partialTicks, MatrixStack matrixStack, ClientWorld world, Minecraft mc) {
        mc.textureManager.bindTexture(texturelocation);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        for (int i = 0; i < 6; ++i) {
            matrixStack.push();
            if (i == 1) {
                matrixStack.rotate(Vector3f.XP.rotationDegrees(90.0F));
            }

            if (i == 2) {
                matrixStack.rotate(Vector3f.XP.rotationDegrees(-90.0F));
            }

            if (i == 3) {
                matrixStack.rotate(Vector3f.XP.rotationDegrees(180.0F));
            }

            if (i == 4) {
                matrixStack.rotate(Vector3f.ZP.rotationDegrees(90.0F));
            }

            if (i == 5) {
                matrixStack.rotate(Vector3f.ZP.rotationDegrees(-90.0F));
            }

            Matrix4f matrix4f = matrixStack.getLast().getMatrix();
            bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            bufferBuilder.pos(matrix4f, -100.0F, -100.0F, -100.0F).tex(0.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.pos(matrix4f, -100.0F, -100.0F, 100.0F).tex(0.0F, 16.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.pos(matrix4f, 100.0F, -100.0F, 100.0F).tex(16.0F, 16.0F).color(40, 40, 40, 255).endVertex();
            bufferBuilder.pos(matrix4f, 100.0F, -100.0F, -100.0F).tex(16.0F, 0.0F).color(40, 40, 40, 255).endVertex();
            tessellator.draw();
            matrixStack.pop();
        }

    }
}
