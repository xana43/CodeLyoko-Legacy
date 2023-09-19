package com.Ultra_Nerd.CodeLyokoLegacy.blocks.Fluids.definition;

import com.Ultra_Nerd.CodeLyokoLegacy.Entity.MantaEntity;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.Piranha;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.vehicle.EntitySkid;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDamageSources;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModFluids;
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
        if (!(entity instanceof EntitySkid) && !(entity instanceof Piranha) && !(entity instanceof MantaEntity) && !world.isClient) {
            entity.damage(ModDamageSources.digitalOceanSource, Float.MAX_VALUE);
            if (entity instanceof ArrowEntity) {
                entity.kill();
            }
        }
    }




}
