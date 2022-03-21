package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ContainerElectroplate;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ElectroplatingTileEntity;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ElectroplatingScreen extends ContainerScreen<ContainerElectroplate> {
    private static final ResourceLocation TEX = new ResourceLocation(Base.MOD_ID + ":textures/gui/electroplating_screen.png");
    private PlayerInventory player;
    private ElectroplatingTileEntity tileEntity;

    public ElectroplatingScreen(final ContainerElectroplate containerElectroplate, final PlayerInventory playerInventory, final ITextComponent title, final ElectroplatingTileEntity tileentity) {
        this(containerElectroplate, playerInventory, title);
        this.player = playerInventory;
        this.tileEntity = tileentity;
    }

    public ElectroplatingScreen(final ContainerElectroplate containerElectroplate, final PlayerInventory playerInventory, final ITextComponent title) {
        super(containerElectroplate, playerInventory, title);
        this.tileEntity = containerElectroplate.getTileEntity();
        this.player = playerInventory;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tn = this.tileEntity.getDisplayName().getUnformattedComponentText();
        this.font.drawString(tn, (this.xSize / 2.f - this.font.getStringWidth(tn) / 2.f), 5, 4210752);
        this.font.drawString(this.player.getDisplayName().getUnformattedComponentText(), 122, this.ySize - 96 + 2, 4210752);
        //this.font.drawString(Integer.toString(this.tileEntity.getENER()), 100, 72, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.blendColor(1.0f, 1.0f, 1.0f, 1.f);
        this.minecraft.getTextureManager().bindTexture(TEX);
        this.blit(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

    }

}
