package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class RetainXP {

    @Unique
    private World worldMix;
    @Inject(method = "<init>",at = @At("RETURN"))
    private void codelyoko$getWorld(final World world, final BlockPos pos, final float yaw, final GameProfile gameProfile, final CallbackInfo ci)
    {
        worldMix = world;
    }

    @Inject(method = "getXpToDrop", at = @At("HEAD"), cancellable = true)
    private void codelyoko$retainxp(final CallbackInfoReturnable<Integer> cir) {

            if (MethodUtil.DimensionCheck.worldIsNotVanilla(worldMix)) {
                cir.setReturnValue(Integer.valueOf(0));
            }
    }

    @Inject(method = "shouldAlwaysDropXp", at = @At("HEAD"), cancellable = true)
    private void codelyoko$retainxp2(final CallbackInfoReturnable<Boolean> cir) {
                if (MethodUtil.DimensionCheck.worldIsNotVanilla(worldMix)) {
                    cir.setReturnValue(Boolean.FALSE);
                }
    }


}
