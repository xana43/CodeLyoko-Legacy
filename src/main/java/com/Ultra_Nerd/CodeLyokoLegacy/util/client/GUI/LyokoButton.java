package com.Ultra_Nerd.CodeLyokoLegacy.util.client.GUI;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;

public class LyokoButton extends ButtonWidget {
    private final SoundEvent downSound;

    public LyokoButton(final int x, final int y, final int width, final int height, final Text message,
            final PressAction onPress, final TooltipSupplier tooltipSupplier, final SoundEvent downSound) {
        super(x, y, width, height, message, onPress, tooltipSupplier);
        this.downSound = downSound;
    }
    public LyokoButton(final int x, final int y, final int width, final int height, final Text message,
            final PressAction onPress,final SoundEvent downSound) {
        super(x, y, width, height, message, onPress);
        this.downSound = downSound;
    }
    public LyokoButton(final int x, final int y, final int width, final int height, final Text message,
            final PressAction onPress, final TooltipSupplier tooltipSupplier) {
        super(x, y, width, height, message, onPress, tooltipSupplier);
        this.downSound = SoundEvents.UI_BUTTON_CLICK;
    }
    public LyokoButton(final int x, final int y, final int width, final int height, final Text message,
            final PressAction onPress) {
        super(x, y, width, height, message, onPress);
        this.downSound = SoundEvents.UI_BUTTON_CLICK;
    }
    public LyokoButton(final Screen currentScreen,final int width,final int height,final Text message,
            final PressAction onPress,SoundEvent downSound)
    {
        super((currentScreen.width >> 1) - (width >> 1),(currentScreen.height >> 1) - (height >> 1),width,height,message,onPress);
        this.downSound = downSound;
    }
    public LyokoButton(final Screen currentScreen,final int width,final int height,final Text message,
            final PressAction onPress)
    {
        super((currentScreen.width >> 1) - (width >> 1),(currentScreen.height >> 1) - (height >> 1),width,height,message,onPress);
        this.downSound = SoundEvents.UI_BUTTON_CLICK;
    }



    public void setOffset(final int x, final int y)
    {
        this.x += x;
        this.y += y;
    }

    public void setPosition(final int x, final int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public void playDownSound(final SoundManager soundManager) {
        soundManager.play(PositionedSoundInstance.master(downSound, 1.0F));
    }
}
