package com.Ultra_Nerd.CodeLyokoLegacy.screens;


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.containers.TowerInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

import java.awt.*;
import java.util.Objects;
import java.util.Random;


public final class TowerGUI extends AbstractContainerScreen<TowerInterfaceContainer> {

    private static final ResourceLocation TEXTURES = CodeLyokoMain.CodeLyokoPrefix("textures/gui/towerinterface.png");
    private EditBox text;
    private EditBox Accepted;
    private byte I = 0;
    private int acceptedColor = 0;

    private static final String correctCode = "ACCEPTED";
    public TowerGUI(@NotNull TowerInterfaceContainer towerInterfaceContainer, @NotNull Inventory playerInventory, Component tw) {
        
        super(towerInterfaceContainer,playerInventory, TextComponent.EMPTY);
        this.inventoryLabelX = - 90;
        this.inventoryLabelY = - 90;


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
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        this.text.mouseClicked(mouseX, mouseY, mouseButton);
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }



    int tick = 0;

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTicks)
    {

        this.renderBackground(poseStack);
        super.render(poseStack,mouseX, mouseY, partialTicks);
        //this.text.render(poseStack,mouseX, mouseY, partialTicks);
        EditBox.drawString(poseStack,font,new TextComponent(this.Accepted.getValue()).withStyle(ConstantUtil.GUNSHIP), this.Accepted.x,this.Accepted.y, acceptedColor);
        EditBox.drawString(poseStack,font,new TextComponent(this.text.getValue()).withStyle(ConstantUtil.GUNSHIP), this.text.x,this.text.y, Color.WHITE.getRGB());

        if((tick >> 3) % 2 == 0)
        {
            EditBox.drawString(poseStack,font,new TextComponent("|").withStyle(ConstantUtil.GUNSHIP), text.x + (this.text.getCursorPosition() * 21),this.text.y,Color.WHITE.getRGB());

 //               Objects.requireNonNull(getMinecraft().player).playSound(ModSounds.CURSORBLINK.get(), 0.1f, 1f);

        }








    }

    @Override
    public void containerTick() {

        this.text.tick();
        tick++;
        I--;
        if (I <= 0 && !this.Accepted.getValue().equals(StringUtils.EMPTY)) {
            this.Accepted.setValue(StringUtils.EMPTY);
        }
    }
    private void CheckField()
    {
        if (this.text.getValue().equalsIgnoreCase("LYOKO") || this.text.getValue().equalsIgnoreCase("CHIMERA")
                || this.text.getValue().equalsIgnoreCase("EARTH")) {
            I = 100;
            acceptedColor = 65280;
            this.Accepted.setValue(correctCode);
            this.text.setValue(StringUtils.EMPTY);
            this.text.setCursorPosition(0);
            Objects.requireNonNull(this.getMinecraft().player).playSound(ModSounds.GUISOUND.get(), 1,2f);
        } else if (this.text.getValue().equalsIgnoreCase("XANA")) {
            I = 100;
            acceptedColor = 16711680;
            this.Accepted.setValue(correctCode);
            this.text.setValue(StringUtils.EMPTY);
            this.text.setCursorPosition(0);
            Objects.requireNonNull(this.getMinecraft().player).playSound(ModSounds.GUISOUND.get(), 1,0.9f);
        }
        else
        {
            this.text.setValue(StringUtils.EMPTY);
            Objects.requireNonNull(this.getMinecraft().player).playSound(ModSounds.GUISOUND.get(), 1,0.5f);
        }
    }



    @Override
    public void init() {
        super.init();
        final int tx = this.width >> 1;
        final int ty = this.height >> 1;
        this.text = new EditBox(font, tx - 70, ty - 10, 200, 33, TextComponent.EMPTY);
        this.text.setMaxLength(8);
        this.text.setBordered(false);
        this.text.setVisible(true);
        this.text.setTextColor(16777215);
        this.text.setFocus(true);
        this.text.setEditable(true);
        this.text.setCursorPosition(0);
        this.text.setCanLoseFocus(false);
        this.text.active = true;
        this.Accepted = new EditBox(font, tx - 95, ty + 20, 200, 33, TextComponent.EMPTY);
        this.Accepted.active = false;
        this.Accepted.setEditable(false);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }


    @Override
    public boolean keyPressed(int Key, int p_keyPressed_2_, int p_keyPressed_3_) {


        if (Key == GLFW.GLFW_KEY_BACKSPACE) {
            this.text.deleteChars(1);
            Objects.requireNonNull(this.getMinecraft().player).playSound(ModSounds.GUISOUND.get(), 1,1f);
        }
        if(Key == GLFW.GLFW_KEY_ENTER)
        {
            CheckField();

        }
        this.text.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);

        //this.Accepted.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
        return super.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
    }

    @Override
    public boolean charTyped(char key, int Keynum) {
        float rand = new Random().nextFloat(1f,1.1f);


        if(Character.getType(key) == Character.UPPERCASE_LETTER)
        {
            this.text.charTyped(key, Keynum);
        }
        else
        {
            this.text.charTyped(key^=32, Keynum);
        }
        Objects.requireNonNull(this.getMinecraft().player).playSound(ModSounds.GUISOUND.get(), 1, rand);
        return super.charTyped(key^=32, Keynum);

    }







    @Override
    public void renderBg(@NotNull PoseStack p_96559_, float tick, int mouseX, int mouseY) {

        RenderSystem.setShaderTexture(0,TEXTURES);
        this.blit(p_96559_,(this.width - 200) >> 1, (this.height - 141) >> 1, 0, 0, 200, 141);
    }



}