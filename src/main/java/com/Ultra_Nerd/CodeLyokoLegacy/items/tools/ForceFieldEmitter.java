package com.Ultra_Nerd.CodeLyokoLegacy.items.tools;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Predicate;

public final class ForceFieldEmitter extends BowItem {


    public ForceFieldEmitter(final Settings settings) {
        super(settings);
    }


    @Override
    public int getMaxUseTime(final ItemStack stack) {
        return 18000;
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
    public void onStoppedUsing(final ItemStack stack, final World world, final LivingEntity user, final int remainingUseTicks) {
        if (user instanceof PlayerEntity playerentity) {

            int i = this.getMaxUseTime(stack) - remainingUseTicks;
            //i = (stack, worldIn, playerentity, i, true);



            final float f = getPullProgress(i);
            if (!((double) f < 0.1D)) {
                boolean flag1 = playerentity.isCreative();
                if (!world.isClient()) {
                    final EntityLaser las = new EntityLaser(world,user);

                    las.setDamage(40);
                    las.setPos(playerentity.getBlockPos().getX(), playerentity.getEyeY(), playerentity.getBlockPos().getZ());
                    las.setNoGravity(true);
                    las.shake = 0;
                    las.setVelocity(playerentity,playerentity.getPitch() ,playerentity.getYaw(), 0.0F, f * 3.0F, 0.1F);
                    if (f == 1.0F) {
                        las.setCritical(true);
                    }
                    world.spawnEntity(las);
                }

                world.playSound( playerentity, playerentity.getBlockPos(), ModSounds.LASERARROW, SoundCategory.PLAYERS, 1.0F, 1.0F / (new Random().nextFloat() * 0.4F + 1.2F) + f * 0.5F);

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
        ItemStack heldItem = user.getStackInHand(hand);
        if (user.getInventory().armor.get(EquipmentSlot.CHEST.getEntitySlotId()).getItem() != ModItems.AELITA_CHESTPLATE &&
                user.getInventory().armor.get(EquipmentSlot.LEGS.getEntitySlotId()).getItem() != ModItems.AELITA_LEGGINGS &&
                user.getInventory().armor.get(EquipmentSlot.FEET.getEntitySlotId()).getItem() != ModItems.AELITA_BOOTS) {
            return TypedActionResult.fail(heldItem);
        }
        else
        {
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
