package com.Ultra_Nerd.CodeLyokoLegacy.mixin;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import com.Ultra_Nerd.CodeLyokoLegacy.util.MethodUtil;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
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
    private void codelyoko$retainxp(final CallbackInfoReturnable<Integer> cir) {

            if (MethodUtil.DimensionCheck.worldIsNotVanilla(worldMix)) {
                cir.setReturnValue(0);
            }
    }

    @Inject(method = "shouldAlwaysDropXp", at = @At("HEAD"), cancellable = true)
    private void codelyoko$retainxp2(final CallbackInfoReturnable<Boolean> cir) {
                if (MethodUtil.DimensionCheck.worldIsNotVanilla(worldMix)) {
                    cir.setReturnValue(Boolean.FALSE);
                }
    }
    @Inject(method = "onDeath", at = @At("HEAD"))
    private void codelyoko$playerDevirtualizeSound(final DamageSource damageSource, final CallbackInfo ci)
    {
        if (MethodUtil.DimensionCheck.playerNotInVanillaWorld((PlayerEntity) (Object) this)) {
            final World currentWorld = ((PlayerEntity)(Object)this).getWorld();
            final Vec3d currentPosition = ((PlayerEntity)(Object)this).getPos();
            currentWorld.playSound(currentPosition.x,currentPosition.y,currentPosition.z, ModSounds.DEVIRTUALIZATION, ((PlayerEntity)(Object)this).getSoundCategory(),0.8F, 0.8F,true);
        }
    }
}
