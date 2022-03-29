package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.client.renderer.PanoramaRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class CustomMenuScreen extends TitleScreen {


    public static final CubeMap PANORAMA_RESOURCES = new CubeMap(new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/skies/mainmenupanorama/sector5sky.png"));
    private static final ResourceLocation customMenuTitle = CodeLyokoMain.CodeLyokoPrefix("textures/gui/title_image");
    private static final PanoramaRenderer customRenderer = new PanoramaRenderer(PANORAMA_RESOURCES);
    public CustomMenuScreen(boolean fade)
    {
        super(fade);

    }

    @Override
    public Component getTitle() {
        return new TranslatableComponent("CodeLyoko:Legacy");
    }

    @Override
    public Minecraft getMinecraft() {
        return super.getMinecraft();
    }

    @Override
    public void renderComponentTooltip(PoseStack pPoseStack, List<Component> pTooltips, int pMouseX, int pMouseY) {
        super.renderComponentTooltip(pPoseStack, pTooltips, pMouseX, pMouseY);
    }

    @Override
    public void renderBackground(PoseStack pPoseStack, int pVOffset) {
        super.renderBackground(pPoseStack, pVOffset);

    }



    @Override
    public void render(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);



    }


}
