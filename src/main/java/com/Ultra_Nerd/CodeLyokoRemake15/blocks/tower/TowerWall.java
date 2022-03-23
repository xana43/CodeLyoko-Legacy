package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tower;

import com.Ultra_Nerd.CodeLyokoRemake15.particles.TowerParticleData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.Random;


public class TowerWall extends Block {

    public static final DirectionProperty DIRTOWER = BlockStateProperties.HORIZONTAL_FACING;

    public TowerWall() {
        super(Block.Properties.of(Material.BARRIER)
                .strength(-1, -1)
                .sound(SoundType.GLASS)

        );

    }


    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }



    @Override
    public int getLightBlock(BlockState p_60585_, BlockGetter p_60586_, BlockPos p_60587_) {
        return 5;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        return 5;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRTOWER);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // TODO Auto-generated method stub
        return this.defaultBlockState().setValue(DIRTOWER, context.getHorizontalDirection().getOpposite());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(DIRTOWER, rot.rotate(state.getValue(DIRTOWER)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(DIRTOWER)));
    }
    //




    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(@Nonnull BlockState stateIn, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        double d0 = (double) pos.getX() + 0.5D + (rand.nextDouble() - 0.5D);
        double d1 = (double) pos.getY() + 0.5D + (rand.nextDouble() - 0.5D);
        double d2 = (double) pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D);
        if (stateIn.getValue(DIRTOWER) == Direction.NORTH) {
            worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                    d0, d1, pos.getZ() + 1.25f, 0, 0, 0);
        } else if (stateIn.getValue(DIRTOWER) == Direction.SOUTH) {
            worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                    d0, d1, pos.getZ() - 0.25f, 0, 0, 0);
        } else if (stateIn.getValue(DIRTOWER) == Direction.EAST) {
            worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                    pos.getX() - 0.25f, d1, d2, 0, 0, 0);
        } else if (stateIn.getValue(DIRTOWER) == Direction.WEST) {
            worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                    pos.getX() + 1.25f, d1, d2, 0, 0, 0);
        }
    }
}