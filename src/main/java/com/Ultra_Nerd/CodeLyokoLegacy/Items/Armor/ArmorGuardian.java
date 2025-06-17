package com.Ultra_Nerd.CodeLyokoLegacy.Items.Armor;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.CardinalData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;


public final class ArmorGuardian extends LyokoArmor {

    public ArmorGuardian(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        super.inventoryTick(stack, world, entity, slot);
    }

    private static boolean isLyokoElytraUsable(final LivingEntity entity,final ItemStack stack)
    {
        if(entity instanceof final PlayerEntity player)
        {
            //return true;
            return CardinalData.LyokoClass.getLyokoClass(player) == 2;
        }
        return true;
    }
    private static void lyokoElytraTick(final LivingEntity entity, final ItemStack stack)
    {
        final int nextRoll = entity.getRandom().nextInt();
        if (!entity.getWorld().isClient && nextRoll % 10 == 0) {
            if ((nextRoll / 10) % 2 == 0) {
                if(entity.elytraFlightController != null) {
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
