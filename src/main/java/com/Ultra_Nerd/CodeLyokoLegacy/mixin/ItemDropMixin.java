package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MixinHooks;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyBinding.class)
public abstract class ItemDropMixin {
    @Inject(method = "onKeyPressed", at = @At("HEAD"), cancellable = true)
    private static void codelyoko$stopDrop(final CallbackInfo ci) {
        MixinHooks.PlayerEvents.cancelOnKeyPressed(ci);

    }


}
