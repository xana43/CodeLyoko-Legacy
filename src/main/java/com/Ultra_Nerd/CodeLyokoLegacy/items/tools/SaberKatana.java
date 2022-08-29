package com.Ultra_Nerd.CodeLyokoLegacy.items.tools;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModSounds;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public final class SaberKatana extends SwordItem {
    private final float attackdamage;
    private final float attackspeed;
    private boolean selectedOnce;
    public SaberKatana(final ToolMaterial toolMaterial, final int attackDamage, final float attackSpeed, final Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.attackspeed = attackSpeed;
        this.attackdamage = attackDamage + toolMaterial.getAttackDamage();



    }





    @Override
    public int getMaxUseTime(final ItemStack stack) {
        return 72000;

    }

    @Override
    public UseAction getUseAction(final ItemStack stack) {


        return UseAction.BLOCK;
    }


    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(final ItemStack stack, final EquipmentSlot slot) {
        Multimap<EntityAttribute,EntityAttributeModifier> multimap = HashMultimap.create();

        if (slot == EquipmentSlot.MAINHAND) {
            multimap.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon damage modifier", this.attackdamage, EntityAttributeModifier.Operation.ADDITION));
            multimap.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon speed modifier",  this.attackspeed, EntityAttributeModifier.Operation.ADDITION));
        }
        return multimap;

    }



    @Override
    public void inventoryTick(final ItemStack stack, final World world, final Entity entity, final int slot, final boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(selected && !selectedOnce)
        {
            entity.playSound(ModSounds.SWORDDRAW,1,1);
            selectedOnce = true;
        } else if (!selected) {
            selectedOnce = false;
        }
        if(!stack.hasEnchantments())
        {
            stack.addEnchantment(Enchantments.SWEEPING,Enchantments.SWEEPING.getMaxLevel());
            stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);

        }
    }

    @Override
    public SoundEvent getEquipSound() {
        return ModSounds.SWORDDRAW;
    }

    @Override
    public TypedActionResult<ItemStack> use(final World world, final PlayerEntity user, final Hand hand) {
        user.setCurrentHand(hand);

        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean hasGlint(final ItemStack stack) {
        return false;
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
