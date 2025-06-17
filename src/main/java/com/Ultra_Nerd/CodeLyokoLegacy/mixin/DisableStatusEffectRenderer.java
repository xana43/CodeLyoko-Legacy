package com.Ultra_Nerd.CodeLyokoLegacy.mixin;


import com.Ultra_Nerd.CodeLyokoLegacy.Util.MixinHooks;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("MethodMayBeStatic")
@Mixin(InventoryScreen.class)
public abstract class DisableStatusEffectRenderer {

    @Inject(method = "shouldHideStatusEffectHud", at = @At("HEAD"), cancellable = true)
    private void codelyoko$disableStatusRenderer(CallbackInfoReturnable<Boolean> cir) {
        MixinHooks.disableStatusEffectsRenderInLyoko(cir);
    }
}
