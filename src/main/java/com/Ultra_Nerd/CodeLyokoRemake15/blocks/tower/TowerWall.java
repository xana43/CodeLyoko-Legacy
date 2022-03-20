package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tower;

import com.Ultra_Nerd.CodeLyokoRemake15.particles.TowerParticleData;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.Random;


public class TowerWall extends Block {

    public static final DirectionProperty DIRTOWER = BlockStateProperties.HORIZONTAL_FACING;

    public TowerWall() {
        super(Block.Properties.create(Material.MISCELLANEOUS)
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
    public int getLightValue(@Nonnull BlockState state) {
        return 5;
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return 5;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DIRTOWER);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(DIRTOWER, context.getPlacementHorizontalFacing().getOpposite());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(DIRTOWER, rot.rotate(state.get(DIRTOWER)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(DIRTOWER)));
    }
    //

    @Override
    public boolean isNormalCube(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTransparent(@Nonnull BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(@Nonnull BlockState stateIn, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        double d0 = (double) pos.getX() + 0.5D + (rand.nextDouble() - 0.5D);
        double d1 = (double) pos.getY() + 0.5D + (rand.nextDouble() - 0.5D);
        double d2 = (double) pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D);
        if (stateIn.get(DIRTOWER) == Direction.NORTH) {
            worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                    d0, d1, pos.getZ() + 1.25f, 0, 0, 0);
        } else if (stateIn.get(DIRTOWER) == Direction.SOUTH) {
            worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                    d0, d1, pos.getZ() - 0.25f, 0, 0, 0);
        } else if (stateIn.get(DIRTOWER) == Direction.EAST) {
            worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                    pos.getX() - 0.25f, d1, d2, 0, 0, 0);
        } else if (stateIn.get(DIRTOWER) == Direction.WEST) {
            worldIn.addParticle(TowerParticleData.TOWER_PARTICLE_2,
                    pos.getX() + 1.25f, d1, d2, 0, 0, 0);
        }
    }
}