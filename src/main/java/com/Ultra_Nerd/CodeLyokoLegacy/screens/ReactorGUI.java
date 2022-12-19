package com.Ultra_Nerd.CodeLyokoLegacy.screens;


import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ReactorScreenHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
@Environment(EnvType.CLIENT)
public final class ReactorGUI extends HandledScreen<ReactorScreenHandler> {

    private static final Identifier TEXTURE = new Identifier("minecraft", "textures/gui/container/dispenser.png");

    public ReactorGUI(final ReactorScreenHandler handler, final PlayerInventory inventory, final Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(final MatrixStack matrices, final float delta, final int mouseX, final int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        final int x = (width - backgroundWidth) >> 1;
        final int y = (height - backgroundHeight) >> 1;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        final int x = (width - 36) >> 1;
        final int y = (height - 117) >> 1;
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
        drawCenteredText(matrices, textRenderer, Text.translatable("computer_reactor.input.slot"), x, y,
                ColorHelper.Argb.getArgb(255, 255, 255, 255));
        drawCenteredText(matrices, textRenderer, Text.translatable("computer_reactor.output.slot"), x + 36, y,
                ColorHelper.Argb.getArgb(255, 255, 255, 255));
        drawCenteredText(matrices, textRenderer,
                Text.translatable("computer_reactor.energy.amount", handler.getEnergyAmount()), x + 36, y + 45,
                ColorHelper.Argb.getArgb(255, 255, 255, 255));
    }

    @Override
    protected void init() {
        super.init();
        // Center the title
        titleX = (backgroundWidth - textRenderer.getWidth(title)) >> 1;
    }
}