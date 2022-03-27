package com.Ultra_Nerd.CodeLyokoRemake15.blocks.saplings;

import com.Ultra_Nerd.CodeLyokoRemake15.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nonnull;
import java.util.Random;

public class DigitalSapling extends SaplingBlock implements IPlantable {

    public static final IntegerProperty PROGRESSFOREST = BlockStateProperties.STAGE;
    protected static final VoxelShape shape = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);

    public final AbstractTreeGrower tree;
    public DigitalSapling(AbstractTreeGrower TreeStruct, Properties properties) {
        super(TreeStruct,properties);
        this.tree = TreeStruct;

    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos, @Nonnull CollisionContext context) {
        return shape;
    }


    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return state.getBlock() == ModBlocks.DIGITAL_GRASS.get();
    }
    @Override
    public void tick(@Nonnull BlockState state, @Nonnull ServerLevel worldIn, @Nonnull BlockPos pos, @Nonnull Random rand) {
        super.tick(state, worldIn, pos, rand);
        if (!worldIn.isAreaLoaded(pos, 1)) {
            return;
        }
        if (rand.nextInt(9) == 0) {
            this.grow(worldIn, pos, state, rand);
        }
    }


    public void grow(ServerLevel world, BlockPos pos, BlockState state, Random rand) {
        if (state.getValue(PROGRESSFOREST) == 0) {
            world.setBlock(pos, state.cycle(PROGRESSFOREST), 4);

        } else {
            if (!ForgeEventFactory.saplingGrowTree(world, rand, pos)) {
                return;
            }

            this.tree.growTree(world, world.getChunkSource().getGenerator(), pos, state, rand);
        }
    }




    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PROGRESSFOREST);
    }
}
