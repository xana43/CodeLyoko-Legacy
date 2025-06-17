package com.Ultra_Nerd.CodeLyokoLegacy.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;


public final class BlackVoid extends Block {

    private static final VoxelShape collisionShape = Block.createCuboidShape(0, 0, 0, 16, 2, 16);


    public BlackVoid(final Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(final BlockState state, final BlockView world, final BlockPos pos, final ShapeContext context) {
        return collisionShape;
    }


    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }


    @Override
    public void onEntityLand(final BlockView world, final Entity entity) {
        super.onEntityLand(world, entity);
        entity.damage((ServerWorld) world,entity.getWorld().getDamageSources().outOfWorld(), Float.MAX_VALUE);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        super.onLandedUpon(world, state, pos, entity, fallDistance);
        entity.damage((ServerWorld) world,entity.getWorld().getDamageSources().outOfWorld(), Float.MAX_VALUE);
    }



    @Override
    public void onProjectileHit(final World world, final BlockState state, final BlockHitResult hit, final ProjectileEntity projectile) {
        super.onProjectileHit(world, state, hit, projectile);
        projectile.remove(Entity.RemovalReason.KILLED);
    }

    @Override
    public void onSteppedOn(final World world, final BlockPos pos, final BlockState state, final Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
        entity.damage((ServerWorld) world,entity.getWorld().getDamageSources().outOfWorld(), Float.MAX_VALUE);
    }

    @Override
    public boolean canMobSpawnInside(final BlockState state) {
        return false;
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        super.onEntityCollision(state, world, pos, entity, handler);
        entity.damage((ServerWorld) world,entity.getWorld().getDamageSources().outOfWorld(), Float.MAX_VALUE);
    }
}
