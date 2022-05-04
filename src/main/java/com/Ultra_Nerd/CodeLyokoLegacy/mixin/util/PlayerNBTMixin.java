package com.Ultra_Nerd.CodeLyokoLegacy.mixin.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerNBTMixin{


    @Inject(method = "writeCustomDataToNbt", at = @At("HEAD"))
    protected void saveClass(final NbtCompound nbt, final CallbackInfo ci) {

    }


    @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
    protected void readeClass(final NbtCompound nbt, final CallbackInfo ci) {

    }


}





