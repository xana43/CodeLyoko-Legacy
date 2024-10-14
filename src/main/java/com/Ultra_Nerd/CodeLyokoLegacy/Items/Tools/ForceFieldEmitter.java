package com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.LaserEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModSounds;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.Random;
import java.util.function.Predicate;

public final class ForceFieldEmitter extends BowItem {


    public int publicUseTicks = 0;


    public ForceFieldEmitter(final Settings settings) {
        super(settings);
    }

    public int getMaxUseTime(final ItemStack stack) {
        return 72000;
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return (itemStack) -> itemStack.equals(ItemStack.EMPTY);
    }

    @Override
    public Predicate<ItemStack> getHeldProjectiles() {
        return itemStack -> itemStack.equals(ItemStack.EMPTY);
    }

    @Override
    public void usageTick(final World world, final LivingEntity user, final ItemStack stack, final int remainingUseTicks) {
        super.usageTick(world, user, stack, remainingUseTicks);
        publicUseTicks = remainingUseTicks;
    }

    @Override
    public void onStoppedUsing(final ItemStack stack, final World world, final LivingEntity user, final int remainingUseTicks) {
        if (user instanceof final PlayerEntity playerentity) {

            final int i = this.getMaxUseTime(stack) - remainingUseTicks;
            //i = (stack, worldIn, playerentity, i, true);
            publicUseTicks = getMaxUseTime(stack) - 1;


            final float f = getPullProgress(i);
            if (!((double) f < 0.1D)) {
                if (!world.isClient()) {
                    final LaserEntity las = new LaserEntity(world, user, 20);

                    las.setDamage(40);
                    las.setPos(playerentity.getBlockPos().getX(), playerentity.getEyeY(),
                            playerentity.getBlockPos().getZ());
                    las.setNoGravity(true);
                    las.shake = 0;
                    las.setVelocity(playerentity, playerentity.getPitch(), playerentity.getYaw(), 0.0F, f * 3.0F, 0.1F);
                    if (f == 1.0F) {
                        las.setCritical(true);
                    }
                    world.spawnEntity(las);
                }

                world.playSound(playerentity, playerentity.getBlockPos(), ModSounds.LASERARROW, SoundCategory.PLAYERS,
                        1.0F, 1.0F / (new Random().nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                playerentity.incrementStat(Stats.USED.getOrCreateStat(this));
            }

        }
    }

    @Override
    public UseAction getUseAction(final ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
        final ItemStack heldItem = user.getStackInHand(hand);
        if (user.getInventory().armor.get(EquipmentSlot.CHEST.getEntitySlotId())
                .getItem() != ModItems.AELITA_CHESTPLATE &&
                user.getInventory().armor.get(EquipmentSlot.LEGS.getEntitySlotId())
                        .getItem() != ModItems.AELITA_LEGGINGS &&
                user.getInventory().armor.get(EquipmentSlot.FEET.getEntitySlotId())
                        .getItem() != ModItems.AELITA_BOOTS) {
            return TypedActionResult.fail(heldItem);
        } else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(heldItem);
        }
        //boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

        //TypedActionResult<ItemStack> ret = EventFactory.createArrayBacked(heldItem, world, user, hand, true);
        //if (ret != null) {
        //    return ret;
        //}


    }


}
