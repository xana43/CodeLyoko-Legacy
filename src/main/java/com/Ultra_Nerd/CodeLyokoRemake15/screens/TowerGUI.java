package com.Ultra_Nerd.CodeLyokoRemake15.screens;


import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.TowerInterfaceContainer;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import org.jline.utils.Log;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;


public class TowerGUI extends AbstractContainerScreen<TowerInterfaceContainer> {

    private static final ResourceLocation TEXTURES = CodeLyokoMain.CodeLyokoPrefix("textures/gui/towerinterface.png");
    private EditBox text;
    private EditBox Accepted;
    private final Font gunship_font = new Font(resourceLocation -> new FontSet(getMinecraft().textureManager, CodeLyokoMain.CodeLyokoPrefix("gunship")));
    private byte I = 100;





    public TowerGUI(TowerInterfaceContainer towerInterfaceContainer, Inventory playerInventory, Component titleIn) {
        
        super(towerInterfaceContainer,playerInventory, titleIn);
        //this.width = 200;
        //this.height = 141;
        //private TowerInterfaceTileEntity tileentity;
        this.inventoryLabelX = - 90;
        this.inventoryLabelY = - 90;
        this.titleLabelX = -90;
        this.titleLabelY = -90;

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
    public static void NoE(final ScreenEvent event) {
        if (event.getResult().ordinal() == GLFW.GLFW_KEY_E) {
            if (event.getScreen() instanceof TowerGUI) {
                event.setCanceled(true);
            }
        }
    }



    @Override
    public void containerTick() {

        this.text.tick();

        if (this.text.getValue().toLowerCase(Locale.ROOT).matches(new TranslatableComponent("LYOKO").getContents()) || this.text.getValue().toUpperCase(Locale.ROOT).matches(new TranslatableComponent("CHIMERA").getKey())
                || this.text.getValue().toUpperCase(Locale.ROOT).matches(new TranslatableComponent("EARTH").getKey())) {
            I = 100;
            this.Accepted.setFGColor(65280);
            Log.debug("accepted value");
            this.Accepted.setMessage(new TranslatableComponent("ACCEPTED"));
            this.text.setMessage(new TranslatableComponent(""));
            this.text.setCursorPosition(0);
        } else if (this.text.getValue().matches(new TranslatableComponent("XANA").getKey())) {
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

        this.setTextField();


    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
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
        Objects.requireNonNull(this.getMinecraft().player).playSound(ModSounds.GUISOUND.get(), 1, rand);
        return super.charTyped(key, Keynum);

    }


    protected void setTextField() {

        int tx = this.width / 2;
        int ty = this.height / 2;
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
        this.Accepted.isActive();
        this.Accepted.visible = true;
        this.Accepted.setBordered(false);
        this.Accepted.setFGColor(65280);
        this.Accepted.changeFocus(true);
        this.Accepted.active = false;

    }



    @Override
    public void renderBg(PoseStack p_96559_, float tick,int mouseX, int mouseY) {

        RenderSystem.setShaderTexture(0,TEXTURES);
        int x = (this.width - this.imageWidth) /2;
        int y = (this.height - this.imageHeight) /2;

        this.blit(p_96559_,x, y, 0, 0, this.imageWidth, this.imageHeight);
    }



}