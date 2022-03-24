package com.Ultra_Nerd.CodeLyokoRemake15.screens;


import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.Random;

public class TowerGUI extends Screen {

    private static final ResourceLocation TEXTURES = new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/gui/towerinterface.png");
    private EditBox text;
    private AbstractWidget Accepted;
    private byte I = 100;
    private int ScreenX, ScreenY, x , y;

    public TowerGUI(Component titleIn) {
        
        super(titleIn);
        this.width = 200;
        this.height = 141;
        //private TowerInterfaceTileEntity tileentity;
        this.ScreenX = Minecraft.getInstance().screen.width;
        this.ScreenY = Minecraft.getInstance().screen.height;

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
    public void setFocused(@Nullable GuiEventListener p_setFocused_1_) {
        super.setFocused(p_setFocused_1_);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        this.text.mouseClicked(mouseX, mouseY, mouseButton);
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }



    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack,mouseX, mouseY, partialTicks);
        this.text.render(poseStack,mouseX, mouseY, partialTicks);
        this.Accepted.render(poseStack, mouseX, mouseY, partialTicks);

    }

    @SubscribeEvent
    public static void NoE(final ScreenEvent.KeyboardKeyEvent event) {
        if (event.getKeyCode() == GLFW.GLFW_KEY_E) {
            if (event.getScreen() instanceof TowerGUI) {
                event.setCanceled(true);
            }
        }
    }

    @Override
    public void tick() {

        this.text.tick();

        if (this.text.getValue().matches(new TranslatableComponent("LYOKO").toString()) || this.text.getValue().matches(new TranslatableComponent("CHIMERA").toString())
                || this.text.getValue().matches(new TranslatableComponent("EARTH").toString())) {
            I = 100;
            this.Accepted.setFGColor(65280);
            this.Accepted.setMessage(new TranslatableComponent("ACCEPTED"));
            this.text.setMessage(new TranslatableComponent(""));
            this.text.setCursorPosition(0);
        } else if (this.text.getValue().matches(new TranslatableComponent("XANA").toString())) {
            I = 100;
            this.Accepted.setFGColor(16711680);
            this.Accepted.setMessage(new TranslatableComponent("ACCEPTED"));
            this.text.setMessage(new TranslatableComponent(""));
            this.text.setCursorPosition(0);
        } else {
            I -= 1;
            if (I == 0) {
                this.Accepted.setMessage(new TranslatableComponent(""));
            }
        }
    }


    @Override
    public void init() {
        super.init();
        x = (this.width - this.ScreenX) / 2;
        y = (this.height - this.ScreenY) / 2;
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
            this.text.deleteChars(1);
        }
        this.text.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
        this.Accepted.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
        return super.keyPressed(Key, p_keyPressed_2_, p_keyPressed_3_);
    }

    @Override
    public boolean charTyped(char key, int Keynum) {
        float rand = 1f + new Random().nextFloat() * (4 - 1);
        this.text.charTyped(Character.toUpperCase(key), Keynum);
        this.getMinecraft().player.playSound(ModSounds.GUISOUND.get(), 1, rand);
        return super.charTyped(key, Keynum);

    }


    protected void setTextField() {
        int tx = this.width / 2;
        int ty = this.height / 2;
        Font gunship_font = new Font(resourceLocation -> new FontSet(getMinecraft().textureManager, new ResourceLocation(CodeLyokoMain.MOD_ID + ":gunship")));
        this.text = new EditBox(gunship_font, tx - 70, ty - 10, 200, 33, new TranslatableComponent("gui.cm.interface_input"));
        this.text.setMaxLength(7);
        this.text.setBordered(false);
        this.text.setVisible(true);
        this.text.setTextColor(16777215);
        this.text.setFocus(true);
        this.text.setEditable(true);
        this.text.setCursorPosition(0);
        this.text.setCanLoseFocus(false);
        this.text.active = true;
        this.text.isActive();
        int tx2 = this.width / 2;
        int ty2 = this.height / 2;
        this.Accepted = new EditBox(gunship_font, tx2 - 95, ty2 + 20, 200, 33, new TranslatableComponent("gui.cm.indicator"));
        this.Accepted.visible = true;
        this.Accepted.clearFGColor();
        this.Accepted.setFGColor(65280);
        this.Accepted.isFocused();
        this.Accepted.changeFocus(true);
        this.Accepted.active = true;

    }


    @Override
    public void renderBackground(PoseStack p_96559_, int p_96560_) {
        super.renderBackground(p_96559_, p_96560_);
        this.minecraft.getTextureManager().bindForSetup(TEXTURES);

        this.blit(p_96559_,x, y, 0, 0, this.ScreenX, this.ScreenY);
    }




}