package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ContainerInfusing;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InfusingChamberTileEntity;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class InfusingChamberScreen extends ContainerScreen<ContainerInfusing> {

    private static final ResourceLocation TEX = new ResourceLocation(Base.MOD_ID + ":textures/gui/flouride_infuser.png");
    private PlayerInventory player;
    private InfusingChamberTileEntity tileentity;

    public InfusingChamberScreen(final ContainerInfusing interfaceContainer, final PlayerInventory playerInventory, final ITextComponent title, final InfusingChamberTileEntity tileentity) {
        this(interfaceContainer, playerInventory, title);
        this.player = playerInventory;
        this.tileentity = tileentity;
    }

    public InfusingChamberScreen(final ContainerInfusing interfaceContainer, final PlayerInventory playerInventory, final ITextComponent title) {
        super(interfaceContainer, playerInventory, title);
        this.tileentity = interfaceContainer.tileentity;
        this.player = playerInventory;
    }

    @Override
    public void render(final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tn = this.tileentity.getDisplayName().getUnformattedComponentText();

        this.font.drawString(tn, (this.xSize / 2.f - this.font.getStringWidth(tn) / 2.f), 5, 4210752);
        this.font.drawString(this.player.getDisplayName().getUnformattedComponentText(), 122, this.ySize - 96 + 2, 4210752);

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.blendColor(1.0f, 1.0f, 1.0f, 1.f);
        this.minecraft.getTextureManager().bindTexture(TEX);
        this.blit(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        if (InfusingChamberTileEntity.isBurning(tileentity)) {
            int k = this.getBurnLeftSDca(13);
            this.blit(this.guiLeft + 57, this.guiTop + 38 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.progess(59);
        this.blit(this.guiLeft + 98, this.guiTop + 57 + 12 - l, 176, 91 - l, 59, l + 1);
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
