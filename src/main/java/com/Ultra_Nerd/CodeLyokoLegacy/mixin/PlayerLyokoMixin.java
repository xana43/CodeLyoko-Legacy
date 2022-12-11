package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class PlayerLyokoMixin {

    @Inject(method = "swingHand(Lnet/minecraft/util/Hand;)V", at = @At("HEAD"))
    public void swingSound(final CallbackInfo ci) {
        final MinecraftClient mc = MinecraftClient.getInstance();
        if (mc != null) {
            if (mc.player != null) {
                if (mc.player.getEquippedStack(EquipmentSlot.MAINHAND)
                        .getItem() == ModItems.DIGITAL_SABER && mc.options.attackKey.isPressed()) {
                    assert mc.crosshairTarget != null;
                    switch (mc.crosshairTarget.getType()) {
                        case MISS -> mc.player.playSound(ModSounds.SWORDSLASH, SoundCategory.PLAYERS, 1, 1);
                        case BLOCK -> {
                        }
                        case ENTITY -> {

                        }

                    }


                }
            }
        }
    }


}
