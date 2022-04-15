package com.Ultra_Nerd.CodeLyokoLegacy.screens;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.client.renderer.PanoramaRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


public final class CustomMenuScreen extends TitleScreen {


    public static final CubeMap PANORAMA_RESOURCES = new CubeMap(new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/skies/mainmenupanorama/sector5sky.png"));
    private static final ResourceLocation customMenuTitle = CodeLyokoMain.CodeLyokoPrefix("textures/gui/title_image");
    private static final PanoramaRenderer customRenderer = new PanoramaRenderer(PANORAMA_RESOURCES);
    public CustomMenuScreen(boolean fade)
    {
        super(fade);


    }



    @Override
    public @NotNull Component getTitle() {
        return new TranslatableComponent("CodeLyoko:Legacy");
    }



    @Override
    public void render(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        customRenderer.render(0.5f,1);
        super.render(pPoseStack, pMouseX, pMouseY, Float.NaN);


    }


}
