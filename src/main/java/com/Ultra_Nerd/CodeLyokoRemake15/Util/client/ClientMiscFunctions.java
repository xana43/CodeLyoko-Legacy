package com.Ultra_Nerd.CodeLyokoRemake15.Util.client;

import com.Ultra_Nerd.CodeLyokoRemake15.screens.ClientScreens.ClassScreen;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.ClientScreens.LaptopGUI;
import com.Ultra_Nerd.CodeLyokoRemake15.screens.ClientScreens.StoryBookGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.TextComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClientMiscFunctions {

    public enum Screens {

        LAPTOP,
        CLASS
    }
    public static @NotNull Runnable runnableScreen(final FormattedText[] texts, final int length)
    {
        return () -> Minecraft.getInstance().setScreen(new StoryBookGUI(texts,length));
    }
    public static @Nullable Runnable runnableScreen(final TextComponent name, @NotNull Screens type)
    {
        switch (type)
        {
            case LAPTOP -> {
                return () -> Minecraft.getInstance().setScreen(new LaptopGUI(name));
            }
            case CLASS -> {
                return () -> Minecraft.getInstance().setScreen(new ClassScreen(name));
            }
            default -> {
                return null;
            }
        }

    }

}
