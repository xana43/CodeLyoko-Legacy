package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import org.jetbrains.annotations.NotNull;

public final class ArmorWarrior extends LyokoArmor {

    private static final double movement_modifier = -0.1D;
    private static final double attack_modifier = 0.7D;
    private static final double attack_speed = -0.2D;
    public ArmorWarrior(@NotNull ArmorMaterial materialIn, @NotNull EquipmentSlot slot, @NotNull Settings builder) {
        super(materialIn, slot, builder);


    } /*@Override
    public @NotNull Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute,AttributeModifier> multimap = HashMultimap.create();

//new AttributeModifier(UUID.fromString("46656c69-6e65-204a-756d-7020426f6f73"),"jump_modifier"
        if(slot == EquipmentSlot.FEET)
        {
            multimap.put(Attributes.MOVEMENT_SPEED,new AttributeModifier(UUID.fromString("91AEAA56-376B-4498-935B-2F7F68070635"),"speed_modifier",movement_modifier, AttributeModifier.Operation.MULTIPLY_TOTAL));

        }
        if(slot == EquipmentSlot.CHEST)
        {
            multimap.put(Attributes.ATTACK_DAMAGE,new AttributeModifier(BASE_ATTACK_DAMAGE_UUID,"attack_modifier",attack_modifier, AttributeModifier.Operation.MULTIPLY_TOTAL));
            multimap.put(Attributes.ATTACK_SPEED,new AttributeModifier(BASE_ATTACK_DAMAGE_UUID,"attack_speed",attack_speed,AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return multimap;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isFoil(final @NotNull ItemStack pStack) {
        return false;
    }

    @Override
    public int getDefaultTooltipHideFlags(@NotNull final ItemStack stack) {
        return ItemStack.TooltipPart.ENCHANTMENTS.getMask();
    }

    @Override
    public void inventoryTick(final @NotNull ItemStack pStack, final @NotNull Level pLevel, final @NotNull Entity pEntity, final int pSlotId, final boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if(!pStack.isEnchanted())
        {
            pStack.enchant(Enchantments.BINDING_CURSE,Enchantments.BINDING_CURSE.getMaxLevel());
        }
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, @NotNull Player player) {
        if (!DimensionCheck.playerNotInVanillaWorld(player)) {
            if (player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.WILLIAM_CHESTPLATE.get()) {
                player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).setCount(0);
                if (player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                    player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).setCount(0);
                }
            }
            if (player.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() == ModItems.WILLIAM_LEGGINGS.get()) {
                player.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).setCount(0);
                if (player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                    player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).setCount(0);
                }
            }
            if (player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() == ModItems.WILLIAM_BOOTS.get()) {
                player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).setCount(0);
                if (player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                    player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).setCount(0);
                }
            }
        } else {
            if (!player.getItemBySlot(EquipmentSlot.CHEST).isEmpty() &&
                    !player.getItemBySlot(EquipmentSlot.FEET).isEmpty() &&
                    !player.getItemBySlot(EquipmentSlot.LEGS).isEmpty()) {
            if(player.getEffect(MobEffects.DAMAGE_RESISTANCE) == null) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 2, false, false, false));
            }

            }
        }
    }
    */


}
