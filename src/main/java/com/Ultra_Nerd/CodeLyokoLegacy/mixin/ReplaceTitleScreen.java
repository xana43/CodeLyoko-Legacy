package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.screens.CustomMenuScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.QuickPlay;
import net.minecraft.client.RunArgs;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.realms.RealmsClient;
import net.minecraft.resource.ResourceReload;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class ReplaceTitleScreen {
    @Shadow
    public abstract void setScreen(final Screen screen);
    @Final
    @Shadow
    public GameOptions options;
    @Inject(method = "onInitFinished",at = @At("HEAD"), cancellable = true)
    private void replaceTitleScreen(final RealmsClient realms, final ResourceReload reload, final RunArgs.QuickPlay quickPlay, final CallbackInfo ci)
    {
      ci.cancel();
        if (quickPlay.isEnabled()) {
            QuickPlay.startQuickPlay(MinecraftClient.getInstance(), quickPlay, reload, realms);
        } else if (this.options.onboardAccessibility) {
            this.setScreen(new AccessibilityOnboardingScreen(this.options));
        } else {
            this.setScreen(new CustomMenuScreen(true));
        }
    }
}

