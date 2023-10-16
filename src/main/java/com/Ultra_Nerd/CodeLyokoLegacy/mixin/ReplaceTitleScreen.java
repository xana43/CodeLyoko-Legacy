package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MinecraftClient.class)
public abstract class ReplaceTitleScreen {
    @Shadow
    public abstract void setScreen(final Screen screen);

    @Shadow @Final public GameOptions options;




}

