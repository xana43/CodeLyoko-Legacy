package com.Ultra_Nerd.CodeLyokoLegacy.Screens.SuperCalculatorNetworkScreens;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.SuperCalculatorNetwork.DemarcationScreenHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.glfw.GLFW;
@Environment(EnvType.CLIENT)
public final class DemarcationPointScreen extends HandledScreen<DemarcationScreenHandler> {
    private static final Identifier TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/gui/demarcation_gui.png");
    private TextFieldWidget nameWidget,idWidget;
    public DemarcationPointScreen(final DemarcationScreenHandler handler, final PlayerInventory inventory, final Text title) {
        super(handler, inventory, title.copy().append(Text.of(" "+ handler.getId())));
        this.playerInventoryTitleX = 900;
        this.titleY -= 5;
        this.titleX = (backgroundWidth >> 1) - getTitle().toString().length();
    }

    @Override
    public void render(final DrawContext context, final int mouseX, final int mouseY, final float delta) {
        super.render(context, mouseX, mouseY, delta);
        nameWidget.render(context, mouseX, mouseY, delta);
        idWidget.render(context, mouseX, mouseY, delta);
    }

    @Override
    protected void init() {
        super.init();

        final int tx = width >> 1;
        final int ty = height >> 1;
        nameWidget = new TextFieldWidget(textRenderer,tx - 50,ty - 73,100,10,Text.empty());
        nameWidget.setMaxLength(20);
        nameWidget.setDrawsBackground(true);
        nameWidget.setVisible(true);
        nameWidget.setEditable(true);
        nameWidget.setCursor(0,false);
        nameWidget.active = true;
        nameWidget.setFocusUnlocked(true);
        idWidget = new TextFieldWidget(textRenderer, tx - 92,ty - 3, 26,10,Text.empty())
        {
            @Override
            public boolean charTyped(final char chr, final int modifiers) {
                if(Character.isDigit(chr)) {
                    return super.charTyped(chr, modifiers);
                }
                return false;
            }
        };
        idWidget.setMaxLength(3);
        idWidget.setDrawsBackground(true);
        idWidget.setEditable(true);
        idWidget.setText(String.valueOf(handler.getId()));
        idWidget.setCursor(0,false);
        idWidget.active = true;
        idWidget.setFocusUnlocked(true);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    public boolean mouseClicked(final double mouseX, final double mouseY, final int button) {
        if(nameWidget.mouseClicked(mouseX, mouseY, button))
        {
            nameWidget.setFocused(true);
        } else if (nameWidget.isFocused()) {
            nameWidget.setFocused(false);
        }
        if(idWidget.mouseClicked(mouseX, mouseY, button))
        {
            idWidget.setFocused(true);
        } else if (idWidget.isFocused()) {
            idWidget.setFocused(false);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void close() {
        if(!nameWidget.isFocused() && !idWidget.isFocused()) {
            super.close();
        }
    }

    @Override
    public boolean keyPressed(final int keyCode, final int scanCode, final int modifiers) {
        if(nameWidget.isFocused()) {
            switch (keyCode) {
                case GLFW.GLFW_KEY_BACKSPACE -> nameWidget.eraseCharacters(1);
                case GLFW.GLFW_KEY_ENTER -> {
                    if (!nameWidget.getText().isEmpty()) {
                        CodeLyokoMain.LOG.warn("sending the name");
                        final PacketByteBuf buf = PacketByteBufs.create();
                        buf.writeBlockPos(handler.getPos());
                        buf.writeString(nameWidget.getText());
                        buf.writeInt(-1);
                        ClientPlayNetworking.send(PacketHandler.RENAME_BLOCK_ENTITY, buf);
                    }
                }
                default -> {
                }
            }
            nameWidget.keyPressed(keyCode, scanCode, modifiers);
        }
        if(idWidget.isFocused())
        {
            switch (keyCode) {
                case GLFW.GLFW_KEY_BACKSPACE -> idWidget.eraseCharacters(1);
                case GLFW.GLFW_KEY_ENTER -> {
                    if (Integer.parseInt(idWidget.getText()) > -1) {
                        final PacketByteBuf buf = PacketByteBufs.create();
                        buf.writeBlockPos(handler.getPos());
                        buf.writeString(StringUtils.EMPTY);
                        buf.writeInt(Integer.parseInt(idWidget.getText()));
                        ClientPlayNetworking.send(PacketHandler.RENAME_BLOCK_ENTITY, buf);
                    }
                }
                default -> {
                }
            }
            idWidget.keyPressed(keyCode, scanCode, modifiers);
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean charTyped(final char chr, final int modifiers) {
        if(nameWidget.isFocused()) {
            nameWidget.charTyped(chr, modifiers);
        }
        if(idWidget.isFocused()) {
            idWidget.charTyped(chr, modifiers);
        }
        return super.charTyped(chr, modifiers);
    }

    @Override
    protected void drawBackground(final DrawContext context, final float delta, final int mouseX, final int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1,1,1,1);
        RenderSystem.setShaderTexture(0,TEXTURE);
        context.drawTexture(TEXTURE,x,y,0,0,backgroundWidth,backgroundHeight);
    }
}
