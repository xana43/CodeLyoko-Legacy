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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Base.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MindHelm extends ArmorItem {
    private static int timer = 3600000;
    private byte damage = 1;
    private static boolean inventory = false;

    public MindHelm(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
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
    public void onArmorTick(ItemStack stack, Level world, Player player) {

        inventory = false;
        if (timer-- <= 0) {
            damage++;
            player.hurt(new DamageSource("Stress"), damage);
            timer = 60000;
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {

        if (stack.getEquipmentSlot() != EquipmentSlot.HEAD || itemSlot != EquipmentSlot.HEAD.getIndex()) {
            inventory = true;
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
