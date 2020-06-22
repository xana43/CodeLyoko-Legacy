package com.Ultra_Nerd.CodeLyokoRemake.Util.handlers;



import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class music extends MusicTicker
{
	
	public music(Minecraft mcIn) {
		super(mcIn);
		// TODO Auto-generated constructor stub
	}
	private static int TimeTilLopp;
	private static SoundHandler MC = Minecraft.getMinecraft().getSoundHandler();
	private static boolean Playing = false;
	
	
	
	@Override
	public void playMusic(MusicType requestedMusicType) {
		// TODO Auto-generated method stub
		super.playMusic(requestedMusicType);
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void InDim(TickEvent.PlayerTickEvent tcik)
	{
		int tick = 0;
		
		EntityPlayer play = (EntityPlayer)tcik.player;
		if(!Playing)
		{
			
			
			if(play.dimension == Conf.Dim)
			{
				tick = 4224;
				MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_GAME));
				MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_CREATIVE));
				MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_NETHER));
				MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_MENU));
				MC.playDelayedSound(PositionedSoundRecord.getMusicRecord(Souinds.FOREST), 10);
				Playing = true;
			}
			else if(play.dimension == Conf.Dim2)
			{
				tick = 2944;
				MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_GAME));
				MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_CREATIVE));
				MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_NETHER));
				MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_MENU));
				
				MC.playDelayedSound(PositionedSoundRecord.getMusicRecord(Souinds.ICE), 10);
				Playing = true;
			}
			
			
			
		}
		if(Playing)
		{
			tick--;
		}
		if(MC.isSoundPlaying(PositionedSoundRecord.getMusicRecord(Souinds.FOREST)) && tick == 0)
		{
			MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_GAME));
			MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_CREATIVE));
			MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_NETHER));
			MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_MENU));
			MC.stopSound(PositionedSoundRecord.getMusicRecord(Souinds.FOREST));
			tick = 4224;
			Playing = false;
			
		}
		else if(MC.isSoundPlaying(PositionedSoundRecord.getMusicRecord(Souinds.ICE)) && tick == 0)
		{
			MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_GAME));
			MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_CREATIVE));
			MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_NETHER));
			MC.stopSound(PositionedSoundRecord.getMusicRecord(SoundEvents.MUSIC_MENU));
			MC.stopSound(PositionedSoundRecord.getMusicRecord(Souinds.ICE));
			tick = 2940;
			Playing = false;
			
		}
		
	}
	
}