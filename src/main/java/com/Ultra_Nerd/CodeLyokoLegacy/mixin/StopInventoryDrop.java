package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.SlotActionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("MethodMayBeStatic")
@Mixin(ClientPlayerInteractionManager.class)
public abstract class StopInventoryDrop {
    @Inject(method = "clickSlot", at = @At("HEAD"), cancellable = true)
    private void codelyoko$disableDropOnItem(final int syncId, final int slotId, final int button, final SlotActionType actionType, final PlayerEntity player, final CallbackInfo ci) {
        if (MethodUtil.DimensionCheck.isPlayerInLyoko(player) && !player.isCreative()) {
            if (actionType == SlotActionType.THROW) {
                ci.cancel();
            }
        }
    }
}
