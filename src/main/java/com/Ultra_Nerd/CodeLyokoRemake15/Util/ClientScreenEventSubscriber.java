package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.TowerGUI;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = Base.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientScreenEventSubscriber {



    @SubscribeEvent
    public static void NoE(final GuiScreenEvent.KeyboardKeyEvent event)
    {
        if(event.getKeyCode() == GLFW.GLFW_KEY_E)
        {
            if(event.getGui() instanceof TowerGUI)
            {
                event.setCanceled(true);
            }
        }
    }
}
