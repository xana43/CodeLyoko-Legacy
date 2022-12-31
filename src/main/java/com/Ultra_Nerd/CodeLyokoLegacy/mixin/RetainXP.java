package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.google.common.collect.ImmutableList;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class RetainXP {

    private World worldMix;
    @Inject(method = "<init>",at = @At("RETURN"))
    private void getWorld(final World world, final BlockPos pos, final float yaw, final GameProfile gameProfile, final CallbackInfo ci)
    {
        worldMix = world;
    }

    @Inject(method = "getXpToDrop", at = @At("HEAD"), cancellable = true)
    private void retainxp(final CallbackInfoReturnable<Integer> cir) {



            if (MethodUtil.DimensionCheck.worldIsNotVanilla(worldMix)) {

                cir.setReturnValue(0);
            }


    }

    @Inject(method = "shouldAlwaysDropXp", at = @At("HEAD"), cancellable = true)
    private void retainxp2(final CallbackInfoReturnable<Boolean> cir) {



                if (MethodUtil.DimensionCheck.worldIsNotVanilla(worldMix)) {
                    cir.setReturnValue(false);
                }


    }


}
