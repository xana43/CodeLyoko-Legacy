package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage.Sector5Dimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean.OceanDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector.IceDimension;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEventSubscriber {

    private static final int[] timer = new int[]{131000, 140000, 103000, 144000, 0, 0, 0};


    @SubscribeEvent
    public static void PlayerJoinMusic(final EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if (player.world.dimension instanceof ForestDimension && Minecraft.getInstance().player != null) {
                timer[0] = 0;
            } else if (player.world.dimension instanceof IceDimension && Minecraft.getInstance().player != null) {
                timer[1] = 0;
            } else if (player.world.dimension instanceof OceanDimension && Minecraft.getInstance().player != null) {
                timer[2] = 0;
            } else if (player.world.dimension instanceof Sector5Dimension && Minecraft.getInstance().player != null) {
                timer[3] = 0;
            } else if (player.world.dimension instanceof OverworldDimension && Minecraft.getInstance().player != null) {
                Minecraft.getInstance().getMusicTicker().tick();
            }
        }
    }

    @SubscribeEvent
    public static void PlayerDimension(final TickEvent.PlayerTickEvent event) {

        if (event.player.world.dimension instanceof ForestDimension && event.phase == TickEvent.Phase.END) {
            if (timer[0]-- <= 0 && Minecraft.getInstance().player != null) {
                timer[0] = 131000;
                Minecraft.getInstance().player.playSound(ModSounds.FOREST.get(), 1f, 1f);


            }
            Minecraft.getInstance().getMusicTicker().stop();
        } else if (!(event.player.world.dimension instanceof ForestDimension) && Minecraft.getInstance().player != null) {
            timer[0] = 131000;

            Minecraft.getInstance().player.playSound(null, 0, 0);
        }
        if (event.player.world.dimension instanceof IceDimension) {
            if (event.phase == TickEvent.Phase.END) {
                if (timer[1]-- <= 0 && Minecraft.getInstance().player != null) {
                    timer[1] = 3240;
                    Minecraft.getInstance().player.playSound(ModSounds.ICE.get(), 1f, 1f);

                }
            }
            Minecraft.getInstance().getMusicTicker().stop();
        } else if (!(event.player.world.dimension instanceof IceDimension) && Minecraft.getInstance().player != null) {

            timer[1] = 3240;

            Minecraft.getInstance().player.playSound(null, 0, 0);
            Minecraft.getInstance().getMusicTicker().tick();
        }
        if (event.player.world.dimension instanceof OceanDimension && event.phase == TickEvent.Phase.END) {
            if (timer[2]-- <= 0 && Minecraft.getInstance().player != null) {

                timer[2] = 103000;

                Minecraft.getInstance().player.playSound(ModSounds.OCEAN.get(), 1f, 1f);


            }
            Minecraft.getInstance().getMusicTicker().stop();
        } else if (!(event.player.world.dimension instanceof OceanDimension) && Minecraft.getInstance().player != null) {
            timer[2] = 103000;

            Minecraft.getInstance().player.playSound(null, 0, 0);
            Minecraft.getInstance().getMusicTicker().tick();
        }
        if (event.player.world.dimension instanceof Sector5Dimension && event.phase == TickEvent.Phase.END) {
            if (timer[3]-- <= 0 && Minecraft.getInstance().player != null) {

                timer[3] = 144000;
                Minecraft.getInstance().player.playSound(ModSounds.SECTOR5.get(), 1, 1);


            }
            Minecraft.getInstance().getMusicTicker().stop();
        } else if (!(event.player.world.dimension instanceof Sector5Dimension) && Minecraft.getInstance().player != null) {
            timer[3] = 144000;
            Minecraft.getInstance().player.playSound(null, 0, 0);
            Minecraft.getInstance().getMusicTicker().tick();
        }

    }
}
