package com.Ultra_Nerd.CodeLyokoRemake15.blocks;


import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import java.util.Random;

public class Marabunta extends Block {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    public Marabunta() {
        super(Block.Properties.of(Material.EGG)
                .strength(6, 10)
                .sound(SoundType.STONE)

        );
    }

    @Nonnull
    @Override
    public VoxelShape getCollisionShape(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos,
                                        @Nonnull ISelectionContext context) {
        // TODO Auto-generated method stub
        return SHAPE;
    }

    /**
     * Called When an Entity Collided with the Block
     */
    @Override
    public void onEntityCollision(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, Entity entityIn) {
        entityIn.setMotionMultiplier(this.getDefaultState(), new Vec3d(0.2, 0.2, 0.2));
        entityIn.attackEntityFrom(new DamageSource(this.getTranslationKey()), RANDOM.nextInt(10));
    }

    @Override
    public void tick(@Nonnull BlockState state, ServerWorld worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        // TODO Auto-generated method stub
        if (!worldIn.isRemote) {
            for (int i = 0; i < 90; ++i) {
                BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos)) {
                    return;
                }
                // BlockState iblockstate = worldIn.getBlockState(blockpos.up());
                BlockState iblockstate1 = worldIn.getBlockState(blockpos);

                if (iblockstate1.getBlock() == Blocks.COARSE_DIRT || iblockstate1.getBlock() == Blocks.GRASS_PATH || iblockstate1.getBlock() == Blocks.DIRT || iblockstate1.getBlock() == ModBlocks.DIGITAL_GRASS.get() || iblockstate1.getBlock() == ModBlocks.DIGITAL_ICE.get() || iblockstate1.getBlock() == Blocks.GRASS_BLOCK) {
                    worldIn.setBlockState(blockpos, ModBlocks.MARABUNTA.get().getDefaultState());
                }
            }
        }
    }


    @Override
    public boolean canEntitySpawn(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull EntityType<?> type) {
        // TODO Auto-generated method stub
        return false;
    }


}
