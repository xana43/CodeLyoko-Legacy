package com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.EntitySkid;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFluids;
import com.Ultra_Nerd.CodeLyokoLegacy.util.DamageSources.LyokoDamage;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public final class DigitalSeaBlock extends FluidBlock {


    public DigitalSeaBlock() {
        super(ModFluids.STILL_DIGITAL_OCEAN, FabricBlockSettings.copy(Blocks.WATER));
    }

    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if (!(entity instanceof EntitySkid) && !world.isClient) {
            entity.damage(new LyokoDamage(this.getTranslationKey()).setBypassesArmor().setNeutral(), Float.MAX_VALUE);
            if (entity instanceof ArrowEntity) {
                entity.kill();
            }
        }
    }



    /*
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

 */
}
