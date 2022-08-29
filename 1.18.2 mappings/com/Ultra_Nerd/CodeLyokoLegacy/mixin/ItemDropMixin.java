package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyBinding.class)
public abstract class ItemDropMixin {
    @Inject(method ="onKeyPressed",at = @At("HEAD"),cancellable = true)
    private static void stopDrop(final CallbackInfo ci)
    {
        final MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player != null) {
            if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(mc.player)) {
                if(mc.options.dropKey.isPressed())
                {

                    ci.cancel();

                }


            }
        }
    }





}
