package com.Ultra_Nerd.CodeLyokoRemake15.screens;


import com.Ultra_Nerd.CodeLyokoRemake15.tileentity.InterfaceTileEntity;
import org.lwjgl.opengl.GL11;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.ref;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class TowerGUI extends GuiScreen
{
	private static final ResourceLocation TEXTURES = new ResourceLocation(ref.MOD_ID + ":textures/gui/tower.png");
	
	private InterfaceTileEntity tileentity;
	private final int sizeX = 512, sizeY = 256;
	int posX,posY;
	
	public TowerGUI(InterfaceTileEntity tileentity)
	{
		
	
		this.tileentity = tileentity;
	}
	
	public void initGui() 
	{
		// TODO Auto-generated method stub
		this.buttonList.clear();
		posX = (this.width - sizeX) / 2;
		posY = (this.height - sizeY)/ 2;
		this.buttonList.add(new GuiButton(0,posX + 4, posY + 4, 20,20, "test"));
		
	}
	
	public void actionPerformced(GuiButton button)
	{
		switch(button.id)
		{
		case 0:
			break;
		}
		
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		// TODO Auto-generated method stub
		drawDefaultBackground();
		GL11.glColor4f(0, 0, 255, 1);
		this.mc.renderEngine.bindTexture(TEXTURES);
		int posX = (this.width - sizeX)  / 2;
		int posY = (this.height - sizeY) / 2;
		drawTexturedModalRect(posX,posY, 0, 0, sizeX,sizeY);
		this.drawString(fontRenderer, "test", posX + 20, posY + 32,4210752);
	}
	
	
}