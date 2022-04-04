package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.vehicle.LyokoVehicleEntity;
import com.Ultra_Nerd.CodeLyokoRemake15.Network.Util.CustomControlServerHandler;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
public class LyokoControls {

public static final KeyMapping KEY_MAPPING_VEHICLES_DOWN = new KeyMapping(
        "key."+ CodeLyokoMain.MOD_ID + ".vehicle_down", GLFW.GLFW_KEY_Z,"key.categories." + CodeLyokoMain.MOD_ID);
    public static final KeyMapping KEY_MAPPING_VEHICLES_UP = new KeyMapping(
            "key."+ CodeLyokoMain.MOD_ID + ".vehicle_up", GLFW.GLFW_KEY_V,"key.categories." + CodeLyokoMain.MOD_ID);
    public static void customInput(InputEvent.KeyInputEvent event)
    {
        if(Minecraft.getInstance().player != null && Minecraft.getInstance().player.getVehicle() instanceof LyokoVehicleEntity)
        {


            CustomControlServerHandler.syncToServer(
                    event.getKey() == KEY_MAPPING_VEHICLES_UP.getKey().getValue() ? event.getAction(): 2,
                    event.getKey() == KEY_MAPPING_VEHICLES_DOWN.getKey().getValue() ? event.getAction() : 2

            );
        }
    }

}
