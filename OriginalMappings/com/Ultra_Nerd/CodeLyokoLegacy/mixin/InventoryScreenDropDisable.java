package com.Ultra_Nerd.CodeLyokoLegacy.mixin;


import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.render.model.SpriteAtlasManager;
import net.minecraft.client.texture.StatusEffectSpriteManager;
import net.minecraft.command.argument.StatusEffectArgumentType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InventoryScreen.class)
public abstract class InventoryScreenDropDisable {
    @Inject(method = "isClickOutsideBounds",at = @At(value = "HEAD"), cancellable = true)
    private void disabledrop(final CallbackInfoReturnable<Boolean> cir)
    {
        final PlayerEntity player = MinecraftClient.getInstance().player;
        if(player != null) {
            if (MethodUtil.DimensionCheck.playerNotInVanillaWorld(player) && !player.isCreative()) {
                cir.cancel();

            }
        }
    }











}
