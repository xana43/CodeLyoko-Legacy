package com.Ultra_Nerd.CodeLyokoLegacy.Items.Tools;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.FanEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.MethodUtil;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
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
            int i = this.getMaxUseTime(stack,entityLiving) - timeLeft;
            if (i >= 10) {
                final FanEntity fan = new FanEntity(worldIn, playerentity, stack);
                fan.setPos(playerentity.getX(), playerentity.getEyeY(), playerentity.getZ());
                fan.setVelocity(playerentity, playerentity.getPitch(),playerentity.getYaw(), 0.0F, 1.25f,0.0F);
                fan.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
                worldIn.spawnEntity(fan);
                RegistryEntry<SoundEvent> registryEntry = EnchantmentHelper.getEffect(stack, EnchantmentEffectComponentTypes.TRIDENT_SOUND).orElse(SoundEvents.ITEM_TRIDENT_THROW);
                worldIn.playSoundFromEntity(null, playerentity, registryEntry.value(), SoundCategory.PLAYERS, 1.0F, 1.0F);
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
            final DynamicRegistryManager registryManager = worldIn.getRegistryManager();
            final RegistryEntry<Enchantment> LOYALTY = MethodUtil.HelperMethods.getRegistryEntry(registryManager, RegistryKeys.ENCHANTMENT,Enchantments.LOYALTY);
            final RegistryEntry<Enchantment> SHARPNESS = MethodUtil.HelperMethods.getRegistryEntry(registryManager, RegistryKeys.ENCHANTMENT,Enchantments.SHARPNESS);
            final RegistryEntry<Enchantment> IMPALING = MethodUtil.HelperMethods.getRegistryEntry(registryManager, RegistryKeys.ENCHANTMENT,Enchantments.IMPALING);
            stack.addEnchantment(LOYALTY, LOYALTY.value().getMaxLevel());
            stack.addEnchantment(SHARPNESS, SHARPNESS.value().getMaxLevel());
            stack.addEnchantment(IMPALING, IMPALING.value().getMaxLevel());
            //stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);
        }
    }


}
