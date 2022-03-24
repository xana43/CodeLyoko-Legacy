package com.Ultra_Nerd.CodeLyokoRemake15.player;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;


//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerHealthCustom {
    private static final ResourceLocation HEALTH_TEX = new ResourceLocation(CodeLyokoMain.MOD_ID, "textures/gui/lyoko_health_bar.png");
    private static int Prevfood;
    private static float PrevSaturation;
    private static boolean once = false;
    private static final Player player = Minecraft.getInstance().player;
    public PlayerHealthCustom() {
        Prevfood = 20;
        PrevSaturation = 20;
    }

    /*
        @SubscribeEvent
        public static void GetFood(final TickEvent.PlayerTickEvent event)
        {
            if(event.phase == TickEvent.Phase.START || event.phase == TickEvent.Phase.END && Minecraft.getInstance().player != null)
            {

                if(Minecraft.getInstance().player.world.dimension instanceof OverworldDimension
                        || Minecraft.getInstance().player.world.dimension instanceof NetherDimension || Minecraft.getInstance().player.world.dimension instanceof EndDimension) {
                    assert Minecraft.getInstance().player != null;
                    Prevfood = Minecraft.getInstance().player.getFoodStats().getFoodLevel();
                    PrevSaturation = Minecraft.getInstance().player.getFoodStats().getSaturationLevel();
                }
            }
        }
    */
/*
    @SubscribeEvent
    public static void removehunger(final PlayerEvent event) {
        if (event.getPlayer() != null) {
            if (DimensionCheck.playerNotInVanillaWorld(event.getPlayer())) {
                event.getPlayer().getFoodData().setFoodLevel(20);
                event.getPlayer().getFoodData().setSaturation(20);
                once = false;
            } else if (!once) {
                event.getPlayer().getFoodData().setSaturation(100);
                event.getPlayer().getFoodData().setFoodLevel(event.getPlayer().getFoodData().getLastFoodLevel());
                once = true;
            }
        }
    }

    @SubscribeEvent
    public static void PlayerHealthRender(final RenderGameOverlayEvent renderEvent) {
        if (renderEvent.getType() == RenderGameOverlayEvent.ElementType.LAYER && DimensionCheck.playerNotInVanillaWorld(player)) {
            int scaleW = renderEvent.getWindow().getGuiScaledWidth();
            int scaleH = renderEvent.getWindow().getHeight();
            renderEvent.setCanceled(true);
            if(!(Minecraft.getInstance().screen instanceof ContainerScreen)) {
                GL11.glPushMatrix();
                Minecraft.getInstance().getTextureManager().bindForSetup(HEALTH_TEX);
                Minecraft.getInstance().gui.blit(new PoseStack(),6, 1, 0, 0, 33, 254);
                Minecraft.getInstance().gui.blit(new PoseStack(),12, scaleH / scaleH, 62, 0, 25, (int) ((12.7) * Minecraft.getInstance().player.getHealth()));
                GL11.glPopMatrix();
            }

        }
        if (renderEvent.getType() == RenderGameOverlayEvent.ElementType.ALL && DimensionCheck.playerNotInVanillaWorld(player)) {
            renderEvent.setCanceled(true);
        }
        if (renderEvent.getType() == RenderGameOverlayEvent.ElementType.ALL && DimensionCheck.playerNotInVanillaWorld(player)) {
            renderEvent.setCanceled(true);
        }

    }

 */


}
