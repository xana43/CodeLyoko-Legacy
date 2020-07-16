package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Supplier;

public class LiquidHelium extends FlowingFluidBlock {

    public LiquidHelium(Supplier<? extends FlowingFluid> supplier) {
        super(supplier, Block.Properties.from(Blocks.WATER).variableOpacity()

        );

    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.attackEntityFrom(new DamageSource(this.getTranslationKey()), RANDOM.nextInt(4));
        if(entityIn instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entityIn;
            livingEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, -1, 3, false, false, false));
            livingEntity.limbSwingAmount = 0;
            livingEntity.limbSwing = 0;
            livingEntity.prevLimbSwingAmount = 0;
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(),pos.getZ() +1), Blocks.SNOW.getDefaultState());
        super.tick(state, worldIn, pos, rand);
    }


}
