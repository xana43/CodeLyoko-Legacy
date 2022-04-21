package com.Ultra_Nerd.CodeLyokoLegacy.Util;

public record LyokoControls() {
    /*
    private static final String lyokoCategory = "key.categories." + CodeLyokoMain.MOD_ID;
    public static final KeyMapping KEY_MAPPING_VEHICLES_DOWN = new KeyMapping(
        "key."+ CodeLyokoMain.MOD_ID + ".vehicle_down", GLFW.GLFW_KEY_Z,lyokoCategory);
    public static final KeyMapping KEY_MAPPING_VEHICLES_UP = new KeyMapping(
            "key."+ CodeLyokoMain.MOD_ID + ".vehicle_up", GLFW.GLFW_KEY_V,lyokoCategory);
    public static final KeyMapping KEY_MAPPING_CLASS_SELECT = new KeyMapping(
            "key." + CodeLyokoMain.MOD_ID + ".class_selct",GLFW.GLFW_KEY_KP_ENTER,lyokoCategory);
    public static void customInput(InputEvent.@NotNull KeyInputEvent event)
    {
        if(Minecraft.getInstance().player != null)
        {
            if(Minecraft.getInstance().player.getVehicle() instanceof LyokoVehicleEntity) {


                CustomControlServerHandler.syncToServer(
                        event.getKey() == KEY_MAPPING_VEHICLES_UP.getKey().getValue() ? event.getAction() : 0,
                        event.getKey() == KEY_MAPPING_VEHICLES_DOWN.getKey().getValue() ? event.getAction() : 0
                );
            }
            if(event.getKey() == KEY_MAPPING_CLASS_SELECT.getKey().getValue() && Minecraft.getInstance().player.level.isClientSide)
            {
                if(event.getAction() == 1)
                {
                    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientMiscFunctions.runnableScreen(ConstantUtil.EMPTY_TEXT_COMPONENT, ClientMiscFunctions.Screens.CLASS));
                }
            }
        }
    }

     */

}
