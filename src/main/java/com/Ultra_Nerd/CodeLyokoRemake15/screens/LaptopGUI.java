package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LaptopGUI extends Screen {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Base.MOD_ID,"textures/gui/towerinterface.png");
    private int x,y;
    public LaptopGUI(ITextComponent titleIn) {
        super(titleIn);


    }

    @Override
    protected void init() {
        x = this.height / 2;
        y = this.width / 2;
        super.init();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
this.blit(x,y,x,y,this.height,this.width);

        assert this.minecraft != null;
        this.minecraft.textureManager.bindTexture(TEXTURE);
        super.render(p_render_1_, p_render_2_, p_render_3_);
    }
}
