package com.Ultra_Nerd.CodeLyokoRemake15.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

public class KeyBoardAccess {
    private static final long MINECRAFT = Minecraft.getInstance().getMainWindow().getHandle();
    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingE()
    {
        return InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(),GLFW.GLFW_KEY_E);
    }
}
