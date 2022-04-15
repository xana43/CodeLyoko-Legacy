package com.Ultra_Nerd.CodeLyokoLegacy.screens;


import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.containers.ComputerControlPanelContainer;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ComputerControlPanelUI extends AbstractContainerScreen<ComputerControlPanelContainer> {


    private static final ResourceLocation TEXTURES = new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/gui/computercontrolpanelui.png");
    private static final ResourceLocation BUTTONTEXTURES = new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/gui/buttonatlas.png");
    private EditBox text;
    private Button button;
    private boolean CompActive;
    private final Font gunship_font = new Font(resourceLocation -> new FontSet(getMinecraft().textureManager, CodeLyokoMain.CodeLyokoPrefix("gunship")));

    int x, y;


    public ComputerControlPanelUI(@NotNull ComputerControlPanelContainer screenContainer, @NotNull Inventory inv, @NotNull Component titleIn) {
        super(screenContainer, inv, titleIn);

        this.inventoryLabelX = -90;
        this.inventoryLabelY = -90;


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
        return super.mouseClicked(mouseX, mouseY, mouseButton);

    }

    @Override
    public void render(@NotNull PoseStack stack, int p_render_1_, int p_render_2_, float p_render_3_) {
        this.renderBackground(stack);
        super.render(stack,p_render_1_, p_render_2_, p_render_3_);
        this.text.render(stack,p_render_1_, p_render_2_, p_render_3_);
        this.button.renderButton(stack,p_render_1_, p_render_2_, p_render_3_);
    }




    @Override
    public void init() {
        super.init();
        x = (this.width - this.getXSize()) >> 1;
        y = (this.height - this.getYSize()) >> 1;
        this.setTextField();
        this.setButtons();

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }


    private void setButtons() {


        this.button = new Button(x, y, this.width / 3, this.height >> 3, new TranslatableComponent("activate"),Button::onPress) {
            @Override
            protected int getYImage(boolean p_getYImage_1_) {
                return super.getYImage(p_getYImage_1_);

            }

            @Override
            public void onPress() {
               //super.onPress();
                CompActive = !CompActive;
                if (!CompActive) {


                    minecraft.player.playSound(ModSounds.QUANTUMZAP.get(), 1, 1);

                } else {

                    minecraft.player.playSound(ModSounds.QUANTUMZAP.get(), 1, 1);

                }
            }




            @Override
            public void renderButton(PoseStack stack, int p_renderButton_1_, int p_renderButton_2_, float p_renderButton_3_) {
                //super.renderButton(p_renderButton_1_, p_renderButton_2_, p_renderButton_3_);
                int i = getYImage(isHovered);

                RenderSystem.setShaderTexture(0,BUTTONTEXTURES);



                int j = getFGColor();
                drawCenteredString(stack,gunship_font, getMessage(), (x + width )>> 1, y + (height - 8) >> 1, j | Mth.ceil(alpha * 255.0F) << 24);
                blit(stack,x, y, 0, (37 + i) << 1, 103, 37);
                blit(stack,x, 38, 0, (46 + i) * 20, width >> 1, height);

            }

        };
        this.button.active = true;
        this.addWidget(this.button);
        this.button.visible = true;


    }
    @Override
    public void containerTick() {
        super.containerTick();
        if (CompActive) {
            this.button.setMessage(new TranslatableComponent("de-activate"));
        } else {
            this.button.setMessage(new TranslatableComponent("activate"));
        }

        if (CompActive) {
            this.text.setMessage(new TranslatableComponent("Active"));
            this.text.setTextColor(0x008000);
        } else {
            this.text.setMessage(new TranslatableComponent("in-active"));
            this.text.setTextColor(0xda2c43);
        }
    }

    private void setTextField() {
        final int tx = this.width >> 1;
        final int ty = this.height >> 1;
        this.text = new EditBox(gunship_font, x, ty + 40, this.width, 23, new TranslatableComponent("gui.cm.computer_input_main"));
        this.text.setBordered(false);
        this.text.setVisible(true);
        this.text.setTextColor(0xda2c43);
        this.text.setMessage(new TranslatableComponent("in-active"));
        this.text.setEditable(false);


    }
    @Override
    protected void renderBg(@NotNull PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShaderTexture(0,TEXTURES);
        this.blit(pPoseStack,x, y, 0, 0, this.getXSize(), this.getYSize());
        if (CompActive) {
            this.blit(pPoseStack,x, y + 15, 0, 144, this.getXSize(), this.getYSize() - 35);
        }
    }







}