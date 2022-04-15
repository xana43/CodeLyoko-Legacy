package com.Ultra_Nerd.CodeLyokoLegacy.Util.client.sky.carthage;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
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
public final record CustomCarthadgeSky() implements ISkyRenderHandler {


    private static final ResourceLocation texturelocation = new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/skies/sector5/sector5sky.png");


    @Override
    public void render(int ticks, float partialTicks, @NotNull PoseStack matrixStack, ClientLevel world, Minecraft mc) {

        RenderSystem.setShaderTexture(0,texturelocation);
        Tesselator tessellator = Tesselator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuilder();


        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        for (int i = 0; i < 6; ++i) {

            matrixStack.pushPose();
            if(i == 0)
            {
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(0.0F));
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
