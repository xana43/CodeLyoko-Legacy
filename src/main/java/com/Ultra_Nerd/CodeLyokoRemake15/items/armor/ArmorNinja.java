package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ArmorNinja extends ArmorItem {
    public ArmorNinja(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {


          RayTraceResult trace = rayTrace(world,player, RayTraceContext.FluidMode.NONE);
          BlockPos pos = new BlockPos(trace.getHitVec().getX(),trace.getHitVec().getY(),trace.getHitVec().getZ());
          Block test = world.getWorld().getBlockState(pos).getBlock();
          

    }
}
