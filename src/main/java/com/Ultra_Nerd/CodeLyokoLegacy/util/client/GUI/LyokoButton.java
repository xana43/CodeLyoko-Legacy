package com.Ultra_Nerd.CodeLyokoLegacy.util.client.GUI;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
@Environment(EnvType.CLIENT)
public class LyokoButton extends ButtonWidget {
    private final SoundEvent downSound;

    public LyokoButton(final int x, final int y, final int width, final int height, final Text message,
            final PressAction onPress, final NarrationSupplier tooltipSupplier, final SoundEvent downSound) {
        super(x, y, width, height, message, onPress, tooltipSupplier);
        this.downSound = downSound;
    }
    public LyokoButton(final int x, final int y, final int width, final int height, final Text message,
            final PressAction onPress, final SoundEvent downSound) {
        super(x, y, width, height, message, onPress, textSupplier -> null);
        this.downSound = downSound;
    }
    public LyokoButton(final int x, final int y, final int width, final int height, final Text message,
            final PressAction onPress, final NarrationSupplier tooltipSupplier) {
        super(x, y, width, height, message, onPress, tooltipSupplier);
        this.downSound = SoundEvents.UI_BUTTON_CLICK.value();
    }
    public LyokoButton(final int x, final int y, final int width, final int height, final Text message,
            final PressAction onPress) {
        super(x, y, width, height, message, onPress, textSupplier -> null);
        this.downSound = SoundEvents.UI_BUTTON_CLICK.value();
    }
    public LyokoButton(final Screen currentScreen,final int width,final int height,final Text message,
            final PressAction onPress,final NarrationSupplier narrationSupplier,final SoundEvent downSound)
    {
        super((currentScreen.width >> 1) - (width >> 1),(currentScreen.height >> 1) - (height >> 1),width,height,
                message,onPress,narrationSupplier);
        this.downSound = downSound;
    }
    public LyokoButton(final Screen currentScreen,final int width,final int height,final Text message,
            final PressAction onPress,final NarrationSupplier narrationSupplier)
    {
        super((currentScreen.width >> 1) - (width >> 1),(currentScreen.height >> 1) - (height >> 1),width,height,
                message,onPress,narrationSupplier);
        this.downSound = SoundEvents.UI_BUTTON_CLICK.value();
    }
    public LyokoButton(final Screen currentScreen,final int width,final int height,final Text message,
            final PressAction onPress)
    {
        super((currentScreen.width >> 1) - (width >> 1),(currentScreen.height >> 1) - (height >> 1),width,height,
                message,onPress,textSupplier -> null);
        this.downSound = SoundEvents.UI_BUTTON_CLICK.value();
    }



    public void setOffset(final int x, final int y)
    {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

    public void setPosition(final int x, final int y)
    {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void playDownSound(final SoundManager soundManager) {
        soundManager.play(PositionedSoundInstance.master(downSound, 1.0F));
    }
}
