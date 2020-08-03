package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import com.Ultra_Nerd.CodeLyokoRemake15.particles.ColoredParticle;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;


public class TowerWall extends Block {

    public static final DirectionProperty DIRTOWER = HorizontalBlock.HORIZONTAL_FACING;

    public TowerWall() {
        super(Block.Properties.create(Material.MISCELLANEOUS)

                .hardnessAndResistance(-1, -1)
                .sound(SoundType.GLASS)
                .lightValue(11)


        );

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
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(DIRTOWER, rot.rotate(state.get(DIRTOWER)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(DIRTOWER)));
    }
    //

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTransparent(BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.tick(state, worldIn, pos, rand);
        //worldIn.addParticle(new ColoredParticle.ColoredParticleData(0, 0.5f, 1, 1), pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, 0, 10, 0);
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        double d0 = (double) pos.getX() + 0.5D + (rand.nextDouble() - 0.5D);
        double d1 = (double) pos.getY() + 0.5D + (rand.nextDouble() - 0.5D);
        double d2 = (double) pos.getZ() + 0.5D + (rand.nextDouble() - 0.5D);
        if (stateIn.get(DIRTOWER) == Direction.NORTH) {
            worldIn.addParticle(ColoredParticle.ColoredParticleData.TOWER_PARTICLE,
                    d0, d1, pos.getZ() + 1.25f, 0, 0, 0);
        } else if (stateIn.get(DIRTOWER) == Direction.SOUTH) {
            worldIn.addParticle(ColoredParticle.ColoredParticleData.TOWER_PARTICLE,
                    d0, d1, pos.getZ() - 0.25f, 0, 0, 0);
        } else if (stateIn.get(DIRTOWER) == Direction.EAST) {
            worldIn.addParticle(ColoredParticle.ColoredParticleData.TOWER_PARTICLE,
                    pos.getX() - 0.25f, d1, d2, 0, 0, 0);
        } else if (stateIn.get(DIRTOWER) == Direction.WEST) {
            worldIn.addParticle(ColoredParticle.ColoredParticleData.TOWER_PARTICLE,
                    pos.getX() + 1.25f, d1, d2, 0, 0, 0);
        }
    }
}