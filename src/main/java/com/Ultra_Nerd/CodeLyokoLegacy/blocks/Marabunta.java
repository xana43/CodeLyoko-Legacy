package com.Ultra_Nerd.CodeLyokoLegacy.blocks;


import com.Ultra_Nerd.CodeLyokoLegacy.Util.DamageSources.LyokoDamage;
import com.Ultra_Nerd.CodeLyokoLegacy.init.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public final class Marabunta extends Block {


    private static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

    public Marabunta() {
        super(FabricBlockSettings.of(Material.EGG)
                .strength(6, 10)
                .sounds(BlockSoundGroup.STONE).ticksRandomly()

        );
    }




    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return SHAPE;
    }

    @Override
    public float getSlipperiness() {
        return Blocks.SOUL_SAND.getSlipperiness();
    }



    /*
     * Called When an Entity Collided with the Block
    */

    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        entity.damage(new LyokoDamage(this.getTranslationKey()), new Random().nextInt(10));
    }

    @Override
    public void scheduledTick(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {
        super.scheduledTick(state, world, pos, random);
        for (byte i = 0; i < 90; ++i) {
            BlockPos blockpos = pos.offset(Direction.Axis.pickRandomAxis(random),random.nextInt(3) - 1);

            if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !world.isChunkLoaded(blockpos)) {
                return;
            }
            // BlockState iblockstate = worldIn.getBlockState(blockpos.up());
            final BlockState iblockstate1 = world.getBlockState(blockpos);

            if (iblockstate1.getBlock() == Blocks.COARSE_DIRT || iblockstate1.getBlock() == Blocks.DIRT_PATH || iblockstate1.getBlock() == Blocks.DIRT || iblockstate1.getBlock() == ModBlocks.DIGITAL_GRASS || iblockstate1.getBlock() == ModBlocks.DIGITAL_ICE || iblockstate1.getBlock() == Blocks.GRASS_BLOCK) {
                world.setBlockState(blockpos, ModBlocks.MARABUNTA.getDefaultState());
            }
        }
    }


    @Override
    public boolean canMobSpawnInside() {
        return false;
    }
}
