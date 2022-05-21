package com.Ultra_Nerd.CodeLyokoLegacy.items.tools;

import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.util.UseAction;
import org.jetbrains.annotations.NotNull;

public final class YumiFans extends TridentItem {
    private static final float Velocity = 1f;
    private static final float FanDamage = 1f;
    private static final int thrownTime = 0;
    public YumiFans(@NotNull Settings builder) {
        super(builder);


    }

    @Override
    public UseAction getUseAction(final ItemStack stack) {
        return UseAction.SPEAR;
    }

    @Override
    public boolean isDamageable() {
        return false;
    }
/*
    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute,AttributeModifier> multimap = HashMultimap.create();

        if (slot == EquipmentSlot.MAINHAND) {
            multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", FanDamage, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier",  Velocity, AttributeModifier.Operation.ADDITION));
        }
        return multimap;
    }
    @Override
    public boolean onDroppedByPlayer(final ItemStack item, final Player player) {
        return false;
    }
    @Override
    public int getDefaultTooltipHideFlags(@NotNull final ItemStack stack) {
        return ItemStack.TooltipPart.ENCHANTMENTS.getMask();
    }

    @Override
    public boolean isFoil(final @NotNull ItemStack pStack) {
        return false;
    }

    @Override
    public void releaseUsing(@Nonnull ItemStack stack, @Nonnull Level worldIn, @Nonnull LivingEntity entityLiving, int timeLeft) {
        super.releaseUsing(stack,worldIn,entityLiving,timeLeft);
        if (entityLiving instanceof Player playerentity) {
            int i = this.getUseDuration(stack) - timeLeft;
            if (i >= 10) {

                final EntityFan fan = new EntityFan(worldIn, playerentity, stack);
                fan.setPos(playerentity.getX(), playerentity.getEyeY(), playerentity.getZ());
                fan.shootFromRotation(fan, playerentity.getXRot(), playerentity.getYRot(), 0.0F, 1.25f,0.0F);
                fan.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                worldIn.addFreshEntity(fan);

                worldIn.playSound(null, playerentity.blockPosition(), SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!playerentity.isCreative()) {
                    playerentity.getInventory().removeItem(stack);
                }


            }
        }
    }


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level worldIn, @NotNull Player playerIn, @NotNull InteractionHand handIn) {
        final ItemStack heldItem = playerIn.getItemInHand(handIn);
        if (playerIn.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() != ModItems.YUMI_CHESTPLATE.get() &&
                playerIn.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() != ModItems.YUMI_LEGGINGS.get() &&
                playerIn.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() != ModItems.YUMI_BOOTS.get()) {
            return InteractionResultHolder.fail(heldItem);
        }
        //boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(heldItem, worldIn, playerIn, handIn, true);
        if (ret != null) {
            return ret;
        }

        playerIn.setMainArm(HumanoidArm.RIGHT);
        return InteractionResultHolder.success(heldItem);
    }


    @Override
    public void inventoryTick(@NotNull ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.LOYALTY, Enchantments.LOYALTY.getMaxLevel());
            stack.enchant(Enchantments.SHARPNESS, Enchantments.SHARPNESS.getMaxLevel());
            stack.getEnchantmentTags().clear();
        }
    }

 */
}
