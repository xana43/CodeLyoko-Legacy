package com.Ultra_Nerd.CodeLyokoLegacy.items.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import org.jetbrains.annotations.NotNull;

public final class ArmorNinja extends LyokoArmor {
    public ArmorNinja(@NotNull ArmorMaterial materialIn, @NotNull EquipmentSlot slot, @NotNull Settings builder) {
        super(materialIn, slot, builder);
    }
/*
    @Override
    public void onArmorTick(ItemStack stack, @NotNull Level world, @NotNull Player player) {


        final BlockHitResult trace = new BlockHitResult(player.getLookAngle(), player.getDirection(),player.eyeBlockPosition(),false);
        final BlockPos pos = new BlockPos(trace.getBlockPos().getX(), trace.getBlockPos().getY(), trace.getBlockPos().getZ());
        final Block test = world.getBlockState(pos).getBlock();


    }

 */
}
