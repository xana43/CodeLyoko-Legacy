package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.DimensionCheck;
import net.fabricmc.fabric.mixin.client.keybinding.KeyBindingAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(KeyBinding.class)
public abstract class ItemDropMixin {
    @Inject(method ="onKeyPressed",at = @At("HEAD"),cancellable = true)
    private static void stopDrop(final InputUtil.Key key, final CallbackInfo ci)
    {
        final MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player != null) {
            if (DimensionCheck.playerNotInVanillaWorld(mc.player)) {
                if(mc.options.dropKey.isPressed())
                {
                    ci.cancel();
                }


            }
        }
    }




}
