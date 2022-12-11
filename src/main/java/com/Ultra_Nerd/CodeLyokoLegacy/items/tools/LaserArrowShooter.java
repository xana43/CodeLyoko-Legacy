package com.Ultra_Nerd.CodeLyokoLegacy.items.tools;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
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

        // TODO Auto-generated constructor stub
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
    public void inventoryTick(@NotNull ItemStack pStack, @NotNull World pLevel, @NotNull Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pStack.hasEnchantments()) {
            pStack.addEnchantment(Enchantments.INFINITY, Enchantments.INFINITY.getMaxLevel());
            pStack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);

        }

    }

    @Override
    public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
        final ItemStack item = user.getStackInHand(hand);




/*
        if (user.getInventory().armor.get(EquipmentSlot.LEGS.getEntitySlotId()).getItem() == ModItems.ODD_LEGGINGS &&
                playerIn.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.ODD_CHESTPLATE.get()
                && playerIn.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() == ModItems.ODD_BOOTS.get()) {
            //worldIn.playSound(null,playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), ModItems.BIT.get(), SoundCategory.NEUTRAL, 1f, 1f);
*/
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
        item.decrement(0);

        //item.getItem().damageItem(item,1, playerIn, null);
        return TypedActionResult.pass(item);
        //} else {
        //    return new InteractionResultHolder<>(InteractionResult.FAIL, item);
        //}
    }

    @Override
    public ItemStack finishUsing(final ItemStack stack, final World world, final LivingEntity user) {
        return null;
    }
/*
    @Override
    public int getDefaultTooltipHideFlags(@NotNull final ItemStack stack) {
        return ItemStack.TooltipPart.ENCHANTMENTS.getMask();
    }
    @Override
    public boolean isFoil(@NotNull ItemStack pStack) {
        return false;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }


    @Override
    public boolean isDamaged(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isRepairable(@NotNull ItemStack stack) {
        return false;
    }



    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@Nonnull Level worldIn, @NotNull Player playerIn, @Nonnull InteractionHand handIn) {

    }

    @Override
    public boolean onDroppedByPlayer(final ItemStack item, final Player player) {
        return false;
    }

 */
}
