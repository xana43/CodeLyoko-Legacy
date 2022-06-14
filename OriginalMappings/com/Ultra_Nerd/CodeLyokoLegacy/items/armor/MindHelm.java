package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import org.jetbrains.annotations.NotNull;

//@Mod.EventBusSubscriber(modid = CodeLyokoMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class MindHelm extends ArmorItem {
    private static int timer = 3600000;
    private byte damage = 1;
    private static boolean inventory = false;

    public MindHelm(@NotNull ArmorMaterial materialIn, @NotNull EquipmentSlot slot, @NotNull Settings builder) {
        super(materialIn, slot, builder);
    }
/*
    @SubscribeEvent
    public void resting(final TickEvent.@NotNull PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END || event.phase == TickEvent.Phase.START) {
            if (inventory && timer != 3600000) {
                timer++;
            }
        }
    }




    @Override
    public void onArmorTick(ItemStack stack, Level world, @NotNull Player player) {

        inventory = false;
        if (timer-- <= 0) {
            damage++;
            player.hurt(new DamageSource("Stress"), damage);
            timer = 60000;
        }
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @Nonnull Level worldIn, @Nonnull Entity entityIn, int itemSlot, boolean isSelected) {

        if (stack.getEquipmentSlot() != EquipmentSlot.HEAD || itemSlot != EquipmentSlot.HEAD.getIndex()) {
            inventory = true;
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

 */
}
