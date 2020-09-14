package com.Ultra_Nerd.CodeLyokoRemake15.blocks.tower;

import com.Ultra_Nerd.CodeLyokoRemake15.particles.ColoredParticle;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
    public boolean canCreatureSpawn(BlockState state, IBlockReader world, BlockPos pos, EntitySpawnPlacementRegistry.PlacementType type, @Nullable EntityType<?> entityType) {
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
        builder.add(DIRTOWERC);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(DIRTOWERC, context.getPlacementHorizontalFacing().getOpposite());
    }

    //mod compatiability
    @Nonnull
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(DIRTOWERC, rot.rotate(state.get(DIRTOWERC)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(DIRTOWERC)));
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
    public void animateTick(@Nonnull BlockState stateIn, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        double d0 = (double) pos.getX() + 0.5D + (rand.nextDouble() - 0.5D);
        double d1 = (double) pos.getY() + 0.5D + (rand.nextDouble() - 0.5D);
        double d2 = (double) pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D);
        if (stateIn.get(DIRTOWERC) == Direction.NORTH) {
            if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)) == Blocks.AIR.getDefaultState()) {
                worldIn.addParticle(ColoredParticle.ColoredParticleData.TOWER_PARTICLE,
                        d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
            } else {
                worldIn.addParticle(ColoredParticle.ColoredParticleData.TOWER_PARTICLE,
                        pos.getX() - 0.25f, d1, d2, 0, -1, 0);
            }
        } else if (stateIn.get(DIRTOWERC) == Direction.SOUTH) {
            if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)) == Blocks.AIR.getDefaultState()) {
                worldIn.addParticle(ColoredParticle.ColoredParticleData.TOWER_PARTICLE,
                        d0, d1, pos.getZ() - 0.25f, 0, -1, 0);
            } else {
                worldIn.addParticle(ColoredParticle.ColoredParticleData.TOWER_PARTICLE,
                        pos.getX() + 1.25f, d1, d2, 0, -1, 0);
            }
        } else if (stateIn.get(DIRTOWERC) == Direction.EAST) {
            if (worldIn.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())) == Blocks.AIR.getDefaultState()) {
                worldIn.addParticle(ColoredParticle.ColoredParticleData.TOWER_PARTICLE,
                        pos.getX() - 0.25f, d1, d2, 0, -1, 0);
            } else {
                worldIn.addParticle(ColoredParticle.ColoredParticleData.TOWER_PARTICLE,
                        d0, d1, pos.getZ() - 0.25f, 0, -1, 0);
            }
        } else if (stateIn.get(DIRTOWERC) == Direction.WEST) {
            if (worldIn.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())) == Blocks.AIR.getDefaultState()) {
                worldIn.addParticle(ColoredParticle.ColoredParticleData.TOWER_PARTICLE,
                        pos.getX() + 1.25f, d1, d2, 0, -1, 0);
            } else {
                worldIn.addParticle(ColoredParticle.ColoredParticleData.TOWER_PARTICLE,
                        d0, d1, pos.getZ() + 1.25f, 0, -1, 0);
            }
        }
    }
}