package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import com.Ultra_Nerd.CodeLyokoRemake15.Network.Util.DataTransferInterfaceMessage;
import com.Ultra_Nerd.CodeLyokoRemake15.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.DataTransferInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensionTypes;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModDimensions;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.DimensionManager;

import java.util.Random;


public class DataTransferInterfaceUI extends ContainerScreen<DataTransferInterfaceContainer> {
    private static final ResourceLocation GUI_TEX = new ResourceLocation("cm:textures/gui/data_transfer_interface_gui_2.png");
    //
    private ImageButton buttonCarthage;
    private ImageButton buttonForest;
    private ImageButton buttonMountain;
    private ImageButton buttonIce;
    private ImageButton buttonDesert;

    private ImageButton sendButton;

    private TextFieldWidget xCoord;
    private TextFieldWidget yCoord;
    private TextFieldWidget zCoord;

    private int territory;

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
        FontRenderer gunship_font = this.getMinecraft().getFontResourceManager().getFontRenderer(new ResourceLocation("cm:gunship"));

        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        buttonCarthage.render(mouseX, mouseY, partialTicks);
        assert gunship_font != null;
        buttonCarthage.drawCenteredString(gunship_font, buttonCarthage.getMessage(), x + 46, y + 46, buttonCarthage.getFGColor());
        buttonDesert.render(mouseX, mouseY, partialTicks);
        buttonDesert.drawCenteredString(gunship_font, buttonDesert.getMessage(), x + 77, y + 46, buttonDesert.getFGColor());
        buttonIce.render(mouseX, mouseY, partialTicks);
        buttonIce.drawCenteredString(gunship_font, buttonIce.getMessage(), x + 46, y + 77, buttonIce.getFGColor());
        buttonForest.render(mouseX, mouseY, partialTicks);
        buttonForest.drawCenteredString(gunship_font, buttonForest.getMessage(), x + 15, y + 46, buttonForest.getFGColor());
        buttonMountain.render(mouseX, mouseY, partialTicks);
        buttonMountain.drawCenteredString(gunship_font, buttonMountain.getMessage(), x + 46, y + 15, buttonMountain.getFGColor());
        sendButton.render(mouseX, mouseY, partialTicks);
        sendButton.drawCenteredString(gunship_font, sendButton.getMessage(), x + 15, y + 112, sendButton.getFGColor());
        xCoord.render(mouseX, mouseY, partialTicks);
        yCoord.render(mouseX, mouseY, partialTicks);
        zCoord.render(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        this.xCoord.mouseClicked(mouseX, mouseY, mouseButton);
        this.yCoord.mouseClicked(mouseX, mouseY, mouseButton);
        this.zCoord.mouseClicked(mouseX, mouseY, mouseButton);
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void init() {
        super.init();
        this.x = (this.width - this.xSize) / 2;
        this.y = (this.height - this.ySize) / 2;
        this.setButtonCarthage();
        this.setButtonDesert();
        this.setButtonForest();
        this.setButtonIce();
        this.setButtonMountain();
        this.setSendButton();
        this.addButton(buttonDesert);
        this.addButton(buttonForest);
        this.addButton(buttonIce);
        this.addButton(buttonMountain);
        this.addButton(buttonCarthage);
        this.addButton(sendButton);
        this.setXCoord();
        this.setYCoord();
        this.setZCoord();
    }

    private void setButtonCarthage() {
        int tx = this.width / 2;
        int ty = this.height / 2;
        this.buttonCarthage = new ImageButton(x + 31, y + 31, 30, 30, 128, 0, 31, GUI_TEX,
                256, 256, (input) -> {
            territory = 0x101010; //CARTHAGE Code
        }, "C");
        buttonCarthage.setFGColor(0x1122FF);
    }

    private void setButtonForest() {
        int tx = this.width / 2;
        int ty = this.height / 2;
        this.buttonForest = new ImageButton(x, y + 31, 30, 30, 128, 0, 31, GUI_TEX,
                256, 256, (input) -> territory = 0x333333, "F");
        buttonForest.setFGColor(0x1d5e18);
    }

    private void setButtonMountain() {
        int tx = this.width / 2;
        int ty = this.height / 2;
        this.buttonMountain = new ImageButton(x + 31, y, 30, 30, 128, 0, 31, GUI_TEX,
                256, 256, (input) -> territory = 0x111111, "M");
        buttonMountain.setFGColor(0x824391);
    }

    private void setButtonIce() {
        int tx = this.width / 2;
        int ty = this.height / 2;
        this.buttonIce = new ImageButton(x + 31, y + 62, 30, 30, 128, 0, 31, GUI_TEX,
                256, 256, (input) -> territory = 0x444444, "I");
        buttonIce.setFGColor(0x37b8a2);
    }

    private void setButtonDesert() {
        int tx = this.width / 2;
        int ty = this.height / 2;
        this.buttonDesert = new ImageButton(x + 62, y + 31, 30, 30, 128, 0, 31, GUI_TEX,
                256, 256, (input) -> territory = 0x222222, "D");
        buttonDesert.setFGColor(0xcf8838);
    }

    private void setXCoord() {
        this.xCoord = new TextFieldWidget(this.getMinecraft().fontRenderer, x + 90, y + 10, 30, 30, I18n.format("gui.cm.interface_input"));
        this.xCoord.setMaxStringLength(7);
        this.xCoord.setEnableBackgroundDrawing(true);
        this.xCoord.setVisible(true);
        this.xCoord.setTextColor(16777215);
        this.xCoord.setFocused2(true);
        this.xCoord.setEnabled(true);
        this.xCoord.setCursorPositionZero();
        this.xCoord.setCanLoseFocus(true);
        this.xCoord.active = true;
        this.xCoord.canWrite();
    }

    private void setYCoord() {
        this.yCoord = new TextFieldWidget(this.getMinecraft().fontRenderer, x + 90, y + 40, 30, 30, I18n.format("gui.cm.interface_input"));
        this.yCoord.setMaxStringLength(7);
        this.yCoord.setEnableBackgroundDrawing(true);
        this.yCoord.setVisible(true);
        this.yCoord.setTextColor(16777215);
        this.yCoord.setFocused2(true);
        this.yCoord.setEnabled(true);
        this.yCoord.setCursorPositionZero();
        this.yCoord.setCanLoseFocus(true);
        this.yCoord.active = true;
        this.yCoord.canWrite();
    }

    private void setZCoord() {
        this.zCoord = new TextFieldWidget(this.getMinecraft().fontRenderer, x + 90, y + 70, 30, 30, I18n.format("gui.cm.interface_input"));
        this.zCoord.setMaxStringLength(7);
        this.zCoord.setEnableBackgroundDrawing(true);
        this.zCoord.setVisible(true);
        this.zCoord.setTextColor(16777215);
        this.zCoord.setFocused2(true);
        this.zCoord.setEnabled(true);
        this.zCoord.setCursorPositionZero();
        this.zCoord.setCanLoseFocus(true);
        this.zCoord.active = true;
        this.zCoord.canWrite();
    }

    private void setSendButton() {
        this.sendButton = new ImageButton(x + 4, y + 104, 120, 16, 0, 128, 17, GUI_TEX,
                256, 256, (input) -> {
            int xCoord = 0, yCoord = 80, zCoord = 0;
            if(this.xCoord.getText().length() > 0)
                xCoord = Integer.parseInt(this.xCoord.getText());
            if(this.yCoord.getText().length() > 0)
                yCoord = Integer.parseInt(this.yCoord.getText());
            if(this.zCoord.getText().length() > 0)
                zCoord = Integer.parseInt(this.zCoord.getText());
            PacketHandler.INSTANCE.sendToServer(new DataTransferInterfaceMessage(territory, xCoord, yCoord, zCoord));
        }, "Send !");

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(GUI_TEX);
        this.blit(x, y, 0, 0, this.xSize, this.ySize);
    }

    @Override
    public boolean keyPressed(int Key, int p_keyPressed_2_, int p_keyPressed_3_) {


        if (Key == 8) {
            this.xCoord.deleteFromCursor(1);
            this.yCoord.deleteFromCursor(1);
            this.zCoord.deleteFromCursor(1);
        }
        this.xCoord.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
        this.yCoord.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
        this.zCoord.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
        return super.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
    }

    @Override
    public boolean charTyped(char key, int Keynum) {
        float rand = 1f + new Random().nextFloat() * (4 - 1);
        this.xCoord.charTyped(Character.toUpperCase(key), Keynum);
        this.yCoord.charTyped(Character.toUpperCase(key), Keynum);
        this.zCoord.charTyped(Character.toUpperCase(key), Keynum);
        this.playerInventory.player.playSound(ModSounds.GUISOUND.get(), 1, rand);
        return super.charTyped(key, Keynum);

    }
}
