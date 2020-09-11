package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BlackVoid extends Block {

    private static final VoxelShape nullshape = Stream.of(
            Block.makeCuboidShape(3, 0, 3, 10, 0.5, 4),
            Block.makeCuboidShape(3, 0, 1, 10, 0.5, 2),
            Block.makeCuboidShape(9, 0, 1, 16, 0.5, 2),
            Block.makeCuboidShape(5, 0, 4, 7, 0.5, 11),
            Block.makeCuboidShape(13, 0, 4, 15, 0.5, 11),
            Block.makeCuboidShape(5, 0, 8, 7, 0.5, 15),
            Block.makeCuboidShape(3.150000000000001, 0, 7, 5.149999999999999, 0.5, 14),
            Block.makeCuboidShape(0.1500000000000008, 0, 8, 2.1499999999999986, 0.5, 15),
            Block.makeCuboidShape(7.15, 0, 7, 9.149999999999999, 0.5, 14),
            Block.makeCuboidShape(9.924999999999997, 0, 2, 11.924999999999995, 0.5, 9),
            Block.makeCuboidShape(0.9249999999999972, 0, 2, 2.9249999999999954, 0.5, 9),
            Block.makeCuboidShape(11.924999999999997, 0, 6, 12.924999999999995, 0.5, 13),
            Block.makeCuboidShape(9.024999999999991, 0, 13.024999999999999, 16.02500000000001, 0.5, 14.024999999999997),
            Block.makeCuboidShape(9.024999999999991, 0, 15.024999999999999, 16.02500000000001, 0.5, 16.025),
            Block.makeCuboidShape(1.5249999999999915, 0, 15.024999999999999, 8.52500000000001, 0.5, 16.025)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public BlackVoid() {
        super(Block.Properties.create(Material.STRUCTURE_VOID)
                .hardnessAndResistance(-1, -1)
                .sound(SoundType.METAL)
                .lightValue(90)
        );
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos, @Nonnull ISelectionContext context) {
        return nullshape;
    }

    @Override
    public void onEntityCollision(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, Entity entityIn) {
        entityIn.attackEntityFrom(DamageSource.OUT_OF_WORLD, Integer.MAX_VALUE);
        entityIn.fallDistance = Integer.MAX_VALUE;
    }

    @Override
    public void onEntityWalk(@Nonnull World worldIn, @Nonnull BlockPos pos, Entity entityIn) {
        entityIn.attackEntityFrom(DamageSource.OUT_OF_WORLD, Integer.MAX_VALUE);
        entityIn.fallDistance = Integer.MAX_VALUE;
    }

    @Override
    public boolean isNormalCube(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return false;
    }

    @Override
    public boolean isReplaceable(@Nonnull BlockState state, @Nonnull BlockItemUseContext useContext) {
        return false;
    }

    @Override
    public boolean canEntityDestroy(BlockState state, IBlockReader world, BlockPos pos, Entity entity) {
        return false;
    }

    @Override
    public boolean canHarvestBlock(BlockState state, IBlockReader world, BlockPos pos, PlayerEntity player) {
        return false;
    }

    @Override
    public boolean canBeReplacedByLeaves(BlockState state, IWorldReader world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isReplaceableOreGen(BlockState state, IWorldReader world, BlockPos pos, Predicate<BlockState> target) {
        return false;
    }

    @Override
    public boolean isReplaceable(@Nonnull BlockState state, @Nonnull Fluid fluidIn) {
        return false;
    }


    @Override
    public void onFallenUpon(@Nonnull World worldIn, @Nonnull BlockPos pos, Entity entityIn, float fallDistance) {
        entityIn.attackEntityFrom(DamageSource.OUT_OF_WORLD, Integer.MAX_VALUE);
        entityIn.fallDistance = Integer.MAX_VALUE;
    }

    @Override
    public void onLanded(@Nonnull IBlockReader worldIn, Entity entityIn) {
        entityIn.attackEntityFrom(DamageSource.OUT_OF_WORLD, Integer.MAX_VALUE);
    }
}
