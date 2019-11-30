package com.Ultra_Nerd.CodeLyokoRemake.Util.handlers;

import com.Ultra_Nerd.CodeLyokoRemake.Util.ref;
import com.mojang.authlib.GameProfile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSoundMinecartRiding;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

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
