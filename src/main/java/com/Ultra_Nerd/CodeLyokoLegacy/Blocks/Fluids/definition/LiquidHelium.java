package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.definition;

import com.Ultra_Nerd.CodeLyokoLegacy.init.common.ModFluids;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.security.SecureRandom;

public final class LiquidHelium extends FluidBlock {
    public LiquidHelium() {
        super(ModFluids.STILL_LIQUID_HELIUM, FabricBlockSettings.copy(Blocks.WATER));
    }

    private static final SecureRandom random = new SecureRandom();
    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        if (entity instanceof final LivingEntity livingEntity) {

            if(!livingEntity.isInvulnerable()) {
                livingEntity.handSwingProgress = 0;
                livingEntity.inPowderSnow = true;
                livingEntity.setOnFire(false);
                livingEntity.slowMovement(state, new Vec3d(0.8999999761581421, 1.5, 0.8999999761581421));
                livingEntity.damage(entity.getWorld().getDamageSources().freeze(), random.nextInt(3));
            }
        }
    }



    @Override
    public void onBlockAdded(final BlockState state, final World worldIn, final BlockPos pos, final BlockState oldState, final boolean notify) {
        for(final Direction direction : Direction.values())
        {
            if(worldIn.getBlockState(pos.offset(direction)) == Blocks.WATER.getDefaultState())
            {
                worldIn.setBlockState(pos.offset(direction),Blocks.BLUE_ICE.getDefaultState());
            }
            if(worldIn.getBlockState(pos.offset(direction)) == Blocks.LAVA.getDefaultState())
            {
                worldIn.setBlockState(pos.offset(direction),Blocks.DIAMOND_BLOCK.getDefaultState());
            }
            if(worldIn.getFluidState(pos.offset(direction)) == Fluids.FLOWING_WATER.getDefaultState())
            {
                worldIn.setBlockState(pos.offset(direction),Blocks.BLUE_ICE.getDefaultState());
            }
            if(worldIn.getFluidState(pos.offset(direction)) == Fluids.FLOWING_LAVA.getDefaultState())
            {
                worldIn.setBlockState(pos.offset(direction), Blocks.OBSIDIAN.getDefaultState());
            }
            if(worldIn.getBlockState(pos.offset(direction)) == Blocks.AIR.getDefaultState())
            {
                worldIn.setBlockState(pos.offset(direction),Blocks.SNOW.getDefaultState());
            }
        }
        super.onBlockAdded(state, worldIn, pos, oldState, notify);
    }


}
