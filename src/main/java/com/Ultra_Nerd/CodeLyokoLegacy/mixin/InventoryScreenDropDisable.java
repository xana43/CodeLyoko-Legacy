package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MixinHooks;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@SuppressWarnings("MethodMayBeStatic")
@Mixin(InventoryScreen.class)
public abstract class InventoryScreenDropDisable {
    @Inject(method = "isClickOutsideBounds", at = @At(value = "HEAD"))
    private void codelyoko$disableDrop(final CallbackInfoReturnable<Boolean> cir) {
        MixinHooks.PlayerEvents.stopClickedOutOfInventoryBounds(cir);
    }


}
