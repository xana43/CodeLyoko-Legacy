package com.Ultra_Nerd.CodeLyokoLegacy.Blocks.Fluids.definition;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.MantaEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.HostileEntities.Piranha;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.SamuraiClass.ServerTriplicateCloneEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.VehicleEntities.SkidbladnirEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModDamageSources;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModFluids;
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
        if (!(entity instanceof SkidbladnirEntity) && !(entity instanceof Piranha) && !(entity instanceof MantaEntity) && !world.isClient) {
            entity.damage(ModDamageSources.digitalOceanSource, Float.MAX_VALUE);
            if (entity instanceof ArrowEntity) {
                entity.kill();
            }
            if(entity instanceof final ServerTriplicateCloneEntity triplicateClone)
            {
                triplicateClone.kill();
            }
        }
    }




}
