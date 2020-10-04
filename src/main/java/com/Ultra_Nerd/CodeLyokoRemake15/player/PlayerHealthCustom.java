package com.Ultra_Nerd.CodeLyokoRemake15.player;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage.Sector5Dimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DesertSector.DesertDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean.OceanDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector.IceDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.MountainSector.MountainDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.VolcanoSector.VolcanoDimension;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
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
    private static int Prevfood;
    private static float PrevSaturation;
    private static final ResourceLocation HEALTH_TEX = new ResourceLocation(Base.MOD_ID,"textures/gui/lyoko_health_bar.png");
    private static boolean once = false;
    public PlayerHealthCustom()
    {
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
    public static void removehunger(final PlayerEvent event)
    {
        if(event.getPlayer().world.dimension instanceof ForestDimension
                ||event.getPlayer().world.dimension instanceof VolcanoDimension || event.getPlayer().world.dimension instanceof Sector5Dimension
                ||event.getPlayer().world.dimension instanceof MountainDimension
                || event.getPlayer().world.dimension instanceof IceDimension || event.getPlayer().world.dimension instanceof DesertDimension
                || event.getPlayer().world.dimension instanceof OceanDimension) {
            event.getPlayer().getFoodStats().setFoodLevel(20);
            event.getPlayer().getFoodStats().setFoodSaturationLevel(20);
            Base.Log.info("true");
            once = false;
        }
        else if (!once)
        {

            event.getPlayer().getFoodStats().setFoodSaturationLevel(PrevSaturation);
            event.getPlayer().getFoodStats().setFoodLevel(Prevfood);

            once = true;
        }
        else
        {
            PrevSaturation = event.getPlayer().getFoodStats().getSaturationLevel();
            Prevfood = event.getPlayer().getFoodStats().getFoodLevel();
        }

    }

    @SubscribeEvent
    public static void PlayerHealthRender(final RenderGameOverlayEvent renderEvent)
    {


        if(renderEvent.getType() == RenderGameOverlayEvent.ElementType.HEALTH &&(Minecraft.getInstance().player.world.dimension instanceof ForestDimension
                ||Minecraft.getInstance().player.world.dimension instanceof VolcanoDimension || Minecraft.getInstance().player.world.dimension instanceof Sector5Dimension
                || Minecraft.getInstance().player.world.dimension instanceof MountainDimension
                || Minecraft.getInstance().player.world.dimension instanceof IceDimension || Minecraft.getInstance().player.world.dimension instanceof DesertDimension
                || Minecraft.getInstance().player.world.dimension instanceof OceanDimension))
        {
            int scaleW = renderEvent.getWindow().getScaledWidth();
            int scaleH = renderEvent.getWindow().getHeight();
            renderEvent.setCanceled(true);
            GL11.glPushMatrix();
            Minecraft.getInstance().getTextureManager().bindTexture(HEALTH_TEX);
            Minecraft.getInstance().ingameGUI.blit(6, 1,0, 0,33,254);
            Minecraft.getInstance().ingameGUI.blit(12, scaleH / scaleH,62, 0,25, (int) ((12.7) * Minecraft.getInstance().player.getHealth()));
            GL11.glPopMatrix();

        }
        if(renderEvent.getType() == RenderGameOverlayEvent.ElementType.FOOD&&(Minecraft.getInstance().player.world.dimension instanceof ForestDimension
                ||Minecraft.getInstance().player.world.dimension instanceof VolcanoDimension || Minecraft.getInstance().player.world.dimension instanceof Sector5Dimension
                || Minecraft.getInstance().player.world.dimension instanceof MountainDimension
                || Minecraft.getInstance().player.world.dimension instanceof IceDimension || Minecraft.getInstance().player.world.dimension instanceof DesertDimension
                || Minecraft.getInstance().player.world.dimension instanceof OceanDimension))
        {
            renderEvent.setCanceled(true);
        }
        if(renderEvent.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE&&(Minecraft.getInstance().player.world.dimension instanceof ForestDimension
                ||Minecraft.getInstance().player.world.dimension instanceof VolcanoDimension || Minecraft.getInstance().player.world.dimension instanceof Sector5Dimension
                || Minecraft.getInstance().player.world.dimension instanceof MountainDimension
                || Minecraft.getInstance().player.world.dimension instanceof IceDimension || Minecraft.getInstance().player.world.dimension instanceof DesertDimension
                || Minecraft.getInstance().player.world.dimension instanceof OceanDimension))
        {
            renderEvent.setCanceled(true);
        }

    }


}
