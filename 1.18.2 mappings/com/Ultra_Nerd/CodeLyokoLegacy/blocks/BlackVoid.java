package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.stream.Stream;

public final class BlackVoid extends Block {

    private static final VoxelShape nullshape = Stream.of(
            Block.createCuboidShape(3, 0, 3, 10, 0.5, 4),
            Block.createCuboidShape(3, 0, 1, 10, 0.5, 2),
            Block.createCuboidShape(9, 0, 1, 16, 0.5, 2),
            Block.createCuboidShape(5, 0, 4, 7, 0.5, 11),
            Block.createCuboidShape(13, 0, 4, 15, 0.5, 11),
            Block.createCuboidShape(5, 0, 8, 7, 0.5, 15),
            Block.createCuboidShape(3.150000000000001, 0, 7, 5.149999999999999, 0.5, 14),
            Block.createCuboidShape(0.1500000000000008, 0, 8, 2.1499999999999986, 0.5, 15),
            Block.createCuboidShape(7.15, 0, 7, 9.149999999999999, 0.5, 14),
            Block.createCuboidShape(9.924999999999997, 0, 2, 11.924999999999995, 0.5, 9),
            Block.createCuboidShape(0.9249999999999972, 0, 2, 2.9249999999999954, 0.5, 9),
            Block.createCuboidShape(11.924999999999997, 0, 6, 12.924999999999995, 0.5, 13),
            Block.createCuboidShape(9.024999999999991, 0, 13.024999999999999, 16.02500000000001, 0.5, 14.024999999999997),
            Block.createCuboidShape(9.024999999999991, 0, 15.024999999999999, 16.02500000000001, 0.5, 16.025),
            Block.createCuboidShape(1.5249999999999915, 0, 15.024999999999999, 8.52500000000001, 0.5, 16.025)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public BlackVoid() {
        super(FabricBlockSettings.of(Material.STRUCTURE_VOID).strength(-1,-1).dropsNothing().resistance(-1));
    }

    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return nullshape;
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }


    @Override
    public void onEntityLand(final BlockView world, final Entity entity) {
        super.onEntityLand(world, entity);
        entity.damage(DamageSource.OUT_OF_WORLD,Float.MAX_VALUE);
    }

    @Override
    public boolean canMobSpawnInside() {
        return false;
    }

    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        entity.damage(DamageSource.OUT_OF_WORLD,Float.MAX_VALUE);
    }


}
