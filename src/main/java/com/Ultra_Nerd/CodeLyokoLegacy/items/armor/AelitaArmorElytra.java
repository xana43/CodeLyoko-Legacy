package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import com.Ultra_Nerd.CodeLyokoLegacy.util.CardinalData;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ElytraItem;
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
            //return true;
            return CardinalData.LyokoClass.getLyokoClass(player) == 2 && ElytraItem.isUsable(stack);
        }
        return true;
    }
    private static void lyokoElytraTick(final LivingEntity entity, final ItemStack stack)
    {
        final int nextRoll = entity.getRoll() + 1;
        if (!entity.getWorld().isClient && nextRoll % 10 == 0) {
            if ((nextRoll / 10) % 2 == 0) {
                if(entity.isFallFlying()) {
                    entity.setNoGravity(entity.forwardSpeed <= 0.5f);
                    stack.damage(1, entity, p -> p.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
                }
                else
                {
                    if(entity.hasNoGravity() && !entity.isSneaking())
                    {
                        if(entity instanceof PlayerEntity)
                        {
                            final MinecraftClient minecraftClient = MinecraftClient.getInstance();


                        }
                    }
                    stack.damage(-1,entity,p-> p.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
                }
            }

            entity.emitGameEvent(GameEvent.ELYTRA_GLIDE);
        }
    }
}
