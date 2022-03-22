package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.DimensionCheck;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ArmorFeline extends ArmorItem {
    private byte I = 0;
    private final int damage;

    public ArmorFeline(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
        super(materialIn, slot, builder);
        this.damage = materialIn.getDurabilityForSlot(slot);
    }




    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {

        if (!DimensionCheck.playerNotInVanillaWorld(player)) {
            if (player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.ODD_CHESTPLATE.get()) {
                player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).setCount(0);

                if (player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                    player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).setCount(0);
                }
            }
            if (player.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() == ModItems.ODD_LEGGINGS.get()) {
                player.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).setCount(0);
                if (player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                    player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).setCount(0);
                }
            }
            if (player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() == ModItems.ODD_BOOTS.get()) {
                player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).setCount(0);
                if (player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                    player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).setCount(0);
                }
            }
        } else {
            if (!player.getItemBySlot(EquipmentSlot.CHEST).isEmpty() &&
                    !player.getItemBySlot(EquipmentSlot.FEET).isEmpty() &&
                    !player.getItemBySlot(EquipmentSlot.LEGS).isEmpty()
            ) {

                if (player.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).getItem() == ModItems.ODD_CHESTPLATE.get() && player.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).getItem() == ModItems.ODD_LEGGINGS.get() && player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getItem() == ModItems.ODD_BOOTS.get()) {

                    if (I++ == 1000) {
                        if (stack.getDamageValue() != 0) {
                            stack.getItem().damageItem(stack,-1, player, null);
                        }
                        I = 0;
                    }

                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 3, false, false, false));
                    if (player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).getDamageValue() < damage) {



                        player.fallDistance = 0;
                        player.isInvulnerableTo(DamageSource.FALL);


                    }

                }


            }
        }
    }


}
