package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import com.Ultra_Nerd.CodeLyokoRemake15.Network.Util.DataTransferInterfaceMessage;
import com.Ultra_Nerd.CodeLyokoRemake15.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.DataTransferInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.Random;


public final class DataTransferInterfaceUI extends AbstractContainerScreen<DataTransferInterfaceContainer> {

  private static final ResourceLocation GUI_TEX = new ResourceLocation("cm:textures/gui/data_transfer_interface_gui_2.png");

    private ImageButton buttonCarthage;
    private ImageButton buttonForest;
    private ImageButton buttonMountain;
    private ImageButton buttonIce;
    private ImageButton buttonDesert;

    private ImageButton sendButton;
    private EditBox xCoord;
    private EditBox yCoord;
    private EditBox zCoord;

    private int territory;

    int x, y;


    public DataTransferInterfaceUI(@NotNull DataTransferInterfaceContainer screenContainer, @NotNull Inventory inv, @NotNull Component titleIn) {
        super(screenContainer, inv, titleIn);

    }

    @Override
    public void render(@NotNull PoseStack stack, int mouseX, int mouseY, float partialTicks) {


        this.renderBg(stack,partialTicks,mouseX,mouseY);
        super.render(stack,mouseX, mouseY, partialTicks);
        buttonCarthage.render(stack,mouseX, mouseY, partialTicks);
        drawCenteredString(stack,font, buttonCarthage.getMessage(), x + 46, y + 46, buttonCarthage.getFGColor());
        buttonDesert.render(stack,mouseX, mouseY, partialTicks);
        drawCenteredString(stack,font, buttonDesert.getMessage(), x + 77, y + 46, buttonDesert.getFGColor());
        buttonIce.render(stack,mouseX, mouseY, partialTicks);
        drawCenteredString(stack,font, buttonIce.getMessage(), x + 46, y + 77, buttonIce.getFGColor());
        buttonForest.render(stack,mouseX, mouseY, partialTicks);
        drawCenteredString(stack,font, buttonForest.getMessage(), x + 15, y + 46, buttonForest.getFGColor());
        buttonMountain.render(stack,mouseX, mouseY, partialTicks);
        drawCenteredString(stack,font, buttonMountain.getMessage(), x + 46, y + 15, buttonMountain.getFGColor());
        sendButton.render(stack,mouseX, mouseY, partialTicks);
        drawCenteredString(stack,font, sendButton.getMessage(), x + 15, y + 112, sendButton.getFGColor());
        xCoord.render(stack,mouseX, mouseY, partialTicks);
        yCoord.render(stack,mouseX, mouseY, partialTicks);
        zCoord.render(stack,mouseX, mouseY, partialTicks);
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
        this.x = (this.width - this.getXSize()) >> 1;
        this.y = (this.height - this.getYSize()) >> 1;
        this.setButtonCarthage();
        this.setButtonDesert();
        this.setButtonForest();
        this.setButtonIce();
        this.setButtonMountain();
        this.setSendButton();
        this.addWidget(buttonDesert);
        this.addWidget(buttonForest);
        this.addWidget(buttonIce);
        this.addWidget(buttonMountain);
        this.addWidget(buttonCarthage);
        this.addWidget(sendButton);
        this.setXCoord();
        this.setYCoord();
        this.setZCoord();
    }

    private void setButtonCarthage() {
        //int tx = this.width / 2;
       // int ty = this.height / 2;
        this.buttonCarthage = new ImageButton(x + 31, y + 31, 30, 30, 128, 0, 31, GUI_TEX,
                256, 256, (input) -> {
            territory = 0x101010; //CARTHAGE Code
        }, new TextComponent("C"));
        buttonCarthage.setFGColor(0x1122FF);
    }

    private void setButtonForest() {
        //int tx = this.width / 2;
        //int ty = this.height / 2;
        this.buttonForest = new ImageButton(x, y + 31, 30, 30, 128, 0, 31, GUI_TEX,
                256, 256, (input) -> territory = 0x333333, new TextComponent("F").withStyle(ConstantUtil.GUNSHIP));
        buttonForest.setFGColor(0x1d5e18);
    }

    private void setButtonMountain() {
       // int tx = this.width / 2;
        //int ty = this.height / 2;
        this.buttonMountain = new ImageButton(x + 31, y, 30, 30, 128, 0, 31, GUI_TEX,
                256, 256, (input) -> territory = 0x111111, new TextComponent("M").withStyle(ConstantUtil.GUNSHIP));
        buttonMountain.setFGColor(0x824391);
    }

