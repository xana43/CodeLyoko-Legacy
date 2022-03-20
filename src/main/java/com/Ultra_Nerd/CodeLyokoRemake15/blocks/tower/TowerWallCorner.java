package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tower;

import com.Ultra_Nerd.CodeLyokoRemake15.particles.TowerParticleData;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.Random;


public class TowerWallCorner extends Block {

    public static final DirectionProperty DIRTOWERC = BlockStateProperties.HORIZONTAL_FACING;

    public TowerWallCorner() {
        super(Properties.create(Material.MISCELLANEOUS)
                .hardnessAndResistance(-1, -1)
                .sound(SoundType.GLASS)
                .lightValue(11)
        );

    }

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRTOWERC);
    }



    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // TODO Auto-generated method stub
        return this.getStateDefinition().any().setValue(DIRTOWERC, context.getHorizontalDirection().getOpposite());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(DIRTOWERC, rot.rotate(state.getValue(DIRTOWERC)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(DIRTOWERC)));
    }
    //



    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(@Nonnull BlockState stateIn, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        double d0 = (double) pos.getX() + 0.5D + (rand.nextDouble() - 0.5D);
        double d1 = (double) pos.getY() + 0.5D + (rand.nextDouble() - 0.5D);
        double d2 = (double) pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D);
        if (stateIn.getValue(DIRTOWERC) == Direction.NORTH) {
            if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)) == Blocks.AIR.defaultBlockState()) {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
            } else {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        pos.getX() - 0.25f, d1, d2, 0, -1, 0);
            }
        } else if (stateIn.get(DIRTOWERC) == Direction.SOUTH) {
            if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)) == Blocks.AIR.defaultBlockState()) {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        d0, d1, pos.getZ() - 0.25f, 0, -1, 0);
            } else {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        pos.getX() + 1.25f, d1, d2, 0, -1, 0);
            }
        } else if (stateIn.get(DIRTOWERC) == Direction.EAST) {
            if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())) == Blocks.AIR.defaultBlockState()) {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        pos.getX() - 0.25f, d1, d2, 0, -1, 0);
            } else {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        d0, d1, pos.getZ() - 0.25f, 0, -1, 0);
            }
        } else if (stateIn.get(DIRTOWERC) == Direction.WEST) {
            if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())) == Blocks.AIR.getDefaultState()) {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        pos.getX() + 1.25f, d1, d2, 0, -1, 0);
            } else {
                worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                        d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
            }
        }
    }
}