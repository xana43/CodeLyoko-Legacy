package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.util.event.Client.ClientEvents;
import net.minecraft.client.resource.language.LanguageManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public record ClientMixins() {
    @SuppressWarnings("MethodMayBeStatic")
    @Mixin(LanguageManager.class)
    public static final class LanguageChanged
    {
        @Inject(method = "setLanguage",at = @At("HEAD"))
        public void codelyoko$setLanguageInterceptor(final String languageCode, final CallbackInfo ci)
        {
            ClientEvents.ON_LANGUAGE_CHANGED_EVENT.invoker().languageChanged();
        }
    }
}
