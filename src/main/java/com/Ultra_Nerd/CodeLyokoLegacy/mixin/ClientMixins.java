package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MixinHooks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resource.language.LanguageManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
public record ClientMixins() {
    @SuppressWarnings("MethodMayBeStatic")
    @Mixin(LanguageManager.class)
    public static abstract class LanguageChanged
    {
        @Inject(method = "setLanguage",at = @At("TAIL"))
        public void codelyoko$setLanguageInterceptor(final String languageCode, final CallbackInfo ci)
        {
            MixinHooks.invokeLanguageUpdate();
        }
    }


}
