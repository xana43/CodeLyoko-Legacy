package com.Ultra_Nerd.CodeLyokoLegacy.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public final class BlackVoid extends Block {

    private static final VoxelShape collisionShape = Block.createCuboidShape(0, 0, 0, 16, 2, 16);


    public BlackVoid() {
        super(FabricBlockSettings.of(Material.STRUCTURE_VOID).strength(-1, Integer.MAX_VALUE).dropsNothing().nonOpaque()
                .luminance(10));
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
        entity.damage(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
    }

    @Override
    public void onLandedUpon(final World world, final BlockState state, final BlockPos pos, final Entity entity, final float fallDistance) {
        super.onLandedUpon(world, state, pos, entity, fallDistance);
        entity.damage(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
    }

    @Override
    public void onProjectileHit(final World world, final BlockState state, final BlockHitResult hit, final ProjectileEntity projectile) {
        super.onProjectileHit(world, state, hit, projectile);
        projectile.remove(Entity.RemovalReason.KILLED);
    }

    @Override
    public void onSteppedOn(final World world, final BlockPos pos, final BlockState state, final Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
        entity.damage(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
    }

    @Override
    public boolean canMobSpawnInside() {
        return false;
    }

    @Override
    public void onEntityCollision(final BlockState state, final World world, final BlockPos pos, final Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        entity.damage(DamageSource.OUT_OF_WORLD, Float.MAX_VALUE);
    }


}
