package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ReadBookScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StoryBookGUI extends ReadBookScreen
{


    private static final int BUTTON_NEXT = 0;
    private static final int BUTTON_PREV = 1;

    private int pageIndex = 0;




    public StoryBookGUI() {

    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        super.render(p_render_1_, p_render_2_, p_render_3_);

    }

    @Override
    public void init(Minecraft p_init_1_, int p_init_2_, int p_init_3_) {
        super.init(p_init_1_, p_init_2_, p_init_3_);
    }

    public int getPageIndex() {
        return pageIndex;
    }



    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
