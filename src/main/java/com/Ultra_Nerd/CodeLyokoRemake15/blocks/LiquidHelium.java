package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.ILightReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class LiquidHelium extends FlowingFluidBlock {

    public LiquidHelium(Supplier<? extends FlowingFluid> supplier) {
        super(supplier, Block.Properties.from(Blocks.WATER).variableOpacity()

        );

    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entityIn;
            livingEntity.attackEntityFrom(new DamageSource(this.getTranslationKey()), RANDOM.nextInt(2));
            livingEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, -1, 6, false, false, false));
            livingEntity.limbSwingAmount = 0;
            livingEntity.limbSwing = 0;
            livingEntity.prevLimbSwingAmount = 0;
        }
    }

    @Override
    public Vec3d getFogColor(BlockState state, IWorldReader world, BlockPos pos, Entity entity, Vec3d originalColor, float partialTicks) {
        return new Vec3d(1,1,1);
    }

    @Override
    public boolean shouldDisplayFluidOverlay(BlockState state, ILightReader world, BlockPos pos, IFluidState fluidState) {
        return true;
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        //water
        if(worldIn.getBlockState(new BlockPos(pos.getX(),pos.getY() - 1 ,pos.getZ())) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() , pos.getY() - 1, pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX(),pos.getY() + 1 ,pos.getZ())) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() , pos.getY() + 1, pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getFluidState(new BlockPos(pos.getX(),pos.getY() - 1 ,pos.getZ())) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() , pos.getY() - 1, pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX(),pos.getY() - 1 ,pos.getZ())) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() , pos.getY() - 1, pos.getZ()), Blocks.DIAMOND_BLOCK.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX(),pos.getY() + 1 ,pos.getZ())) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() , pos.getY() + 1, pos.getZ()), Blocks.DIAMOND_BLOCK.getDefaultState());
        }
        if(worldIn.getFluidState(new BlockPos(pos.getX(),pos.getY() - 1 ,pos.getZ())) == Fluids.FLOWING_LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() , pos.getY() - 1, pos.getZ()), Blocks.OBSIDIAN.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() + 1)) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() - 1)) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ() + 1)) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ())) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ())) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ() - 1)) == Blocks.WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() + 1)) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() - 1)) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ() + 1)) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ())) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ())) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ() - 1)) == Blocks.LAVA.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getFluidState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() + 1)) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getFluidState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() - 1)) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getFluidState(new BlockPos(pos.getX(),pos.getY(),pos.getZ() + 1)) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getFluidState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ())) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getFluidState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ())) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
        }
        if(worldIn.getFluidState(new BlockPos(pos.getX(),pos.getY(),pos.getZ() - 1)) == Fluids.FLOWING_WATER.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.BLUE_ICE.getDefaultState());
        }
        //snow
        if(worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() + 1)) == Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 1), Blocks.SNOW.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() - 1)) == Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ() - 1), Blocks.SNOW.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ() + 1)) == Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.SNOW.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ())) == Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.SNOW.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ())) == Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.SNOW.getDefaultState());
        }
        if(worldIn.getBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ() - 1)) == Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.SNOW.getDefaultState());
        }

        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
    }
}
