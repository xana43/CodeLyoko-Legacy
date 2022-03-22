package com.Ultra_Nerd.CodeLyokoRemake15.player;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.DimensionCheck;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.opengl.GL11;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerHealthCustom {
    private static final ResourceLocation HEALTH_TEX = new ResourceLocation(Base.MOD_ID, "textures/gui/lyoko_health_bar.png");
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

    @SubscribeEvent
    public static void removehunger(final PlayerEvent event) {
        if (event.getPlayer() != null) {
            if (event.getPlayer().level.dimension() != Level.END && event.getPlayer().level.dimension() != Level.NETHER && event.getPlayer().level.dimension() != Level.OVERWORLD) {
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


}
