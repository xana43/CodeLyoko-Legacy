package com.Ultra_Nerd.CodeLyokoRemake15.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.worldselection.WorldSelectionList;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldSelectionList.WorldListEntry.class)
public abstract class SuppressWorld {

    @Inject(method = "renderExperimentalWarning", at = @At("HEAD"), cancellable = true, remap = false)
    private void ignoreExperimentalWarningIcon(PoseStack stack, int mouseX, int mouseY, int top, int left, @NotNull CallbackInfo ci)
    {
        ci.cancel();
    }

}
