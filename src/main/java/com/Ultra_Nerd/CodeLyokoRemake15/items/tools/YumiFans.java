package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityFan;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class YumiFans extends TridentItem {
    public YumiFans(Properties builder) {
        super(builder);

    }



    @Override
    public void releaseUsing(@Nonnull ItemStack stack, @Nonnull Level worldIn, @Nonnull LivingEntity entityLiving, int timeLeft) {
        super.releaseUsing(stack,worldIn,entityLiving,timeLeft);
        if (entityLiving instanceof Player) {
            Player playerentity = (Player) entityLiving;
            int i = this.getUseDuration(stack) - timeLeft;
            if (i >= 10) {

                EntityFan fan = new EntityFan(worldIn, playerentity, stack);
                fan.setPos(playerentity.getX(), playerentity.getEyeY(), playerentity.getZ());
                fan.shootFromRotation(playerentity, playerentity.getXRot(), playerentity.getYRot(), 0.0F, 2.5F * 0.5F,0.0F);
                if (playerentity.isCreative()) {
                    fan.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                }
                if (worldIn.isClientSide) {
                    worldIn.addFreshEntity(fan);
                }
                worldIn.playSound(playerentity, fan, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!playerentity.isCreative()) {
                    playerentity.getInventory().removeItem(stack);
                }


            }
        }
    }


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level worldIn, Player playerIn, @NotNull InteractionHand handIn) {
        ItemStack heldItem = playerIn.getItemInHand(handIn);
        if (playerIn.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() != ModItems.YUMI_CHESTPLATE.get() &&
                playerIn.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() != ModItems.YUMI_LEGGINGS.get() &&
                playerIn.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() != ModItems.YUMI_BOOTS.get()) {
            return InteractionResultHolder.success(heldItem);
        }
        //boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(heldItem, worldIn, playerIn, handIn, true);
        if (ret != null) return ret;

        playerIn.setMainArm(HumanoidArm.RIGHT);
        return InteractionResultHolder.success(heldItem);
    }


    @Override
    public void inventoryTick(ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.LOYALTY, Enchantments.LOYALTY.getMaxLevel());
            stack.enchant(Enchantments.SHARPNESS, Enchantments.SHARPNESS.getMaxLevel());
        }
    }
}
