package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;


public class LaptopGUI extends Screen {

    private static final ResourceLocation TEXTURE = new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/gui/laptopguibase.png");
    private int x, y, xSize, ySize;

    public LaptopGUI(TextComponent titleIn) {
        super(titleIn);


    }

    @Override
    protected void init() {
        xSize = 1280;
        ySize = 720;
        x = (this.width - xSize) / 2;
        y = (this.height - ySize) / 2;

        super.init();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }


    @Override
    public void render(PoseStack pose,int p_render_1_, int p_render_2_, float p_render_3_) {
        super.render(pose,p_render_1_, p_render_2_, p_render_3_);

        assert this.minecraft != null;
        this.minecraft.textureManager.bindForSetup(TEXTURE);
        this.blit(null,x, y, 0, 0, this.xSize, this.ySize);

    }
}
