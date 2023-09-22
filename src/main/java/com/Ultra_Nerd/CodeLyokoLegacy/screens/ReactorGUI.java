package com.Ultra_Nerd.CodeLyokoLegacy.screens;


import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ReactorScreenHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
@Environment(EnvType.CLIENT)
public final class ReactorGUI extends HandledScreen<ReactorScreenHandler> {

    private boolean narrow;
    private static final Identifier background = new Identifier("textures/gui/container/furnace.png");
    public ReactorGUI(final ReactorScreenHandler handler, final PlayerInventory inventory, final Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        narrow = width < 379;
        titleX = (backgroundWidth - textRenderer.getWidth(title)) >> 1;
    }

    @Override
    protected void drawBackground(final DrawContext context, final float delta, final int mouseX, final int mouseY) {
        context.drawTexture(background,x,y,0,0,backgroundWidth,backgroundHeight);
        int results;
        if(handler.isReacting())
        {
            results = handler.getUraniumProgress();
            context.drawTexture(background,x+56,y+36+12 - results,176,12 - results,14,results + 1);
        }
        results = handler.getReactionProgress();
        context.drawTexture(background,x + 79,y + 34,176,14,results+1,16);
    }
}