package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.Util.DamageSources.LyokoDamage;
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

import java.util.Random;

public final class FrontierBlock extends TransparentBlock {
    public FrontierBlock() {
        super(FabricBlockSettings.copyOf(Blocks.BARRIER));
    }




    private static int DamangeTime = 10000;


    @Override
    public void randomTick(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        super.randomTick(state, world, pos, random);
        if(world.getRegistryKey() == ModDimensions.forestSectorWorld) {
            DamangeTime -= random.nextInt(0, 10);
        }
    }


    @Override
    public void scheduledTick(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        super.scheduledTick(state, world, pos, random);
        if(DamangeTime <= 0)
        {
            final Iterable<Entity> serverEntities = world.iterateEntities();
            final DamageSource source = new LyokoDamage(this.getName().toString()).setBypassesArmor();
            for(Entity entity : serverEntities)
            {
                if(entity instanceof ItemEntity itemEntity)
                {
                    itemEntity.remove(Entity.RemovalReason.KILLED);
                }
                entity.damage(source,random.nextInt(0,20));
            }
            DamangeTime = 10000;
        }
    }




}
