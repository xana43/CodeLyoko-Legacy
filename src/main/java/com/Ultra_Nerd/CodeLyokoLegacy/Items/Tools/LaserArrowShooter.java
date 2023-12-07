package com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.EntityLaser;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;


public final class LaserArrowShooter extends BowItem {


    public LaserArrowShooter(@NotNull Settings builder) {
        super(builder);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean hasGlint(final ItemStack stack) {
        return false;
    }




    @Override
    public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
        final ItemStack item = user.getStackInHand(hand);
        if (!world.isClient()) {
            world.playSound(null, user.getBlockPos(), ModSounds.LASERARROW, SoundCategory.PLAYERS, 1f, 1f);


            final EntityLaser las = new EntityLaser(world, user, 20);

            //las.(10);
            las.setNoGravity(true);
            las.shake = 0;
            las.setPos(user.getX(), user.getEyeY(), user.getZ());
            las.setVelocity(user, user.getPitch(), user.getYaw(), 0, 11.44f, 0);
            world.spawnEntity(las);
        }
        return TypedActionResult.success(item);

    }

    @Override
    public ItemStack finishUsing(final ItemStack stack, final World world, final LivingEntity user) {
        return null;
    }

}
