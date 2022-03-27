package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.Entity.MantaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Supplier;


public class DigitalSeaBlock extends LiquidBlock {


    public DigitalSeaBlock(Supplier<? extends FlowingFluid> supplier) {
        super(supplier, BlockBehaviour.Properties.copy(Blocks.WATER).noOcclusion().color(MaterialColor.WATER));
    }


    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        if (!(entityIn instanceof MantaEntity)) {
            entityIn.hurt(new DamageSource(Objects.requireNonNull(this.getRegistryName()).toString()).bypassArmor(), Byte.MAX_VALUE);
        }
    }

    @Override
    public boolean isPossibleToRespawnInThis() {
        return false;
    }

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }




    @Override
    public boolean propagatesSkylightDown(@Nonnull BlockState state, @Nonnull BlockGetter reader, @Nonnull BlockPos pos) {
        return true;
    }
}
