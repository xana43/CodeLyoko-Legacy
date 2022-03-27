package com.Ultra_Nerd.CodeLyokoRemake15.Util;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEventSubscriber {

    private static final int[] timer = new int[]{131000, 140000, 103000, 144000, 0, 0, 0};
/*

    @SubscribeEvent
    public static void PlayerJoinMusic(final EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.world.dimension instanceof ForestDimension && Minecraft.getInstance().player != null) {
                timer[0] = 0;
            } else if (player.level.dimension() instanceof IceDimension && Minecraft.getInstance().player != null) {
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

        if (event.player.getLevel().dimension() instanceof ForestDimension && event.phase == TickEvent.Phase.END) {
            if (timer[0]-- <= 0 && Minecraft.getInstance().player != null) {
                timer[0] = 131000;
                Minecraft.getInstance().player.playSound(ModSounds.FOREST.get(), 1f, 1f);


            }
            Minecraft.getInstance().getMusicManager().stopPlaying();
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

 */
}
