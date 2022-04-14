package com.Ultra_Nerd.CodeLyokoRemake15.player.Dimension;

import com.Ultra_Nerd.CodeLyokoRemake15.Util.client.DimensionCheck;
import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import com.Ultra_Nerd.CodeLyokoRemake15.player.Capabilities.CapabilityRegistration;
import com.Ultra_Nerd.CodeLyokoRemake15.player.PlayerClassType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public final class ClassDetection
{
        private static PlayerClassType blitType;
        public static PlayerClassType getClass(Player player)
        {
            if(DimensionCheck.playerNotInVanillaWorld(player)) {
                player.getCapability(CapabilityRegistration.CLASS_CAPABILITY).ifPresent(capability -> blitType = capability.getClassType());

                return blitType;
            }
            else
            {
                return null;
            }

        }

        public static void setDimensionItems(PlayerClassType playerClassType, Player player)
        {
            if(DimensionCheck.playerNotInVanillaWorld(player)) {
                saveInventory(player.getInventory());
                player.getInventory().clearContent();
                player.getInventory().setItem(EquipmentSlot.HEAD.getIndex(), new ItemStack(ModItems.BLANKHELMET.get()));
                if (playerClassType != null) {
                    switch (playerClassType) {
                        case Feline -> {


                        }
                    }
                }
            }
        }

        private static void saveInventory(Inventory player)
        {
            final CompoundTag tag = player.player.getPersistentData();
            ListTag inventory;
            final String nbt = "normal_inventory";
            if(!tag.contains(Player.PERSISTED_NBT_TAG))
            {
                tag.put(Player.PERSISTED_NBT_TAG,(inventory = new ListTag()));
            }
            else
            {
                inventory = tag.getList(Player.PERSISTED_NBT_TAG,9);
            }


            player.save(inventory);

        }

}
