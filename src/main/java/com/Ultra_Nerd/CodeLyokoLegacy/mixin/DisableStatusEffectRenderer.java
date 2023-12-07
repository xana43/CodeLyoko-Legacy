package com.Ultra_Nerd.CodeLyokoLegacy.mixin;


import com.Ultra_Nerd.CodeLyokoLegacy.Util.MixinHooks;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("MethodMayBeStatic")
@Mixin(AbstractInventoryScreen.class)
public abstract class DisableStatusEffectRenderer {

    @Inject(method = "drawStatusEffects", at = @At("HEAD"), cancellable = true)
    private void codelyoko$disableStatusRenderer(final DrawContext matrices, final int mouseX, final int mouseY,
            final CallbackInfo ci) {
        MixinHooks.disableStatusEffectsRenderInLyoko(ci);
    }
}
