package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import net.minecraft.world.level.storage.PrimaryLevelData;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PrimaryLevelData.class)
public abstract class Suppress {
    @Inject(method = "hasConfirmedExperimentalWarning", at = @At("HEAD"),cancellable = true,remap = false)
    private void shutup(@NotNull CallbackInfoReturnable<Boolean> cir)
    {
        cir.setReturnValue(true);
    }
}
