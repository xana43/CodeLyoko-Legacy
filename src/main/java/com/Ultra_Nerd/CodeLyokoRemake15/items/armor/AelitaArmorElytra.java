package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AelitaArmorElytra extends ArmorItem {

    public AelitaArmorElytra(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }



    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.inventory.armorItemInSlot(EquipmentSlotType.CHEST.getIndex()).getItem() == ModItems.AELITA_CHESTPLATE.get())
        {
            if(player.isAirBorne && player.isCrouching() && !player.onGround)
            {
                if(!player.isElytraFlying()) {
                    player.startFallFlying();

                }
                player.onLivingFall(0,0);
            }
            else if(player.isElytraFlying())
            {
                player.stopFallFlying();
                player.onLivingFall(0,0);
            }
        }
    }
}
