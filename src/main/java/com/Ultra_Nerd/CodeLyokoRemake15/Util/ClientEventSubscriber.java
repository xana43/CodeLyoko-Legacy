package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean.OceanDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector.IceDimension;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Base.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEventSubscriber {

    private static int[] timer = new int[] {131000, 140000,103000,0,0,0,0};
    @SubscribeEvent
    public  static void PlayerJoinMusic(final EntityJoinWorldEvent event)
    {
        if(event.getEntity() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity)event.getEntity();
            if(player.world.dimension instanceof ForestDimension && Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.playSound(ModSounds.FOREST.get(),1f,1f);
            }
            else if(player.world.dimension instanceof IceDimension && Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.playSound(ModSounds.ICE.get(),1f,1f);
            }
            else if(player.world.dimension instanceof OceanDimension && Minecraft.getInstance().player != null) {
                Minecraft.getInstance().player.playSound(ModSounds.OCEAN.get(),1f,1f);
            }
        }
    }
    @SubscribeEvent
    public static void PlayerDimension(final TickEvent.PlayerTickEvent event)
    {


        if (event.player.world.dimension instanceof ForestDimension && event.phase == TickEvent.Phase.END) {
            if (timer[0]-- <= 0 && Minecraft.getInstance().player != null) {
                timer[0] = 131000;
                Minecraft.getInstance().player.playSound(ModSounds.FOREST.get(), 1f, 1f);
                Minecraft.getInstance().getMusicTicker().stop();
            }

        }
        else if(!(event.player.world.dimension instanceof ForestDimension) && Minecraft.getInstance().player != null)
        {
            timer[0] = 131000;

            Minecraft.getInstance().player.playSound(null,0,0);
        }
        if (event.player.world.dimension instanceof IceDimension && event.phase == TickEvent.Phase.END) {
            if (timer[1]-- <= 0 && Minecraft.getInstance().player != null) {
                timer[1] = 140000;
                Minecraft.getInstance().player.playSound(ModSounds.ICE.get(), 1f, 1f);
                Minecraft.getInstance().getMusicTicker().stop();
            }

        }
        else if(!(event.player.world.dimension instanceof ForestDimension) && Minecraft.getInstance().player != null)
        {
            timer[1] = 140000;

            Minecraft.getInstance().player.playSound(null,0,0);
        }
        if (event.player.world.dimension instanceof OceanDimension && event.phase == TickEvent.Phase.END) {
            if (timer[2]-- <= 0 && Minecraft.getInstance().player != null) {
                timer[2] = 103000;
                Minecraft.getInstance().player.playSound(ModSounds.OCEAN.get(), 1f, 1f);
                Minecraft.getInstance().getMusicTicker().stop();
            }

        }
        else if(!(event.player.world.dimension instanceof OceanDimension) && Minecraft.getInstance().player != null)
        {
            timer[2] = 103000;

            Minecraft.getInstance().player.playSound(null,0,0);
        }

    }
}