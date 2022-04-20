package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.client.DimensionCheck;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModItems;
import com.Ultra_Nerd.CodeLyokoLegacy.items.armor.Models.Util.ArmorModelRenderer;
import com.Ultra_Nerd.CodeLyokoLegacy.items.armor.Models.Util.ModModelLayers;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.IItemRenderProperties;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.function.Consumer;

public final class ArmorFeline extends ArmorItem {


    private static final double movement_modifier = 0.6;
    public ArmorFeline(@NotNull ArmorMaterial materialIn, @NotNull EquipmentSlot slot, @NotNull Properties builder) {
        super(materialIn, slot, builder);



    }

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

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute,AttributeModifier> multimap = HashMultimap.create();

//new AttributeModifier(UUID.fromString("46656c69-6e65-204a-756d-7020426f6f73"),"jump_modifier"
        if(slot == EquipmentSlot.FEET)
        {
            multimap.put(Attributes.MOVEMENT_SPEED,new AttributeModifier(UUID.fromString("91AEAA56-376B-4498-935B-2F7F68070635"),"speed_modifier",movement_modifier, AttributeModifier.Operation.MULTIPLY_TOTAL));
            //multimap.put(Attributes);
        }
        return multimap;
    }

    @Override
    public boolean isFoil(final @NotNull ItemStack pStack) {
        return false;
    }



    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public int getDefaultTooltipHideFlags(@NotNull final ItemStack stack) {
        return ItemStack.TooltipPart.ENCHANTMENTS.getMask();
    }

    @Override
    public void inventoryTick(final ItemStack stack, final Level pLevel, final Entity pEntity, final int pSlotId, final boolean pIsSelected) {
        super.inventoryTick(stack, pLevel, pEntity, pSlotId, pIsSelected);
        if(!stack.isEnchanted()) {

            stack.enchant(Enchantments.BINDING_CURSE,Enchantments.BINDING_CURSE.getMaxLevel());
        }
    }
private static final MobEffectInstance JUMPEFFECT = new MobEffectInstance(MobEffects.JUMP, -1, 3, false, false, false);
    @Override
    public void onArmorTick(ItemStack stack, Level world, @NotNull Player player) {

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


            if(!stack.isEnchanted()) {
                //preventRemoval(stack);
                stack.enchant(Enchantments.BINDING_CURSE,Enchantments.BINDING_CURSE.getMaxLevel());
            }
            if(player.getEffect(MobEffects.JUMP) == null) {
                player.addEffect(JUMPEFFECT);
            }




                        player.fallDistance = 0;









        }
    }


}
