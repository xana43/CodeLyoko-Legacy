package com.Ultra_Nerd.CodeLyokoRemake15.Util.client.sky.carthage;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.SkyRenderHandler;

public class CustomCarthadgeSky implements SkyRenderHandler {


    private ResourceLocation texturelocation = null;

    public CustomCarthadgeSky() {

        texturelocation = new ResourceLocation(Base.MOD_ID,"textures/skies/tower_wall.png");

    }


    @Override
    public void render(int ticks, float partialTicks, MatrixStack matrixStack, ClientWorld world, Minecraft mc) {


        mc.textureManager.bindTexture(texturelocation);
        if(mc.worldRenderer != null) {
            mc.worldRenderer.renderSky(matrixStack, partialTicks);
            mc.worldRenderer.setWorldAndLoadRenderers(world);
        }




    }
}
