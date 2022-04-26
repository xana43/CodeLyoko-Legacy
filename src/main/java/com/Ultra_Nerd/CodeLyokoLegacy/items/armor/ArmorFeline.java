package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Util.DimensionCheck;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.items.armor.Models.Util.ArmorModelRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.items.armor.Models.Util.ModModelLayers;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.item.TooltipData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.UUID;

public final class ArmorFeline extends ArmorItem {


    private static final double movement_modifier = 0.6;
    public ArmorFeline(@NotNull ArmorMaterial materialIn, @NotNull EquipmentSlot slot, @NotNull Settings builder) {
        super(materialIn, slot, builder);



    }
/*
    @Override
    public void initializeClient(@NotNull Consumer<IItemRenderProperties> consumer) {
       // consumer.accept(CatRenderer.INSTANCE);
        super.initializeClient(consumer);
    }

    private static final class CatRenderer implements IItemRenderProperties
    {
        private static final CatRenderer INSTANCE = new CatRenderer();

        @Override
        public @NotNull HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
            EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
            ModelPart root = modelSet.bakeLayer(armorSlot == EquipmentSlot.CHEST ? ModModelLayers.FELINE_LAYER_LOCATION_INNER : ModModelLayers.FELINE_LAYER_LOCATION_OUTER);
            return new ArmorModelRenderer(root);
        }
    }
    */

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(final ItemStack stack, final EquipmentSlot slot) {
        Multimap<EntityAttribute,EntityAttributeModifier> multimap = HashMultimap.create();
        if(slot == EquipmentSlot.FEET)
        {
            multimap.put(EntityAttributes.GENERIC_MOVEMENT_SPEED,new EntityAttributeModifier(UUID.fromString("91AEAA56-376B-4498-935B-2F7F68070635"),"speed_modifier",movement_modifier, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
            //multimap.put(Attributes);
        }


        return multimap;
    }

    @Override
    public boolean hasGlint(final ItemStack stack) {

        return false;
    }



    @Override
    public boolean isDamageable() {
        return false;
    }






    @Override
    public void inventoryTick(final ItemStack stack, final World pLevel, final Entity pEntity, final int pSlotId, final boolean pIsSelected) {
        super.inventoryTick(stack, pLevel, pEntity, pSlotId, pIsSelected);
        stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);
        if(!stack.hasEnchantments()) {

            stack.addEnchantment(Enchantments.BINDING_CURSE,Enchantments.BINDING_CURSE.getMaxLevel());
        }
        if(pEntity instanceof PlayerEntity player)
        {
            this.onArmorTick(stack,pLevel,player);
        }
    }





private static final StatusEffectInstance JUMPEFFECT = new StatusEffectInstance(StatusEffects.JUMP_BOOST, -1, 3, false, false, false);






    public void onArmorTick(ItemStack stack, World world, @NotNull PlayerEntity player) {

        if (!DimensionCheck.playerNotInVanillaWorld(player)) {

            if (player.getInventory().getArmorStack(EquipmentSlot.CHEST.getEntitySlotId()).getItem() == ModItems.ODD_CHESTPLATE) {
                player.getInventory().getArmorStack(EquipmentSlot.CHEST.getEntitySlotId()).setCount(0);

                if (player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId()).getItem() == ModItems.BLANKHELMET) {
                    player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId()).setCount(0);
                }
            }
            if (player.getInventory().getArmorStack(EquipmentSlot.LEGS.getEntitySlotId()).getItem() == ModItems.ODD_LEGGINGS) {
                player.getInventory().getArmorStack(EquipmentSlot.LEGS.getEntitySlotId()).setCount(0);
                if (player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId()).getItem() == ModItems.BLANKHELMET) {
                    player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId()).setCount(0);
                }
            }
            if (player.getInventory().getArmorStack(EquipmentSlot.FEET.getEntitySlotId()).getItem() == ModItems.ODD_BOOTS) {
                player.getInventory().getArmorStack(EquipmentSlot.FEET.getEntitySlotId()).setCount(0);
                if (player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId()).getItem() == ModItems.BLANKHELMET) {
                    player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId()).setCount(0);
                }
            }
        } else {

            if(player.getInventory().getArmorStack(EquipmentSlot.FEET.getEntitySlotId()).getItem() == ModItems.ODD_BOOTS && player.getInventory().getArmorStack(EquipmentSlot.LEGS.getEntitySlotId()).getItem() == ModItems.ODD_LEGGINGS) {
                if (!player.hasStatusEffect(StatusEffects.JUMP_BOOST)) {
                    player.addStatusEffect(JUMPEFFECT);
                }


                player.fallDistance = 0;
            }








        }
    }



}
