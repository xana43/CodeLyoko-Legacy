package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientScreenEventSubscriber {

/*
    @SubscribeEvent
    public static void NoE(final ScreenEvent event) {
        KeyboardHandler handler = event.getScreen().getMinecraft().keyboardHandler;
        if (event.getScreen(). == GLFW.GLFW_KEY_E) {
            if (event.getScreen() instanceof TowerGUI) {
                event.setCanceled(true);
            }
        }
    }

 */
/*
    @SubscribeEvent
    public static void CustomMainMenu(final ScreenOpenEvent event) {
        if (event.getScreen() instanceof TitleScreen) {
            event.setScreen(new CustomMenuScreen(true));
            //event.setCanceled(true);
        }
    }

 */
}
