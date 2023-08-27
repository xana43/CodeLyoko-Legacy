package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDamageSources;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModDimensions;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TransparentBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;


public final class FrontierBlock extends TransparentBlock {
    private int DamageTime = 10000;


    public FrontierBlock() {
        super(FabricBlockSettings.copyOf(Blocks.BARRIER));
    }

    @Override
    public void randomTick(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        super.randomTick(state, world, pos, random);
        if (world.getRegistryKey() == ModDimensions.forestSectorWorld) {
            DamageTime -= random.nextInt(10);
        }
    }


    @Override
    public void scheduledTick(final BlockState state, final ServerWorld world, final BlockPos pos, final net.minecraft.util.math.random.Random random) {
        super.scheduledTick(state, world, pos, random);
        if (DamageTime <= 0) {
            final Iterable<Entity> serverEntities = world.iterateEntities();
            final DamageSource source = ModDamageSources.frontierDamageSource;
            for (final Entity entity : serverEntities) {
                if (entity instanceof final ItemEntity itemEntity) {
                    itemEntity.remove(Entity.RemovalReason.KILLED);
                }
                entity.damage(source, random.nextInt(20));
            }
            DamageTime = 10000;
        }
    }


}
