package com.Ultra_Nerd.CodeLyokoLegacy.screens;


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TowerInterfaceScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.PressableTextWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

public final class TowerGUI extends HandledScreen<TowerInterfaceScreenHandler> {
    public TowerGUI(final TowerInterfaceScreenHandler handler, final PlayerInventory inventory, final Text title) {
        super(handler, inventory, title);
        this.playerInventoryTitleX = 900;


    }


    private static final Identifier TEXTURES = CodeLyokoMain.CodeLyokoPrefix("textures/gui/towerinterface.png");
    private TextFieldWidget text;
    private TextFieldWidget Accepted;
    private byte I;
    private int acceptedColor;


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
    public void render(@NotNull MatrixStack poseStack, int mouseX, int mouseY, float partialTicks) {

        this.renderBackground(poseStack);

        super.render(poseStack, mouseX, mouseY, partialTicks);
        //this.text.render(poseStack,mouseX, mouseY, partialTicks);
        final var AcceptedText = Text.of(this.Accepted.getText()).getWithStyle(ConstantUtil.Styles.GUNSHIP.getThisStyle());
        final var CodeEnterTest = Text.of(this.text.getText()).getWithStyle(ConstantUtil.Styles.GUNSHIP.getThisStyle());
        if (AcceptedText.size() >= 1) {
            PressableTextWidget.drawTextWithShadow(poseStack, this.textRenderer, AcceptedText.get(0), this.Accepted.x, this.Accepted.y, acceptedColor);
        }
        if (CodeEnterTest.size() >= 1) {
            PressableTextWidget.drawTextWithShadow(poseStack, this.textRenderer, CodeEnterTest.get(0), this.text.x, this.text.y, Color.WHITE.getRGB());
        }
        if ((tick >> 2) % 5 == 0) {
            PressableTextWidget.drawTextWithShadow(poseStack, this.textRenderer, Text.of("|").getWithStyle(ConstantUtil.Styles.GUNSHIP.getThisStyle()).get(0), text.x + (this.text.getCursor() * 21), this.text.y, Color.WHITE.getRGB());

            Objects.requireNonNull(client.player).playSound(ModSounds.CURSORBLINK, 0.1f, 1f);

        }


    }

    @Override
    protected void handledScreenTick() {
        this.text.tick();
        tick++;
        I--;
        if (I <= 0 && this.Accepted.getText().length() != 0) {
            this.Accepted.setText(StringUtils.EMPTY);
        }
    }


    private void CheckField() {
        final String correctCode = "ACCEPTED";

        if (this.text.getText().equalsIgnoreCase("LYOKO") || this.text.getText().equalsIgnoreCase("CHIMERA")
                || this.text.getText().equalsIgnoreCase("EARTH")) {
            I = 100;
            acceptedColor = 65280;
            this.Accepted.setText(correctCode);
            this.text.setText(StringUtils.EMPTY);
            this.text.setCursor(0);
            Objects.requireNonNull(this.client.player).playSound(ModSounds.GUISOUND, 1, 2f);
        } else if (this.text.getText().equalsIgnoreCase("XANA")) {
            I = 100;
            acceptedColor = 16711680;
            this.Accepted.setText(correctCode);
            this.text.setText(StringUtils.EMPTY);
            this.text.setCursor(0);
            Objects.requireNonNull(this.client.player).playSound(ModSounds.GUISOUND, 1, 0.9f);
        } else {
            this.text.setText(StringUtils.EMPTY);
            Objects.requireNonNull(this.client.player).playSound(ModSounds.GUISOUND, 1, 0.5f);
        }
    }


    @Override
    public void init() {
        super.init();
        final int tx = this.width >> 1;
        final int ty = this.height >> 1;
        this.text = new TextFieldWidget(this.textRenderer, tx - 70, ty - 10, 200, 33, Text.empty());
        this.text.setMaxLength(8);
        this.text.setDrawsBackground(false);
        this.text.setVisible(true);
        this.text.setEditableColor(16777215);
        this.text.setTextFieldFocused(true);
        this.text.setEditable(true);
        this.text.setCursor(0);
        this.text.setFocusUnlocked(false);
        this.text.active = true;
        this.Accepted = new TextFieldWidget(this.textRenderer, tx - 95, ty + 20, 200, 33, Text.empty());
        this.Accepted.active = false;
        this.Accepted.setEditable(false);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }


    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }


    @Override
    public boolean keyPressed(int Key, int p_keyPressed_2_, int p_keyPressed_3_) {

        switch (Key) {
            case GLFW.GLFW_KEY_BACKSPACE -> this.text.eraseCharacters(1);
            case GLFW.GLFW_KEY_ENTER -> CheckField();
        }

        this.text.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);

        //this.Accepted.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
        return super.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
    }

    @Override
    public boolean charTyped(char key, final int Keynum) {


        if (Character.getType(key) == Character.UPPERCASE_LETTER) {
            this.text.charTyped(key, Keynum);
        } else {
            this.text.charTyped(key ^= 32, Keynum);
        }
        Objects.requireNonNull(this.client.player).playSound(ModSounds.GUISOUND, 1, new Random().nextFloat(1f, 1.1f));
        return super.charTyped(key ^= 32, Keynum);

    }


    @Override
    protected void drawBackground(final MatrixStack matrices, final float delta, final int mouseX, final int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURES);
        this.drawTexture(matrices, (this.width - 200) >> 1, (this.height - 141) >> 1, 0, 0, 200, 141);
    }


}