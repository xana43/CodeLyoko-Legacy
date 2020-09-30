package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import com.Ultra_Nerd.CodeLyokoRemake15.Base;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MindHelm extends ArmorItem {
    private static int timer = 3600000;
    private static boolean inventory = false;
    private byte damage = 1;

    public MindHelm(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }

    @SubscribeEvent
    public static void resting(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END || event.phase == TickEvent.Phase.START) {
            if (inventory && timer != 3600000) {
                timer++;
            }
        }
    }


    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {

        inventory = false;
        if (timer-- <= 0) {
            damage++;
            player.getEntity().attackEntityFrom(new DamageSource(this.getTranslationKey()), damage);
            timer = 60000;
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, @Nonnull World worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {

        if (stack.getEquipmentSlot() != EquipmentSlotType.HEAD || itemSlot != EquipmentSlotType.HEAD.getIndex()) {
            inventory = true;
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
