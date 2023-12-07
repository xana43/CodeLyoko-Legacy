package com.Ultra_Nerd.CodeLyokoLegacy.Screens;


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.TowerInterfaceScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.ConstantUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

import java.awt.*;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;

@Environment(EnvType.CLIENT)
public final class TowerGUI extends HandledScreen<TowerInterfaceScreenHandler> {
    private static final Identifier TEXTURES = CodeLyokoMain.codeLyokoPrefix("textures/gui/towerinterface.png");
    private static final SecureRandom completeRandom = new SecureRandom();
    int tick = 0;
    private TextFieldWidget Accepted;
    private byte I;
    private int acceptedColor;
    private TextFieldWidget text;

    public TowerGUI(final TowerInterfaceScreenHandler handler, final PlayerInventory inventory, final Text title) {
        super(handler, inventory, title);
        this.playerInventoryTitleX = 900;


    }

    private static boolean checkLanguage(final TextFieldWidget textWidget, final MinecraftClient client,final boolean isXana)
    {
        if(!isXana) {
            switch (client.getLanguageManager().getLanguage()) {
                case "en_us" -> {
                    return textWidget.getText().equalsIgnoreCase("LYOKO") || textWidget.getText().equalsIgnoreCase("CHIMERA")
                            || textWidget.getText().equalsIgnoreCase("EARTH");
                }
                case "fr_fr" -> {
                    return textWidget.getText().equalsIgnoreCase("LYOKO") || textWidget.getText().equalsIgnoreCase("TERRE") ||
                            textWidget.getText().equalsIgnoreCase("MONDE") || textWidget.getText().equalsIgnoreCase("LA TERRE") ||
                            textWidget.getText().equalsIgnoreCase("LE MONDE") || textWidget.getText().equalsIgnoreCase("CHIMÈRE") ||
                            textWidget.getText().equalsIgnoreCase("LA CHIMÈRE");
                }
                default -> {
                    return false;
                }
            }
        }
        else {
            return textWidget.getText().equalsIgnoreCase("XANA");
        }
    }

    @Override
    public void close() {

            super.close();

    }

