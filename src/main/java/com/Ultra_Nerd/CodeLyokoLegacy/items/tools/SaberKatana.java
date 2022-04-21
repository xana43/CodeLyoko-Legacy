package com.Ultra_Nerd.CodeLyokoLegacy.items.tools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public final class SaberKatana extends SwordItem {
   // private final float attackdamage;
    //private final float attackspeed;

    public SaberKatana(final ToolMaterial toolMaterial, final int attackDamage, final float attackSpeed, final Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

/*
    public SaberKatana(@NotNull Tier tier, int attackDamageIn, float attackSpeedIn, @NotNull Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        this.attackspeed = attackSpeedIn;
        this.attackdamage = (float) attackDamageIn + tier.getAttackDamageBonus();
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public void inventoryTick(@Nonnull ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {

        if (entityIn instanceof final @NotNull Player player) {
            final ItemStack IStack = player.getItemInHand(InteractionHand.OFF_HAND);
            if (IStack.getItem() == ModItems.DIGITAL_SABER.get()) {

                player.getInventory().add(player.getInventory().getFreeSlot(), IStack);

            }
            player.setMainArm(HumanoidArm.RIGHT);
        }




        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute,AttributeModifier> multimap = HashMultimap.create();

        if (slot == EquipmentSlot.MAINHAND) {
            multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackdamage, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier",  this.attackspeed, AttributeModifier.Operation.ADDITION));
        }
        return multimap;


    }
    @Override
    public boolean onDroppedByPlayer(final ItemStack item, final Player player) {
        return false;
    }

 */
}
