package com.Ultra_Nerd.CodeLyokoLegacy.Util;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class ClientScreenEventSubscriber {
/*
    @SubscribeEvent
    public static void test(ScreenEvent.InitScreenEvent.@NotNull Post event)
    {

        if(event.getScreen() instanceof SoundOptionsScreen)
        {

            event.getScreen().renderables.add(new ImageButton((event.getScreen().width >> 1) + 30 ,(event.getScreen().height  >> 1) + 10 ,30,20,10,(event.getScreen().width >> 1),(event.getScreen().height >> 1),CodeLyokoMain.CodeLyokoPrefix("textures/gui/reactor.png"), 10,10, (input) -> CodeLyokoMain.Log.info("press"),new TextComponent("test")));
        }
    }
    @SubscribeEvent
    public static void ScreenControlGait(final ScreenEvent.@NotNull KeyboardKeyEvent event) {

        if (event.getKeyCode() == GLFW.GLFW_KEY_E) {

            if (event.getScreen() instanceof TowerGUI) {
                event.setCanceled(true);
            }
        }
        if(event.getKeyCode() == LyokoControls.KEY_MAPPING_CLASS_SELECT.getKey().getValue())
        {
            if(event.getScreen() instanceof ChatScreen)
            {

                event.setCanceled(true);
            }
        }
    }



    @SubscribeEvent
    public static void CustomMenus(final @NotNull ScreenOpenEvent event) {
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

 */


}
