package com.Ultra_Nerd.CodeLyokoLegacy.Blocks;

import com.Ultra_Nerd.CodeLyokoLegacy.Blockentity.LyokoCoreBE;
import com.Ultra_Nerd.CodeLyokoLegacy.Entity.ProjectileEntities.EntityLaser;
import com.Ultra_Nerd.CodeLyokoLegacy.Init.Common.ModBlockEntities;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LyokoCore extends BlockWithEntity {


    public LyokoCore(final Settings settings) {
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean canMobSpawnInside(final BlockState state) {
        return false;
    }

    @Override
    public <T extends BlockEntity> @NotNull BlockEntityTicker<T> getTicker(final World world, final BlockState state, final BlockEntityType<T> type) {
        return (world1, pos, state1, blockEntity) -> {
            if(blockEntity instanceof final LyokoCoreBE lyokoCoreBE) {
                lyokoCoreBE.tick();
            }
        };
    }
    @Override
    public void onProjectileHit(final World world, final BlockState state, final BlockHitResult hit, final ProjectileEntity projectile) {
        super.onProjectileHit(world, state, hit, projectile);
        if(projectile instanceof final PersistentProjectileEntity persistentProjectileEntity) {
            if(world.getBlockEntity(hit.getBlockPos()) instanceof LyokoCoreBE lyokoCoreBE) {
                if(persistentProjectileEntity instanceof EntityLaser laser)
                {
                    lyokoCoreBE.damageHealth(laser.getCalculatedDamage());
                } else {
                    lyokoCoreBE.damageHealth((float) persistentProjectileEntity.getDamage());
                }
                world.playSound(null,hit.getBlockPos(), SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS,1,1);
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(final BlockPos pos, final BlockState state) {
        return ModBlockEntities.LYOKO_CORE.instantiate(pos, state);
    }
}
