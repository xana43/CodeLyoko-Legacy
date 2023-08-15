package com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens.LapTopHeirarichy;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public final class MainLaptopScreen extends Screen {

    private static final Identifier TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/gui/laptopguibase_pot.png");
    private static final int xSize = 1024, ySize = 1024;
    private int x/*, y*/;
    private ButtonWidget imageButton;

    public MainLaptopScreen() {
        super(Text.of(""));


    }



    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }


    @Override
    protected void init() {
        x = (this.width - xSize) >> 1;
        //y = (this.height - ySize) >> 1;

        setImageButton();
        this.addDrawable(imageButton);
        super.init();
    }

    private void setImageButton() {
        imageButton = ButtonWidget.builder(Text.of("test"), button -> {
        }).size(30,30).build();
        imageButton.setPosition(this.width >> 1, this.height >> 1);
    }


    @Override
    public void renderBackground(@NotNull DrawContext pPoseStack) {
        // super.renderBackground(pPoseStack);
        RenderSystem.setShaderTexture(0, TEXTURE);
        pPoseStack.drawTexture(TEXTURE,x, 0, 0, 0, xSize, ySize);
    }

    @Override
    public void render(@NotNull DrawContext pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);

        this.imageButton.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        pPoseStack.drawCenteredTextWithShadow(this.client.textRenderer, imageButton.getMessage(), imageButton.getX(),
                imageButton.getY(),
                0x1d5e18);
    }
}
