package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.MantaEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.EntitySkid;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.function.Supplier;


public final class DigitalSeaBlock extends LiquidBlock {


    public DigitalSeaBlock(@NotNull Supplier<? extends FlowingFluid> supplier) {
        super(supplier, LiquidBlock.Properties.copy(Blocks.WATER).friction(0));


    }


    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        if (!(entityIn instanceof MantaEntity) && !(entityIn instanceof EntitySkid) && !(entityIn.getVehicle() instanceof EntitySkid)) {
            entityIn.hurt(CodeLyokoMain.RegistryEventHandler.DigitaloceanDamageSource,Float.MAX_VALUE);
        }
    }

    @Override
    public float getFriction(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity) {
        return 0;
    }



    @Override
    public float getFriction() {
        return 0;
    }



    @Override
    public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter level, BlockPos pos, FluidState fluidState) {
        return false;
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
