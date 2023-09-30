package com.Ultra_Nerd.CodeLyokoLegacy.screens;


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Network.Util.PacketHandlerCommon;
import com.Ultra_Nerd.CodeLyokoLegacy.ScreenHandlers.ComputerControlPanelScreenHandler;
import com.Ultra_Nerd.CodeLyokoLegacy.util.ConstantUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public final class ComputerControlPanelUI extends HandledScreen<ComputerControlPanelScreenHandler> /*extends AbstractContainerScreen<ComputerControlPanelScreenHandler>*/ {

    private static final int size = 256;
    private static final Identifier TEXTURES = CodeLyokoMain.codeLyokoPrefix("textures/gui/computercontrolpanelui.png");
    private static final Identifier BUTTONTEXTURES = CodeLyokoMain.codeLyokoPrefix("textures/gui/buttonatlas.png");
    int x, y;
    private TextFieldWidget text;
    private boolean active;
    private TexturedButtonWidget button;

    public ComputerControlPanelUI(final ComputerControlPanelScreenHandler handler, final PlayerInventory inventory, final Text title) {
        super(handler, inventory, title);
        playerInventoryTitleX = -900;


    }


    @Override
    public boolean isMouseOver(double p_isMouseOver_1_, double p_isMouseOver_3_) {
        return false;
    }




    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        this.button.mouseClicked(mouseX, mouseY, mouseButton);
        return super.mouseClicked(mouseX, mouseY, mouseButton);


    }

    @Override
    public void render(@NotNull DrawContext stack, int p_render_1_, int p_render_2_, float p_render_3_) {
        this.renderBackground(stack);
        super.render(stack, p_render_1_, p_render_2_, p_render_3_);
        this.text.render(stack, p_render_1_, p_render_2_, p_render_3_);
        this.button.render(stack, p_render_1_, p_render_2_, p_render_3_);

        //drawCenteredText(stack,textRenderer,String.valueOf(handler.isActive()),this.width >> 1, this.height >> 1, Formatting.WHITE.getColorIndex());
    }


    @Override
    public void init() {
        super.init();
        x = (this.width - size) >> 1;
        y = (this.height - (size >> 1)) >> 1;
        this.setTextField();
        this.setButtons();
        active = handler.isActive();

    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    private void setButtons() {

        //
        this.button = new TexturedButtonWidget(x, y, this.width / 3, this.height >> 3, 0, 0, BUTTONTEXTURES,
                (press) -> {
                    final PacketByteBuf buf = PacketByteBufs.create();
                    active = !active;
                    buf.writeBlockPos(handler.getPos());
                    buf.writeBoolean(active);
                    ClientPlayNetworking.send(PacketHandlerCommon.ChannelID, buf);

                }) {
            @Override
            public void renderButton(DrawContext stack, int p_renderButton_1_, int p_renderButton_2_,
                    float p_renderButton_3_) {
                //super.renderButton(p_renderButton_1_, p_renderButton_2_, p_renderButton_3_);
                final int i = getType().ordinal();//getYImage(hovered);


                RenderSystem.setShaderTexture(0, BUTTONTEXTURES);
                int j = 0;
                if (this.getMessage().getStyle().getColor() != null) {
                    j = this.getMessage().getStyle().getColor().getRgb();
                }
                if (i == 1) {
                    j = ColorHelper.Argb.getArgb(255, 0, 0, 255);
                    drawTexture(stack, BUTTONTEXTURES,x, y, 0, 0, 104, 19, 1024, 512,512);
                } else {
                    drawTexture(stack,BUTTONTEXTURES, x, y, 0, 19, 104, 19, 1024, 512,512);
                }
                //drawTexture(stack,x, 38, 0, (46 + i) * 20, width >> 1, height);
                stack.drawCenteredTextWithShadow(client.textRenderer,
                        getMessage().copy().setStyle(ConstantUtil.Styles.HUD.getThisStyle()), x + (width + 55) >> 1,
                        y + (height + 32) >> 1, j | MathHelper.ceil(alpha * 255.0F) << 24);


            }

        };
        this.button.active = true;
        this.addDrawable(this.button);
        this.button.visible = true;


    }

    @Override
    protected void handledScreenTick() {
        super.handledScreenTick();

        //CompActive = handler.isActive();
        if (active) {
            this.button.setMessage(Text.translatable("de-activate"));
        } else {
            this.button.setMessage(Text.translatable("activate"));
        }

        if (active) {
            this.text.setMessage(Text.translatable("Active"));
            this.text.setEditableColor(0x008000);
        } else {
            this.text.setMessage(Text.translatable("in-active"));
            this.text.setEditableColor(0xda2c43);
        }
    }


    private void setTextField() {
        //final int tx = this.width >> 1;
        final int ty = this.height >> 1;
        this.text = new TextFieldWidget(client.textRenderer, x, ty + 40, this.width, 23,
                Text.translatable("gui.codelyoko.computer_input_main").setStyle(ConstantUtil.Styles.GUNSHIP.getThisStyle()));
        this.text.setDrawsBackground(false);
        this.text.setVisible(true);
        this.text.setEditableColor(0xda2c43);
        this.text.setMessage(Text.translatable("gui.codelyoko.inactive"));
        this.text.setEditable(false);


    }

    @Override
    protected void drawBackground(final DrawContext matrices, final float delta, final int mouseX, final int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURES);
        matrices.drawTexture(TEXTURES, x, y, 0, 0, size, size >> 1);
        if (active) {
            matrices.drawTexture(TEXTURES, x, y + 19, 0, 144, size, (size >> 1) - 35);
        }
    }


}