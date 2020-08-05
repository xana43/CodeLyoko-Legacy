package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityFan;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.item.UseAction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class YumiFans extends TridentItem {
    public YumiFans(Properties builder) {
        super(builder);

    }
    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity) entityLiving;
            int i = this.getUseDuration(stack) - timeLeft;
            if (i >= 10) {


                EntityFan fan = new EntityFan(worldIn, playerentity, stack);
                fan.shoot(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, 2.5F * 0.5F, 0.0F);
                if (playerentity.abilities.isCreativeMode) {
                    fan.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                }
                if(!worldIn.isRemote()) {
                    worldIn.addEntity(fan);
                }
                worldIn.playMovingSound(playerentity, fan, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
                if (!playerentity.abilities.isCreativeMode) {
                    playerentity.inventory.deleteStack(stack);
                }


            }
        }
    }


    @Override
    public boolean hasEffect(ItemStack stack) {
        return false;
    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }



    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(!stack.isEnchanted())
        {
            stack.addEnchantment(Enchantments.LOYALTY,Enchantments.LOYALTY.getMaxLevel());
            stack.addEnchantment(Enchantments.SHARPNESS,Enchantments.SHARPNESS.getMaxLevel());
        }
    }
}
