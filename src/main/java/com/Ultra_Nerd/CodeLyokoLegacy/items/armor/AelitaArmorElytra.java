package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.NotNull;


public final class AelitaArmorElytra extends LyokoArmor implements FabricElytraItem {
    public AelitaArmorElytra(@NotNull ArmorMaterial materialIn, @NotNull ArmorItem.Type slot,
            @NotNull Settings builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public boolean useCustomElytra(final LivingEntity entity, final ItemStack chestStack, final boolean tickElytra) {
        if(isLyokoElytraUsable(entity,chestStack))
        {
            if(tickElytra)
            {
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
            return true;
            //return CardinalData.LyokoClass.getLyokoClass(player) == 2 && ElytraItem.isUsable(stack);
        }
        return true;
    }
    private static void lyokoElytraTick(final LivingEntity entity, final ItemStack stack)
    {
        final int nextRoll = entity.getRoll() + 1;
        if (!entity.getWorld().isClient && nextRoll % 10 == 0) {
            if ((nextRoll / 10) % 2 == 0) {
                if(entity.isFallFlying()) {
                    entity.setNoGravity(entity.forwardSpeed <= 0.5f && !entity.isSneaking());
                    stack.damage(1, entity, p -> p.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
                }
                else
                {
                    stack.damage(-1,entity,p-> p.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
                }
            }

            entity.emitGameEvent(GameEvent.ELYTRA_GLIDE);
        }
    }
}
