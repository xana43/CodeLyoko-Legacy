package com.Ultra_Nerd.CodeLyokoLegacy.screens;


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandlerCommon;
import com.Ultra_Nerd.CodeLyokoLegacy.util.client.GUI.LyokoButton;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public final class ComputerInterfaceUi extends Screen {
    private static final Identifier TEXTURE = CodeLyokoMain.codeLyokoPrefix("textures/gui/computer_gui.png");
    private final BlockPos calledPosition;
    public ComputerInterfaceUi(final Text title,final BlockPos pos) {
        super(title);
        this.calledPosition = pos;
    }

    @Override
    public void render(final MatrixStack matrices, final int mouseX, final int mouseY, final float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);


    }

    @Override
    protected void init() {
        super.init();
        this.addDrawableChild(new LyokoButton(this,80,20,Text.literal("test"),
                button -> {

                    final PacketByteBuf namebuf = PacketByteBufs.create();
                    namebuf.writeBlockPos(calledPosition);
                    ClientPlayNetworking.send(PacketHandlerCommon.ComputerUIChannelID, namebuf);
                }));

    }

    @Override
    public void renderBackground(final MatrixStack matrices) {
        //super.renderBackground(matrices);
        RenderSystem.setShaderTexture(0,TEXTURE);
        drawTexture(matrices,0,0,0,0,1280,720,this.width,this.height);

    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}