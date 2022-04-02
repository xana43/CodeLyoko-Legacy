package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityLaser;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;


public class LaserArrowShooter extends BowItem {





    public LaserArrowShooter(Properties builder) {
        super(builder);

        // TODO Auto-generated constructor stub
    }

    @Override
    public void inventoryTick(ItemStack pStack, @NotNull Level pLevel, @NotNull Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(!pStack.isEnchanted())
        {
            pStack.enchant(Enchantments.INFINITY_ARROWS,Enchantments.INFINITY_ARROWS.getMaxLevel());
            pStack.getEnchantmentTags().clear();

        }

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
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, 0);
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
    public InteractionResultHolder<ItemStack> use(@Nonnull Level worldIn, Player playerIn, @Nonnull InteractionHand handIn) {
        ItemStack item = playerIn.getItemInHand(handIn);



        if (playerIn.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() == ModItems.ODD_LEGGINGS.get() &&
                playerIn.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.ODD_CHESTPLATE.get()
                && playerIn.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() == ModItems.ODD_BOOTS.get()) {
            //worldIn.playSound(null,playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), ModItems.BIT.get(), SoundCategory.NEUTRAL, 1f, 1f);


            worldIn.playSound(null,playerIn.blockPosition(), ModSounds.LASERARROW.get(), SoundSource.PLAYERS, 1f, 1f);


            EntityLaser las = new EntityLaser(worldIn, 1.0D, 1.0D, 1.0D);

            las.setBaseDamage(10);
            las.setNoGravity(true);
            las.setPos(playerIn.getX(), playerIn.getEyeY(), playerIn.getZ());
            las.shootFromRotation(playerIn, playerIn.getRotationVector().x, playerIn.getRotationVector().y, (float)playerIn.getLookAngle().z, 5f, 0f);

            worldIn.addFreshEntity(las);


            item.getItem().damageItem(item,1, playerIn, null);
            return new InteractionResultHolder<>(InteractionResult.PASS, item);
        } else {
            return new InteractionResultHolder<>(InteractionResult.FAIL, item);
        }
    }


}
