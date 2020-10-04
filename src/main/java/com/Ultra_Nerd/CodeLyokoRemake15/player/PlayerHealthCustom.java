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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.opengl.GL11;
@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerHealthCustom {



    @SubscribeEvent
    public static void PlayerHealthRender(final RenderGameOverlayEvent renderEvent)
    {
        if(renderEvent.getType() == RenderGameOverlayEvent.ElementType.HEALTH &&(Minecraft.getInstance().player.world.dimension instanceof ForestDimension
                ||Minecraft.getInstance().player.world.dimension instanceof VolcanoDimension || Minecraft.getInstance().player.world.dimension instanceof Sector5Dimension
                || Minecraft.getInstance().player.world.dimension instanceof MountainDimension
                || Minecraft.getInstance().player.world.dimension instanceof IceDimension || Minecraft.getInstance().player.world.dimension instanceof DesertDimension
                || Minecraft.getInstance().player.world.dimension instanceof OceanDimension))
        {
            GL11.glPushMatrix();
            Minecraft.getInstance().ingameGUI.drawString(Minecraft.getInstance().fontRenderer,"test",4,4,0xFFFFFF);
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
