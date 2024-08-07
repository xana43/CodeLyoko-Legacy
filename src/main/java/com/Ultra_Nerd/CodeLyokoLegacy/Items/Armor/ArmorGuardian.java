package com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.event.GameEvent;


public final class ArmorGuardian extends LyokoArmor implements FabricElytraItem {


    public ArmorGuardian(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public boolean useCustomElytra(final LivingEntity entity, final ItemStack chestStack, final boolean tickElytra) {
        if(isLyokoElytraUsable(entity,chestStack)) {
            if(tickElytra) {
                lyokoElytraTick(entity,chestStack);
            }
            return true;
        }
        return false;
    }

    private static boolean isLyokoElytraUsable(final LivingEntity entity,final ItemStack stack)
    {
        if(entity instanceof final PlayerEntity player)
        {
            //return true;
            return CardinalData.LyokoClass.getLyokoClass(player) == 2 && ElytraItem.isUsable(stack);
        }
        return true;
    }
    private static void lyokoElytraTick(final LivingEntity entity, final ItemStack stack)
    {
        final int nextRoll = entity.getRandom().nextInt();
        if (!entity.getWorld().isClient && nextRoll % 10 == 0) {
            if ((nextRoll / 10) % 2 == 0) {
                if(entity.isFallFlying()) {
                    entity.setNoGravity(entity.forwardSpeed <= 0.5f);
                    stack.damage(1,entity,EquipmentSlot.CHEST);

                }
                else
                {
                    if(entity.hasNoGravity() && !entity.isSneaking())
                    {
                        if(entity instanceof PlayerEntity)
                        {
                        }
                    }
                    stack.damage(-1,entity,EquipmentSlot.CHEST);
                }
            }

            entity.emitGameEvent(GameEvent.ELYTRA_GLIDE);
        }
    }
}
