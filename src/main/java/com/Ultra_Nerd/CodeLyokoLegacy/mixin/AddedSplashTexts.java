package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.MixinHooks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resource.SplashTextResourceSupplier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
@Environment(EnvType.CLIENT)
@Mixin(SplashTextResourceSupplier.class)
public abstract class AddedSplashTexts {

    @Final
    @Shadow
    private List<String> splashTexts;

    @Inject(method = "apply(Ljava/util/List;Lnet/minecraft/resource/ResourceManager;" + "Lnet/minecraft/util/profiler/Profiler;)V",at = @At("RETURN"))
    private void codelyoko$addNewSplashTexts(final List<String> vanillaValues,final ResourceManager resources, final Profiler profiler,final CallbackInfo ci)
    {
        //splashTexts.removeAll(vanillaValues);
        MixinHooks.customSplashTexts(splashTexts);
    }
}