    private void setButtonIce() {
        //int tx = this.width / 2;
        //int ty = this.height / 2;
        this.buttonIce = new ImageButton(x + 31, y + 62, 30, 30, 128, 0, 31, GUI_TEX,
                256, 256, (input) -> territory = 0x444444, new TextComponent("I"));
        buttonIce.setFGColor(0x37b8a2);
    }

    private void setButtonDesert() {
        //int tx = this.width / 2;
        //int ty = this.height / 2;
        this.buttonDesert = new ImageButton(x + 62, y + 31, 30, 30, 128, 0, 31, GUI_TEX,
                256, 256, (input) -> territory = 0x222222, new TextComponent("D"));
        buttonDesert.setFGColor(0xcf8838);
    }

    private void setXCoord() {
        this.xCoord = new EditBox(this.getMinecraft().font, x + 90, y + 10, 30, 30, new TextComponent("gui.cm.interface_input"));
        this.xCoord.setMaxLength(7);
        this.xCoord.setBordered(true);
        this.xCoord.setVisible(true);
        this.xCoord.setTextColor(16777215);
        this.xCoord.setFocus(true);
        this.xCoord.setVisible(true);
        this.xCoord.setCursorPosition(0);
        this.xCoord.setCanLoseFocus(true);
        this.xCoord.active = true;
        //this.xCoord.setEditable(true);
        //this.xCoord.canConsumeInput();
    }

    private void setYCoord() {
        this.yCoord = new EditBox(this.getMinecraft().font, x + 90, y + 40, 30, 30, new TranslatableComponent("gui.cm.interface_input"));
        this.yCoord.setMaxLength(7);
        this.yCoord.setBordered(true);
        this.yCoord.setVisible(true);
        this.yCoord.setTextColor(16777215);
        this.yCoord.setFocus(true);
        this.yCoord.setCursorPosition(0);
        this.yCoord.setCanLoseFocus(true);
        this.yCoord.active = true;
        //this.yCoord.canConsumeInput();
    }

    private void setZCoord() {
        this.zCoord = new EditBox(this.getMinecraft().font, x + 90, y + 70, 30, 30, new TranslatableComponent("gui.cm.interface_input"));
        this.zCoord.setMaxLength(7);
        this.zCoord.setBordered(true);
        this.zCoord.setVisible(true);
        this.zCoord.setTextColor(16777215);
        this.zCoord.setFocus(true);
        this.zCoord.setVisible(true);
        this.zCoord.setCursorPosition(0);
        this.zCoord.setCanLoseFocus(true);
        this.zCoord.active = true;
        //this.zCoord.canWrite();
    }

    private void setSendButton() {
        this.sendButton = new ImageButton(x + 4, y + 104, 120, 16, 0, 128, 17, GUI_TEX,
                256, 256, (input) -> {
            int xCoord = 0, yCoord = 80, zCoord = 0;
            if(this.xCoord.getValue().length() > 0)
                xCoord = Integer.parseInt(this.xCoord.getValue());
            if(this.yCoord.getValue().length() > 0)
                yCoord = Integer.parseInt(this.yCoord.getValue());
            if(this.zCoord.getValue().length() > 0)
                zCoord = Integer.parseInt(this.zCoord.getValue());
            PacketHandler.INSTANCE.sendToServer(new DataTransferInterfaceMessage(territory, xCoord, yCoord, zCoord));
        }, new TextComponent("Send !").withStyle(ConstantUtil.GUNSHIP));

    }

    @Override
    protected void renderBg(@NotNull PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        assert this.minecraft != null;
        RenderSystem.setShaderTexture(0,GUI_TEX);
        this.blit(poseStack,x, y, 0, 0, this.getXSize(), this.getYSize());
    }

    @Override
    public boolean keyPressed(int Key, int p_keyPressed_2_, int p_keyPressed_3_) {


        if (Key == 8) {
            this.xCoord.deleteChars(1);
            this.yCoord.deleteChars(1);
            this.zCoord.deleteChars(1);
        }
        this.xCoord.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
        this.yCoord.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
        this.zCoord.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
        return super.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
    }

    @Override
    public boolean charTyped(char key, int Keynum) {
        float rand = 1f + new Random().nextFloat() * 3;
        this.xCoord.charTyped(Character.toUpperCase(key), Keynum);
        this.yCoord.charTyped(Character.toUpperCase(key), Keynum);
        this.zCoord.charTyped(Character.toUpperCase(key), Keynum);
        assert this.minecraft != null;
        assert this.minecraft.player != null;
        this.minecraft.player.playSound(ModSounds.GUISOUND.get(), 1, rand);
        return super.charTyped(key, Keynum);

    }


}
