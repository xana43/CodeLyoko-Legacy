package com.Ultra_Nerd.CodeLyokoRemake15.items.armor;

import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.Carthage.Sector5Dimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DesertSector.DesertDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.DigitalOcean.OceanDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.ForestSector.ForestDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.IceSector.IceDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.MountainSector.MountainDimension;
import com.Ultra_Nerd.CodeLyokoRemake15.world.dimension.VolcanoSector.VolcanoDimension;
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
    private boolean checkDim(PlayerEntity player) {
        return player.world.dimension instanceof ForestDimension || player.world.dimension instanceof IceDimension ||
                player.world.dimension instanceof DesertDimension || player.world.dimension instanceof MountainDimension
                || player.world.dimension instanceof Sector5Dimension || player.world.dimension instanceof OceanDimension || player.world.dimension
                instanceof VolcanoDimension;
    }
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {


        RayTraceResult trace = rayTrace(world, player, RayTraceContext.FluidMode.NONE);
        BlockPos pos = new BlockPos(trace.getHitVec().getX(), trace.getHitVec().getY(), trace.getHitVec().getZ());
        Block test = world.getWorld().getBlockState(pos).getBlock();


    }
}
