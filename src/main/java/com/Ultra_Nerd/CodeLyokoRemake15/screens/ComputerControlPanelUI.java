package com.Ultra_Nerd.CodeLyokoRemake15.screens;


import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ComputerControlPanelContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.Random;

public class ComputerControlPanelUI extends ContainerScreen<ComputerControlPanelContainer> {

    private static final ResourceLocation TEXTURES = new ResourceLocation(Base.MOD_ID,"textures/gui/towerinterface.png");
    private TextFieldWidget text;
    private TextFieldWidget Accepted;
    private byte I = 100;



    int x, y;


    public ComputerControlPanelUI(ComputerControlPanelContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 200;
        this.ySize = 141;


    }

    @Override
    public boolean isMouseOver(double p_isMouseOver_1_, double p_isMouseOver_3_) {
        return false;
    }

    @Override
    public boolean changeFocus(boolean p_changeFocus_1_) {
        return false;
    }


    @Override
    public void setFocused(@Nullable IGuiEventListener p_setFocused_1_) {
        super.setFocused(p_setFocused_1_);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        this.text.mouseClicked(mouseX, mouseY, mouseButton);
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        this.renderBackground();
        super.render(p_render_1_, p_render_2_, p_render_3_);
        this.text.render(p_render_1_, p_render_2_, p_render_3_);
        this.Accepted.render(p_render_1_, p_render_2_, p_render_3_);
    }

    @SubscribeEvent
    public static void NoE(final GuiScreenEvent.KeyboardKeyEvent event) {
        if (event.getKeyCode() == GLFW.GLFW_KEY_E) {
            if (event.getGui() instanceof ComputerControlPanelUI) {
                event.setCanceled(true);
            }
        }
    }

    @Override
    public void tick() {

        this.text.tick();

        if (this.text.getText().matches("LYOKO") || this.text.getText().matches("CHIMERA") || this.text.getText().matches("EARTH")) {
            I = 100;
            this.Accepted.setTextColor(65280);
            this.Accepted.setText("ACCEPTED");
            this.text.setText("");
            this.text.setCursorPositionZero();
        } else if (this.text.getText().matches("XANA")) {
            I = 100;
            this.Accepted.setTextColor(16711680);
            this.Accepted.setText("ACCEPTED");
            this.text.setText("");
            this.text.setCursorPositionZero();
        } else {
            I -= 1;
            if (I == 0) {
                this.Accepted.setText("");
            }
        }
    }


    @Override
    public void init() {
        super.init();
        x = (this.width - this.xSize) / 2;
        y = (this.height - this.ySize) / 2;
        this.setTextField();


    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }


    @Override
    public boolean keyPressed(int Key, int p_keyPressed_2_, int p_keyPressed_3_) {


        if (Key == 8) {
            this.text.deleteFromCursor(1);
        }
        this.text.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
        this.Accepted.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
        return super.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
    }

    @Override
    public boolean charTyped(char key, int Keynum) {
        float rand = 1f + new Random().nextFloat() * (4 - 1);
        this.text.charTyped(Character.toUpperCase(key), Keynum);
        this.playerInventory.player.playSound(ModSounds.GUISOUND.get(), 1, rand);
        return super.charTyped(key, Keynum);

    }


    protected void setTextField() {
        int tx = this.width / 2;
        int ty = this.height / 2;
        FontRenderer gunship_font = this.getMinecraft().getFontResourceManager().getFontRenderer(new ResourceLocation(Base.MOD_ID + ":gunship"));
        assert gunship_font != null;
        this.text = new TextFieldWidget(gunship_font, tx - 70, ty - 10, 200, 33, I18n.format("gui.cm.interface_input"));
        this.text.setMaxStringLength(7);
        this.text.setEnableBackgroundDrawing(false);
        this.text.setVisible(true);
        this.text.setTextColor(16777215);
        this.text.setFocused2(true);
        this.text.setEnabled(true);
        this.text.setCursorPositionZero();
        this.text.setCanLoseFocus(false);
        this.text.active = true;
        this.text.canWrite();
        int tx2 = this.width / 2;
        int ty2 = this.height / 2;
        FontRenderer gunship_font2 = this.getMinecraft().getFontResourceManager().getFontRenderer(new ResourceLocation(Base.MOD_ID + ":gunship"));
        assert gunship_font2 != null;
        this.Accepted = new TextFieldWidget(gunship_font, tx2 - 95, ty2 + 20, 200, 33, I18n.format("gui.cm.indicator"));
        this.Accepted.setMaxStringLength(8);
        this.Accepted.setEnableBackgroundDrawing(false);
        this.Accepted.setVisible(true);
        this.Accepted.setTextColor(65280);
        this.Accepted.setFocused2(false);
        this.Accepted.setEnabled(true);
        this.Accepted.setCursorPositionZero();
        this.Accepted.setCanLoseFocus(true);
        this.Accepted.canWrite();
        this.Accepted.active = true;

    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.minecraft.getTextureManager().bindTexture(TEXTURES);

        this.blit(x, y, 0, 0, this.xSize, this.ySize);
    }


}