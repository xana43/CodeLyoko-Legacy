package com.Ultra_Nerd.CodeLyokoRemake15.Blocks.machine.flouride;

import com.Ultra_Nerd.CodeLyokoRemake15.Blocks.tileentity.TileEntityInfusingChamber;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.ref;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class gui extends GuiContainer {
	
	private static final ResourceLocation TEX = new ResourceLocation(ref.MOD_ID + ":textures/gui/FlourideInfuser.png" );
	private final InventoryPlayer player;
	private final TileEntityInfusingChamber tileentity;
	
	public gui(InventoryPlayer player, TileEntityInfusingChamber tileentity )
	{
		super(new containerInfusing(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
		
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String tn = this.tileentity.getDisplayName().getUnformattedText();
		
	this.fontRenderer.drawString(tn, (this.xSize / 2 - this.fontRenderer.getStringWidth(tn) / 2), 5, 4210752);
	this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, 4210752);
	
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEX);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		if(TileEntityInfusingChamber.isBurning(tileentity))
		{
			int k = this.getBurnLeftSDca(13);
			this.drawTexturedModalRect(this.guiLeft + 57, this.guiTop + 38 + 12 - k, 176, 12 - k, 14, k + 1);
		}
		
		int l = this.progess(59);
		this.drawTexturedModalRect(this.guiLeft + 98, this.guiTop + 57 + 12 - l, 176, 91 - l, 59, l + 1);
		// TODO Auto-generated method stub
		
	}
	private int getBurnLeftSDca(int pixels)
	{
		int i = this.tileentity.getField(1);
		if (i== 0) i = 20;
		return this.tileentity.getField(0) * pixels / i;
	}
	
	
	private int progess(int pixels)
	{
		int i = this.tileentity.getField(2);
		int j = this.tileentity.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}
	
}
