package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage.Sector5Dimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DesertSector.DesertDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean.OceanDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector.IceDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.MountainSector.MountainDimension;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ArmorWarrior extends ArmorItem {
    private final int damage;
    private byte I = 0;

    public ArmorWarrior(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
        this.damage = materialIn.getDurability(slot);
    }


    private boolean checkDim(PlayerEntity player) {
        return player.world.dimension instanceof ForestDimension || player.world.dimension instanceof IceDimension ||
                player.world.dimension instanceof DesertDimension || player.world.dimension instanceof MountainDimension
                || player.world.dimension instanceof Sector5Dimension || player.world.dimension instanceof OceanDimension;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (!checkDim(player)) {
            if (player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.WILLIAM_CHESTPLATE.get()) {
                player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).setCount(0);
                if (player.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                    player.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).setCount(0);
                }
            }
            if (player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getItem() == ModItems.WILLIAM_LEGGINGS.get()) {
                player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).setCount(0);
                if (player.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                    player.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).setCount(0);
                }
            }
            if (player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getItem() == ModItems.WILLIAM_BOOTS.get()) {
                player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).setCount(0);
                if (player.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).getItem() == ModItems.BLANKHELMET.get()) {
                    player.inventory.armorItemInSlot(EquipmentSlotType.HEAD.getIndex()).setCount(0);
                }
            }
        } else {
            if (!player.getItemStackFromSlot(EquipmentSlotType.CHEST).isEmpty() &&
                    !player.getItemStackFromSlot(EquipmentSlotType.FEET).isEmpty() &&
                    !player.getItemStackFromSlot(EquipmentSlotType.LEGS).isEmpty()) {

                if (player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.WILLIAM_CHESTPLATE.get() && player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getItem() == ModItems.WILLIAM_LEGGINGS.get() && player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getItem() == ModItems.WILLIAM_BOOTS.get()) {

                    if (I++ == 1000) {
                        if (stack.getDamage() != 0) {
                            stack.damageItem(-1, player, null);
                        }
                        I = 0;
                    }
                    if (player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getDamage() < damage && player.inventory.armorItemInSlot(EquipmentSlotType.LEGS.getIndex()).getDamage() < damage && player.inventory.armorItemInSlot(EquipmentSlotType.FEET.getIndex()).getDamage() < damage) {
                        player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, -1, 1, false, false, false));
                        player.addPotionEffect(new EffectInstance(Effects.STRENGTH, -1, 3, false, false, false));
                        player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, -1, 2, false, false, false));
                    }

                }


            }
        }
    }


}
