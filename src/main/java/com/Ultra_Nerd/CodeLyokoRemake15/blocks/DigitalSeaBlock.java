package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.CodeLyokoMain;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.EntitySkid;
import com.Ultra_Nerd.CodeLyokoRemake15.Entity.MantaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nonnull;
import java.util.function.Supplier;


public class DigitalSeaBlock extends LiquidBlock {


    public DigitalSeaBlock(Supplier<? extends FlowingFluid> supplier) {
        super(supplier, LiquidBlock.Properties.of(Material.WATER).strength(-1,-1).noOcclusion().noCollission().noDrops().friction(0));


    }


    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Entity entityIn) {
        if (!(entityIn instanceof MantaEntity) && !(entityIn instanceof EntitySkid) && !(entityIn.getVehicle() instanceof EntitySkid)) {
            entityIn.hurt(CodeLyokoMain.RegistryEventHandler.DigitaloceanDamageSource,Float.MAX_VALUE);
        }
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
