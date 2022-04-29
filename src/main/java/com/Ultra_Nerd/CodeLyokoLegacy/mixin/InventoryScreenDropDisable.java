package com.Ultra_Nerd.CodeLyokoLegacy.mixin;


import com.Ultra_Nerd.CodeLyokoLegacy.Util.DimensionCheck;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InventoryScreen.class)
public abstract class InventoryScreenDropDisable {
    @Inject(method = "isClickOutsideBounds",at = @At(value = "HEAD"),cancellable = true)
    private void disabledrop(final double mouseX, final double mouseY, final int left, final int top, final int button, final CallbackInfoReturnable<Boolean> cir)
    {
        final PlayerEntity player = MinecraftClient.getInstance().player;
        if(player != null) {
            if (DimensionCheck.playerNotInVanillaWorld(player) && !player.isCreative()) {
                cir.cancel();
            }
        }
    }




}
