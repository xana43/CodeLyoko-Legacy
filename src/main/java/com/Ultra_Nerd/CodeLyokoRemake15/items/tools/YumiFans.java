package com.Ultra_Nerd.CodeLyokoRemake15.items.tools;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntityFan;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class YumiFans extends TridentItem {
    public YumiFans(Properties builder) {
        super(builder);

    }
    @Override
    public void onPlayerStoppedUsing(@Nonnull ItemStack stack, @Nonnull World worldIn, @Nonnull LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity) entityLiving;
            int i = this.getUseDuration(stack) - timeLeft;
            if (i >= 10) {

                EntityFan fan = new EntityFan(worldIn, playerentity, stack);
                fan.setPosition(playerentity.getPosX(), playerentity.getPosYEye(), playerentity.getPosZ());
                fan.shoot(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, 2.5F * 0.5F, 0.0F);
                if (playerentity.abilities.isCreativeMode) {
                    fan.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                }
                if(!worldIn.isRemote) {
                    worldIn.addEntity(fan);
                }
                worldIn.playMovingSound(playerentity, fan, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
                if (!playerentity.abilities.isCreativeMode) {
                    playerentity.inventory.deleteStack(stack);
                }


            }
        }
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World worldIn, PlayerEntity playerIn, @Nonnull Hand handIn) {
        ItemStack heldItem = playerIn.getHeldItem(handIn);
        if (playerIn.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() != ModItems.YUMI_CHESTPLATE.get() &&
                playerIn.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getItem() != ModItems.YUMI_LEGGINGS.get() &&
                playerIn.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getItem() != ModItems.YUMI_BOOTS.get()) {
            return ActionResult.resultFail(heldItem);
        }
        //boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(heldItem, worldIn, playerIn, handIn, true);
        if (ret != null) return ret;

        playerIn.setActiveHand(handIn);
        return ActionResult.resultSuccess(heldItem);

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
