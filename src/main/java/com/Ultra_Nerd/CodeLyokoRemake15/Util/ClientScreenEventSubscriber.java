package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.DimensionCheck;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.CustomMenuScreen;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.Devirtualized;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.TowerGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.client.event.ScreenOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientScreenEventSubscriber {


    @SubscribeEvent
    public static void NoE(final ScreenEvent.KeyboardKeyEvent event) {

        if (event.getKeyCode() == GLFW.GLFW_KEY_E) {

            if (event.getScreen() instanceof TowerGUI) {
                event.setCanceled(true);
            }
        }
    }



    @SubscribeEvent
    public static void CustomMenus(final ScreenOpenEvent event) {
        if (event.getScreen() instanceof TitleScreen) {
            event.setScreen(new CustomMenuScreen(true));


        }
        if(event.getScreen() instanceof DeathScreen && Minecraft.getInstance().level != null)
        {
            if(DimensionCheck.worldIsNotVanilla(Minecraft.getInstance().level))
            {
                event.setScreen(new Devirtualized(null,Minecraft.getInstance().level.getLevelData().isHardcore()));
            }

        }
    }


}
