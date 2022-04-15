package com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;


public final class LaptopGUI extends Screen {

    private static final ResourceLocation TEXTURE = CodeLyokoMain.CodeLyokoPrefix("textures/gui/laptopguibase.png");
    private int x, y;
    private static final int xSize = 1280, ySize = 720;
    private ImageButton imageButton;

    public LaptopGUI(@NotNull TextComponent titleIn) {
        super(titleIn);


    }


    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {

        if(pButton == GLFW.GLFW_MOUSE_BUTTON_RIGHT)
        {
            assert this.minecraft != null;
            ForgeHooksClient.popGuiLayer(this.minecraft);
        }


        return false;
    }



    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }



    @Override
    protected void init() {
        x = (this.width - xSize) >> 1;
        y = (this.height - ySize) >> 1;
        imageButton =  new ImageButton(this.width >> 1, this.height >> 1, 30, 30, 128, 0, 31, TEXTURE,
                256, 256, Button::onPress, new TextComponent("Test"));
        imageButton.setFGColor(0x1d5e18);

        this.addRenderableWidget(imageButton);
        super.init();
    }




    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void renderBackground(@NotNull PoseStack pPoseStack) {
       // super.renderBackground(pPoseStack);
        RenderSystem.setShaderTexture(0,TEXTURE);
        this.blit(pPoseStack,x, y, 0, 0, xSize, ySize);
    }

    @Override
    public void render(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);

        this.imageButton.render(pPoseStack,pMouseX,pMouseY,pPartialTick);
        drawCenteredString(pPoseStack,font,imageButton.getMessage(),imageButton.x,imageButton.y,0x1d5e18);
    }
}
