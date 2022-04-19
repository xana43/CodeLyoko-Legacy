package com.Ultra_Nerd.CodeLyokoLegacy.blocks;


import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Random;

public final class Marabunta extends Block  {
    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    public Marabunta() {
        super(Block.Properties.of(Material.EGG)
                .strength(6, 10)
                .sound(SoundType.STONE)

        );
    }

    @Override
    public boolean isRandomlyTicking(BlockState p_49921_) {
        return true;
    }



    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos,
                                        @Nonnull CollisionContext context) {
        // TODO Auto-generated method stub
        return SHAPE;
    }


    @Override
    public float getFriction() {
        return Blocks.SOUL_SAND.getFriction();
    }

    /**
     * Called When an Entity Collided with the Block
     */
    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @NotNull Entity entityIn) {

        entityIn.hurt(new DamageSource(this.getRegistryName().toString()), RANDOM.nextInt(10));
    }


    @Override
    public void tick(@Nonnull BlockState state, ServerLevel worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        // TODO Auto-generated method stub
       // if (worldIn.isClientSide) {
            for (int i = 0; i < 90; ++i) {
                BlockPos blockpos = pos.offset(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isLoaded(blockpos)) {
                    return;
                }
                // BlockState iblockstate = worldIn.getBlockState(blockpos.up());
              final BlockState iblockstate1 = worldIn.getBlockState(blockpos);

                if (iblockstate1.getBlock() == Blocks.COARSE_DIRT || iblockstate1.getBlock() == Blocks.DIRT_PATH || iblockstate1.getBlock() == Blocks.DIRT || iblockstate1.getBlock() == ModBlocks.DIGITAL_GRASS.get() || iblockstate1.getBlock() == ModBlocks.DIGITAL_ICE.get() || iblockstate1.getBlock() == Blocks.GRASS_BLOCK) {
                    worldIn.setBlockAndUpdate(blockpos, ModBlocks.MARABUNTA.get().defaultBlockState());
                }
            }
        //}
    }


    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }
}