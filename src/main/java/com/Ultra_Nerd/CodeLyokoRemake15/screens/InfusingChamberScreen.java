package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ContainerInfusing;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.entity.player.Inventory;

public class InfusingChamberScreen extends ContainerScreen<ContainerInfusing> {

    private static final ResourceLocation TEX = new ResourceLocation(Base.MOD_ID + ":textures/gui/flouride_infuser.png");
    private Inventory player;
    private InfusingChamberTileEntity tileentity;

    public InfusingChamberScreen(final ContainerInfusing interfaceContainer, final Inventory playerInventory, final Component title, final InfusingChamberTileEntity tileentity) {
        this(interfaceContainer, playerInventory, title);
        this.player = playerInventory;
        this.tileentity = tileentity;
    }

    public InfusingChamberScreen(final ContainerInfusing interfaceContainer, final Inventory playerInventory, final Component title) {
        super(interfaceContainer, playerInventory, title);
        this.tileentity = interfaceContainer.;
        this.player = playerInventory;
    }



    @Override
    public void render(PoseStack poseStack,final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack,mouseX, mouseY, partialTicks);
        this.renderTooltip(poseStack,mouseX, mouseY);
    }



    @Override
    public void renderBackground(PoseStack stack, int whateverthisis) {
        String tn = this.tileentity.getDisplayName().;

        this.font.draw(stack,tn, (this.xSize / 2.f - this.font.getStringWidth(tn) / 2.f), 5, 4210752);
        this.font.draw(stack,this.player.getDisplayName().getUnformattedComponentText(), 122, this.ySize - 96 + 2, 4210752);

    }


    @Override
    protected void renderBg(PoseStack poseStack,float partialTicks, int mouseX, int mouseY) {
        GlStateManager._clearColor(1.0f, 1.0f, 1.0f, 1.f);
        this.minecraft.getTextureManager().bindForSetup(TEX);
        this.blit(poseStack,this.getGuiLeft(), this.getGuiTop(), 0, 0, this.getXSize(), this.getYSize());
        if (InfusingChamberTileEntity.isBurning(tileentity)) {
            int k = this.getBurnLeftSDca(13);
            this.blit(poseStack,this.getGuiLeft() + 57, this.getGuiTop() + 38 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.progess(59);
        this.blit(poseStack,this.getGuiLeft() + 98, this.getGuiTop() + 57 + 12 - l, 176, 91 - l, 59, l + 1);
        // TODO Auto-generated method stub

    }

    private int getBurnLeftSDca(int pixels) {
        int i = this.tileentity.getField(1);
        if (i == 0) {
            i = 20;
        }
        return this.tileentity.getField(0) * pixels / i;
    }


    private int progess(int pixels) {
        int i = this.tileentity.getField(2);
        int j = this.tileentity.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }


}
