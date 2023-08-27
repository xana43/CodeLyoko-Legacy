package com.Ultra_Nerd.CodeLyokoLegacy.util;

import com.Ultra_Nerd.CodeLyokoLegacy.screens.CustomMenuScreen;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.event.PlaceBlockEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.QuickPlay;
import net.minecraft.client.RunArgs;
import net.minecraft.client.gui.screen.AccessibilityOnboardingScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.realms.RealmsClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.resource.ResourceReload;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public record MixinHooks() {

    public static void LyokoBlockPlacer(final World world, final BlockPos pos,@Nullable final LivingEntity placer, final CallbackInfo ci)
    {
        final ActionResult result = PlaceBlockEvent.EVENT.invoker().onPlace(placer, world, pos);
        if (result == ActionResult.FAIL) {
            ci.cancel();
        }
    }

    public static void disableStatusEffectsRenderInLyoko(
            final CallbackInfo ci)
    {
        final MinecraftClient mc = MinecraftClient.getInstance();
        if (mc != null) {
            if (mc.player != null) {
                if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(mc.player)) {
                    ci.cancel();

                }
            }
        }
    }

    public static void cancelPlayerEvents(final MinecraftClient client,final CallbackInfo ci)
    {
        if (client.player != null) {
            if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(client.player)) {
                ci.cancel();
            }
        }
    }

    public static void replaceTitleScreen(final RealmsClient realms, final ResourceReload reload,
            final RunArgs.QuickPlay quickPlay, final CallbackInfo ci,final GameOptions options,
            final MinecraftClient client)
    {
        ci.cancel();
        if (quickPlay.isEnabled()) {
            QuickPlay.startQuickPlay(MinecraftClient.getInstance(), quickPlay, reload, realms);
        } else if (options.onboardAccessibility) {
            client.setScreen(new AccessibilityOnboardingScreen(options));
        } else {
            client.setScreen(new CustomMenuScreen(true));
        }
    }

}
