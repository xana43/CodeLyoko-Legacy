package com.Ultra_Nerd.CodeLyokoLegacy.Blocks;


import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModBlocks;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.common.ModDamageSources;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoulSandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;


public final class Marabunta extends SoulSandBlock {


    public Marabunta() {
        super(FabricBlockSettings.copyOf(Blocks.DRAGON_EGG)
                .strength(6, 10)
                .sounds(BlockSoundGroup.STONE).ticksRandomly()


        );
    }

    @Override
    public void randomTick(final BlockState state, final ServerWorld world, final BlockPos pos, final net.minecraft.util.math.random.Random random) {
        super.randomTick(state, world, pos, random);
        for (int i = 0; i < 90; ++i) {
            final BlockPos blockpos = pos.offset(Direction.Axis.pickRandomAxis(random), random.nextInt(3) - 1);

            if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !world.isChunkLoaded(
                    world.getWorldChunk(pos).getPos().x, world.getWorldChunk(pos).getPos().z)) {
                return;
            }
            // BlockState iblockstate = worldIn.getBlockState(blockpos.up());
            final BlockState iblockstate1 = world.getBlockState(blockpos);

            if (iblockstate1.getBlock() == Blocks.COARSE_DIRT || iblockstate1.getBlock() == Blocks.DIRT_PATH || iblockstate1.getBlock() == Blocks.DIRT || iblockstate1.getBlock() == ModBlocks.DIGITAL_GRASS || iblockstate1.getBlock() == ModBlocks.DIGITAL_ICE || iblockstate1.getBlock() == Blocks.GRASS_BLOCK) {
                world.setBlockState(blockpos, ModBlocks.MARABUNTA.getDefaultState());
            }
        }
    }








    /*
     * Called When an Entity Collided with the Block
     */

    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        entity.damage(ModDamageSources.marabuntaDamageSource, Random.create().nextInt(10));
    }


    @Override
    public boolean canMobSpawnInside(final BlockState state) {
        return false;
    }
}
