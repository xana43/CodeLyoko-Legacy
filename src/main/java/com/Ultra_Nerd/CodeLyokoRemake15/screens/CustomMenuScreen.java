package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CustomMenuScreen extends MainMenuScreen{

    public CustomMenuScreen(boolean fade)
    {
        super(fade);
    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        assert minecraft != null;
        this.minecraft.getTextureManager().bindTexture(new ResourceLocation(Base.MOD_ID,"textures/skies/sector5/sector5sky.png"));

        super.render(p_render_1_, p_render_2_, p_render_3_);


    }
}
