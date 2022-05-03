package com.Ultra_Nerd.CodeLyokoLegacy.mixin.util;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.player.PlayerClassType;
import com.Ultra_Nerd.CodeLyokoLegacy.screens.ClientScreens.ClassScreen;
import net.fabricmc.fabric.impl.networking.server.ServerNetworkingImpl;
import net.fabricmc.fabric.impl.transfer.item.InventoryStorageImpl;
import net.fabricmc.fabric.mixin.content.registry.MixinAbstractFurnaceBlockEntity;
import net.fabricmc.fabric.mixin.dimension.ServerPlayerEntityMixin;
import net.fabricmc.fabric.mixin.transfer.AbstractFurnaceBlockEntityMixin;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.SoftOverride;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public interface PlayerNBTMixin{




    @Inject(method = "writeCustomDataToNbt", at = @At("HEAD"))
    void saveClass(final NbtCompound nbt, final CallbackInfo ci);


    @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
    void readeClass(final NbtCompound nbt, final CallbackInfo ci);




}






