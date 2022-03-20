package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
public class KeyBoardAccess {

    private static final long MINECRAFT = Minecraft.getInstance().keyboardHandler;


    public static boolean shift() {
        return InputMappings.isKeyDown(MINECRAFT, GLFW.GLFW_KEY_LEFT_SHIFT) || InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_RIGHT_SHIFT);
    }

    public static boolean w() {
        return InputMappings.isKeyDown(MINECRAFT, GLFW.GLFW_KEY_W);
    }

    public static boolean S() {
        return InputMappings.isKeyDown(MINECRAFT, GLFW.GLFW_KEY_S);
    }

    public static boolean Q() {
        return InputMappings.isKeyDown(MINECRAFT, GLFW.GLFW_KEY_Q);
    }

    public static boolean Z() {
        return InputMappings.isKeyDown(MINECRAFT, GLFW.GLFW_KEY_Z);
    }
}
