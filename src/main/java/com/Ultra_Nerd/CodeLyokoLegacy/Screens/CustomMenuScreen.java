package com.Ultra_Nerd.CodeLyokoLegacy.Screens;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.CubeMapRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;


public final class CustomMenuScreen extends TitleScreen {

    private static float rotation = 0;
    public static final Identifier PANORAMA_RESOURCES = CodeLyokoMain.codeLyokoPrefix("textures/skies/mainmenupanorama" +
            "/sector5sky.png");
    private static final Identifier customMenuTitle = CodeLyokoMain.codeLyokoPrefix("textures/gui/title_image.png");
    private static final CubeMapRenderer customRenderer = new CubeMapRenderer(PANORAMA_RESOURCES);
    public CustomMenuScreen(boolean fade)
    {
        super(fade);


    }



    @Override
    public @NotNull Text getTitle() {
        return Text.translatable("lyoko.titlescreen.text");
    }



    @Override
    public void render(@NotNull DrawContext pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        customRenderer.draw(MinecraftClient.getInstance(),1,rotation,1);
        pPoseStack.drawTexture(customMenuTitle,width / 2 - 79,30,0,0,256,32);
        rotation+= 0.05f;
        if(rotation > 360)
        {
            rotation = 0;
        }
        super.render(pPoseStack, pMouseX, pMouseY, Float.NaN);


    }




}
