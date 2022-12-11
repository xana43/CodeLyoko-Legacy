package com.Ultra_Nerd.CodeLyokoLegacy.mixin;


import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InventoryScreen.class)
public abstract class InventoryScreenDropDisable {
    @Inject(method = "isClickOutsideBounds", at = @At(value = "HEAD"), cancellable = true)
    private void disabledrop(final CallbackInfoReturnable<Boolean> cir) {
        final PlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null) {
            if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(player) && !player.isCreative()) {
                cir.cancel();

            }
        }
    }


}
