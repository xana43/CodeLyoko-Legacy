package com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.FanEntity;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;


public final class YumiFans extends TridentItem {
    private static final float Velocity = 1f;
    private static final float FanDamage = 1f;
    private static final int thrownTime = 0;
    private final AttributeModifiersComponent component;

    public YumiFans(Item.Settings builder) {
        super(builder);
        component = createAttributeModifiers();

    }

    @Override
    public UseAction getUseAction(final ItemStack stack) {
        return UseAction.SPEAR;
    }







    @Override
    public boolean hasGlint(final ItemStack stack) {
        return false;
    }

    @Override
    public void onStoppedUsing(@NotNull ItemStack stack, @NotNull World worldIn, @NotNull LivingEntity entityLiving, int timeLeft) {
        //super.onStoppedUsing(stack,worldIn,entityLiving,timeLeft);
        if (entityLiving instanceof PlayerEntity playerentity) {
            int i = this.getMaxUseTime(stack) - timeLeft;
            if (i >= 10) {
                final FanEntity fan = new FanEntity(worldIn, playerentity, stack);
                fan.setPos(playerentity.getX(), playerentity.getEyeY(), playerentity.getZ());
                fan.setVelocity(playerentity, playerentity.getPitch(),playerentity.getYaw(), 0.0F, 1.25f,0.0F);
                fan.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
                worldIn.spawnEntity(fan);

                worldIn.playSound(null, playerentity.getBlockPos(), SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
                if (!playerentity.getAbilities().creativeMode) {
                    playerentity.getInventory().removeOne(stack);
                }


            }
        }
    }


    @Override
    public @NotNull TypedActionResult<ItemStack> use(@NotNull World worldIn, @NotNull PlayerEntity playerIn, @NotNull Hand handIn) {
        final ItemStack heldItem = playerIn.getStackInHand(handIn);
       // if(!playerIn.isCreative())
        //{
         //   if(CardinalData.LyokoClass.getLyokoClass(playerIn) != 2) {
          //      return TypedActionResult.fail(heldItem);
           // }
        //}


        playerIn.setCurrentHand(handIn);
        return TypedActionResult.consume(heldItem);
    }


    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull World worldIn, @NotNull Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.hasEnchantments()) {
            stack.addEnchantment(Enchantments.LOYALTY, Enchantments.LOYALTY.getMaxLevel());
            stack.addEnchantment(Enchantments.SHARPNESS, Enchantments.SHARPNESS.getMaxLevel());
            stack.addEnchantment(Enchantments.IMPALING, Enchantments.IMPALING.getMaxLevel());
            //stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);
        }
    }


}
