package com.Ultra_Nerd.CodeLyokoLegacy.Screens;


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.LithographyScreenHandlerT2;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public final class LithographyT2GUI extends HandledScreen<LithographyScreenHandlerT2> {

    private static final Identifier background = CodeLyokoMain.codeLyokoPrefix("textures/gui/reactor_new.png");
    public LithographyT2GUI(final LithographyScreenHandlerT2 handler, final PlayerInventory inventory, final Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) >> 1;
    }

    @Override
    public void render(final DrawContext context, final int mouseX, final int mouseY, final float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context,mouseX,mouseY);
        drawIndicatorToolTips(context,mouseX,mouseY);
    }
    private void drawIndicatorToolTips(final DrawContext context,final int mouseX,final int mouseY)
    {

        if(mouseY > y+7 && mouseY < y + 76) {

            if (mouseX > x + 152 && mouseX < (x + 152) + 16) {
                context.drawTooltip(textRenderer, Text.translatable("reactor.energy.amount.gui", handler.getEnergyAmount()), mouseX, mouseY);
            }
        }
    }
    @Override
    protected void drawBackground(final DrawContext context, final float delta, final int mouseX, final int mouseY) {
        context.drawTexture(background,x,y,0,0,backgroundWidth,backgroundHeight);
        final int l = getReactionProcessScaled();
        context.drawTexture(background,x + 74,y+33,176,14,l+1,16);
        final int k = getEnergyStoredScaled();
        context.drawTexture(background,x + 152,y+7,176,32,16,76-k);

    }
    private int getEnergyStoredScaled()
    {
        final int i = handler.getEnergyAmount();
        final int j = handler.getEnergyCapacity();
        return i != 0 && j != 0 ? i* 75 / j:0;
    }

    private int getReactionProcessScaled()
    {
        final int i = handler.getReactionProgress();
        return i != 0? i * 24 / 25:0;
    }
}