    @Override
    public boolean isMouseOver(double p_isMouseOver_1_, double p_isMouseOver_3_) {
        return false;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        this.text.mouseClicked(mouseX, mouseY, mouseButton);
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void render(@NotNull DrawContext poseStack, int mouseX, int mouseY, float partialTicks) {

        this.renderBackground(poseStack,mouseX,mouseY,partialTicks);

        super.render(poseStack, mouseX, mouseY, partialTicks);
        //this.text.render(poseStack,mouseX, mouseY, partialTicks);
        final var AcceptedText = Text.of(this.Accepted.getText())
                .getWithStyle(ConstantUtil.Styles.GUNSHIP.getThisStyle());
        final var CodeEnterTest = Text.of(this.text.getText()).getWithStyle(ConstantUtil.Styles.GUNSHIP.getThisStyle());
        if (!AcceptedText.isEmpty()) {
            poseStack.drawTextWithShadow(this.textRenderer, AcceptedText.get(0),
                    this.Accepted.getX(),
                    this.Accepted.getY(), acceptedColor);
        }
        if (!CodeEnterTest.isEmpty()) {
            poseStack.drawTextWithShadow(this.textRenderer, CodeEnterTest.get(0), this.text.getX(),
                    this.text.getY(), Color.WHITE.getRGB());
        }
        if ((tick >> 2) % 5 == 0) {
            poseStack.drawTextWithShadow(this.textRenderer,
                    Text.of("|").getWithStyle(ConstantUtil.Styles.GUNSHIP.getThisStyle()).get(0),
                    text.getX() + (this.text.getCursor() * 21), this.text.getY(), Color.WHITE.getRGB());

            assert client != null;
            Objects.requireNonNull(client.player).playSound(ModSounds.CURSOR_BLINK, 0.1f, 1f);

        }


    }

    @Override
    protected void handledScreenTick() {
        tick++;
        I--;
        if (I <= 0 && !this.Accepted.getText().isEmpty()) {
            this.Accepted.setText(StringUtils.EMPTY);
        }
    }

    private void CheckField() {
        final String correctCode = "ACCEPTED";
        final PacketByteBuf data = PacketByteBufs.create();
        data.writeBlockPos(handler.getCurrentPosition());

        assert client != null;
        if (checkLanguage(text,client,false)) {
            I = 100;
            acceptedColor = 65280;
            this.Accepted.setText(correctCode);

            this.text.setCursor(0,false);
            CodeLyokoMain.LOG.info(this.text.getText());

            switch (client.getLanguageManager().getLanguage())
            {
                case "en_us" -> {
                    switch (this.text.getText().toLowerCase(Locale.US))
                    {
                        case "lyoko" -> data.writeInt(0);
                    }
                }
                case "fr_fr" -> {
                    switch (this.text.getText().toLowerCase(Locale.FRANCE))
                    {
                        case "lyoko" -> data.writeInt(0);
                    }
                }
                case "zh_cn" -> {
                    switch (this.text.getText().toLowerCase(Locale.CHINA))
                    {
                        case "廖科" -> data.writeInt(0);
                    }
                }
            }

            this.text.setText(StringUtils.EMPTY);
            ClientPlayNetworking.send(PacketHandler.TowerChannelID, data);
            Objects.requireNonNull(this.client.player).playSound(ModSounds.GUISOUND, 1, 2f);
        } else if (checkLanguage(text,client,true)) {
            I = 100;
            acceptedColor = 16711680;
            this.Accepted.setText(correctCode);
            this.text.setText(StringUtils.EMPTY);
            this.text.setCursor(0,false);
            data.writeInt(1);
            ClientPlayNetworking.send(PacketHandler.TowerChannelID, data);
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
        this.text.setFocused(true);
        this.text.setEditable(true);
        this.text.setCursor(0,false);
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
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {

        switch (keyCode) {
            case GLFW.GLFW_KEY_BACKSPACE -> this.text.eraseCharacters(1);
            case GLFW.GLFW_KEY_ENTER -> CheckField();
            default -> {
            }
        }

        this.text.keyPressed(keyCode, scanCode, modifiers);


        if (keyCode == 256 && shouldCloseOnEsc()) {

            close();
        } else {
            this.handleHotbarKeyPressed(keyCode, scanCode);
            if (this.focusedSlot != null && this.focusedSlot.hasStack()) {
                if (this.client.options.pickItemKey.matchesKey(keyCode, scanCode)) {
                    this.onMouseClick(this.focusedSlot, this.focusedSlot.id, 0, SlotActionType.CLONE);
                } else if (this.client.options.dropKey.matchesKey(keyCode, scanCode)) {
                    this.onMouseClick(this.focusedSlot, this.focusedSlot.id, hasControlDown() ? 1 : 0, SlotActionType.THROW);
                }
            }

        }
        return true;
    }

    @Override
    public boolean charTyped(char key, final int Keynum) {


        if (Character.getType(key) == Character.UPPERCASE_LETTER) {
            this.text.charTyped(key, Keynum);
        } else {
            this.text.charTyped(key ^= 32, Keynum);
        }
        assert this.client != null;
        Objects.requireNonNull(this.client.player).playSound(ModSounds.GUISOUND, client.options.getSoundVolume(SoundCategory.PLAYERS), completeRandom.nextFloat(1f,
                1.1f));
        return super.charTyped(key, Keynum);

    }


    @Override
    protected void drawBackground(final DrawContext matrices, final float delta, final int mouseX, final int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURES);
        matrices.drawTexture(TEXTURES,(this.width - 200) >> 1, (this.height - 141) >> 1, 0, 0, 200, 141);
    }


}