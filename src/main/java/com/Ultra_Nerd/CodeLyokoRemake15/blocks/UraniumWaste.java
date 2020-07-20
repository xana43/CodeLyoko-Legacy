package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class UraniumWaste extends FlowingFluidBlock {
    public UraniumWaste(Supplier<? extends FlowingFluid> supplier) {
        super(supplier, Block.Properties.create(Material.LAVA)
                .noDrops()
                .hardnessAndResistance(100,100)
                .doesNotBlockMovement()
                .lightValue(5)

        );
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof LivingEntity)
        {
            LivingEntity livingEntity = (LivingEntity)entityIn;
            if(!livingEntity.isPotionActive(Effects.NAUSEA) || !livingEntity.isPotionActive(Effects.POISON)) {
                livingEntity.addPotionEffect(new EffectInstance(Effects.POISON, 10, 3, false, false, false));
                livingEntity.addPotionEffect(new EffectInstance(Effects.NAUSEA, 255, 255, false, false, false));
            }
        }
    }
}
