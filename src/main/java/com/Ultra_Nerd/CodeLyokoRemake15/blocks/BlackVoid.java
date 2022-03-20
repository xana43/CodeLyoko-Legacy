package com.Ultra_Nerd.CodeLyokoRemake15.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import org.jetbrains.annotations.Nullable;

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
        super(Block.Properties.of(Material.STRUCTURAL_AIR)
                .strength(-1, -1)
                .sound(SoundType.METAL)
                .noDrops()
                .explosionResistance(-1)

        );
    }



    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return nullshape;
    }

    @Override
    public void entityInside(BlockState p_60495_, Level p_60496_, BlockPos p_60497_, Entity p_60498_) {
        super.entityInside(p_60495_, p_60496_, p_60497_, p_60498_);
        p_60498_.hurt(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
    }

    @Override
    public boolean canEntityDestroy(BlockState state, BlockGetter level, BlockPos pos, Entity entity) {
        return false;
    }

    @Override
    public void fallOn(Level p_152426_, BlockState p_152427_, BlockPos p_152428_, Entity p_152429_, float p_152430_) {
        super.fallOn(p_152426_, p_152427_, p_152428_, p_152429_, p_152430_);
        p_152429_.hurt(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        return false;
    }

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }

    @Override
    public boolean isPossibleToRespawnInThis() {
        return false;
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter p_49821_, Entity p_49822_) {
        super.updateEntityAfterFallOn(p_49821_, p_49822_);
        p_49822_.hurt(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
    }

    @Override
    public boolean canBeReplaced(BlockState p_60535_, Fluid p_60536_) {
        return false;
    }

    @Override
    public boolean canBeReplaced(BlockState p_60470_, BlockPlaceContext p_60471_) {
        return false;
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return false;
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return false;
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return false;
    }

    @Override
    public boolean canSurvive(BlockState p_60525_, LevelReader p_60526_, BlockPos p_60527_) {
        return false;
    }

    @Override
    public boolean addLandingEffects(BlockState state1, ServerLevel level, BlockPos pos, BlockState state2, LivingEntity entity, int numberOfParticles) {
        return entity.hurt(DamageSource.OUT_OF_WORLD,Float.MAX_VALUE);
    }
}
