package com.Ultra_Nerd.CodeLyokoRemake15.screens;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.containers.ContainerElectricInfusing;
import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.ElectricInfusingChamberTileEntity;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ElectricInfusingChamberScreen extends ContainerScreen<ContainerElectricInfusing> {
	
	private static final ResourceLocation TEX = new ResourceLocation(Base.MOD_ID + ":textures/gui/FlourideInfuser.png" );
	private PlayerInventory player;
	private ElectricInfusingChamberTileEntity tileentity;

	public ElectricInfusingChamberScreen(final ContainerElectricInfusing interfaceContainer, final PlayerInventory playerInventory, final ITextComponent title, final ElectricInfusingChamberTileEntity tileentity) {
		this(interfaceContainer, playerInventory, title);
		this.player = playerInventory;
		this.tileentity = tileentity;
	}

	public ElectricInfusingChamberScreen(final ContainerElectricInfusing interfaceContainer, final PlayerInventory playerInventory, final ITextComponent title) {
		super(interfaceContainer, playerInventory, title);

	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String tn = this.tileentity.getDisplayName().getUnformattedComponentText();
		
	this.font.drawString(tn, (this.xSize / 2 - this.font.getStringWidth(tn) / 2), 5, 4210752);
	this.font.drawString(this.player.getDisplayName().getUnformattedComponentText(), 122, this.ySize - 96 + 2, 4210752);
	this.font.drawString(Integer.toString(this.tileentity.getENER()), 100, 72, 4210752);
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.blendColor(1.0f, 1.0f, 1.0f,1.f);
		this.minecraft.getTextureManager().bindTexture(TEX);
		this.blit(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		
		int l = this.progess(10);
		this.blit(this.guiLeft + 98, this.guiTop + 57 + 12 - l, 176, 91 - l, 59, l + 1);
		
		int k = this.getEnergyStoredScaled(75);
		this.blit(this.guiLeft + 152, this.guiTop + 7, 300, 32, 16, 76 - k);
		
	}
	
	
	private int getEnergyStoredScaled(int pixels)
	{
		int i = this.tileentity.getENER();
		int j = this.tileentity.maxenergy();
		return i != 0 && j != 0 ? i * pixels / j : 0; 
	}
	private int progess(int pixels)
	{
		int i = this.tileentity.getField(1);
		return i != 0 ? i * pixels / 25 : 0;
	}
	
}
