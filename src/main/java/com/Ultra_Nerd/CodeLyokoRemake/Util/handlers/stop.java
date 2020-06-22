package com.Ultra_Nerd.CodeLyokoRemake.Util.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class stop {
	@SubscribeEvent
	public void PlayerDied(LivingEvent event, EntityPlayer playerIn)
	{
		if(playerIn.isDead)
		{
			Minecraft.getMinecraft().getSoundHandler().stopSound(PositionedSoundRecord.getMusicRecord(Souinds.THEME));
		}
	}
	
	
	
}
