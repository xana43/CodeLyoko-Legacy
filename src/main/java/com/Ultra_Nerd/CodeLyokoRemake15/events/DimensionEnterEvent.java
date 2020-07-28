package com.Ultra_Nerd.CodeLyokoRemake15.events;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = Base.MOD_ID, value = Dist.CLIENT)
public class DimensionEnterEvent {


    /*@SubscribeEvent
    public static void EnterDimension(PlayerEvent.PlayerChangedDimensionEvent event)
    {


           PlayerEntity player = event.getPlayer();

                if (player.world.dimension instanceof ForestDimension) {
                        if(player.inventory.armorInventory.isEmpty()) {
                            player.inventory.armorInventory.add(EquipmentSlotType.CHEST.getSlotIndex(), new ItemStack(ModItems.AELITA_CHESTPLATE.get()));
                        }
                }



    }

     */
}
