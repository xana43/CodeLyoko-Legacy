package com.Ultra_Nerd.CodeLyokoRemake15.screens;


import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ComputerControlPanelContainer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nullable;

public class ComputerControlPanelUI extends ContainerScreen<ComputerControlPanelContainer> {

    private static final ResourceLocation TEXTURES = new ResourceLocation(Base.MOD_ID,"textures/gui/computercontrolpanelui.png");
    private static final ResourceLocation BUTTONTEXTURES = new ResourceLocation(Base.MOD_ID,"textures/gui/buttonatlas.png");
    private TextFieldWidget text;
    private Widget button;




    int x, y;


    public ComputerControlPanelUI(ComputerControlPanelContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 190;
        this.ySize = 143;


    }

    @Override
    public boolean isMouseOver(double p_isMouseOver_1_, double p_isMouseOver_3_) {
        return false;
    }

    @Override
    public boolean changeFocus(boolean p_changeFocus_1_) {
        return false;
    }


    @Override
    public void setFocused(@Nullable IGuiEventListener p_setFocused_1_) {
        super.setFocused(p_setFocused_1_);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        this.renderBackground();
        super.render(p_render_1_, p_render_2_, p_render_3_);
        this.text.render(p_render_1_, p_render_2_, p_render_3_);
        this.button.renderButton(p_render_1_,p_render_2_,p_render_3_);
    }






    @Override
    public void init() {
        super.init();
        x = (this.width - this.xSize) / 2;
        y = (this.height - this.ySize) / 2;
        this.setTextField();
        this.setButtons();

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }



    protected void setButtons()
    {


        this.button = new Widget(x,y,this.width/3,this.height/6,"activate") {
            @Override
            protected int getYImage(boolean p_getYImage_1_) {
                return super.getYImage(p_getYImage_1_);

            }
            @Override
            public void renderButton(int p_renderButton_1_, int p_renderButton_2_, float p_renderButton_3_) {
                //super.renderButton(p_renderButton_1_, p_renderButton_2_, p_renderButton_3_);
                int i = getYImage(isHovered());
                assert minecraft != null;
                minecraft.textureManager.bindTexture(TEXTURES);
                FontRenderer gunship_font = minecraft.getFontResourceManager().getFontRenderer(new ResourceLocation(Base.MOD_ID + ":gunship"));
                assert gunship_font != null;
                int j = getFGColor();
                drawCenteredString(gunship_font, getMessage(), x + width / 2, y + (height - 8) / 2, j | MathHelper.ceil(alpha * 255.0F) << 24);
                blit(x, y, 0, 37 + i * 2, 103, 37);
                blit(x, 38, 0, 46 + i * 20, width / 2, height);

            }

        };
        this.button.active = true;
        this.addButton(this.button);
        this.button.visible = true;


    }



    protected void setTextField() {
        int tx = this.width / 2;
        int ty = this.height / 2;
        FontRenderer gunship_font = this.getMinecraft().getFontResourceManager().getFontRenderer(new ResourceLocation(Base.MOD_ID + ":gunship"));
        assert gunship_font != null;
        this.text = new TextFieldWidget(gunship_font, x, ty + 40, this.width, 23, I18n.format("gui.cm.computer_input_main"));
        this.text.setEnableBackgroundDrawing(false);
        this.text.setVisible(true);
        this.text.setTextColor(16777215);
        this.text.setText("in-active");






    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.minecraft.getTextureManager().bindTexture(TEXTURES);

        this.blit(x, y, 0, 0, this.xSize, this.ySize);
    }


}