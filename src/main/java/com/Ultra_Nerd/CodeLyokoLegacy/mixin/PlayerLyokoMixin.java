package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MixinHooks;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.damage.DamageSource;
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
public abstract class PlayerLyokoMixin {

    @Unique
    private World worldMix;
    @Inject(method = "<init>",at = @At("RETURN"))
    private void codelyoko$getWorld(final World world, final BlockPos pos, final float yaw, final GameProfile gameProfile, final CallbackInfo ci)
    {
        worldMix = world;
    }

    @Inject(method = "getXpToDrop", at = @At("HEAD"), cancellable = true)
    private void codelyoko$dropNoXpInLyoko(final CallbackInfoReturnable<Integer> cir) {

            if (MethodUtil.DimensionCheck.isWorldLyoko(worldMix)) {
                cir.setReturnValue(0);
            }
    }

    @Inject(method = "shouldAlwaysDropXp", at = @At("HEAD"), cancellable = true)
    private void codelyoko$whileInLyokoStopXpDrop(final CallbackInfoReturnable<Boolean> cir) {
                if (MethodUtil.DimensionCheck.isWorldLyoko(worldMix)) {
                    cir.setReturnValue(Boolean.FALSE);
                }
    }
    @Inject(method = "onDeath", at = @At("HEAD"))
    private void codelyoko$playerDevirtualizeSound(final DamageSource damageSource, final CallbackInfo ci)
    {
        MixinHooks.PlayerEvents.customDeathSoundInLyoko((PlayerEntity) (Object) this);

    }
}
