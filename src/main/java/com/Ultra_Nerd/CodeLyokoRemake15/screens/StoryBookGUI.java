package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.ReadBookScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class StoryBookGUI extends ReadBookScreen {

    private static final int BUTTON_NEXT = 0;
    private static final int BUTTON_PREV = 1;
    private TextFieldWidget story;
    private int pageIndex = 0;


    public StoryBookGUI() {

    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        super.render(p_render_1_, p_render_2_, p_render_3_);

    }

    @Override
    public void init(@Nonnull Minecraft p_init_1_, int p_init_2_, int p_init_3_) {
        super.init(p_init_1_, p_init_2_, p_init_3_);
        Initall();
    }

    private void Initall() {

        int tx = this.width / 2;
        int ty = this.height / 2;
        FontRenderer gunship_font = this.getMinecraft().getFontResourceManager().getFontRenderer(new ResourceLocation(Base.MOD_ID + ":gunship"));
        assert gunship_font != null;
        this.story = new TextFieldWidget(gunship_font, tx, ty, 200, 33, I18n.format("gui.cm.story_screen"));
        this.story.setEnableBackgroundDrawing(false);
        this.story.setVisible(true);
        this.story.setTextColor(16777215);
        this.story.setFocused2(true);
        this.story.setEnabled(true);
        this.story.setCanLoseFocus(false);
        this.story.active = true;
        this.story.canWrite();
        this.story.writeText("Entry 1: " + "\n" +
                "07/29/2020" + "\n" +
                "Jeremy Belpois" + "\n" + "01:00" + "\n" + "I'm not sure what happened, X.A.N.A. was defeated years ago" + "\n" +
                "but this time he's done it, he's managed to destroy the world as we know it, but I survived because I tried to save everyone by putting them in lyoko"
                + "\n" + "I'm not sure how long I have to be here, hopefully someone finds this, and finds the hidden instructions to rebuild the super calculator and reset this mess");


    }

    public int getPageIndex() {
        return pageIndex;
    }


    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
