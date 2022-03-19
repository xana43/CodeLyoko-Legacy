package com.Ultra_Nerd.CodeLyokoRemake15.blocks.saplings;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Supplier;

public class DigitalSapling extends BushBlock implements IGrowable {

    public static final IntegerProperty PROGRESSFOREST = BlockStateProperties.STAGE_0_1;
    protected static final VoxelShape shape = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    private final Supplier<Tree> tree;

    public DigitalSapling(Supplier<Tree> TreeStruct, Properties properties) {
        super(properties);
        this.tree = TreeStruct;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        return shape;
    }

    @Override
    public void tick(@Nonnull BlockState state, @Nonnull ServerWorld worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        super.tick(state, worldIn, pos, rand);
        if (!worldIn.isAreaLoaded(pos, 1)) {
            return;
        }
        if (rand.nextInt(9) == 0) {
            this.grow(worldIn, pos, state, rand);
        }
    }

    @Override
    protected boolean isValidGround(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return state.getBlock() == ModBlocks.DIGITAL_GRASS.get();
    }

    public void grow(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
        if (state.get(PROGRESSFOREST) == 0) {
            world.setBlockState(pos, state.cycle(PROGRESSFOREST), 4);

        } else {
            if (!ForgeEventFactory.saplingGrowTree(world, rand, pos)) {
                return;
            }
            this.tree.get().place(world, world.getChunkProvider().getChunkGenerator(), pos, state, rand);
        }
    }


    @Override
    public boolean canGrow(@Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(@Nonnull World worldIn, @Nonnull Random rand, @Nonnull BlockPos pos, @Nonnull BlockState state) {
        return false;
    }

    @Override
    public void grow(@Nonnull ServerWorld worldIn, @Nonnull Random rand, @Nonnull BlockPos pos, @Nonnull BlockState state) {
        this.grow(worldIn, pos, state, rand);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(PROGRESSFOREST);
    }
}
