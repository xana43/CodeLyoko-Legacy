package com.Ultra_Nerd.CodeLyokoRemake15.events;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = Base.MOD_ID, value = Dist.CLIENT)
public class DimensionEnterEvent {

    @SubscribeEvent
    public static void EnterDimension(TickEvent.PlayerTickEvent event)
    {
        PlayerEntity player = event.player;
        if(event.side.isClient()) {
            if(event.phase == TickEvent.Phase.START || event.phase == TickEvent.Phase.END)
            {

                if (player.world.dimension instanceof ForestDimension) {
                        if(player.inventory.armorInventory.isEmpty()) {
                            player.inventory.armorInventory.add(EquipmentSlotType.CHEST.getSlotIndex(), new ItemStack(ModItems.AELITA_CHESTPLATE.get()));
                        }
                }

            }
        }
    }
}
