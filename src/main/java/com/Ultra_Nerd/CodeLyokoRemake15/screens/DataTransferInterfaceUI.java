package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import com.Ultra_Nerd.CodeLyokoRemake15.containers.DataTransferInterfaceContainer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;


public class DataTransferInterfaceUI extends ContainerScreen<DataTransferInterfaceContainer> {
    private static final ResourceLocation GUI_TEX = new ResourceLocation("cm:textures/gui/data_transfer_interface_gui.png");

    private Button buttonCarthage;

    int x, y;


    public DataTransferInterfaceUI(DataTransferInterfaceContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 128;
        this.ySize = 128;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.buttonCarthage.render(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void init() {
        super.init();
        this.x = (this.width - this.xSize) / 2;
        this.y = (this.height - this.ySize) / 2;
        this.setButtonCarthage();
        this.addButton(buttonCarthage);
    }

    private void setButtonCarthage() {
        int tx = this.width / 2;
        int ty = this.height / 2;
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(GUI_TEX);
        FontRenderer gunship_font = this.getMinecraft().getFontResourceManager().getFontRenderer(new ResourceLocation("cm:gunship"));
        this.buttonCarthage = new Button(tx,ty,41,41, "Carthage", (input) -> {});
        this.buttonCarthage.blit(x,y,128,0,41,41);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(GUI_TEX);
        this.blit(x, y, 0, 0, this.xSize, this.ySize);
    }
}
