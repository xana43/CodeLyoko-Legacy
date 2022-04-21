package com.Ultra_Nerd.CodeLyokoLegacy.Util.client;

public final class ClientMiscFunctions {

    public enum Screens {

        LAPTOP,
        LAPTOP_1,
        CLASS
    }
    /*


    public static @NotNull Runnable runnableScreen(final FormattedText[] texts, final int length)
    {
        return () -> Minecraft.getInstance().setScreen(new StoryBookGUI(texts,length));
    }
    public static @Nullable Runnable runnableScreen(final TextComponent name, @NotNull Screens type)
    {
        switch (type)
        {
            case LAPTOP -> {
                return () -> Minecraft.getInstance().setScreen(new MainLaptopScreen(name));
            }
            case CLASS -> {
                return () -> Minecraft.getInstance().setScreen(new ClassScreen(name));
            }
            case LAPTOP_1 -> {
                return () -> Minecraft.getInstance().setScreen(new MainLaptopScreen(name));
            }
            default -> {
                return null;
            }
        }

    }

     */

}
