package com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens.LapTopHeirarichy;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.FabricUtil;


public final class MainLaptopScreen extends Screen {

    private static final Identifier TEXTURE = CodeLyokoMain.CodeLyokoPrefix("textures/gui/laptopguibase_pot.png");
    private static int x/*, y*/;
    private static final int xSize = 1024, ySize = 1024;
    private ButtonWidget imageButton;

    public MainLaptopScreen() {
        super(Text.of(""));


    }
/*

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {

        if(pButton == GLFW.GLFW_MOUSE_BUTTON_RIGHT)
        {
            assert this.minecraft != null;
            ForgeHooksClient.popGuiLayer(this.minecraft);
        }


        return false;
    }

 */



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

    private void setImageButton()
    {
        imageButton =  new ButtonWidget(this.width >> 1, this.height >> 1, 30, 30// 0, 31, TEXTURE,
                /*256, 256*/,Text.of("Test"), (button) -> {});
        //imageButton.(0x1d5e18);
    }




    @Override
    public void renderBackground(@NotNull MatrixStack pPoseStack) {
       // super.renderBackground(pPoseStack);
        RenderSystem.setShaderTexture(0,TEXTURE);
        this.drawTexture(pPoseStack,x, 0, 0, 0, xSize, ySize);
    }

    @Override
    public void render(@NotNull MatrixStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);

        this.imageButton.render(pPoseStack,pMouseX,pMouseY,pPartialTick);
        drawCenteredText(pPoseStack,this.client.textRenderer,imageButton.getMessage(),imageButton.x,imageButton.y,0x1d5e18);
    }
}
