package com.Ultra_Nerd.CodeLyokoRemake.Blocks.machine.flouride;

import com.Ultra_Nerd.CodeLyokoRemake.Blocks.tileentity.TileEntityElectricInfusingChamber;
import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class electricgui extends GuiContainer {
	
	private static final ResourceLocation TEX = new ResourceLocation(ref.MOD_ID + ":textures/gui/FlourideInfuser.png" );
	private final InventoryPlayer player;
	private final TileEntityElectricInfusingChamber tileentity;
	
	public electricgui(InventoryPlayer player, TileEntityElectricInfusingChamber tileentity )
	{
		super(new containerelectricinfusing(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
		
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String tn = this.tileentity.getDisplayName().getUnformattedText();
		
	this.fontRenderer.drawString(tn, (this.xSize / 2 - this.fontRenderer.getStringWidth(tn) / 2), 5, 4210752);
	this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, 4210752);
	this.fontRenderer.drawString(Integer.toString(this.tileentity.getENER()), 100, 72, 4210752);
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEX);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		
		int l = this.progess(10);
		this.drawTexturedModalRect(this.guiLeft + 98, this.guiTop + 57 + 12 - l, 176, 91 - l, 59, l + 1);
		
		int k = this.getEnergyStoredScaled(75);
		this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 7, 300, 32, 16, 76 - k);
		
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
